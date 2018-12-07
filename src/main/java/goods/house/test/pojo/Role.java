package goods.house.test.pojo;

import lombok.Data;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 10:00
 * @Description:
 */
@Data
public class Role extends BaseEntity {

    private Integer roleId;
    private String name;//角色名称
    private String description;//角色描述
}
