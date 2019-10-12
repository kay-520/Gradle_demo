package com.digitalchina.sc.demo.api.base.mapper.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * <p>================================================
 * <p>Title: 填充创建时间，创建人，更新时间，更新人
 * <p>Description:
 * <p>Date: 2018/2/25 15:48
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class BaseMetaObjectHandler extends MetaObjectHandler {

    /**
     * 新增
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时间
        Object createDate = getFieldValByName(DataBaseFieldConstant.CREATE_DATE, metaObject);
        if (createDate == null) {
            setFieldValByName(DataBaseFieldConstant.CREATE_DATE, new Date(), metaObject);
        }
        Object createTime = getFieldValByName(DataBaseFieldConstant.CREATE_TIME, metaObject);
        if (createTime == null) {
            setFieldValByName(DataBaseFieldConstant.CREATE_TIME, new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间
        Object updateDate = getFieldValByName(DataBaseFieldConstant.UPDATE_DATE, metaObject);
        if (updateDate == null) {
            setFieldValByName(DataBaseFieldConstant.UPDATE_DATE, new Date(), metaObject);
        }
        Object updateTime = getFieldValByName(DataBaseFieldConstant.UPDATE_TIME, metaObject);
        if (updateTime == null) {
            setFieldValByName(DataBaseFieldConstant.UPDATE_TIME, new Date(), metaObject);
        }
    }
}