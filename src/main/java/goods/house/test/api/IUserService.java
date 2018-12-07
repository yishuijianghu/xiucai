package goods.house.test.api;

import goods.house.test.controller.vo.UserVO;

import java.util.List;

/**
 * @Auther: lvlj
 * @Date: 2018/12/6/0006 16:21
 * @Description:
 */
public interface IUserService {

    List<UserVO> selectListUser(int offset, int limit);

}
