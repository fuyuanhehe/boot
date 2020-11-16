package beanUtis_1;

import java.util.Date;

public class test {

    public static void main(String[] args) {

        //实际中从数据库取
        CarPo carPo = new CarPo();
        carPo.setId(1);
        carPo.setBrand("AA");
        carPo.setCarName("carName");
        carPo.setCreateTime(new Date());

        CarVo carVo = CarCovertBasic.INSTANCE.toConvertVo(carPo);
        System.out.println(carVo);


    }

}
