package cn.buildworld.ahlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.buildworld.ahlive.R;

/**
 * 作者：MiChong on 2017/7/24 0024 20:17
 * 邮箱：1564666023@qq.com
 */
public class FunVideoAdapter extends RecyclerView.Adapter<FunVideoAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mStrings;
    private String TAG = "搞笑视频数据适配器";

    public FunVideoAdapter(Context context, List<String> strings) {
        mContext = context;
        mStrings = strings;
    }

    @Override
    public FunVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.funvideo_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FunVideoAdapter.ViewHolder holder, int position) {

        holder.title.setText(mStrings.get(position));
        Log.i(TAG, "onBindViewHolder: "+mStrings.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrings == null ? 0 :mStrings.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder {

       TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.funvideo_title);

        }
    }
}
