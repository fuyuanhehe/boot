package ifElse;


import org.springframework.stereotype.Service;

@Service
public class GrantTypeService {

    public String redPaper(Integer resourceId){
        //红包的发放方式
        return "每周末9点发放";
    }
    public String shopping(Integer resourceId){
        //购物券的发放方式
        return "每周三9点发放";
    }
    public String QQVip(Integer resourceId){
        //qq会员的发放方式
        return "每周一0点开始秒杀";
    }
}