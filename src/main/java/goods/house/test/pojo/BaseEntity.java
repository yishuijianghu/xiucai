package goods.house.test.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 10:09
 * @Description:
 */
public class BaseEntity implements Serializable {

    private Integer isDel;

    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
}
