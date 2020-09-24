package http;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * GET请求示例
 *
 * @author 小明
 *
 */
/*
使用HttpClient发送请求、接收响应很简单，只要如下几步即可。

        创建HttpClient对象。
        如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。
        如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HttpParams params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。
        调用HttpClient对象的execute(HttpUriRequest request)发送请求，执行该方法返回一个HttpResponse。
        调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容
*/

public class HttpClientGet {

    public static void main(String[] args) {
        // 1. 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 2. 创建HttpGet对象
        String address = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
        HttpGet httpGet = new HttpGet(
                "http://localhost:8080/Servlet/do_login.do?username=test&password=123456");
        CloseableHttpResponse response = null;
        try {
            // 3. 执行GET请求
            response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine());
            // 4. 获取响应实体
            HttpEntity entity = response.getEntity();
            // 5. 处理响应实体
            if (entity != null) {
                System.out.println("长度：" + entity.getContentLength());
                System.out.println("内容：" + EntityUtils.toString(entity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}