package lambda;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class LocalDateTimeUtis {

    public void LocalDateTimeToString() {
        LocalDateTime dateTime = LocalDateTime.now();

        //使用预定义实例来转换
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        String dateStr = dateTime.format(fmt);
        System.out.println("LocalDateTime转String[预定义]:"+dateStr);

        //使用pattern来转换
        //12小时制与24小时制输出由hh的大小写决定
        DateTimeFormatter fmt12 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS");
        String dateStr12 = dateTime.format(fmt12);
        System.out.println("LocalDateTime转String[pattern](12小时制):"+dateStr12);

        DateTimeFormatter fmt24 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String dateStr24 = dateTime.format(fmt24);
        System.out.println("LocalDateTime转String[pattern](24小时制):"+dateStr24);

        //如果想要给12小时制时间加上am/pm,这样子做：
        fmt12 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS a");
        dateStr12 = dateTime.format(fmt12);
        System.out.println("LocalDateTime转String[pattern](12小时制带am/pm):"+dateStr12);
    }



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
