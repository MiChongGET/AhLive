package cn.buildworld.ahlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.FunVideoBean;
import cn.buildworld.ahlive.utils.StandardVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 作者：MiChong on 2017/7/24 0024 20:17
 * 邮箱：1564666023@qq.com
 */
public class FunVideoAdapter extends RecyclerView.Adapter<FunVideoAdapter.ViewHolder> {

    private Context mContext;
    private  List<FunVideoBean.DataBeanX.DataBean> mDataBeen;
    private String TAG = "搞笑视频数据适配器";
    private OnImageShareListener mOnImageShareListener;


    public void setOnImageShareListener(OnImageShareListener onImageShareListener){
        this.mOnImageShareListener = onImageShareListener;
    }

    public FunVideoAdapter(Context context,  List<FunVideoBean.DataBeanX.DataBean> mDataBeen) {
        this.mContext = context;
        this.mDataBeen = mDataBeen;
    }

    @Override
    public FunVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.funvideo_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.funvideo_ad,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(final FunVideoAdapter.ViewHolder holder, final int position) {

        if (mDataBeen.get(position).getType() == 1) {
            holder.title.setText(mDataBeen.get(position).getGroup().getText());
            Glide.with(mContext).load(mDataBeen.get(position).getGroup().getUser().getAvatar_url()).into(holder.user_icon);
            holder.user_name.setText(mDataBeen.get(position).getGroup().getUser().getName());
            holder.category_name.setText(mDataBeen.get(position).getGroup().getCategory_name());

            holder.mJcVideoPlayerStandard.setUp(mDataBeen.get(position).getGroup().getMp4_url(),
                    JCVideoPlayer.SCREEN_LAYOUT_NORMAL,mDataBeen.get(position).getGroup().getCategory_name());
            Glide.with(mContext).load(mDataBeen.get(position).getGroup().getLarge_cover().getUrl_list().get(0).getUrl())
                    .into(holder.mJcVideoPlayerStandard.thumbImageView);
            holder.digg_count.setText(mDataBeen.get(position).getGroup().getDigg_count()+"");
            holder.bury_count.setText(mDataBeen.get(position).getGroup().getBury_count()+"");


            holder.img_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnImageShareListener != null) {
                        int po = holder.getLayoutPosition();
                        mOnImageShareListener.OnClick(holder.img_share, po);
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataBeen.get(position).getType() == 1){
            return 1;
        }else return 5;
    }

    @Override
    public int getItemCount() {
        return mDataBeen == null ? 0 :mDataBeen.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder {

       TextView title;
       ImageView user_icon;
       TextView user_name;
       StandardVideoPlayer mJcVideoPlayerStandard;
       TextView digg_count;
       TextView bury_count;
       TextView category_name;
       ImageView img_share;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.funvideo_title);
            user_icon = (ImageView) itemView.findViewById(R.id.user_icon);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            mJcVideoPlayerStandard = (StandardVideoPlayer)itemView.findViewById(R.id.JCVideoPlayerStandard);
            digg_count = (TextView) itemView.findViewById(R.id.digg_count);
            bury_count = (TextView) itemView.findViewById(R.id.bury_count);
            category_name = (TextView) itemView.findViewById(R.id.category_name);
            img_share = (ImageView) itemView.findViewById(R.id.img_share);
        }
    }

    public interface OnImageShareListener{
        void OnClick(View view,int position);
    }
}
