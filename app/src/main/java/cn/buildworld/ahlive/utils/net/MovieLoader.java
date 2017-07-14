package cn.buildworld.ahlive.utils.net;


import java.util.List;

import cn.buildworld.ahlive.bean.Movie;
import cn.buildworld.ahlive.bean.MovieSubject;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Func1;

/**
 * 作者：MiChong on 2017/7/12 0012 15:17
 * 邮箱：1564666023@qq.com
 */


public class MovieLoader extends ObjectLoader{

    private MovieService mMovieService;

    public MovieLoader(){
        mMovieService = RetrofitServiceManager.getInstance()
                .create(MovieService.class);
    }


    public Observable<List<Movie>> getMovie(int start, int count){
        return observe(mMovieService.getTop250(start,count))
                .map(new Func1<MovieSubject, List<Movie>>() {
                    @Override
                    public List<Movie> call(MovieSubject movieSubject) {
                        return movieSubject.subjects;
                    }
                });
    }


    public interface MovieService{

        //获取豆瓣Top250 榜单
        @GET("top250")
        Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);
    }


}
