package com.guo.uilts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author guosx
 * @date 2021/2/25
 */
public class DateUtil {
    public static String getDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
