# AhLive
# 手机生活客户端 #

### 集成新闻，图片，电影，搞笑视频等功能为一体的App,使用到今日头条，时光网，每日一文，和内涵段子的API接口，本软件无任何商业用途，如有侵权，请联系本人。

![](https://github.com/MiChongGET/AhLive/blob/master/app/ahlive.gif)

----------
>1、 本次项目使用到如下的开源库
#####  Xutils
#####  Gson
#####  MZBannerView
#####  Glide
#####  Jiecaovideoplayer
#####  fastjson
#####  butterknife
#####  RxTools
#####  ucrop
#####  EventBus

----------
>2、还使用到第三方集成SDK
####   高德地图定位模块
####   Mob的sharesdk，社会化分享

----------
>3、特别感谢作者jokermonn开源的API接口
[https://github.com/jokermonn/-Api](https://github.com/jokermonn/-Api)


#App详情
>4、基础框架搭建
#### SlidingActivity+TabFragment实现侧边栏和底部导航按钮
![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/1.png)![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/2.png)


1）侧边栏主要开发了个人中心，包括个人头像，姓名，个性签名，位置信息。其中位置信息是集成了高德地图的定位服务，实时获取用户的地理位置。头像和签名使用EventBus来更新的。图片使用Glide框架实现加载图片。

2）底部导航栏分为四个功能：首页，新闻中心，上映电影，以及搞笑视频模块。


>5、首页搭建

![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/2.png)![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/3.png)
###### １）图片滚动使用的是[MZBannerView](https://github.com/pinguo-zhouwei/MZBannerView)，仿照魅族商店的滚动图片做的

###### 2）每日一文使用的是[每日一文](https://github.com/jokermonn/-Api/blob/master/OneArticle.md)的接口。文章显示界面使用的是CollapsingToolbarLayout+AppBarLayout

######  其中改变标题显示

<pre><code>

mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
		//判断位置
                if (verticalOffset <= -mLayout.getHeight() /2){
                    mToolbarLayout.setTitle(mTitle1);
                }else {
                    mToolbarLayout.setTitle("");
                }
            }
        });
</code></pre>

>6、新闻中心

###### 新闻中心分为推荐、社会、段子、趣图四个模块

![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/4.png)
![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/5.png)
![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/6.png)

使用到[今日头条](https://github.com/jokermonn/-Api/blob/master/Todaynews.md)的api接口

界面使用的是ReclerView搭建的，新闻模块和社会模块中在自定义adapter判断图片有无以及显示图片多少设置相应的xml。趣图模块使用Glide实现静态图和Gif图的显示。

>7、上映电影模块使用[时光网](https://github.com/jokermonn/-Api/blob/master/Time.md)的API

![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/6.png)![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/8.png)![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/9.png)

电影详情模块使用CollapsingToolbarLayout+AppBarLayout，下半部分使用TabLayout+ViewPager结合使用实现滑动效果。预告片视频使用的是[Jiecaovideoplayer](https://github.com/lipangit/JieCaoVideoPlayer)。分享模块使用的Mob的社会化分享业务。评论区主要是实现每20个条目更新。

评论区条目更新的实现，搭建	自定义的[BaseLoadAdapter](https://github.com/MiChongGET/AhLive/blob/master/app/src/main/java/cn/buildworld/ahlive/adapter/BaseLoadAdapter.java)以及[LoadMoreScrollListener](https://github.com/MiChongGET/AhLive/blob/master/app/src/main/java/cn/buildworld/ahlive/listener/LoadMoreScrollListener.java)
<pre><code>
public void addList(List<T> addList) {
        Log.i("MiChong", "addList: "+addList.size());
        int count = this.list.size();
        this.list.addAll(addList);
        notifyItemRangeChanged(count, addList.size());
        setLoading(false);
    }
</code></pre>

>8、搞笑视频模块，引用[内涵段子](https://github.com/jokermonn/-Api/blob/master/Neihan.md)的api接口。


![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/11.png)

主要使用[Jiecaovideoplayer](https://github.com/lipangit/JieCaoVideoPlayer)框架。修改了方法实现视频上下滑动自动暂停和自动播放。详情请看[代码](https://github.com/MiChongGET/AhLive/blob/master/app/src/main/java/cn/buildworld/ahlive/fragment/GaoxiaoVideo.java)

>9、[个人中心模块](https://github.com/MiChongGET/AhLive/blob/master/app/src/main/java/cn/buildworld/ahlive/activity/PersonalActivity.java)，实现头像更换，修改签名，生日等。


![](https://github.com/MiChongGET/AhLive/blob/master/app/pic/12.png)

头像图片剪裁使用的是[uCrop](https://github.com/Yalantis/uCrop)开源框架。头像修改保存实现是利用图片剪裁后存在本地缓存，通过记录缓存路径找到头像，实现头像的更新和保存。

注意记得在AndroidManifest中加入


        <activity
           android:name="com.yalantis.ucrop.UCropActivity"
            android:screenOrientation="portrait"
            android:theme="@style/Theme.AppCompat.Light.NoActionBar"/>
</code></pre>
