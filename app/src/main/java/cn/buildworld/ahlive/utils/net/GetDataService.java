package cn.buildworld.ahlive.utils.net;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 作者：MiChong on 2017/7/12 0012 15:17
 * 邮箱：1564666023@qq.com
 */
public interface GetDataService {
    //http://www.buildworld.xyz/onenet/getdata.php
    @GET("onenet/getdata.php")

    void getData(Call<Response> responseCall);

}
