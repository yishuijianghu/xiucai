package goods.house.test.domain.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lvlj
 * @Date: 2019/1/3/0003 15:23
 * @Description:
 */
@Data
public class RegisterRequest implements Serializable{

    private static final long serialVersionUID = 2997975655402551706L;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private Long deptId;

}
