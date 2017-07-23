package cn.buildworld.ahlive.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class MovieContentFragment extends Fragment {

    private String content ;

    public MovieContentFragment(String content) {
        this.content = content;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fm_movie_content,null);


        TextView textView = (TextView) view.findViewById(R.id.movie_story);
        textView.setText(content);

        return view;
    }

}
