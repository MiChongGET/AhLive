package cn.buildworld.ahlive.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.FunVideoAdapter;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class GaoxiaoVideo extends BaseFragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private String TAG = "搞笑视频：";
    private FloatingActionButton mActionButton;
    private Animation mAnimation;

    public static GaoxiaoVideo newInstance(){
        return new GaoxiaoVideo();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_gaoxiaovideo,null);


        mActionButton = (FloatingActionButton) view.findViewById(R.id.funvideo_floatbutton);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.gxvideo_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.gx_swiperefresh);




        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();
            }
        });

        getData();

        return view;
    }


    @Override
    public View initData() {


        return null;
    }

    private void getData() {

        //悬浮按钮刷新
        mAnimation = new RotateAnimation(0.0f,+360f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mAnimation.setDuration(800);
        mAnimation.setFillAfter(true);
        mActionButton.setAnimation(mAnimation);

        //数据刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            list.add("我是第"+i);
        }


         mRecyclerView.setAdapter(new FunVideoAdapter(getContext(),list));

    }

}
