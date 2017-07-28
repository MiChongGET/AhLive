package cn.buildworld.ahlive.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.util.List;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.adapter.FunVideoAdapter;
import cn.buildworld.ahlive.bean.FunVideoBean;
import cn.buildworld.ahlive.utils.MyCallBack;
import cn.buildworld.ahlive.utils.MyDecoration;
import cn.buildworld.ahlive.utils.StandardVideoPlayer;
import cn.buildworld.ahlive.utils.XUtils;
import cn.sharesdk.onekeyshare.OnekeyShare;
import fm.jiecao.jcvideoplayer_lib.JCMediaManager;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 作者：MiChong on 2017/7/12 0012 20:16
 * 邮箱：1564666023@qq.com
 */
public class GaoxiaoVideo extends BaseFragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private String TAG = "搞笑视频：";
    private FloatingActionButton mActionButton;
    private Animation mAnimation;
    private String mFunVedio;
    private long min_time = 0;
    private FunVideoAdapter mFunVideoAdapter;
    private FunVideoBean.DataBeanX mData;
    private List<FunVideoBean.DataBeanX.DataBean> mDataBeen;
    private String mShare_url;
    private String mImgUrl;
    private String mText;


    public static GaoxiaoVideo newInstance(){
        return new GaoxiaoVideo();
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fm_gaoxiaovideo,null);


        mActionButton = (FloatingActionButton) view.findViewById(R.id.funvideo_floatbutton);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.gxvideo_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.gx_swiperefresh);
        mActionButton.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int _firstItemPosition = -1, _lastItemPosition;
            private View fistView, lastView;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    //获取可见view的总数
                    int visibleItemCount = linearManager.getChildCount();

                    if (_firstItemPosition < firstItemPosition) {
                        Log.i(TAG, "onScrolled: "+"视频划上去了");
                        _firstItemPosition = firstItemPosition;
                        _lastItemPosition = lastItemPosition;
                        GCView(fistView);
                        fistView = recyclerView.getChildAt(0);
                        lastView = recyclerView.getChildAt(visibleItemCount - 1);
                    } else if (_lastItemPosition > lastItemPosition) {
                        Log.i(TAG, "onScrolled: "+"视频划下去了");
                        _firstItemPosition = firstItemPosition;
                        _lastItemPosition = lastItemPosition;
                        GCView(lastView);
                        fistView = recyclerView.getChildAt(0);
                        lastView = recyclerView.getChildAt(visibleItemCount - 1);
                    }else if (_firstItemPosition > firstItemPosition){
                        Log.i(TAG, "onScrolled: "+"视频从上滑倒下了");
                        _firstItemPosition = firstItemPosition;
                        _lastItemPosition = lastItemPosition;
                        ResumeView(fistView);
                        fistView = recyclerView.getChildAt(0);
                        lastView = recyclerView.getChildAt(visibleItemCount - 1);
                    }else if (_lastItemPosition < lastItemPosition){
                        _firstItemPosition = firstItemPosition;
                        _lastItemPosition = lastItemPosition;
                        Log.i(TAG, "onScrolled: "+"视频从下滑倒上了");
                        ResumeView(lastView);
                        fistView = recyclerView.getChildAt(0);
                        lastView = recyclerView.getChildAt(visibleItemCount - 1);
                    }
                }
            }

            /**
             * 回收播放
             * @param gcView
             */
            public void GCView(View gcView) {
                if (gcView != null && gcView.findViewById(R.id.JCVideoPlayerStandard) != null) {
                    StandardVideoPlayer video = (StandardVideoPlayer) gcView
                            .findViewById(R.id.JCVideoPlayerStandard);
                    if (video != null
                            && (video.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING || video.currentState == JCVideoPlayer.CURRENT_STATE_ERROR)) {
                        video.setSystemUiVisibility(JCVideoPlayer.CURRENT_STATE_AUTO_COMPLETE);
                        JCMediaManager.instance().mediaPlayer.pause();
                    }
                }
            }

            /**
             * 恢复播放
             * @param gcView
             */
            public void ResumeView(View gcView) {
                if (gcView != null && gcView.findViewById(R.id.JCVideoPlayerStandard) != null) {
                    StandardVideoPlayer video = (StandardVideoPlayer) gcView
                            .findViewById(R.id.JCVideoPlayerStandard);
                    if (video != null
                            && (video.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING || video.currentState == JCVideoPlayer.CURRENT_STATE_ERROR)) {
                        video.setSystemUiVisibility(JCVideoPlayer.CURRENT_STATE_AUTO_COMPLETE);
                        JCMediaManager.instance().mediaPlayer.start();
                    }
                }
            }
        });


        getData();

        return view;
    }


    @Override
    public View initData() {


        return null;
    }

    private void getData() {

        //悬浮按钮刷新
        mAnimation = new RotateAnimation(0.0f,+720f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mAnimation.setDuration(800);
        mAnimation.setFillAfter(true);
        mActionButton.setAnimation(mAnimation);

        //数据刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        //释放所有的视频
        StandardVideoPlayer.releaseAllVideos();

        long millis = System.currentTimeMillis();

        if (min_time == 0) {
            mFunVedio = "http://iu.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-104&message_cursor=-1&am_loc_time=" + millis + "&count=30&min_time="+millis+"&screen_width=1450&do00le_col_mode=0&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1920*1080&dpi=620&update_version_code=6470";
        }else {
            mFunVedio = "http://iu.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-104&message_cursor=-1&am_loc_time=" + millis + "&count=30&min_time="+min_time+"&screen_width=1450&do00le_col_mode=0&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1920*1080&dpi=620&update_version_code=6470";
            Log.i(TAG, "min_time"+min_time);
        }
        min_time = millis;

        XUtils.Get(mFunVedio,null,new MyCallBack<String>(){

            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Log.i(TAG, "onSuccess: "+result);
                com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(result);
                mData = jsonObject.getObject("data", FunVideoBean.DataBeanX.class);
                Log.i(TAG, "data:"+ mData.toString());
                mDataBeen = mData.getData();
                Log.i(TAG, "databean： "+ mDataBeen.size());
                String mp4_url = mDataBeen.get(0).getGroup().getMp4_url();

                Log.i(TAG, "mp4_url: "+mp4_url);

                mFunVideoAdapter = new FunVideoAdapter(getContext(), mDataBeen);
                mRecyclerView.setAdapter(mFunVideoAdapter);


                mFunVideoAdapter.setOnImageShareListener(new FunVideoAdapter.OnImageShareListener() {
                    @Override
                    public void OnClick(View view, int position) {

                        mShare_url = mDataBeen.get(position).getGroup().getShare_url();
                        mImgUrl = mDataBeen.get(position).getGroup().getLarge_cover().getUrl_list().get(0).getUrl();
                        mText = mDataBeen.get(position).getGroup().getText();
                        showShare();
                    }
                });

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });



    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不     调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(mText);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(mShare_url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("内涵段子搞笑视频");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImageUrl(mImgUrl);//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(mShare_url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(mText);
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(mShare_url);

        // 启动分享GUI
        oks.show(getActivity());
    }
}
