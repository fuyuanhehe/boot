package http;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * POST请求测试
 *
 * @author 小明
 */
public class HttpClientPost {

    public static void main(String[] args) {
        // 1. 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 2. 创建HttpPost对象
        //请求地址(我这里测试使用淘宝提供的手机号码信息查询的接口)
        String address = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";

        //请求参数
        //   Map<String, String> params = new HashMap< >();
        //   params.put("tel", "18782025848");//这是该接口需要的参数

        HttpPost post = new HttpPost(address);


        // 3. 设置POST请求传递参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("tel", "18782025848"));
        // params.add(new BasicNameValuePair("username", "test"));
        //  params.add(new BasicNameValuePair("password", "12356"));
        try {
            Map m = new HashMap();
            m.put("tel", "18782025848");

            //  StringEntity s = new StringEntity(m);

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
            post.setEntity(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 4. 执行请求并处理响应
        try {
            CloseableHttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("响应内容：");
                System.out.println(EntityUtils.toString(entity));
            }
            response.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 请求json格式的参数
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, String params){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(params, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();

            System.err.println("请求URL：" + url + ";code："+ code);

            if (code == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            if (response != null) {
                response.close();
            }
            httpclient.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }



}