package com.bank.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    
    public static  String formatDate(Date date)throws ParseException{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
        return sdf.format(date);
    }
    
    public static Date parse(String strDate) throws ParseException{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
        return sdf.parse(strDate);
    }
}