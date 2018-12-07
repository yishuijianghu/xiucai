package goods.house.test.dao;

import goods.house.test.pojo.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 15:45
 * @Description:
 */
public interface PermissionDao extends BaseDao<Permission>{

    /**
     * @param: map
     * @return: List<Permission>
     * @auther: lvxiucai
     */
    @Select("SELECT p.perms from permission p \n" +
            "LEFT JOIN role_permission rp on p.permission_id = rp.permission_id \n" +
            "LEFT JOIN user_role ur on ur.role_id = rp.role_id\n" +
            "WHERE ur.user_id = #{userId} and  and p.is_del = '0' ")
    List<String> queryAllPerms(@Param("userId") Integer userId);

    /**
     * 查询内部类
     * */
    class SqlProvider{

    }
}
