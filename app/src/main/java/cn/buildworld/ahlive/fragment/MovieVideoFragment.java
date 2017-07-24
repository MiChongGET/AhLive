package cn.buildworld.ahlive.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.PlayVedioActivity;

/**
 * 作者：MiChong on 2017/7/22 0022 14:36
 * 邮箱：1564666023@qq.com
 */
public class MovieVideoFragment extends Fragment {

    private ImageView mImageView;

    private String img_url ;
    private String title ;
    private String video_url;

    private TextView mVideoTitle;

    public MovieVideoFragment(String img_url, String title, String video_url) {
        this.img_url = img_url;
        this.title = title;
        this.video_url = video_url;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fm_moive_video,null);

//        mPlayer = new GiraffePlayer(getActivity());
//        mPlayer.play("https://vf1.mtime.cn/Video/2017/07/16/mp4/170716214607948899.mp4");

        mImageView = (ImageView) view.findViewById(R.id.v_img);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle  = new Bundle();
                bundle.putString("video_url",video_url);
                bundle.putString("title",title);
                bundle.putString("img_url",img_url);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(),PlayVedioActivity.class);


                startActivity(intent);

            }
        });

        mVideoTitle = (TextView) view.findViewById(R.id.video_title);


        if (TextUtils.isEmpty(img_url) && TextUtils.isEmpty(title)){

        }else {
            mVideoTitle.setText(title);
            Glide.with(getActivity()).load(img_url).into(mImageView);
        }

        return view;
    }

}
