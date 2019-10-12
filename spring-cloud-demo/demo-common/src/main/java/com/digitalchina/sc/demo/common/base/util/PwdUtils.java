package com.digitalchina.sc.demo.common.base.util;

import cn.hutool.crypto.SecureUtil;

/**
 * Created by heyt on 2018/5/25.
 */
public class PwdUtils {


    public static String encode(CharSequence rawPassword) {
        return SecureUtil.md5(rawPassword.toString());
    }


    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (SecureUtil.md5(rawPassword.toString()).equals(encodedPassword)) {
            return true;
        }
        return false;
    }

    public static String encodeSalt(CharSequence rawPassword) {
        return MD5Util.generate(rawPassword.toString());
    }


    public static boolean matchesSalt(CharSequence rawPassword, String encodedPassword) {
        return MD5Util.verify(rawPassword.toString(), encodedPassword);
    }


}
