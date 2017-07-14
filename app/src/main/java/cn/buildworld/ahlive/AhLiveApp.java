package cn.buildworld.ahlive;

import android.app.Application;

import org.xutils.x;

/**
 * 作者：MiChong on 2017/7/14 0014 12:36
 * 邮箱：1564666023@qq.com
 */
public class AhLiveApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
    }
}
