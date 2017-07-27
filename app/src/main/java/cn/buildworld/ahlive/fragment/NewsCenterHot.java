package cn.buildworld.ahlive.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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


        return view;
    }

    @Override
    public View initData() {

        XUtils.Get("http://is.snssdk.com/api/news/feed/v51/",null,new MyCallBack<String>(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);
                Gson gson = new Gson();
                NewsCenterHotBean newsCenterHotBean = gson.fromJson(result, NewsCenterHotBean.class);
                List<NewsCenterHotBean.DataBean> data = newsCenterHotBean.getData();

                Log.i(TAG, "onSuccess: "+data.size());
                String content = data.get(0).getContent();
                NewCenterHotContentBean hot = new NewCenterHotContentBean();

                List<NewsHotlistBean> hotlistBeen = new ArrayList<NewsHotlistBean>();

                for (int i = 0; i <data.size() ; i++) {

                    hot = gson.fromJson(data.get(i).getContent(), NewCenterHotContentBean.class);
                    Log.i(TAG, "hot "+hot.getTitle());
                    hotlistBeen.add(new NewsHotlistBean(hot.getTitle(),hot.getKeywords(),hot.getMedia_name(),
                    hot.getBehot_time(),hot.getImage_list().get(0).getUrl(),
                    hot.getImage_list().get(1).getUrl(),hot.getImage_list().get(2).getUrl(),hot.getArticle_type()));

                }

                Log.i(TAG, "hotlistBeen: "+hotlistBeen.toString());

//                mRecyclerView.setAdapter(new NewsCentHotAdapter(hotlistBeen,getContext()));

//


            }
        });


        return null;
    }



}

