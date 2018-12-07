package goods.house.test.pojo;

import lombok.Data;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 11:33
 * @Description:
 */
@Data
public class Permission extends BaseEntity {

    private Integer permissionId;
    private String name;//权限名称
    private String description;//权限描述
    private String url;//权限访问路径
    private String perms;//权限标识
    private Integer parentId;//父级权限id
    private Integer type;//'类型   0：目录   1：菜单   2：按钮'
    private String icon;//图标
    private Integer orderNum;//排序


}
