package cn.buildworld.ahlive;

import android.app.Application;
import android.util.Log;

import org.xutils.x;

/**
 * 作者：MiChong on 2017/7/14 0014 12:36
 * 邮箱：1564666023@qq.com
 */
public class AhLiveApp extends Application {

    private static final String TAG = "APP";
    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "初始化");
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}
