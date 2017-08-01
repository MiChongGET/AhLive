package cn.buildworld.ahlive;

import org.junit.Test;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);



//        X-Channel-Code:official
//        X-Client-Agent:Xiaomi
//        X-Client-Hash:2f3d6ffkda95dlz2fhju8d3s6dfges3t
//        X-Client-ID:123456789123456
//        X-Client-Version:2.3.2
//        X-Long-Token:
//        X-Platform-Type:0
//        X-Platform-Version:5.0
//        X-Serial-Num:1492140134
//        X-User-ID:

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("X-Channel-Code","official");
        hashMap.put("X-Client-Agent","Xiaomi");
        hashMap.put("X-Client-Hash","");
        hashMap.put("X-Client-ID","");
        hashMap.put("X-Client-Version","");
        hashMap.put("X-Long-Token","");
        hashMap.put("X-Platform-Type","");
        hashMap.put("X-Platform-Version","");
        hashMap.put("X-Serial-Num","1500949815");
        hashMap.put("X-User-ID","");

//        XUtils.GetWithHeader("http://app.pearvideo.com/clt/jsp/v2/getCategorys.jsp",hashMap,new MyCallBack<String>(){
//
//            @Override
//            public void onSuccess(String result) {
//                super.onSuccess(result);
//                System.out.println(result);
//            }
//        });


        RequestParams params = new RequestParams("http://app.pearvideo.com/clt/jsp/v2/getCategorys.jsp");
        params.addHeader("X-Channel-Code","official");
        params.addHeader("X-Client-Agent","Xiaomi");
        params.addHeader("X-Client-Hash","");
        params.addHeader("X-Client-ID","");
        params.addHeader("X-Client-Version","");
        params.addHeader("X-Long-Token","");
        params.addHeader("X-Platform-Type","");
        params.addHeader("X-Platform-Version","");
        params.addHeader("X-Serial-Num","1500949815");
        params.addHeader("X-User-ID","");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

}