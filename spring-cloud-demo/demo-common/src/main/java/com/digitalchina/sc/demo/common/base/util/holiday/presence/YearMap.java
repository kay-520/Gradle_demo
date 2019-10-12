package com.digitalchina.sc.demo.common.base.util.holiday.presence;

import com.digitalchina.sc.demo.common.base.util.holiday.presence.impl.Year2018;

import java.util.Map;

/**
 * <p>================================================
 * <p>Title:
 * <p>Description:
 * <p>Date: 2018/9/5 10:52
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class YearMap {

    public static Map<String, Boolean> yearMap(int year) {
        Year20xx createMap = createMap(year);
        return createMap.getYearMap();
    }

    private static Year20xx createMap(int year) {
        if (year == 2018) {
            return new Year2018();
        }
        return null;
    }
}
