package cn.buildworld.ahlive.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.NewsBrowserActivity;
import cn.buildworld.ahlive.adapter.NewsCentHotAdapter;
import cn.buildworld.ahlive.bean.news.NewCenterHotContentBean;
import cn.buildworld.ahlive.bean.news.NewsCenterHotBean;
import cn.buildworld.ahlive.utils.net.MyCallBack;
import cn.buildworld.ahlive.utils.MyDecoration;
import cn.buildworld.ahlive.utils.Preferences;
import cn.buildworld.ahlive.utils.net.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class NewsCenterHot extends BaseFragment {

    private String TAG = "新闻热点：";
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private long mL;
    private NewsCentHotAdapter mNewsCentHotAdapter;
    private Gson mGson;
    private Gson gson;
    private List<NewsCenterHotBean.DataBean> data;
    private NewCenterHotContentBean mContentBean;

    public static NewsCenterHot newInstance(){
        return new NewsCenterHot();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.newscenter_hot,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.newscenter_rl);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });




        return view;
    }


    public void getData(){
        mL = System.currentTimeMillis();
        long currentTimeMillis = Preferences.getLong(getContext(), "currentTimeMillis", 0);
        if (currentTimeMillis == 0){
            Preferences.setLong(getContext(),"currentTimeMillis", mL);
        }

        String deviceID = Preferences.getString(getContext(), "deviceID", null);
        XUtils.Get("http://is.snssdk.com/api/news/feed/v51/?category=news_hot&refer=one&count=20&min_behot_time=1491981025&last_refresh_sub_entrance_interval="+ mL +"&loc_mode=&loc_time="+ mL +"&latitude=&longitude=&city=&tt_from=pull&lac=&cid=&cp=&iid=0123456789&device_id="+deviceID+"&ac=wifi&channel=&aid=&app_name=&version_code=&version_name=&device_platform=&ab_version=&ab_client=&ab_group=&ab_feature=&abflag=3&ssmix=a&device_type=&device_brand=&language=zh&os_api=&os_version=&openudid=1b8d5bf69dc4a561&manifest_version_code=&resolution=&dpi=&update_version_code=&_rticket=",null,new MyCallBack<String>(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);

                Preferences.setLong(getContext(),"currentTimeMillis", mL);

                gson = new Gson();
                NewsCenterHotBean newsCenterHotBean = gson.fromJson(result, NewsCenterHotBean.class);
                data = newsCenterHotBean.getData();

                mNewsCentHotAdapter = new NewsCentHotAdapter(data, getContext());
                mRecyclerView.setAdapter(mNewsCentHotAdapter);
                Log.i(TAG, "onSuccess: "+ data.size());
                String content = data.get(0).getContent();
                Log.i(TAG, "content"+content);

                mNewsCentHotAdapter.setOnNewsCenterListener(new NewsCentHotAdapter.OnNewsCenterListener() {
                    @Override
                    public void onClick(View view, int position,String url) {
                        mContentBean = gson.fromJson(data.get(position).getContent(), NewCenterHotContentBean.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("article_url",mContentBean.getArticle_url());
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        intent.setClass(getActivity(), NewsBrowserActivity.class);
                        startActivity(intent);

                    }
                });

            }


        });




    }
    @Override
    public View initData() {

        getData();

        return null;
    }



}

