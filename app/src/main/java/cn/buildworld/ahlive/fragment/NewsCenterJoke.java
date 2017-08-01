package cn.buildworld.ahlive.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.NewsCentJokeAdapter;
import cn.buildworld.ahlive.bean.news.NewsCenterHotBean;
import cn.buildworld.ahlive.utils.net.MyCallBack;
import cn.buildworld.ahlive.utils.Preferences;
import cn.buildworld.ahlive.utils.net.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class NewsCenterJoke extends BaseFragment {

    private String TAG = "笑话：";
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private long mL;

    public static NewsCenterJoke newInstance(){
        return new NewsCenterJoke();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.newscenter_joke,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.newscenter_rl);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.SwipeRefreshLayout);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));

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
        long currentTimeMillis = Preferences.getLong(getContext(), "currentTimeMillis3", 0);
        if (currentTimeMillis == 0){
            Preferences.setLong(getContext(),"currentTimeMillis3", mL);
        }
        String url = "http://is.snssdk.com/api/news/feed/v51/?category=essay_joke&refer=1&count=20&min_behot_time="+currentTimeMillis+"&last_refresh_sub_entrance_interval="+mL+"&loc_mode=&loc_time="+mL+"&latitude=&longitude=&city=&tt_from=pull&lac=&cid=&cp=&iid=0123456789&device_id=12345678952&ac=wifi&channel=&aid=&app_name=&version_code=&version_name=&device_platform=&ab_version=&ab_client=&ab_group=&ab_feature=&abflag=3&ssmix=a&device_type=&device_brand=&language=zh&os_api=&os_version=&openudid=1b8d5bf69dc4a561&manifest_version_code=&resolution=&dpi=&update_version_code=&_rticket=";
        XUtils.Get(url,null,new MyCallBack<String>(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);
                Preferences.setLong(getContext(),"currentTimeMillis3", mL);

                Gson gson = new Gson();
                NewsCenterHotBean newsCenterHotBean = gson.fromJson(result, NewsCenterHotBean.class);
                List<NewsCenterHotBean.DataBean> data = newsCenterHotBean.getData();
                String content = data.get(0).getContent();
                Log.i(TAG, "content: "+content);

                mRecyclerView.setAdapter(new NewsCentJokeAdapter(data,getContext()));


            }
        });

    }
    @Override
    public View initData() {

        getData();

        return null;
    }



}

