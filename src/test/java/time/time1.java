package time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class time1 {

    public static void main(String[] args) {
        // 格式化
      String time = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(time);

        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));

        String month = new SimpleDateFormat("MM").format(new Date());

        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR)+"-";

        int moth2 = calendar.get(Calendar.MONTH+1);
        int day = calendar.get(Calendar.DATE);

 /*
        String[] str = {"a", "b", "c"};
        String join = String.join("-", str);
        System.out.println(join);*/

/*
     File file = new File("./upload/cc");
     if(!file.exists()){
         System.out.println(11);
         file.mkdirs();
     }
*/



    }


}
