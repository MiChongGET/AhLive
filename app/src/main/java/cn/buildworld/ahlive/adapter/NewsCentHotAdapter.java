package cn.buildworld.ahlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.NewCenterHotContentBean;
import cn.buildworld.ahlive.bean.NewsCenterHotBean;
import cn.buildworld.ahlive.bean.NewsHotlistBean;

/**
 * 作者：MiChong on 2017/7/27 0027 20:08
 * 邮箱：1564666023@qq.com
 */
public class NewsCentHotAdapter extends RecyclerView.Adapter<NewsCentHotAdapter.ViewHolder>{


    private List<NewsHotlistBean> data;
    private Context mContext;
    private int mArticleType;
    private NewCenterHotContentBean mContentBean;

    public NewsCentHotAdapter(List<NewsHotlistBean> data, Context context) {
        this.data = data;
        mContext = context;
    }




    @Override
    public NewsCentHotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newscenter_hot_item,parent,false));
        }
        else {
            return null;
        }


    }

    @Override
    public void onBindViewHolder(NewsCentHotAdapter.ViewHolder holder, int position) {

        if (mArticleType == 0){

            holder.newscenter_title.setText(mContentBean.getTitle());
            holder.keywords.setText(mContentBean.getKeywords());
            holder.media_name.setText(mContentBean.getMedia_name());
            holder.behot_time.setText(mContentBean.getBehot_time());
            Glide.with(mContext).load(mContentBean.getImage_list().get(0).getUrl()).into(holder.newscenter_img1);
            Glide.with(mContext).load(mContentBean.getImage_list().get(1).getUrl()).into(holder.newscenter_img2);
            Glide.with(mContext).load(mContentBean.getImage_list().get(2).getUrl()).into(holder.newscenter_img3);
        }

    }

    @Override
    public int getItemCount() {

        return data == null ? 0 :data.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (mArticleType == 0){
            return 0;
        }
        else
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView newscenter_title;
        TextView keywords;
        TextView media_name;
        TextView behot_time;
        ImageView newscenter_img1;
        ImageView newscenter_img2;
        ImageView newscenter_img3;


        public ViewHolder(View itemView) {
            super(itemView);

            newscenter_title = (TextView) itemView.findViewById(R.id.newscenter_title);
            keywords = (TextView) itemView.findViewById(R.id.keywords);
            media_name = (TextView) itemView.findViewById(R.id.media_name);
            behot_time = (TextView) itemView.findViewById(R.id.behot_time);
            newscenter_img1 = (ImageView) itemView.findViewById(R.id.newscenter_img1);
            newscenter_img2 = (ImageView) itemView.findViewById(R.id.newscenter_img2);
            newscenter_img3 = (ImageView) itemView.findViewById(R.id.newscenter_img3);
        }
    }
}
