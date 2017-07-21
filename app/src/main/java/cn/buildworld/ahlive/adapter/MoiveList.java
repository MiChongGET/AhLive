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
import cn.buildworld.ahlive.bean.TimeMoive;

/**
 * 作者：MiChong on 2017/7/20 0020 16:22
 * 邮箱：1564666023@qq.com
 */
public class MoiveList extends RecyclerView.Adapter<MoiveList.ViewHolder> {

    private List<TimeMoive.MoviesBean> mMoviesBeen;
    private Context mContext;
    private MoiveList.OnImageViewListener mOnImageViewListener;

    public MoiveList(Context context,List<TimeMoive.MoviesBean> moviesbeen) {
        mMoviesBeen = moviesbeen;
        mContext = context;
    }

//    public void update(ArrayList<String> mStrings){
//        this.mStrings = mStrings;
//        notifyDataSetChanged();
//    }

    public void setOnImageViewListener(OnImageViewListener onImageViewListener){
        this.mOnImageViewListener = onImageViewListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //使用图片框架加载图片
        Glide.with(mContext).load(mMoviesBeen.get(position).getImg())
                .into(holder.img);
        if (!mMoviesBeen.get(position).isIsHot()){
            holder.newmoive.setVisibility(View.INVISIBLE);
        }

        holder.tv.setText("《"+mMoviesBeen.get(position).getTitleCn()+"》");
        holder.commenSpecial.setText(mMoviesBeen.get(position).getCommonSpecial());
        holder.directorName.setText("导演："+mMoviesBeen.get(position).getDirectorName());
        holder.actorName.setText("主演："+mMoviesBeen.get(position).getActorName1()+"/"+mMoviesBeen.get(position).getActorName2());
        holder.type.setText(mMoviesBeen.get(position).getType());
        holder.rday.setText("上映时间："+mMoviesBeen.get(position).getRYear()+"/"+mMoviesBeen.get(position).getRMonth()
        +"/"+mMoviesBeen.get(position).getRDay());

        //设置图片监听回调
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnImageViewListener != null) {
                    int po = holder.getLayoutPosition();
                    mOnImageViewListener.OnClick(holder.tv, po);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMoviesBeen == null ? 0:mMoviesBeen.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        TextView rday;
        TextView commenSpecial;
        TextView directorName;
        TextView actorName;
        TextView type;
        ImageView img;
        ImageView newmoive;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.name);
            img = (ImageView) itemView.findViewById(R.id.movie_item_img);
            rday = (TextView) itemView.findViewById(R.id.rday);
            commenSpecial = (TextView) itemView.findViewById(R.id.commenSpecial);
            directorName = (TextView) itemView.findViewById(R.id.directorName);
            actorName = (TextView) itemView.findViewById(R.id.actorName);
            newmoive = (ImageView) itemView.findViewById(R.id.newmoive);
            type = (TextView) itemView.findViewById(R.id.type);
        }
    }


    //图片事件监听回调
    public interface OnImageViewListener{

        void OnClick(View view,int position);

    }

}
