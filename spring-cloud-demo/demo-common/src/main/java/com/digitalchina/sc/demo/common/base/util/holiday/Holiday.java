package com.digitalchina.sc.demo.common.base.util.holiday;

/**
 * <p>================================================
 * <p>Title:
 * <p>Description:
 * <p>Date: 2018/9/5 10:53
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class Holiday {

    private int date;
    private boolean repose;

    public Holiday(int date, boolean repose) {
        this.date = date;
        this.repose = repose;
    }

    public int getDate() {
        return date;
    }

    public boolean getRepose() {
        return repose;
    }
}
