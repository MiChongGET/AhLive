package cn.buildworld.ahlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.news.NewCenterHotContentBean;
import cn.buildworld.ahlive.bean.news.NewsCenterHotBean;
import cn.buildworld.ahlive.utils.TransforDate;

/**
 * 作者：MiChong on 2017/7/27 0027 20:08
 * 邮箱：1564666023@qq.com
 */
public class NewsCentHotAdapter extends RecyclerView.Adapter<NewsCentHotAdapter.ViewHolder>{


    private  List<NewsCenterHotBean.DataBean> data;
    private Context mContext;
    private int mArticleType;
    private NewCenterHotContentBean mContentBean;
    private Gson gson = new Gson();
    private NewCenterHotContentBean mHotContentBean;
    private String TAG = "热门新闻适配器：";
    private boolean mHas_image;
    private OnNewsCenterListener mOnNewsCenterListener;
    private String mArticleUrl;

    public NewsCentHotAdapter( List<NewsCenterHotBean.DataBean> data, Context context) {
        this.data = data;
        this.mContext = context;
    }


    public void setOnNewsCenterListener(OnNewsCenterListener onNewsCenterListener){
        this.mOnNewsCenterListener = onNewsCenterListener;
    }


    @Override
    public NewsCentHotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newscenter_hot_item,parent,false));
        }
        else if (viewType == 1){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newscenter_hot_item2,parent,false));
        }
        else {
           return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newscenter_hot_item3,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(final NewsCentHotAdapter.ViewHolder holder, int position) {


        if (mHas_image && mHotContentBean.getTitle() != null && mHotContentBean.getImage_list().size() >0){

            holder.newscenter_title.setText(mHotContentBean.getTitle());
            holder.keywords.setText(mHotContentBean.getKeywords());
            holder.media_name.setText(mHotContentBean.getMedia_name());
            holder.behot_time.setText(TransforDate.transForDate1(mHotContentBean.getBehot_time()));
            Glide.with(mContext).load(mHotContentBean.getImage_list().get(0).getUrl()).into(holder.newscenter_img1);
            Glide.with(mContext).load(mHotContentBean.getImage_list().get(1).getUrl()).into(holder.newscenter_img2);
            Glide.with(mContext).load(mHotContentBean.getImage_list().get(2).getUrl()).into(holder.newscenter_img3);

            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int po = holder.getLayoutPosition();
                    mOnNewsCenterListener.onClick(holder.mLayout,po,mArticleUrl);
                }
            });


        }else if (!mHas_image){

            holder.title3.setText(mHotContentBean.getTitle());
            holder.media_name3.setText(mHotContentBean.getMedia_name());
            holder.behot_time3.setText(TransforDate.transForDate1(mHotContentBean.getBehot_time()));
            holder.mLayout3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int po = holder.getLayoutPosition();
                    mOnNewsCenterListener.onClick(holder.mLayout3,po,mArticleUrl);
                }
            });

        }else {

            Log.i(TAG, "onBindViewHolder: "+"我是第二种界面");
            holder.title2.setText(mHotContentBean.getTitle());
            holder.media_name2.setText(mHotContentBean.getMedia_name());
            holder.behot_time2.setText(TransforDate.transForDate1(mHotContentBean.getBehot_time()));
            Glide.with(mContext).load(mHotContentBean.getMiddle_image().getUrl()).into(holder.newscenter_img12);
            holder.mLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int po = holder.getLayoutPosition();
                    mOnNewsCenterListener.onClick(holder.mLayout2,po,mArticleUrl);
                }
            });

        }



    }

    @Override
    public int getItemCount() {

        return data == null ? 0 :data.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (data.size() != 0) {

            mHotContentBean = gson.fromJson(data.get(position).getContent(), NewCenterHotContentBean.class);
            if (mHotContentBean != null)
//                Log.i(TAG, "hot " + mHotContentBean.getTitle());
//                    hotlistBeen.add(new NewsHotlistBean(hot.getTitle(),hot.getKeywords(),hot.getMedia_name(),
//                    hot.getBehot_time(),hot.getImage_list().get(0).getUrl(),

            mArticleType = mHotContentBean.getArticle_type();
//            Log.i(TAG, "mArticleType " + mHotContentBean.getArticle_type());
        }
        mHas_image = mHotContentBean.isHas_image();
        mArticleUrl = mHotContentBean.getArticle_url();
        Log.i(TAG, "网址： "+position+"----------"+mArticleUrl);
//        Log.i(TAG, "isHas_image: "+ mHas_image);

            if (mHas_image) {
                if (mHotContentBean.getImage_list().size() >0)
                return 0;
                else return 1;
            } else {
                return 2;
            }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView newscenter_title;
        TextView keywords;
        TextView media_name;
        TextView behot_time;
        ImageView newscenter_img1;
        ImageView newscenter_img2;
        ImageView newscenter_img3;

        TextView title2;
        ImageView newscenter_img12;
        TextView media_name2;
        TextView behot_time2;


        TextView title3;
        TextView media_name3;
        TextView behot_time3;

        LinearLayout mLayout;
        LinearLayout mLayout2;
        LinearLayout mLayout3;
        public ViewHolder(View itemView) {
            super(itemView);

            newscenter_title = (TextView) itemView.findViewById(R.id.newscenter_title);
            keywords = (TextView) itemView.findViewById(R.id.keywords);
            media_name = (TextView) itemView.findViewById(R.id.media_name);
            behot_time = (TextView) itemView.findViewById(R.id.behot_time);
            newscenter_img1 = (ImageView) itemView.findViewById(R.id.newscenter_img1);
            newscenter_img2 = (ImageView) itemView.findViewById(R.id.newscenter_img2);
            newscenter_img3 = (ImageView) itemView.findViewById(R.id.newscenter_img3);


            title2 = (TextView) itemView.findViewById(R.id.title2);
            newscenter_img12 = (ImageView) itemView.findViewById(R.id.img_2);
            media_name2 = (TextView) itemView.findViewById(R.id.media_name2);
            behot_time2 = (TextView) itemView.findViewById(R.id.behot_time2);

            title3 = (TextView) itemView.findViewById(R.id.title3);
            media_name3 = (TextView) itemView.findViewById(R.id.media_name3);
            behot_time3 = (TextView) itemView.findViewById(R.id.behot_time3);

            mLayout = (LinearLayout) itemView.findViewById(R.id.layout_1);
            mLayout2 = (LinearLayout) itemView.findViewById(R.id.layout_2);
            mLayout3 = (LinearLayout) itemView.findViewById(R.id.layout_3);
        }
    }

    public interface OnNewsCenterListener{
        void onClick(View view,int position,String url);
    }


}
