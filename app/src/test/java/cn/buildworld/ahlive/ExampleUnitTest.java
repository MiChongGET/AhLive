package cn.buildworld.ahlive;

import org.junit.Test;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
//        System.out.println("hello world");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.buildworld.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();





    }

}