package cn.buildworld.ahlive.adapter;

import android.content.Context;
import android.location.LocationListener;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.UserCommentBean;

/**
 * 作者：MiChong on 2017/7/23 0023 16:14
 * 邮箱：1564666023@qq.com
 */
public class HotMovieComments extends RecyclerView.Adapter<HotMovieComments.ViewHolder>{

    private List<UserCommentBean.DataBean.CtsBean> ctsBeen;
    private Context mContext;
    private String TAG = "评论区数据适配器：";
    public static final int TYPE_OTHER = 1;//处于正常item
    public static final int TYPE_BOTTOM = 2;//加载到最底部
    private int max = 20;

    public HotMovieComments(List<UserCommentBean.DataBean.CtsBean> ctsBeen, Context context) {
        this.ctsBeen = ctsBeen;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        if (viewType == TYPE_OTHER){
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotmoviecomments_item,parent,false);
//        viewHolder = new ViewHolder(view);
          return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotmoviecomments_item,parent,false),TYPE_OTHER);
        }else {

          return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_foot_item,parent,false),TYPE_BOTTOM);

        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_OTHER) {
            Glide.with(mContext).load(ctsBeen.get(position).getCaimg()).into(holder.user_icon);
            holder.username.setText(ctsBeen.get(position).getCa());

            Log.i(TAG, "onBindViewHolder: " + ctsBeen.get(position).getCd());

            holder.usertime.setText(transForDate1(ctsBeen.get(position).getCd()));

            holder.comment_content.setText(ctsBeen.get(position).getCe());
            holder.commentCount.setText(ctsBeen.get(position).getCommentCount() + "");
        }else {

            holder.loading_text.setText("正在加载");
        }
//        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        //总共有20条数据，此时必须加载一个item来放置footitem。
        return ctsBeen.size() < max ? ctsBeen.size(): max+1;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        ImageView user_icon;
        TextView usertime;
        TextView comment_content;
        TextView commentCount;

        TextView loading_text;
        public ViewHolder(View itemView,int viewType) {
            super(itemView);
            if (viewType == TYPE_OTHER){
                username = (TextView) itemView.findViewById(R.id.user_name);
                user_icon  = (ImageView) itemView.findViewById(R.id.user_icon);
                usertime = (TextView) itemView.findViewById(R.id.user_time);
                comment_content = (TextView) itemView.findViewById(R.id.user_comment_content);
                commentCount = (TextView) itemView.findViewById(R.id.commentCount);
            }else {
                loading_text = (TextView) itemView.findViewById(R.id. loading_text);
            }
        }
    }



    @Override
    public int getItemViewType(int position) {
        if (position == max)
            return TYPE_BOTTOM;
        return TYPE_OTHER;

    }

    //时间戳转化为时间
    public static String transForDate1(Integer ms){
        String str = "";
        if(ms!=null){
            long msl=(long)ms*1000;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if(ms!=null){
                try {
                    str=sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }
}
