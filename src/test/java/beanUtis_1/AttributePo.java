package beanUtis_1;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AttributePo {
    private double price;
    private String color;
}


 class CarBo {
    private Integer id;
    private String brand;
    private String carName;
    private Date createTime;
    private double price;
    private String color;
}