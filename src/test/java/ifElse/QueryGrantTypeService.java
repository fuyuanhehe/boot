package ifElse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class QueryGrantTypeService {

    //  CompletableFuture.runAsync  te
    @Autowired
    private GrantTypeService grantTypeSerive;

    private Map<Integer, Function<Integer, String>> getGrantTypeMap = new HashMap<>();

    /**
     * 初始化业务分派逻辑,代替了if-else部分
     * key: 优惠券类型
     * value: lambda表达式,最终会获得该优惠券的发放方式
     */
    @PostConstruct
    public void dispatcherInit() {
        getGrantTypeMap.put(1, resourceId -> grantTypeSerive.redPaper(resourceId));
        getGrantTypeMap.put(2, resourceId -> grantTypeSerive.shopping(resourceId));
        getGrantTypeMap.put(3, resourceId -> grantTypeSerive.QQVip(resourceId));
    }

    public String getResult(Integer resourceType) {
        //Controller根据 优惠券类型resourceType、编码resourceId 去查询 发放方式grantType
        Function<Integer, String> result = getGrantTypeMap.get(resourceType);
        if (result != null) {
            //传入resourceId 执行这段表达式获得String型的grantType
            return result.apply(resourceType);
        }
        return "查询不到该优惠券的发放方式";
    }
}