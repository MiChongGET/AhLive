package cn.buildworld.ahlive.fragment;

import android.view.View;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class NewsCenter extends BaseFragment {


    public static NewsCenter newInstance(){
        return new NewsCenter();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_newscenter,null);
        return view;
    }

    @Override
    public View initData() {
        return null;
    }
}
