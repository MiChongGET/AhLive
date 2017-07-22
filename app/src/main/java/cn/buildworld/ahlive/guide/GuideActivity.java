package cn.buildworld.ahlive.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.activity.SlidingActivity;
import cn.buildworld.ahlive.utils.Preferences;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] images = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    private ArrayList<ImageView> imageViews;
    private LinearLayout container;
    private ImageView red_point;
    private int dis;
    private Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);



        initView();
        initControl();
        initData();
        viewPager.setAdapter(new GuideAdapter());
    }

    //布局文件初始化
    private void initView(){
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        container = (LinearLayout) findViewById(R.id.ll_container);
        red_point = (ImageView) findViewById(R.id.iv_red_point);
        start = (Button) findViewById(R.id.btn_start);

    }


    //控制
    private void initControl(){
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                //positionOffset偏移百分比
                //更新小红点距离
                int leftMargin = (int) (dis * positionOffset)+position * dis;//小红点当前的左边距

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) red_point.getLayoutParams();

                layoutParams.leftMargin = leftMargin;

                //重新设置布局参数
                red_point.setLayoutParams(layoutParams);


            }


            //某个页面被选中的时候
            @Override
            public void onPageSelected(int position) {

                if (position == imageViews.size() - 1){
                    start.setVisibility(View.VISIBLE);
                }else {
                    start.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //计算两个圆点的距离
        //移动距离 = 第二个圆点的left值 - 第一个圆点的值
        //  dis = container.getChildAt(1).getLeft() - container.getChildAt(0).getLeft();

        //监听layout方法结束的事件，位置确定好之后获取圆点间距
        red_point.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //移除监听，避免重复回调
                red_point.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                dis = container.getChildAt(1).getLeft() - container.getChildAt(0).getLeft();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.setBoolean(getApplicationContext(),"first_start",false);
                startActivity(new Intent(GuideActivity.this, SlidingActivity.class));
                finish();
            }
        });
    }

    private void initData(){
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i <images.length ; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(images[i]);
            imageViews.add(view);


            //设置小圆点
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.shape_point_gray);

            // 初始化布局参数, 宽高包裹内容,父控件是谁,就是谁声明的布局参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            if (i>0){
                params.leftMargin = 20;
            }

            imageView.setLayoutParams(params);

            container.addView(imageView);
        }
    }

    class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //初始化item布局
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = imageViews.get(position);
            container.addView(imageView);

            return imageView;
        }

        //销毁布局
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
