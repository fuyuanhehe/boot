package mi;


import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) throws Exception {

        String nd1 = URLEncoder.encode("(){}（）还好", "UTF-8");
        System.out.println(nd1);

        nd1 = URLDecoder.decode(nd1, "UTF-8");
        System.out.println(nd1);


  /*      String t = "yyyy-MM-dd'T'HH:mm:ssZ";
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(t);
        String dateStr = date.format(fmt);
        System.out.println(dateStr);*/

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String format = sdf.format(new Date());
        System.out.println(format);

        String f = URLEncoder.encode(format,"UTF-8");
        System.out.println(f);
    }


}
