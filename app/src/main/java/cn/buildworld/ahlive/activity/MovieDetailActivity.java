package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.movie.HotMovieDetail;
import cn.buildworld.ahlive.fragment.MovieContentFragment;
import cn.buildworld.ahlive.fragment.MovieVideoFragment;
import cn.buildworld.ahlive.api.ApiUrl;
import cn.buildworld.ahlive.fragment.UserCommentFrament;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.XUtils;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MovieDetailActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mToolbarLayout;
    private AppBarLayout mAppBarLayout;
    private LinearLayout mLinearLayout;
    private String TAG = "影片详情";
    private int mMovieId;
    private ImageView mMovieImg;
    private TextView mCnName;
    private TextView mEnName;
    private TextView mLength;
    private TextView mType;
    private TextView mMvScore;
    private TextView mRanking;
    private TextView mTodayBoxDes;
    private TextView mTotalBoxDes;
    private TextView mMvStory;

    private HotMovieDetail.DataBean.BasicBean mBasic;
    private HotMovieDetail.DataBean mData;
    private HotMovieDetail mMovieDetail;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mList;
    private String[] titles = {"简介","预告片","评论"};
    private MyAdapter mMyAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_comment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        if (item.getItemId() == R.id.user_share){

//            Bundle bundle = new Bundle();
//            bundle.putString("movie_id", String.valueOf(mMovieId));
//            Intent intent = new Intent();
//            intent.putExtras(bundle);
//            intent.setClass(this,UserCommentActivity.class);
//            startActivity(intent);
            if (mMovieDetail != null)
            showShare();

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mMovieId = bundle.getInt("movie_id");
        Log.i(TAG, "onCreate: "+ mMovieId);

        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mLinearLayout = (LinearLayout) findViewById(R.id.movie_layout);

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -mLinearLayout.getHeight() / 2){
                    if (mBasic != null)
                        mToolbarLayout.setTitle(mBasic.getName());
                }else {
                    mToolbarLayout.setTitle("");
                }
            }
        });

        init();
        getData();
    }

    public void init(){
        mMovieImg = (ImageView) findViewById(R.id.movie_detail_img);
        mCnName = (TextView) findViewById(R.id.cn_name);
        mEnName = (TextView) findViewById(R.id.en_name);
        mLength = (TextView) findViewById(R.id.length);
        mType = (TextView) findViewById(R.id.type);
        mMvScore = (TextView) findViewById(R.id.mv_score);
        mTabLayout = (TabLayout) findViewById(R.id.toolbar_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);


    }

    public void getData(){
        String url = ApiUrl.MoiveDetail+mMovieId;
        XUtils.Get(url,null,new MyCallBack<String>(){


            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);
                Gson gson = new Gson();

//
//                //fastjson解析
//                JSONObject jsonObject = JSON.parseObject(result);
//                HotMovieDetail.DataBean dataBean = jsonObject.getObject("data", HotMovieDetail.DataBean.class);
//                String title = dataBean.getLive().getTitle();
//                Log.i(TAG, "title: "+title);


                mMovieDetail = gson.fromJson(result,HotMovieDetail.class);
                mData = mMovieDetail.getData();
                mBasic = mData.getBasic();
//                MovieDetail.DataBean.BoxOfficeBean boxOffice = data.getBoxOffice();
                Log.i(TAG, "onSuccess: "+ mBasic.getName());

                //内容填充
                Glide.with(getApplicationContext()).load(mBasic.getImg()).into(mMovieImg);
                mCnName.setText("《"+mBasic.getName()+"》");
                mEnName.setText(mBasic.getNameEn());
                if (mBasic.getOverallRating() >0) {
                    mMvScore.setText("评分："+mBasic.getOverallRating() + "");
                }else mMvScore.setText("0.0");
                mLength.setText("片长："+mBasic.getMins());


                mList = new ArrayList<Fragment>();
                if (!TextUtils.isEmpty(mBasic.getStory())) {
                    mList.add(new MovieContentFragment(mBasic.getStory()));
                    mList.add(new MovieVideoFragment(mBasic.getVideo().getImg(),mBasic.getVideo().getTitle(),mBasic.getVideo().getHightUrl()));
                    mList.add(new UserCommentFrament(mMovieId));
                    mMyAdapter = new MyAdapter(getSupportFragmentManager());
                    mViewPager.setAdapter(mMyAdapter);
                    mTabLayout.setupWithViewPager(mViewPager);
                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });

    }


    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不     调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(mBasic.getVideo().getTitle());
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(mBasic.getVideo().getHightUrl());
        // text是分享文本，所有平台都需要这个字段
        oks.setText("上映电影分享");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImageUrl(mBasic.getVideo().getImg());//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(mBasic.getVideo().getHightUrl());
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(mBasic.getVideo().getTitle());
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(mBasic.getVideo().getHightUrl());

        // 启动分享GUI
        oks.show(this);
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
