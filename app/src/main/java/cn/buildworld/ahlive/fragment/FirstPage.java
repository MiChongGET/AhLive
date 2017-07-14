package cn.buildworld.ahlive.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.Movie;
import cn.buildworld.ahlive.utils.Fault;
import cn.buildworld.ahlive.utils.net.MovieLoader;
import rx.functions.Action1;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */

public class FirstPage extends BaseFragment {
    public static final int []RES = new int[]{R.mipmap.image5,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image6,R.mipmap.image7,R.mipmap.image8};
    private MZBannerView mzBannerView;
    private List<Integer> list;



    public static FirstPage newInstance(){
        return new FirstPage();
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return x.view().inject(this,inflater,container);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }

        @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_firstpage,null);

        mzBannerView = (MZBannerView) view.findViewById(R.id.banner);


        list = new ArrayList<>();

        for (int i = 0; i <RES.length ; i++) {
            list.add(RES[i]);
        }

        mzBannerView.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        return view;

    }

      @Override
        public View initData() {

          System.out.println("网络功能开启！！！");

            return null;
    }



//    /**
//     * 获取电影列表
//     */
//    private void getMovieList(){
//        mMovieLoader.getMovie(0,10).subscribe(new Action1<List<Movie>>() {
//            @Override
//            public void call(List<Movie> movies) {
//                Log.e("zhouwei","get data suceess");
//
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                Log.e("TAG","error message:"+throwable.getMessage());
//                if(throwable instanceof Fault){
//                    Fault fault = (Fault) throwable;
//                    if(fault.getErrorCode() == 404){
//                        //错误处理
//                    }else if(fault.getErrorCode() == 500){
//                        //错误处理
//                    }else if(fault.getErrorCode() == 501){
//                        //错误处理
//                    }
//                }
//            }
//        });
//
//    }



    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }


//    @Override
//    public void onPause() {
//        super.onPause();
//        mzBannerView.pause();//暂停轮播
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mzBannerView.start();//开始轮播
//    }

}

