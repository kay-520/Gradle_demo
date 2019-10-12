package com.digitalchina.sc.demo.common.base.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import com.digitalchina.sc.demo.common.base.util.holiday.HolidayUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * <p>
 *
 * @author Hope Chen
 * @version 1.0
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {

    private final static SimpleDateFormat YYMMDDHHMMSS = new SimpleDateFormat(
            "yyyyMMddHHmmss");

    /**
     * 获取指定日期偏移指定工作日后（前）的时间
     *
     * @param date   基准日期
     * @param offset 偏移天数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static DateTime offsetWorkDay(Date date, int offset) {
        boolean positive = offset > 0;

        for (int i = 0; i < Math.abs(offset); i++) {
            int calOffset = positive ? i : i * (-1);

            if (HolidayUtils.isHoliday(DateUtil.offsetDay(date, calOffset))) {
                if (positive) {
                    offset++;
                } else {
                    offset--;
                }
            }
        }
        return offset(date, DateField.DAY_OF_YEAR, offset);
    }

    /**
     * 取得当月天数
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取YYYYMMDDHHmmss格式
     *
     * @return
     */
    public static String getTimes() {

        return YYMMDDHHMMSS.format(new Date());
    }

    /**
     * 获取时间差（分钟)
     *
     * @return
     */
    public  static  int  getDiffMinute(Date start,Date end){
        long diff = end.getTime() - start.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;

           return  (int)diffMinutes;
    }
}
