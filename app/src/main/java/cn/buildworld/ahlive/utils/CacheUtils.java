package cn.buildworld.ahlive.utils;

import android.content.Context;

/**
 * 作者：MiChong on 2017/7/18 0018 19:35
 * 邮箱：1564666023@qq.com
 *
 * 网络缓存工具类
 *
 */
public class CacheUtils {

    /**
     * 以url为key,以json为value,保存在本地
     * @param url
     * @param json
     */

    /**
     * 设置缓存
     * @param url
     * @param json
     * @param context
     */
    public static void setCache(String url, String json, Context context){
        Preferences.setString(context,url,json);

    }

    /**
     * 获取缓存
     * @param url
     * @param context
     * @return
     */
    public static String getCache(String url,Context context){

        return Preferences.getString(context,url,null);
    }

}
