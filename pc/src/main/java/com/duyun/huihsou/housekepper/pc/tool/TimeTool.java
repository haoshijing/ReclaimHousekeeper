package com.duyun.huihsou.housekepper.pc.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class TimeTool {

    public static long StringToIntegeter(String Data) throws ParseException {

      return 1;
    }

    public static String  DataIntegerToString(Integer time){
        long nowTimeLong=new Long(time).longValue()*1000;
        DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  ymdhmsFormat.format(nowTimeLong);
    }




}
