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

import java.text.SimpleDateFormat;
import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.UserCommentBean;

/**
 * 作者：MiChong on 2017/7/23 0023 16:14
 * 邮箱：1564666023@qq.com
 */
public class HotMovieCommentsAdapter extends BaseLoadAdapter<UserCommentBean.DataBean.CtsBean>{

    private List<UserCommentBean.DataBean.CtsBean> ctsBeen;
    private Context mContext;
    private String TAG = "评论区数据适配器：";
    public static final int TYPE_OTHER = 1;//处于正常item
    public static final int TYPE_BOTTOM = 2;//加载到最底部
    private int max = 20;
    private LoadMoreListener loadMoreData;

    public HotMovieCommentsAdapter(List<UserCommentBean.DataBean.CtsBean> ctsBeen, Context context,LoadMoreListener loadMoreData) {
        this.list = ctsBeen;
        this.mContext = context;
        this.loadMoreData = loadMoreData;
    }



    @Override
    protected RecyclerView.ViewHolder setItemViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotmoviecomments_item,parent,false));
    }

    @Override
    protected void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(list.get(position).getCaimg()).into(((MyViewHolder)holder).user_icon);
        ((MyViewHolder)holder).username.setText(list.get(position).getCa());

        Log.i(TAG, "onBindViewHolder: " + list.get(position).getCd());

        ((MyViewHolder)holder).usertime.setText(transForDate1(list.get(position).getCd()));

        ((MyViewHolder)holder).comment_content.setText(list.get(position).getCe());
        ((MyViewHolder)holder).commentCount.setText(list.get(position).getCommentCount() + "");
    }


    @Override
    public void LoadingMore() {
        if(loadMoreData == null){
            return;
        }
//        max = max + 20;
        loadMoreData.loadMoreData();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        ImageView user_icon;
        TextView usertime;
        TextView comment_content;
        TextView commentCount;

        public MyViewHolder(View itemView) {
            super(itemView);

                username = (TextView) itemView.findViewById(R.id.user_name);
                user_icon  = (ImageView) itemView.findViewById(R.id.user_icon);
                usertime = (TextView) itemView.findViewById(R.id.user_time);
                comment_content = (TextView) itemView.findViewById(R.id.user_comment_content);
                commentCount = (TextView) itemView.findViewById(R.id.commentCount);
        }


    }

    public interface LoadMoreListener{
        void loadMoreData();
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
