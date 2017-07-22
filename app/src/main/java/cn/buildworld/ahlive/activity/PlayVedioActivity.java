package cn.buildworld.ahlive.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.io.File;

import cn.buildworld.ahlive.R;

public class PlayVedioActivity extends AppCompatActivity {

    private StandardGSYVideoPlayer mStandardGSYVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_vedio);
        String source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";

        mStandardGSYVideoPlayer = (StandardGSYVideoPlayer) findViewById(R.id.StandardGSYVideoPlayer);

        mStandardGSYVideoPlayer.setUp(source1,true,null,"title");
        mStandardGSYVideoPlayer.startPlayLogic();





    }
}
