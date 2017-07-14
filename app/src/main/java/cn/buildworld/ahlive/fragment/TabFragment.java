package cn.buildworld.ahlive.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/6/23 0023 17:30
 * 邮箱：1564666023@qq.com
 */
public class TabFragment extends BaseFragment {

    private FirstPage mFirstPage;
    private NewsCenter mNewsCenter;
    private Server mServer;
    private Work mWork;
    private Setting mSetting;
    private FragmentTransaction transaction;


    public static TabFragment newInstance(){
        return new TabFragment();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            transaction = getFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
//                    getFragmentManager().beginTransaction().replace(R.id.content,FirstPage.newInstance(),null).commit();

//                    if (mFirstPage == null) {
//                        mFirstPage = new FirstPage();
//                        transaction.add(R.id.content,mFirstPage);
//                    }
//                    hidefragment(transaction);
//                    transaction.show(mFirstPage);
//                    transaction.commit();

                    getFragment(mFirstPage,"firstpage");

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



    //传入fragment
    public void getFragment(Fragment fragment,String tag){

        if (fragment == null) {
            fragment = new FirstPage();
            transaction.add(R.id.content,fragment,tag);
//            fragment = FragmentManager.
        }
        hidefragment(transaction);
        transaction.show(fragment);
        transaction.commit();

    }

    //隐藏其它fragment
    private void hidefragment(FragmentTransaction transaction){

        if (mFirstPage != null){
            transaction.hide(mFirstPage);
        }

        if (mServer != null){
            transaction.hide(mServer);
        }

        if (mWork != null){
            transaction.hide(mWork);
        }

        if (mSetting != null){
            transaction.hide(mSetting);
        }

        if (mNewsCenter != null){
            transaction.hide(mNewsCenter);
        }


    }

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
