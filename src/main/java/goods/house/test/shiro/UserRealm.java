package goods.house.test.shiro;

import goods.house.test.dao.PermissionDao;
import goods.house.test.dao.UserDao;
import goods.house.test.pojo.Permission;
import goods.house.test.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 09:23
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {

    private static final Integer ADMIN_ID = 1;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;


    /**
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.getPrimaryPrincipal();
        Integer userId = user.getUserId();

        List<String> permList = null;
        //系统管理员拥有最高权限
        if(userId == ADMIN_ID){
            List<Permission> listPermission = permissionDao.queryList(new HashMap<>());
            permList = new ArrayList<>(listPermission.size());
            permList = listPermission.stream().map(Permission::getPerms).collect(toList());
        }else{
            permList = permissionDao.queryAllPerms(userId);
        }

        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for(String perms : permList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);

        return info;
    }

    /**
     * 认证登录
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        String username = userToken.getUsername();

        User user = userDao.queryByUsername(username);
        if(user == null){
            throw new RuntimeException("用户不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        return info;
    }
}
