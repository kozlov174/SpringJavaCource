package com.example.MyThirdApp.util;
import java.text.SimpleDateFormat;

public class DateTimeUtil {
    public static SimpleDateFormat getCustomFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
