package goods.house.test.api.impl;

import goods.house.test.api.IUserService;
import goods.house.test.common.util.BeanUtil;
import goods.house.test.controller.vo.UserVO;
import goods.house.test.dao.UserDao;
import goods.house.test.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lvlj
 * @Date: 2018/12/6/0006 16:22
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserVO> selectListUser(int offset, int limit) {
        List<UserVO> listVo = new ArrayList<>();
        List<User> users = userDao.selectListUser(offset,limit);
        try {
            BeanUtil.copyPropertiesList(users, listVo, UserVO.class);
        }catch (Exception e){
            log.error("Vo类转换错误");
        }
        return listVo;
    }
}
