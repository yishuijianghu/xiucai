package goods.house.test.pojo;

import lombok.Data;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 09:24
 * @Description:
 */
@Data
public class User extends BaseEntity {

    private Integer userId;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private Integer sex;
    private Integer age;

}
