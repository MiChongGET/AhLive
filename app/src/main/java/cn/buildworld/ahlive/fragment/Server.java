package cn.buildworld.ahlive.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.MovieDetailActivity;
import cn.buildworld.ahlive.adapter.MoiveList;
import cn.buildworld.ahlive.bean.Article;
import cn.buildworld.ahlive.bean.CityCode;
import cn.buildworld.ahlive.bean.TimeMoive;
import cn.buildworld.ahlive.utils.ApiUrl;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.Preferences;
import cn.buildworld.ahlive.utils.XUtils;

import static android.content.Context.MODE_PRIVATE;

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
    private MoiveList mMoiveList;

    public static Server newInstance() {
        return new Server();
    }

    @Override
    public View initView() {

//        mSharedPreferences = getActivity().getSharedPreferences("config", MODE_PRIVATE);
//        citycode = mSharedPreferences.getString("citycode", null);
//        Log.i(TAG, "initView: " + citycode);
//
//        if (TextUtils.isEmpty(citycode)) {
//
//            mView = View.inflate(getActivity(), R.layout.fm_addcity, null);
//
//            mCityname = (EditText) mView.findViewById(R.id.cityName);
//
//            mToString = mCityname.getText().toString();
//
//            mButton = (Button) mView.findViewById(R.id.button_cityname);
//            mButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!TextUtils.isEmpty(mToString)) {
//                        mEditor = mSharedPreferences.edit();
//                        mEditor.putString("cityname", mToString);
//                        mEditor.commit();
//                        mView = View.inflate(getActivity(), R.layout.fm_server, null);
//
//                    } else {
//                        Toast.makeText(getActivity(), "输入的城市为空", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//
//
//        } else {
//
//
//        }
        mView = View.inflate(getActivity(), R.layout.fm_server, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.moive_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        ArrayList<String> list = new ArrayList<String>();
//        for (int i = 0; i < 20 ; i++) {
//            list.add("我是第"+i);
//        }
//
//        Log.i(TAG, "list: "+list.toString());


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

                mMoiveList = new MoiveList(getContext(), movies);

                mRecyclerView.setAdapter(mMoiveList);

                mMoiveList.setOnImageViewListener(new MoiveList.OnImageViewListener() {
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
