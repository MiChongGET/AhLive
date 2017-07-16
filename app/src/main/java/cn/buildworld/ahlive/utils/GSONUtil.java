package cn.buildworld.ahlive.utils;

import com.google.gson.Gson;

/**
 * 作者：MiChong on 2017/7/16 0016 18:49
 * 邮箱：1564666023@qq.com
 */
public class GSONUtil {
    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
}