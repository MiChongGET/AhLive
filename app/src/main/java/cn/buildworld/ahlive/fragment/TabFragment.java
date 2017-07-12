package cn.buildworld.ahlive.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/6/23 0023 17:30
 * 邮箱：1564666023@qq.com
 */
public class TabFragment extends BaseFragment {

    public static TabFragment newInstance(){
        return new TabFragment();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    getFragmentManager().beginTransaction().replace(R.id.content,FirstPage.newInstance(),null).commit();
                    return true;
                case R.id.navigation_news:
                    getFragmentManager().beginTransaction().replace(R.id.content,NewsCenter.newInstance(),null).commit();
                    return true;
                case R.id.navigation_server:
                    getFragmentManager().beginTransaction().replace(R.id.content,Server.newInstance(),null).commit();
                    return true;
                case R.id.navigation_work:
                    getFragmentManager().beginTransaction().replace(R.id.content,Work.newInstance(),null).commit();
                    return true;
                case R.id.navigation_setting:
                    getFragmentManager().beginTransaction().replace(R.id.content,Setting.newInstance(),null).commit();
                    return true;
            }
            return false;
        }

    };


    @Override
    public View initView() {

        View view = View.inflate(getActivity(), R.layout.activity_tab, null);
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getFragmentManager().beginTransaction().replace(R.id.content,FirstPage.newInstance(),null).commit();
        return view;
    }

    @Override
    public View initData() {
        return null;
    }
}
