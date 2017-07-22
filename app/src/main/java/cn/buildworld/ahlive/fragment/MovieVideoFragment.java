package cn.buildworld.ahlive.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shuyu.gsyvideoplayer.video.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.PlayVedioActivity;

/**
 * 作者：MiChong on 2017/7/22 0022 14:36
 * 邮箱：1564666023@qq.com
 */
public class MovieVideoFragment extends Fragment {

    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fm_moive_video,null);

//        mPlayer = new GiraffePlayer(getActivity());
//        mPlayer.play("https://vf1.mtime.cn/Video/2017/07/16/mp4/170716214607948899.mp4");

        mImageView = (ImageView) view.findViewById(R.id.v_img);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), PlayVedioActivity.class));

            }
        });


        return view;
    }





//    @Override
//    public void onPause() {
//        super.onPause();
//        if (mPlayer != null) {
//            mPlayer.onPause();
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (mPlayer != null) {
//            mPlayer.onResume();
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (mPlayer != null) {
//            mPlayer.onDestroy();
//        }
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        if (mPlayer != null) {
//            mPlayer.onConfigurationChanged(newConfig);
//        }
//    }

}
