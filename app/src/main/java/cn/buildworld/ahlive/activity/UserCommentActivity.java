package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.HotMovieComments;
import cn.buildworld.ahlive.bean.UserCommentBean;
import cn.buildworld.ahlive.utils.ApiUrl;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.XUtils;

public class UserCommentActivity extends AppCompatActivity {

    private String mMovieId;
    private String TAG = "电影评论：";
    private RecyclerView mRecyclerView;


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
        initData();
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));


    }

    private void init() {

        mRecyclerView = (RecyclerView) findViewById(R.id.commentRv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    public void initData(){

        String url = ApiUrl.userComment+mMovieId;

        XUtils.Get(url,null,new MyCallBack<String>(){

            private List<UserCommentBean.DataBean.CtsBean> mList;

            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);

                Log.i(TAG, "onSuccess: "+result);
                Gson gson = new Gson();
                UserCommentBean userCommentBean = gson.fromJson(result, UserCommentBean.class);
//                Log.i(TAG, "onSuccess: "+userCommentBean.toString());
                UserCommentBean.DataBean data = userCommentBean.getData();
                mList = data.getCts();
                HotMovieComments hotMovieComments = new HotMovieComments(mList, UserCommentActivity.this);
                mRecyclerView.setAdapter(hotMovieComments);

                Log.i(TAG, "用户名 "+ mList.get(0).getCa());

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });

    }



    class MyItemDecoration extends RecyclerView.ItemDecoration {
        /**
         *
         * @param outRect 边界
         * @param view recyclerView ItemView
         * @param parent recyclerView
         * @param state recycler 内部数据管理
         */
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //设定底部边距为1px
            outRect.set(0, 0, 0, 1);
        }
    }



}
