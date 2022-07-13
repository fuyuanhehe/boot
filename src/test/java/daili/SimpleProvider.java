package daili;

public class SimpleProvider implements IProvider {
    @Override
    public Object getData(String json) {
        //解析json 拿到数据
        System.out.println(9999);
        return parseJson(json);
    }




    public Object parseJson(String aa) {

        return aa;
    }

}