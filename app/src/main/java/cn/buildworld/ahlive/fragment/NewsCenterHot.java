package cn.buildworld.ahlive.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.NewsCentHotAdapter;
import cn.buildworld.ahlive.bean.NewCenterHotContentBean;
import cn.buildworld.ahlive.bean.NewsCenterHotBean;
import cn.buildworld.ahlive.bean.NewsHotlistBean;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.MyDecoration;
import cn.buildworld.ahlive.utils.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class NewsCenterHot extends BaseFragment {

    private String TAG = "新闻热点：";
    private RecyclerView mRecyclerView;

    public static NewsCenterHot newInstance(){
        return new NewsCenterHot();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.newscenter_hot,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.newscenter_rl);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));


        return view;
    }


    public void getData(){
        long l = System.currentTimeMillis();
        XUtils.Get("http://is.snssdk.com/api/news/feed/v51/?category=news_hot&refer=1&count=20&min_behot_time=1491981025&last_refresh_sub_entrance_interval="+l+"&loc_mode=&loc_time="+l+"&latitude=&longitude=&city=&tt_from=pull&lac=&cid=&cp=&iid=0123456789&device_id=12345678952&ac=wifi&channel=&aid=&app_name=&version_code=&version_name=&device_platform=&ab_version=&ab_client=&ab_group=&ab_feature=&abflag=3&ssmix=a&device_type=&device_brand=&language=zh&os_api=&os_version=&openudid=1b8d5bf69dc4a561&manifest_version_code=&resolution=&dpi=&update_version_code=&_rticket=",null,new MyCallBack<String>(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);
                Gson gson = new Gson();
                NewsCenterHotBean newsCenterHotBean = gson.fromJson(result, NewsCenterHotBean.class);
                List<NewsCenterHotBean.DataBean> data = newsCenterHotBean.getData();

                mRecyclerView.setAdapter(new NewsCentHotAdapter(data,getContext()));
                Log.i(TAG, "onSuccess: "+data.size());
                String content = data.get(0).getContent();
                Log.i(TAG, "content"+content);



            }
        });

    }
    @Override
    public View initData() {

        getData();

        return null;
    }



}

