package goods.house.test.dao;

import goods.house.test.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户mapper
 * @Auther: lvlj
 * @Date: 2018/12/6/0006 16:51
 * @Description:
 */
public interface UserDao extends BaseDao<User>{

    @Results({
            @Result(column = "user_id",property = "userId"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "salt",property = "salt"),
            @Result(column = "email",property = "email"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age"),
            @Result(column = "last_login_time",property = "last_login_time"),

            @Result(column = "is_del",property = "is_del"),
            @Result(column = "create_time",property = "create_time"),
            @Result(column = "update_time",property = "update_time"),
            @Result(column = "create_by",property = "create_by"),
            @Result(column = "update_by",property = "update_by")

    })
    @SelectProvider(method = "selectListUser",type = UserDao.SqlProvider.class )
    List<User> selectListUser(int offset,int limit);

    @Select("select * from user where username = #{username} and is_del = '0'")
    User queryByUsername(@Param("username") String username);


    /**
     * 提供sql查询的内部类
     * */
    class SqlProvider{
        public String selectListUser(int offset,int limit){
            StringBuffer sb = new StringBuffer("select * from user ");
            sb.append("where id_del = '0' limit ")
                    .append(offset)
                    .append(" , ")
                    .append(limit);

            return sb.toString();
        }
    }

}
