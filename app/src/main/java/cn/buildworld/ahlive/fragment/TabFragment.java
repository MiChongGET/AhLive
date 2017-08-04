package cn.buildworld.ahlive.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
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
    private GaoxiaoVideo mGaoxiaoVideo;
    private Setting mSetting;
    private FragmentTransaction transaction;


    private Fragment mFragment;
    private Fragment currentFragment;
    public static final String TAG_FIRSTPAGE = "FIRSTPAGE";
    public static final String TAG_NEWSCENTER = "NEWSCENTER";
    public static final String TAG_SERVER = "SERVER";
    public static final String TAG_WORK = "WORK";
    public static final String TAG_SETTING = "SETTING";
    private boolean isFristCreated;

    public static TabFragment newInstance(){
        return new TabFragment();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    addfragment(TAG_FIRSTPAGE);
                    return true;

                case R.id.navigation_news:
//                    getFragmentManager().beginTransaction().replace(R.id.content,NewsCenter.newInstance(),null).commit();
                    addfragment(TAG_NEWSCENTER);

                    return true;
                case R.id.navigation_server:
//                    getFragmentManager().beginTransaction().replace(R.id.content,Server.newInstance(),null).commit();

                    addfragment(TAG_SERVER);

                    return true;
                case R.id.navigation_work:
//                    getFragmentManager().beginTransaction().replace(R.id.content,GaoxiaoVideo.newInstance(),null).commit();

                    addfragment(TAG_WORK);

                    return true;
//                case R.id.navigation_setting:
////                    getFragmentManager().beginTransaction().replace(R.id.content,Setting.newInstance(),null).commit();
//                    addfragment(TAG_SETTING);
//
//
//                    return true;
            }
            return false;
        }

    };


    public void addfragment(String tag){
        mFragment = getFragmentManager().findFragmentByTag(tag);
        if (mFragment == null){
            transaction = getFragmentManager().beginTransaction();

            if (tag.equals("FIRSTPAGE")){
                mFragment = new FirstPage();
            }else if (tag.equals("NEWSCENTER")){
                mFragment = new NewsCenter();
            }else if (tag.equals("SERVER")){
                mFragment = new Server();
            }else if (tag.equals("WORK")){
                mFragment = new GaoxiaoVideo();
            }
// else if (tag.equals("SETTING")){
//                mFragment = new Setting();
//            }

            if (currentFragment != null){
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.content,mFragment,tag);
            transaction.commit();

            currentFragment = mFragment;

        }else if (currentFragment != mFragment){
            transaction = getFragmentManager().beginTransaction();
            transaction.show(mFragment);
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            currentFragment = mFragment;
            transaction.commit();

        }

    }



    @Override
    public View initView() {

        View view = View.inflate(getActivity(), R.layout.activity_tab, null);
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        getFragmentManager().beginTransaction().replace(R.id.content,FirstPage.newInstance(),null).commit();

        addfragment(TAG_FIRSTPAGE);


        return view;
    }

    @Override
    public View initData() {
        return null;
    }
}
