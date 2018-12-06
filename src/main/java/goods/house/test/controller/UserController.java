package goods.house.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lvlj
 * @Date: 2018/12/6/0006 14:26
 * @Description:
 */
@RequestMapping("user")
@Controller
public class UserController {

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> test(){
        Map<String,Object> result = new HashMap<>();
        result.put("result","hello,xicai ~~~~~~~~~~!");
        return result;
    }

}
