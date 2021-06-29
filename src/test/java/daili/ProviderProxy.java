package daili;

public class ProviderProxy implements IProvider{

    //持有一个被代理对象的引用（在这里是SimpleProvider）
    IProvider iProvider;

    public ProviderProxy(IProvider iProvider){
        this.iProvider = iProvider;
    }

    @Override
    public Object getData(String json) throws Exception {
        //做限流检查
     /*   if(55 > 10) {
            //流量超限
            throw new Exception();
        }*/
        Object object = iProvider.getData(json);
        return object;
    }

    @Override
    public int a() {
        return 111;
    }

    //main
    public static void main(String[] args) throws Exception {
        IProvider provider = new ProviderProxy(new SimpleProvider());
        provider.getData("xxx");

    }


}