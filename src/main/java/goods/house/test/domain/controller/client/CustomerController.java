package goods.house.test.domain.controller.client;

import com.google.common.collect.Lists;
import goods.house.test.common.utils.R;
import goods.house.test.common.utils.RestResult;
import goods.house.test.domain.controller.vo.RegisterRequest;
import goods.house.test.modules.sys.entity.SysUserEntity;
import goods.house.test.modules.sys.service.SysUserService;
import goods.house.test.modules.sys.shiro.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: lvlj
 * @Date: 2019/1/3/0003 14:47
 * @Description:
 */
@RequestMapping("customer")
@Controller
public class CustomerController {

    @Autowired
    private SysUserService sysUserService;


    @ResponseBody
    @GetMapping("/checkUsername")
    public RestResult checkUsername(@RequestParam String username){
        RestResult restResult = new RestResult();
        int count = sysUserService.checkUsername(username);
        if(count>0){
            return restResult.error("用户名已使用，请更换");
        }
        return restResult.OK();
    }

    @ResponseBody
    @RequestMapping("/register")
    public RestResult register(@RequestBody RegisterRequest request){
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());
        userEntity.setSalt(UUID.randomUUID().toString().substring(0,19));
        userEntity.setDeptId(5L);
        userEntity.setDeptName("一水家族");
        userEntity.setRoleIdList(Lists.newArrayList());
        userEntity.setMobile(request.getMobile());
        userEntity.setStatus(1);

        sysUserService.save(userEntity);
        return RestResult.OK();
    }

    /**
     * 访问客户登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(String username, String password, String captcha)throws IOException {
        try{
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        }catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return R.error("账号或密码不正确");
        }catch (LockedAccountException e) {
            return R.error("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }
}
