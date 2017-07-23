package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.HotMovieComments;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class PlayVedioActivity extends AppCompatActivity {


    private JCVideoPlayerStandard mJcVideoPlayerStandard;
    private Bundle mBundle;
    private String mVideoUrl;
    private String mTitle;
    private String mImgUrl;
    private RecyclerView mRecyclerView;
    private String TAG = "视频播放：";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_vedio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("返回电影详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true) ;


        Intent intent = getIntent();
        mBundle = intent.getExtras();
        mVideoUrl = (String) mBundle.get("video_url");
        mTitle = (String) mBundle.get("title");
        mImgUrl = (String) mBundle.get("img_url");


        String source1 = "https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4";

        //http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg

        init();
        initData();



    }

    public void init(){

        mJcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.JCVideoPlayerStandard);
        mJcVideoPlayerStandard.setUp(mVideoUrl, JCVideoPlayer.SCREEN_LAYOUT_NORMAL,mTitle);
        Glide.with(this).load(mImgUrl)
                .into(mJcVideoPlayerStandard.thumbImageView);


    }

    public void initData(){

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            list.add("我是第"+i);
//        }
//
//        Log.i(TAG, "initData: "+list.toString());
//        mRecyclerView.setAdapter(new HotMovieComments(list));
    }


    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
