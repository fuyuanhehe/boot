package beanUtis_1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo {
    private Integer id;
    private String brand;

      private String name;
    private String createTime;

    @Override
    public String toString() {
        return "CarVo{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
