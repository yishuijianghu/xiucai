package goods.house.test.common.utils;

import goods.house.test.common.YiShuiError;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lvlj
 * @Date: 2018/12/28/0028 16:41
 * @Description:
 */
public class RestResult extends HashMap<String,Object> {

    public RestResult() {
        put("code",YiShuiError.SYS_SUCCESS.getCode());
        put("msg",YiShuiError.SYS_SUCCESS.getMsg());
    }

    public static RestResult error(){
        return error(YiShuiError.SYS_ERROR.getCode(),YiShuiError.SYS_ERROR.getMsg());
    }

    public static RestResult error(String msg){
        return error(YiShuiError.SYS_ERROR.getCode(),msg);
    }

    public static RestResult error(int code,String msg){
        RestResult restResult = new RestResult();
        restResult.put("code",code);
        restResult.put("msg",msg);
        return restResult;
    }

    public static RestResult OK(){
        return new RestResult();
    }

    public static RestResult OK(Map<String,Object> map){
        RestResult restResult = new RestResult();
        restResult.putAll(map);
        return restResult;
    }

    public static RestResult OK(String msg){
        RestResult restResult = new RestResult();
        restResult.put("code",YiShuiError.SYS_SUCCESS.getCode());
        restResult.put("msg",msg);
        return restResult;
    }

    public RestResult put(String key,Object value){
        super.put(key,value);
        return this;
    }

}
