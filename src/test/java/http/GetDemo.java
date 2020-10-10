package http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * GET请求示例
 *
 * @author 小明
 *
 */
public class GetDemo {
/*1. GET请求与POST请求

    HTTP协议是现在Internet上使用得最多、最重要的协议了，越来越多的Java应用程序需要直接通过HTTP协议来访问网络资源。

    在介绍HttpURLConnection前，我们还是再来说一下URL请求最常用的两种方式：GET请求与POST请求。

    GET请求的数据会附在URL之后（就是把数据放置在HTTP协议头中），以?分割URL和传输数据，参数之间以&相连，如：http://localhost:8080/test.do?name=test&password=123456。

    GET请求发送的参数如果数据是英文字母或数字，则按原样发送，如果是空格，则转换为+，如果是中文或其他字符，则直接把字符串用BASE64加密，得出如 %E4%BD%A0%E5%A5%BD 这类似的字符串，其中％XX中的XX为该符号以16进制表示的ASCII。

    POST请求的参数不是放在URL字符串里面，而是放在HTTP请求的正文内，请求的参数被封装起来以流的形式发送给服务端。

    对于GET方式提交数据的大小，HTTP协议并没有硬性限制，但某些浏览器及服务器会对它进行限制，如IE对URL长度的限制是2083字节(2K+35)。理论上POST也没有限制，可传较大量的数据。

    POST的安全性要比GET的安全性高。比如：通过GET提交数据，用户名和密码将明文出现在URL上，因为登录页面有可能被浏览器缓存，如果其他人查看浏览器的历史纪录，那么别人就可以拿到你的账号和密码了，除此之外，使用GET提交数据还可能会造成Cross-site request forgery（CSRF，跨站请求伪造）攻击。

    一般来说，Get是向服务器索取数据的一种请求，而Post是向服务器提交数据的一种请求。*/
    public static void main(String[] args) {
        try {
            // 1. 得到访问地址的URL
            URL url = new URL(
                    "http://localhost:8080/Servlet/do_login.do?username=test&password=123456");
            // 2. 得到网络访问对象java.net.HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            /* 3. 设置请求参数（过期时间，输入、输出流、访问方式），以流的形式进行连接 */
            // 设置是否向HttpURLConnection输出
            connection.setDoOutput(false);
            // 设置是否从httpUrlConnection读入
            connection.setDoInput(true);
            // 设置请求方式
            connection.setRequestMethod("GET");
            // 设置是否使用缓存
            connection.setUseCaches(true);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置超时时间
            connection.setConnectTimeout(3000);
            // 连接
            connection.connect();
            // 4. 得到响应状态码的返回值 responseCode
            int code = connection.getResponseCode();


            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            String msg = "";
            if (code == 200) { // 正常响应
                // 从流中读取响应信息
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line = null;

                while ((line = reader.readLine()) != null) { // 循环从流中读取
                    msg += line + "\n";
                }
                reader.close(); // 关闭流
            }
            // 6. 断开连接，释放资源
            connection.disconnect();

            // 显示响应结果
            System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
HttpURLConnection对象不能直接构造，需要通过URL类中的openConnection()方法来获得。
        HttpURLConnection的connect()函数，实际上只是建立了一个与服务器的TCP连接，并没有实际发送HTTP请求。HTTP请求实际上直到我们获取服务器响应数据（如调用getInputStream()、getResponseCode()等方法）时才正式发送出去。
        对HttpURLConnection对象的配置都需要在connect()方法执行之前完成。
        HttpURLConnection是基于HTTP协议的，其底层通过socket通信实现。如果不设置超时（timeout），在网络异常的情况下，可能会导致程序僵死而不继续往下执行。
        HTTP正文的内容是通过OutputStream流写入的， 向流中写入的数据不会立即发送到网络，而是存在于内存缓冲区中，待流关闭时，根据写入的内容生成HTTP正文。
        调用getInputStream()方法时，返回一个输入流，用于从中读取服务器对于HTTP请求的返回信息。
        我们可以使用HttpURLConnection.connect()方法手动的发送一个HTTP请求，但是如果要获取HTTP响应的时候，请求就会自动的发起，比如我们使用HttpURLConnection.getInputStream()方法的时候，所以完全没有必要调用connect()方法。
        4. HttpClient简介*/
