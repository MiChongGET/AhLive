package cn.buildworld.ahlive.utils;

import java.text.SimpleDateFormat;

/**
 * 作者：MiChong on 2017/7/24 0024 15:55
 * 邮箱：1564666023@qq.com
 *
 *
 * 时间戳转化为时间
 */
public class TransforDate {

    private Integer ms ;

    public TransforDate(Integer ms) {
        this.ms = ms;
    }

    //时间戳转化为时间
    public static String transForDate1(Integer ms){
        String str = "";
        if(ms!=null){
            long msl=(long)ms*1000;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if(ms!=null){
                try {
                    str=sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }
}
