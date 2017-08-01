package cn.buildworld.ahlive.utils.net;

import org.xutils.common.Callback;

/**
 * 作者：MiChong on 2017/7/16 0016 18:01
 * 邮箱：1564666023@qq.com
 */
public class MyCallBack<ResultType> implements Callback.CommonCallback<ResultType>{

    //ResultType 在此设置泛型是为了更好的扩展功能
    @Override
    public void onSuccess(ResultType result) {        //可以根据公司的需求进行统一的请求成功的逻辑处理
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {        //可以根据公司的需求进行统一的请求网络失败的逻辑处理
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override    public void onFinished() {

    }


}