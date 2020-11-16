package beanUtis_1;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarCovertBasic {

    CarCovertBasic INSTANCE = Mappers.getMapper(CarCovertBasic.class);


 //   @Mapping(source = "carName", target = "name"),

    @Mappings({
            @Mapping(source = "carName", target = "name"),
            @Mapping(target = "createTime", expression = "java(com.boot.boot.util.CCtticDateUtils.formatDate(source.getCreateTime()))")
    })
    CarVo toConvertVo(CarPo source);


   // @Mapping(source = "carName", target = "name")
    List<CarVo> toConvertVos(List<CarPo> source);


    CarBo toConvertBo(CarPo source1, AttributePo source2);
}