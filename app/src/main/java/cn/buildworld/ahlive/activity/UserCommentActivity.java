package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.HotMovieComments;
import cn.buildworld.ahlive.adapter.HotMovieCommentsAdapter;
import cn.buildworld.ahlive.bean.UserCommentBean;
import cn.buildworld.ahlive.listener.LoadMoreScrollListener;
import cn.buildworld.ahlive.utils.LinearLayoutManagerWrapper;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.MyDecoration;
import cn.buildworld.ahlive.utils.XUtils;

public class UserCommentActivity extends AppCompatActivity implements HotMovieCommentsAdapter.LoadMoreListener{

    private static final int STATE_NORMAL = 1;
    private static final int STATE_MORE = 2;
    private String mMovieId;
    private String TAG = "电影评论：";
    private RecyclerView mRecyclerView;
    private HotMovieComments mHotMovieComments;
    private List<UserCommentBean.DataBean.CtsBean> mList;
    private int state =1;
    private int currentPage = 1;
    private HotMovieCommentsAdapter mCommentsAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_comment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("电影评论区");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mMovieId = bundle.getString("movie_id");

        init();
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        initData();

    }

    private void init() {

        mRecyclerView = (RecyclerView) findViewById(R.id.commentRv);
        LinearLayoutManager layoutManager = new LinearLayoutManagerWrapper(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
//        mRecyclerView.addOnScrollListener(new LoadMoreScrollListener(layoutManager) {
//            @Override
//            public void onLoadMore(int currentPage) {
//                Log.i(TAG, "currentPage: "+currentPage);
//                loadMoreData();
//            }
//        });

    }

    public void initData(){


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
                    mCommentsAdapter = new HotMovieCommentsAdapter(mList, UserCommentActivity.this, UserCommentActivity.this);
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
