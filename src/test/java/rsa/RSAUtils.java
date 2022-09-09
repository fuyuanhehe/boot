package rsa;


import org.apache.commons.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


public class RSAUtils {

    private static final String CHARSET = "UTF-8";
    private static final String RSA_ALGORITHM = "RSA";

/*

    public static void main(String[] args) throws Exception {
        Map<String, String> keyMap = RSAUtils.createKeys();
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);

        String str = "hello word";
        System.out.println("\r明文：\r\n" + str);

      */
/*  String s = RSAUtils.publicEncrypt(str, RSAUtils.getPublicKey(publicKey));
        System.out.println("密文：\r\n" + s);
        String s1 = RSAUtils.privateDecrypt(s, RSAUtils.getPrivateKey(privateKey));
        System.out.println("解密后文字: \r\n" + s1);*//*


        String s = RSAUtils.privateEncrypt(str, RSAUtils.getPrivateKey(privateKey));
        System.out.println("密文：\r\n" + s);

        String s1 = RSAUtils.publicDecrypt(s, RSAUtils.getPublicKey(publicKey));
        System.out.println("解密后文字: \r\n" + s1);

       */
/* String encodedData = RSAUtils.privateEncrypt(str, RSAUtils.getPrivateKey(privateKey));  //传入明文和私钥加密,得到密文
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtils.publicDecrypt(encodedData, RSAUtils.getPublicKey(publicKey)); //传入密文和公钥,得到明文
        System.out.println("解密后文字: \r\n" + decodedData);*//*




    }
*/



    public static Map<String, String> createKeys() {
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(1024);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);

