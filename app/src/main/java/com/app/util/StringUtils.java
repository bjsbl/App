package com.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2015/8/13 0013.
 */
public class StringUtils {
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input)) {
            return true;
        } else {
            if (input.trim().length() > 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static String getCurTimeStr() {
        Calendar cal = Calendar.getInstance();
        String curDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
        return curDate;
    }
}
