package cn.buildworld.ahlive.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：MiChong on 2017/6/14 0014 15:10
 * 邮箱：1564666023@qq.com
 */
public class Preferences {

    public static boolean getBoolean(Context context,String key,boolean value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getBoolean(key,value);
    }


    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);

        config.edit().putBoolean(key, value).commit();
    }

    public static String getString(Context context, String key, String value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getString(key,value);
    }


    public static void setString(Context context,String key,String value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);

        config.edit().putString(key, value).commit();
    }


    public static int getInt(Context context, String key, int value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getInt(key,value);
    }


    public static void setInt(Context context,String key,int value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);

        config.edit().putInt(key, value).commit();
    }

    public static long getLong(Context context, String key, long value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getLong(key,value);
    }


    public static void setLong(Context context,String key,long value){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);

        config.edit().putLong(key, value).commit();
    }

}