        return keyPairMap;
    }

    public static String getPublicKeySignature(String srcStr, String publicKey, String clientId) throws InvalidKeySpecException, NoSuchAlgorithmException {
        srcStr = getSHA256(srcStr) + clientId;
        return publicEncrypt(srcStr, getPublicKey(publicKey));
    }

    public static boolean verifyPublicKeySignature(String srcStr, String publicKeySignature, String privateKey, String clientId) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String target = privateDecrypt(publicKeySignature, getPrivateKey(privateKey));
        srcStr = getSHA256(srcStr) + clientId;
        return srcStr.equals(target);
    }

    public static String getPrivateKeySignature(String srcStr, String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        srcStr = getSHA256(srcStr);
        return privateEncrypt(srcStr, getPrivateKey(privateKey));
    }

    public static String getPrivateKeySignature(String srcStr, String privateKey, String clientId) throws InvalidKeySpecException, NoSuchAlgorithmException {
        srcStr = getSHA256(srcStr) + clientId;
        return privateEncrypt(srcStr, getPrivateKey(privateKey));
    }

    public static String getPrivateKeySignature(String srcStr, String privateKey, String timestamp, String nonce) throws InvalidKeySpecException, NoSuchAlgorithmException {
        srcStr = getSHA256(srcStr) + "&" + timestamp + "&" + nonce;
        return privateEncrypt(srcStr, getPrivateKey(privateKey));
    }

    public static boolean verifyPrivateKeySignature(String srcStr, String privateKeySignature, String publicKey, String clientId) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String target = publicDecrypt(privateKeySignature, getPublicKey(publicKey));
        srcStr = getSHA256(srcStr) + clientId;
        return srcStr.equals(target);
    }

    public static boolean verifyPrivateKeySignature(String srcStr, String privateKeySignature, String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String target = publicDecrypt(privateKeySignature, getPublicKey(publicKey));
        srcStr = getSHA256(srcStr);
        return srcStr.equals(target);
    }

    public static String publicKeyEncrypt(String srcStr, String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return publicEncrypt(srcStr, getPublicKey(publicKey));
    }

    public static String privateKeyDecrypt(String srcStr, String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return privateDecrypt(srcStr, getPrivateKey(privateKey));
    }

    public static String privateKeyEncrypt(String srcStr, String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return privateEncrypt(srcStr, getPrivateKey(privateKey));
    }

    public static String publicKeyDecrypt(String srcStr, String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return publicDecrypt(srcStr, getPublicKey(publicKey));
    }


    /***********************
     * private
     ***********************/

    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        return (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
    }

    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        return (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
    }

    public static String publicEncrypt(String data, RSAPublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    public static String privateDecrypt(String data, RSAPrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), privateKey.getModulus().bitLength()), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    public static String privateEncrypt(String data, RSAPrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), privateKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    public static String publicDecrypt(String data, RSAPublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    public static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) {
        int maxBlock;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }

    /**
     * 利用java原生的类实现SHA256加密
     *
     * @param str 加密后的报文
     */
    public static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodestr = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    /**
     * 将byte转为16进制    
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        /*String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnLBT6x-3EPeM2G4oMGnfKwPEkk_ybF3-8hjdBeJxafN_X_A26aKlbdbkt7lqJcnb3uHjj8FdAOE0ixDhr4aDCVOGdjo4zkPDtJjfgXt_nZDqbO6_IEsRZ6Lk6FAY3BM8TO11-51Zb2dheeu62OHPIVm4ValwVImCE1Nl9RuMdPQIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKcsFPrH7cQ94zYbigwad8rA8SST_JsXf7yGN0F4nFp839f8DbpoqVt1uS3uWolydve4eOPwV0A4TSLEOGvhoMJU4Z2OjjOQ8O0mN-Be3-dkOps7r8gSxFnouToUBjcEzxM7XX7nVlvZ2F567rY4c8hWbhVqXBUiYITU2X1G4x09AgMBAAECgYEAl6vDDRS_gEC2GK07vmd1MBuFra4mjX_wgNc04s3O7bpGTOt-eRXkMfrJHAcZVYLotTBFXmj8gGOUeGqW1ipLcw2jdHbN-TL1a4k26xVWaE9v-u1yJnowdu0DYKkU5n7B2HNrfjsRqKmuU-mVwa_PS8s4SQFocVcxxtsLObV26nECQQDS6DK_xfOyBhbQ6pvZxi27L6PLt2UcOhMd1GMef7Iko2FDyp67eTUfLejCz6lxQw6bXnlSwmtr3WJzO9ZTT1UrAkEAyuoZHZzMmig9K2znDo6wCu30gOlncHCK5dplaik7Kx4t-Y3xc2ucKqDTeW1gjgKbjCqCTdedWW7WnqPzuQDzNwJBAK3XLLV7sbHkaPwM1Sd8vYcT7nvlD5djmww0WvrxoGGotWxOX-YBMzMfAUNKLc0oy6pvBaucizSehx6ajL-gnX8CQB4kLfznGMFhbsyvjZbs_Rtyg1pO0W2zWf6QtXXSkBZ0kjG6sv4JIxZ181PbOnd9zatBeT-k4puxSjIgeoilqnsCQHm5QEMKP8Y1hLQ3QPcz__mnEXXXgafMynmUf9PNtIjRzfK3k4OGyAe0_xDLdtcyram0HHneKsq0D_VwVis5cBw";
        String clienId = "jdMIrmAqmw7FqzzdNRM4";
        String s = "{\"createTime\":\"2020-06-10 09:24:11\",\"creditCode\":\"91410100786229412G\",\"ensureIsEncryp\":\"1\",\"ensureType\":\"company\",\"enterpriseName\":\"河南洲海置业开发有限公司\",\"guaranteeAmount\":\"50000.00\",\"guaranteeCode\":\"CJ6H66Z6YB\",\"guaranteeFileUrl\":\"https://hhyl-test.hanhua.com/pfbpapi/api/file/v1/get/download/docid?docId=1366A743-BE05-4CF6-B50B-7F6C106FB12D\",\"guaranteeNumber\":\"HH671516202006100923021484\",\"letterExpireEndTime\":\"2021-06-10\",\"letterExpireStartTime\":\"2020-06-10 09:24:11\",\"lgNo\":\"4028b881729bafe001729bd298c00017\",\"orgName\":\"瀚华融资担保股份有限公司\",\"payAmount\":\"500.00\",\"payStatus\":\"00\",\"platformCode\":\"PC06001\",\"platformName\":\"山东省公共资源交易中心\",\"rate\":\"0.007000\",\"status\":\"2\",\"systemId\":\"GLODON\",\"transactor\":\"关羽\",\"transactorNumber\":\"13978562898\"}";
        String sign = getPublicKeySignature(s,publicKey,clienId);
        System.out.println(sign);
        System.out.println(verifyPublicKeySignature(s,sign,privateKey,clienId));*/
        Map<String, String> keyMap = RSAUtils.createKeys();
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);
//        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsopjVAptVsNKIyY3Hiq7BPzQS43PbAyeVggKJ/h/slIV+xZnbGWSaazV2q43Szt3YXOoFAmMJs0VjMycmt7mPyQINZQXb9rNzWG9K2m6ybk535+NelgDZF4QnvpPm9AzUK5CBku0yIQNHko50aZFXTBFhp73ZumdaKTOwNVze/VpwPeVYcu4wnzbU3xV+dy2SRaXwevx4Y64Tl66H14+p8pl4LfFPSgTg9Fo9L6UgRNlFai6nIqeAcCiyGQHt+P4Yh3rpzYngsWYNA3dO47ifWKnaZ0OWmRNvfueg9P77sFcYYfCjNOh4gug3tMffgj03oJ6IN+zHsMp3ztAXh2sMQIDAQAB";
//        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCyimNUCm1Ww0ojJjceKrsE/NBLjc9sDJ5WCAon+H+yUhX7FmdsZZJprNXarjdLO3dhc6gUCYwmzRWMzJya3uY/JAg1lBdv2s3NYb0rabrJuTnfn416WANkXhCe+k+b0DNQrkIGS7TIhA0eSjnRpkVdMEWGnvdm6Z1opM7A1XN79WnA95Vhy7jCfNtTfFX53LZJFpfB6/HhjrhOXrofXj6nymXgt8U9KBOD0Wj0vpSBE2UVqLqcip4BwKLIZAe34/hiHeunNieCxZg0Dd07juJ9YqdpnQ5aZE29+56D0/vuwVxhh8KM06HiC6De0x9+CPTegnog37MewynfO0BeHawxAgMBAAECggEBAKON6pgeRTNqCwxQAcX81v4mqpnL+uu8U3/0NXmQR0qPr9soFu5RzeJIlk+RsM2WWDJJxPs2E9Gnpcop1nx5HOtSksKiOyYYhtdSZfzTCm2o5L9aZjxhTBoxoYBBRZQzEg8i0xD5YU8eyPWqgXTwoDJR+h7smS8Ja01lTJGR+AzgqJiL4OaeXkfP82RIZiHcHRUSU3d5iR0MPZQZAFt9LKYOvef3N9JwBJcnZi+i4ab6XCEvIb+bzpm81UV+Z7akKbN9HXwA3ImFrmUQVLyt5QmtRbdKGXaQBGnkdGAWbvWGyVx4d6dm7eRINBzk2aCQNwRzRRGsgS23ZIghf95SEQECgYEA2Le4gpDywR8xJbv6eLhVDDsFTZat74Cvmz/3DZaOrvFbpCP3h0KIh9726a1Yfbeq+O3uhTN/V/hdMtD7fBJFUtZbsxddat247ZEd5auqrggiOMhztgTSH/W6hwEsjsrOp3WC238pZK9+3gcLSAzWWRvjslN9uE7RuUDky7nuNVkCgYEA0ucmB0rFIHqOMt7N1yPgVAAMt1+io8W8zUPMM+AH5e+o2eUM7cFqqFp8zOyEfsE84Zc2HHHw3F2QeHe5rYQ9pTBxjpKd6C38cjx3vuEV/D3pKC8fe7Tb5q7RxZpidEUqo7cV0m7F96Csnu82ScyuN9udfqkHXSIVn8O3fVui2pkCgYEAkI6D6bvL4VvwCY6I9Wtnd4AK+oUuwlohSLpzDcJGrJTcHvHK05NixNbJ9nclVr5jsiXrezgtkj1d1V6m0UzSpv3LLvu/2V/KUdUBj0hh0jIkuaGj5V7z1lOvtwvmb90B2Zu9zLHWp42UX39tXAMMG2ZKDJI6gu04YYzS0L3WEgkCgYAec9/q16IFIY0czU0djoGav3MWm0mJqkirvuliaCvbyLIx3D/0qKP08TPqBxDOmKpozIO0scMcnqn4qxj1dA3Op2MOOh9w4gr8l7yWpDufc3USJ1O9cgz6jy2dAcDLlx0kDJCrFPGi4uFqBZJqL5LMX/qqyk9U5FIJAqKhCDVIqQKBgHuNLEkgdowXkg6+0ykiKhXTiiOXpTzMDyGvAhnBGrgkljQvrR6Z4WInReOzTD2f2EJnUnboVRFEl03zPyjxboIytKO3GojI881AmqEyKhVVDfhv2S4Y8z2seIsPaoZmuPGlnu1Qv1aSbM+GMCI6d3aSaR0xAO277UMGPezRoc7P";
        // String clienId = "jdMIrmAqmw7FqzzdNRM4";

        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<ROOT>\n" +
                "    <Head>\n" +
                "        <SIGN>PHUlUA+4f2H8Zbzn/pt5O4x82fa9aQbH3jjK86B4cNEoWHD/ANH8I3bz9OBj6c0VzP1TRksf1pv68/cdvrRWnrCk7NNoz+foI0AI8VW6qlrPNRTI99DpQpnMsRJZp3QJMjN+UXMw6DfaSCTqxD7loexWvDSTZkLM0oc8Q7faOpw=</SIGN>\n" +
                "        <TIMESTAMP>20211122</TIMESTAMP>\n" +
                "        <SERNUMBER>000000000001</SERNUMBER>\n" +
                "        <USERID>664564654</USERID>\n" +
                "    </Head>\n" +
                "    <Body>\n" +
                "        <projectName>珠穆朗玛峰修筑电梯</projectName>\n" +
                "        <projectNo>322165466465</projectNo>\n" +
                "        <projectBzj>3000000</projectBzj>\n" +
                "        <projectDeadline>2029-09-01 10:30:00</projectDeadline>\n" +
                "        <projectIndate>90</projectIndate>\n" +
                "        <bidderName>张三</bidderName>\n" +
                "        <bidderLicNo>91431230271107061R</bidderLicNo>\n" +
                "        <tendererName>爱德华</tendererName>\n" +
                "        <notifyUrl>https://c.runoob.com/front-end/710</notifyUrl>\n" +
                "        <orderNo>00000000001</orderNo>\n" +
                "        <guaranteePrm>5000</guaranteePrm>\n" +
                "        <legalName>李四</legalName>\n" +
                "\t\t<legalCardNo>500222199610156012</legalCardNo>\n" +
                "\t\t<productCode>toubiao</productCode>\n" +
                "    </Body>\n" +
                "</ROOT>";
        System.out.println("\r明文：\r\n" + str);
        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = RSAUtils.privateEncrypt(str, RSAUtils.getPrivateKey(privateKey));  //传入明文和私钥加密,得到密文
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtils.publicDecrypt(encodedData, RSAUtils.getPublicKey(publicKey)); //传入密文和公钥,得到明文
        System.out.println("解密后文字: \r\n" + decodedData);
    }
}
