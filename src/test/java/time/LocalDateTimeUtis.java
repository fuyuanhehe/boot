package time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class LocalDateTimeUtis {




    @Test
    public void LocalDateToString() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = date.format(fmt);
        System.out.println("LocalDate转String:"+dateStr);
    }


    @Test
    public void StringToLocalDateAndLocalDateTime(){
        String str = "2017-11-21 14:41:06:612";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        LocalDate date = LocalDate.parse(str, fmt);
        LocalDateTime time = LocalDateTime.parse(str, fmt);
        System.out.println("date:"+date);
        System.out.println("time:"+time);
    }






    public static void main(String[] args) {
        Map<String,Object> data =  new HashMap<>();
        data.put("age",18);
        data.put("name","gonglei");
        data.put("sex",null);

        String jstr = JSON.toJSONString(data, SerializerFeature.WriteMapNullValue);
        System.err.println(jstr);
    }
  //  输出结果为：
  //  {"sex":null,"name":"gonglei","age":18}




}
