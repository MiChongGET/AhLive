package cn.buildworld.ahlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.news.NewCenterHotContentBean;
import cn.buildworld.ahlive.bean.news.NewsCenterHotBean;
import cn.buildworld.ahlive.bean.news.NewsCenterImageBean;
import cn.buildworld.ahlive.utils.TransforDate;

/**
 * 作者：MiChong on 2017/7/27 0027 20:08
 * 邮箱：1564666023@qq.com
 */
public class NewsCentImageAdapter extends RecyclerView.Adapter<NewsCentImageAdapter.ViewHolder>{


    private  List<NewsCenterHotBean.DataBean> data;
    private Context mContext;
    private int mArticleType;
    private NewCenterHotContentBean mContentBean;
    private Gson gson = new Gson();
    private NewCenterHotContentBean mHotContentBean;
    private String TAG = "图片适配器：";
    private boolean mHas_image;
    private OnNewsCenterListener mOnNewsCenterListener;
    private NewsCenterImageBean mImageContentBean;

    public NewsCentImageAdapter(List<NewsCenterHotBean.DataBean> data, Context context) {
        this.data = data;
        this.mContext = context;
    }


    public void setOnNewsCenterListener(OnNewsCenterListener onNewsCenterListener){
        this.mOnNewsCenterListener = onNewsCenterListener;
    }


    @Override
    public NewsCentImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newscenter_image_item, parent, false));


    }

    @Override
    public void onBindViewHolder(NewsCentImageAdapter.ViewHolder holder, int position) {

        holder.show_joke.setText(mImageContentBean.getContent());
        holder.show_time.setText(TransforDate.transForDate1(mImageContentBean.getBehot_time()));
//
        holder.show_image.setMaxHeight(mImageContentBean.getLarge_image().getHeight()*10);
        holder.show_image.setMaxWidth(mImageContentBean.getLarge_image().getWidth()*10);
        Glide.with(mContext).load(mImageContentBean.getLarge_image().getUrl()).into(holder.show_image);



    }

    @Override
    public int getItemCount() {

        return data == null ? 0 :data.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (data.size() != 0) {

            mImageContentBean = gson.fromJson(data.get(position).getContent(), NewsCenterImageBean.class);
            if (mImageContentBean != null) {

//                Log.i(TAG, "getItemViewType: "+mImageContentBean.getLarge_image().getUrl());
            }
        }
//        Log.i(TAG, "isHas_image: "+ mHas_image);

        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView show_joke;
        TextView show_time;
        ImageView show_image;


        public ViewHolder(View itemView) {
            super(itemView);

            show_joke = (TextView) itemView.findViewById(R.id.show_joke);
            show_time = (TextView) itemView.findViewById(R.id.show_time);
            show_image = (ImageView) itemView.findViewById(R.id.show_image);


        }
    }

    public interface OnNewsCenterListener{
        void onClick(View view, int position);
    }


}
