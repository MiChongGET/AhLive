package cn.buildworld.ahlive.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class Setting extends BaseFragment {


    public static Setting newInstance(){
        return new Setting();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_setting,null);
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);





        return view;
    }

    @Override
    public View initData() {
        return null;
    }
}
