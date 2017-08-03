package cn.buildworld.ahlive.listener;

import android.net.Uri;

/**
 * 作者：MiChong on 2017/8/2 0002 10:51
 * 邮箱：1564666023@qq.com
 */
public class MyEvent {

    private Uri icon_url;
    private String sign;

    public MyEvent(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public MyEvent(Uri icon_url) {
        this.icon_url = icon_url;
    }



    public Uri getIcon_url() {
        return icon_url;
    }
}
