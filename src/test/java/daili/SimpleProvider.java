package daili;

public class SimpleProvider implements IProvider {
    @Override
    public Object getData(String json) {
        //解析json 拿到数据
        System.out.println(1111);
        return parseJson(json);
    }

    @Override
    public int a() {
        return 22;
    }


    public Object parseJson(String aa) {

        return aa;
    }

}