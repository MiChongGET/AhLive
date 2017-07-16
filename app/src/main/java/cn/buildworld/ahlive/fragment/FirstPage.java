package cn.buildworld.ahlive.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.Article;
import cn.buildworld.ahlive.bean.Data;
import cn.buildworld.ahlive.utils.ApiUrl;
import cn.buildworld.ahlive.utils.GSONUtil;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.NetUtils;
import cn.buildworld.ahlive.utils.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */

public class FirstPage extends BaseFragment {
    public static final int []RES = new int[]{R.mipmap.image5,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image6,R.mipmap.image7,R.mipmap.image8};
    private MZBannerView mzBannerView;
    private List<Integer> list;
    private String TAG = "首页";
    private Article.DataBean articleData;

    private TextView title;
    private TextView author;
    private TextView digest;

    public static FirstPage newInstance(){
        return new FirstPage();
    }


        @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_firstpage,null);

        //每日一文
         title = (TextView) view.findViewById(R.id.cv_title);
         author = (TextView) view.findViewById(R.id.cv_author);
         digest = (TextView) view.findViewById(R.id.cv_digest);

        //轮播图的显示
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


          boolean connected = NetUtils.isConnected(getActivity());
          boolean iswifi = NetUtils.isWifi(getActivity());

          if (connected) {
              if (iswifi){
                  Toast.makeText(getActivity(), "正在使用wifi", Toast.LENGTH_SHORT).show();
              }else Toast.makeText(getActivity(), "正在使用移动网络", Toast.LENGTH_SHORT).show();
              //获取网络文章
              getAticle();
          }


          return null;
    }



    private static final String URL = "https://interface.meiriyiwen.com/article/today?dev=1";
    public void getAticle(){

        Log.i(TAG, "网络请求！！！");

//        RequestParams params = new RequestParams(URL);
//        Callback.Cancelable cancelable = x.http().get(params,new Callback.CommonCallback<String>(){
//
////            @Override
////            public void onSuccess(Object result) {
////                Log.i(TAG, "onSuccess: "+result);
////            }
//
//            @Override
//            public void onSuccess(String result) {
//                Log.i(TAG, "onSuccess: "+result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                Log.i(TAG, "onError");
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//            }
//
//            @Override
//            public void onFinished() {
//                Log.i(TAG, "onFinished");
//            }
//        });
////        cancelable.cancel();

        XUtils.Get(ApiUrl.ATICLE_URL,null,new MyCallBack<String>(){

            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);
                Gson gson = new Gson();
//                Data data = gson.fromJson(s, Data.class);
                Article article = gson.fromJson(result,Article.class);
                articleData = article.getData();
                Article.DataBean.DateBean date = articleData.getDate();
//                System.out.println("success: "+ articleData.getTitle());
//                System.out.println("success: "+ articleData.getAuthor());


                if (articleData != null){

                    title.setText(articleData.getTitle());
                    author.setText("作者："+articleData.getAuthor());
                    digest.setText(articleData.getDigest());
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

    class Person {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

    }


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


    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();//开始轮播
    }

}

