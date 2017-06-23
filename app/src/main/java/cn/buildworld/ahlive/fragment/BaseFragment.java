package cn.buildworld.ahlive.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：MiChong on 2017/6/23 0023 17:15
 * 邮箱：1564666023@qq.com
 */
public abstract class BaseFragment extends Fragment {


    private FragmentActivity myActivity;

    //Fragment创建
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myActivity = getActivity();//获取当前fragment所依赖的Activity对象；

    }

    //初始化fragment的布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = initView();

        return view;
    }


    //fragment所依赖的activity的onCreate方法执行结束
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //初始化数据
        initData();
    }


    //初始化布局，必须由子类实现
    public abstract View initView();

    //初始化数据，必须由子类实现
    public abstract View initData();

}
