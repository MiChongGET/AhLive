package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.HotMovieDetail;
import cn.buildworld.ahlive.bean.MovieDetail;
import cn.buildworld.ahlive.fragment.MovieContentFragment;
import cn.buildworld.ahlive.fragment.MovieVideoFragment;
import cn.buildworld.ahlive.utils.ApiUrl;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.XUtils;

import static android.R.id.list;

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
    private String[] titles = {"简介","预告片"};
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
        if (item.getItemId() == R.id.user_comments_menu){

            Bundle bundle = new Bundle();
            bundle.putString("movie_id", String.valueOf(mMovieId));
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(this,UserCommentActivity.class);
            startActivity(intent);

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
//        mRanking = (TextView) findViewById(R.id.ranking);
//        mTodayBoxDes = (TextView) findViewById(R.id.todayBoxDes);
//        mTotalBoxDes = (TextView) findViewById(R.id.totalBoxDes);
//        mMvStory = (TextView) findViewById(R.id.movie_story);

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
//                StringBuilder stringBuilder = null;
//                for (int i = 0; i <mBasic.getType().size() ; i++) {
//                    stringBuilder.append(mBasic.getType().get(i));
//                    if (i<mBasic.getType().size()){
//                        stringBuilder.append("/");
//                    }
//                }
//                mType.setText(stringBuilder.toString());
                //mMvStory.setText(mBasic.getStory());
//                mRanking.setText(boxOffice.getRanking());
//                mTodayBoxDes.setText(boxOffice.getTodayBoxDes());
//                mTotalBoxDes.setText(boxOffice.getTotalBoxDes());

                mList = new ArrayList<Fragment>();
                if (!TextUtils.isEmpty(mBasic.getStory())) {
                    mList.add(new MovieContentFragment(mBasic.getStory()));
                    mList.add(new MovieVideoFragment(mBasic.getVideo().getImg(),mBasic.getVideo().getTitle(),mBasic.getVideo().getHightUrl()));
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
