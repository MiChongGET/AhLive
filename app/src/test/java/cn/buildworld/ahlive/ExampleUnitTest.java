package cn.buildworld.ahlive;

import com.vondear.rxtools.RxEncryptUtils;

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
        String md2ToString = RxEncryptUtils.encryptMD2ToString("michong");
        System.out.println(md2ToString);

    }

}