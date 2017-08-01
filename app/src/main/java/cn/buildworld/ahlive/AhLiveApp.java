package cn.buildworld.ahlive;

import android.app.Application;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.vondear.rxtools.RxUtils;

import org.xutils.x;

import cn.buildworld.ahlive.utils.Preferences;

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
        RxUtils.init(this);


    }
}
