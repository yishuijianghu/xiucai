package goods.house.test.modules.job.dao;

import goods.house.test.modules.job.entity.ScheduleJobLogEntity;
import goods.house.test.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
