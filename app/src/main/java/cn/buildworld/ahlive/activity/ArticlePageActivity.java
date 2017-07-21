package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.bean.BundleArticle;

public class ArticlePageActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mContent;
    private AppBarLayout mAppBarLayout;
    private LinearLayout mLayout;
    private TextView mTitle;
    private TextView mAuthor;
    private String mArticle;
    private String mAuthor1;
    private String mTitle1;


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
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_article_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("难服侍");
        setSupportActionBar(toolbar);

        // 设置返回键和菜单栏可用，可见
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mLayout = (LinearLayout) findViewById(R.id.apa_layout);
        mToolbarLayout.setBackgroundResource(R.drawable.article_bg);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mContent = (TextView) findViewById(R.id.apa_article);
        mTitle = (TextView) findViewById(R.id.apa_title);
        mAuthor = (TextView) findViewById(R.id.apa_author);

        //获取bundle传过来的值
        Intent intent = getIntent();
        BundleArticle bundleArticle = (BundleArticle) intent.getSerializableExtra("showArticle");
        mArticle = bundleArticle.getArticle();
        mAuthor1 = bundleArticle.getAuthor();
        mTitle1 = bundleArticle.getTitle();

        mTitle.setText(mTitle1);
        mAuthor.setText("作者："+mAuthor1);

        //
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -mLayout.getHeight() /2){
                    mToolbarLayout.setTitle(mTitle1);
                }else {
                    mToolbarLayout.setTitle("");
                }
            }
        });




        CharSequence charSequence ;
        //FROM_HTML_MODE_COMPACT：html块元素之间使用一个换行符分隔
        //FROM_HTML_MODE_LEGACY：html块元素之间使用两个换行符分隔
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            charSequence = Html.fromHtml(mArticle,Html.FROM_HTML_MODE_LEGACY);
        } else {
            charSequence = Html.fromHtml(mArticle);
        }
        mContent.setText(charSequence);

    }
}
