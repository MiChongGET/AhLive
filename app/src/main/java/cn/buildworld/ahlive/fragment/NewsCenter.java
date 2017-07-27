package cn.buildworld.ahlive.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class NewsCenter extends BaseFragment {
    private List<Fragment> mList;
    private String[] titles = {"推荐","社会","段子","趣图"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public static NewsCenter newInstance(){
        return new NewsCenter();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_newscenter,null);

        mTabLayout = (TabLayout) view.findViewById(R.id.toolbar_tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);

        mList = new ArrayList<Fragment>();
        mList.add(new NewsCenterHot());
        mList.add(new NewsCenterHot());
        mList.add(new NewsCenterHot());
        mList.add(new NewsCenterHot());

        MyAdapter myAdapter = new MyAdapter(getFragmentManager());
        mViewPager.setAdapter(myAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


        return view;
    }

    @Override
    public View initData() {
        return null;
    }





    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}

