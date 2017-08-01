package cn.buildworld.ahlive.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.HotMovieComments;
import cn.buildworld.ahlive.adapter.HotMovieCommentsAdapter;
import cn.buildworld.ahlive.bean.movie.UserCommentBean;
import cn.buildworld.ahlive.listener.LoadMoreScrollListener;
import cn.buildworld.ahlive.utils.LinearLayoutManagerWrapper;
import cn.buildworld.ahlive.utils.net.MyCallBack;
import cn.buildworld.ahlive.utils.MyDecoration;
import cn.buildworld.ahlive.utils.net.XUtils;

public class UserCommentFrament extends BaseFragment implements HotMovieCommentsAdapter.LoadMoreListener{

    private static final int STATE_NORMAL = 1;
    private static final int STATE_MORE = 2;
    private int mMovieId;
    private String TAG = "电影评论：";
    private RecyclerView mRecyclerView;
    private HotMovieComments mHotMovieComments;
    private List<UserCommentBean.DataBean.CtsBean> mList;
    private int state =1;
    private int currentPage = 1;
    private HotMovieCommentsAdapter mCommentsAdapter;

    public UserCommentFrament(int movieId) {
        mMovieId = movieId;
    }


    @Override
    public View initView() {

        View view = View.inflate(getActivity(),R.layout.fragment_user_comment,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.commentRv);
        LinearLayoutManager layoutManager = new LinearLayoutManagerWrapper(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));

        return view;
    }


    public View initData(){


        String url = "https://api-m.mtime.cn/Showtime/HotMovieComments.api?pageIndex="
                +currentPage+"&movieId="+mMovieId;

        Log.i(TAG, "网址： "+url);
        XUtils.Get(url,null,new MyCallBack<String>(){

            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);

                Log.i(TAG, "onSuccess: "+result);
                Gson gson = new Gson();
                UserCommentBean userCommentBean = gson.fromJson(result, UserCommentBean.class);
                UserCommentBean.DataBean data = userCommentBean.getData();
                mList = data.getCts();

//                mHotMovieComments = new HotMovieComments(mList, UserCommentActivity.this);
//                mHotMovieComments.updateData(mList);

                if (currentPage == 1) {
                    mCommentsAdapter = new HotMovieCommentsAdapter(mList, getActivity(), UserCommentFrament.this);
                    mRecyclerView.setOnScrollListener(new LoadMoreScrollListener(mRecyclerView));
                    mRecyclerView.setAdapter(mCommentsAdapter);
//                    currentPage += currentPage;
                }else mCommentsAdapter.addList(mList);


                if (mList.size() == 0){
                    mCommentsAdapter.setLastedStatus();
                }
                Log.i(TAG, "currentPage: "+currentPage);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });

        return null;
    }


    @Override
    public void loadMoreData() {
        if (mCommentsAdapter.isLoading()){
            return;
        }
        mCommentsAdapter.setLoading(true);
        currentPage = currentPage+1;
        initData();
//        mCommentsAdapter.setLastedStatus();
//        mCommentsAdapter.addList(mList);

    }
}
