package http;


import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * POST请求示例
 *
 * @author 小明
 *
 */
public class PostDemo {

    public static void main(String[] args) {
        try {
            // 1. 获取访问地址URL
         //   String address = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
            String address = "http://123.182.227.105:12020/bhtong/hanhua/insure/auditNotice";
            URL url = new URL(address);
            // 2. 创建HttpURLConnection对象
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            /* 3. 设置请求参数等 */
            // 请求方式
            connection.setRequestMethod("POST");
            // 超时时间
            connection.setConnectTimeout(3000);
            // 设置是否输出
            connection.setDoOutput(true);
            // 设置是否读入
            connection.setDoInput(true);
            // 设置是否使用缓存
            connection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置使用标准编码格式编码参数的名-值对
            connection.setRequestProperty("Content-Type",
                    "application/json");
            // 连接
            connection.connect();

            /* 4. 处理输入输出 */
            // 写入参数到请求中
         //   String params = "tel=18782025848";

          String str = "AWCU87G0FewHMV92kgdRAmHbGUp7_pSPbwYkRxP6eu7v0T28P2zCYzoSXHzlDSYDjt-8_lMjyL_Yd6EMtwgzcL0DvUgX_WKxU6iBREXYebs_GWQomz0se4C422wepCN3AFHexnHx2BWYEAZPwqKpn96qvN5GGyuTug4eSk2iSdJj3tYjya7pOlHnM-LZNl5_NA75FjU-TKY3bwzay4xGlmkMkDcTOHHVcmo0QYqmLNKjFGSyE8nBzgSQxcwEDhadym9jEDytY2WCU2Ur3elzZdyvIrtKieTzd57yxKmunYe-3SAljOWx1-4-4hAbTi76HmPWmM7BEzZ4rO5LIV0j5w";

            OutputStream out = connection.getOutputStream();
            out.write(JSON.toJSON(str).toString().getBytes());
            out.flush();
            out.close();
            // 从连接中读取响应信息
            String msg = "";
            int code = connection.getResponseCode();
            if (code == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    msg += line + "\n";
                }
                reader.close();
            }
            // 5. 断开连接
            connection.disconnect();

            // 处理结果
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}