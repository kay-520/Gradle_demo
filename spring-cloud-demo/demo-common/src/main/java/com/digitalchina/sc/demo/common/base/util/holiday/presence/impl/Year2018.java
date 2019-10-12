package com.digitalchina.sc.demo.common.base.util.holiday.presence.impl;

import com.digitalchina.sc.demo.common.base.util.holiday.presence.Year20xx;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>================================================
 * <p>Title:
 * <p>Description:
 * <p>Date: 2018/9/5 10:51
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class Year2018 implements Year20xx {

    @Override
    public Map<String, Boolean> getYearMap() {
        Map<String, Boolean> map = new HashMap<>();
        map.put("20180101", true); // 休
        map.put("20180211", false); // 班
        map.put("20180215", true); // 休
        map.put("20180216", true); // 休
        map.put("20180219", true); // 休
        map.put("20180220", true); // 休
        map.put("20180221", true); // 休
        map.put("20180224", false); // 班
        map.put("20180405", true); // 休
        map.put("20180406", true); // 休
        map.put("20180408", false); // 班
        map.put("20180428", false); // 班
        map.put("20180430", true); // 休
        map.put("20180501", true); // 休
        map.put("20180618", true); // 休
        map.put("20180924", true); // 休
        map.put("20180929", false); // 班
        map.put("20180930", false); // 班
        map.put("20181001", true); // 休
        map.put("20181002", true); // 休
        map.put("20181003", true); // 休
        map.put("20181004", true); // 休
        map.put("20181005", true); // 休
        return map;
    }
}
