package cn.buildworld.ahlive.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.MovieDetailActivity;
import cn.buildworld.ahlive.adapter.MovieList;
import cn.buildworld.ahlive.bean.TimeMoive;
import cn.buildworld.ahlive.api.ApiUrl;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class Server extends BaseFragment {

    private String citycode;
    private SharedPreferences mSharedPreferences;
    private View mView;
    private String TAG = "时光电影：";
    private EditText mCityname;
    private String mToString;
    private SharedPreferences.Editor mEditor;
    private String mCitycode;
    private Button mButton;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MovieList mMovieList;

    public static Server newInstance() {
        return new Server();
    }

    @Override
    public View initView() {


        mView = View.inflate(getActivity(), R.layout.fm_server, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.moive_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.SwipeRefreshLayout);

        //数据刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });



        getData();


        return mView;
    }


    //列表数据获取
    public void getData(){
        XUtils.Get(ApiUrl.TimeMoive, null, new MyCallBack<String>() {

            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: " + result);
                Gson gson = new Gson();
                TimeMoive timeMoive = gson.fromJson(result, TimeMoive.class);
                final List<TimeMoive.MoviesBean> movies = timeMoive.getMovies();
                Log.i(TAG, "电影列表："+movies.get(0).getTitleCn());

                mMovieList = new MovieList(getContext(), movies);

                mRecyclerView.setAdapter(mMovieList);

                mMovieList.setOnImageViewListener(new MovieList.OnImageViewListener() {
                    @Override
                    public void OnClick(View view, int position) {
                        Log.i(TAG, "OnClick: "+position);
//                        Toast.makeText(getActivity(), "我是第"+position, Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putInt("movie_id",movies.get(position).getMovieId());
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        intent.setClass(getActivity(),MovieDetailActivity.class);
                        startActivity(intent);
                    }
                });


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });

    }

    @Override
    public View initData() {
        return null;
    }
}
