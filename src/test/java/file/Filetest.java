package file;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class Filetest {


    public static void main(String[] args) throws Exception {

        test(null);

    }

    public static void test(MultipartFile m) throws Exception {
        // InputStream in = m.getInputStream();
        File file = new File("src/main/webapp/upload/");
        if (!file.exists()) {
            file.mkdirs();
        }

        OutputStream out = new FileOutputStream("src/main/webapp/upload/" + "xx.txt");

        File file1 = new File("src/main/webapp/upload/AA.txt");
        InputStream in = new FileInputStream(file1);

        byte[] bytes = new byte[1024];
        int i;
        while ((i = in.read(bytes)) != -1) {
            System.out.println("======");
            System.out.println(i);
            System.out.println(new String(bytes));
            out.write(bytes);
        }


     //   in.read(bytes);

        out.close();
        in.close();
        //  in.close();
    }
}
