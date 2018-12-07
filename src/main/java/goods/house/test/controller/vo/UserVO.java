package goods.house.test.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 11:17
 * @Description:
 */
@Data
public class UserVO implements Serializable {

    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer sex;
    private Integer age;



}
