package goods.house.test.common.util;

import goods.house.test.common.constant.CommonErrorEnum;
import goods.house.test.common.exception.CommonException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 11:25
 * @Description:
 */
public class BeanUtil {

    /**
     * 拷贝实体，source,target不允许为空
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(source, target);
    }

    /**
     *
     * 拷贝list，
     * */
    public static void copyPropertiesList(List sourceList, List targetList, Class clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        if (CollectionUtils.isEmpty(sourceList)) {
            throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(),CommonErrorEnum.PARAM_ERROR.getErrorMsg());
        }
        for (Object items : sourceList) {
            Object target = clazz.newInstance();
            BeanUtils.copyProperties(items, target);
            targetList.add(target);
        }

    }



}
