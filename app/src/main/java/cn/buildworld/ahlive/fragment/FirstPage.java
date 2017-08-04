package cn.buildworld.ahlive.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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

import java.util.ArrayList;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.ArticlePageActivity;
import cn.buildworld.ahlive.bean.article.Article;
import cn.buildworld.ahlive.bean.BundleArticle;
import cn.buildworld.ahlive.api.ApiUrl;
import cn.buildworld.ahlive.utils.net.MyCallBack;
import cn.buildworld.ahlive.utils.net.NetUtils;
import cn.buildworld.ahlive.utils.net.XUtils;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */

public class FirstPage extends BaseFragment {
    public static final int []RES = new int[]{R.mipmap.one,R.mipmap.two,R.mipmap.three,R.mipmap.four,R.mipmap.five};
    private MZBannerView mzBannerView;
    private List<Integer> list;
    private String TAG = "首页";
    private Article.DataBean articleData;

    private TextView title;
    private TextView author;
    private TextView digest;

    private CardView mCardView;

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
         mCardView = (CardView) view.findViewById(R.id.cv_article);

         mCardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (articleData != null) {

                     Bundle bundle = new Bundle();
                     BundleArticle article = new BundleArticle(articleData.getContent(), articleData.getAuthor()
                             , articleData.getTitle());

                     bundle.putSerializable("showArticle", article);
                     Intent intent = new Intent();
                     intent.putExtras(bundle);
                     intent.setClass(getActivity(), ArticlePageActivity.class);
                     startActivity(intent);
                 }else Toast.makeText(getActivity(), "网络异常!!!", Toast.LENGTH_SHORT).show();
             }
         });

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
          }else {
              Toast.makeText(getActivity(), "请检查您的网络！！！", Toast.LENGTH_SHORT).show();
          }


          return null;
    }



    public void getAticle(){

        Log.i(TAG, "网络请求！！！");

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

//                Log.i(TAG, "onSuccess: "+articleData.toString());


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


