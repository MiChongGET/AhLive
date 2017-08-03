package cn.buildworld.ahlive.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.fragment.TabFragment;
import cn.buildworld.ahlive.listener.MyEvent;
import cn.buildworld.ahlive.utils.Preferences;
import cn.buildworld.ahlive.utils.StandardVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class SlidingActivity extends CheckPermissionsActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private String TAG = "侧边栏：";
    //高德定位系统
    public AMapLocationClient mLocationClient = null;
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {

            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                //可在其中解析amapLocation获取相应内容。


                    Log.i(TAG, "onLocationChanged: "+  aMapLocation.getCountry()+"-------"+
                    aMapLocation.getCity()+aMapLocation.getCityCode());

                    mPosition.setText(aMapLocation.getCity()+"  "+aMapLocation.getCountry());
                    if (!(TextUtils.isEmpty(aMapLocation.getCity()) && TextUtils.isEmpty(aMapLocation.getCountry()))){

                        Preferences.setString(SlidingActivity.this,"City",aMapLocation.getCity());
                        Preferences.setString(SlidingActivity.this,"Country",aMapLocation.getCountry());
                    }


                }else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError","location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }

        }
    };
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    private Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private TextView mPosition;
    private ImageView mHeaderIcon;
    private View mHeaderview;
    private TextView mUserName;
    private TextView mSign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        setSupportActionBar(mToolbar);

        //注册EventBus
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        //界面初始化
        init();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, TabFragment.newInstance()).commit();

      //定位功能实现
        getLocation();
//        mPosition.setText("安徽省");
        mHeaderIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlidingActivity.this, "个人中心", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SlidingActivity.this,PersonalActivity.class));
            }
        });

    }

    public void init(){


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        mHeaderview = mNavigationView.getHeaderView(0);
        mPosition = (TextView) mHeaderview.findViewById(R.id.position);
        mHeaderIcon = (ImageView) mHeaderview.findViewById(R.id.header_icon);
        mUserName = (TextView) mHeaderview.findViewById(R.id.user_name);
        mSign = (TextView) mHeaderview.findViewById(R.id.sign);

        String name = Preferences.getString(SlidingActivity.this, "name", null);
        if(!TextUtils.isEmpty(name)){
            mUserName.setText(name);
        }

        String iconUrl = Preferences.getString(SlidingActivity.this, "header_icon_url", null);
        if (!TextUtils.isEmpty(iconUrl)){
            Uri uri = Uri.parse(iconUrl);
            Glide.with(SlidingActivity.this)
                    .load(uri)
                    .error(R.drawable.header)
                    .into(mHeaderIcon);
        }

        String id = Preferences.getString(getApplicationContext(), "deviceID", null);
        if (TextUtils.isEmpty(id)) {
            TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            String deviceID = TelephonyMgr.getDeviceId();
//            Log.i(TAG, "设备序列号: " + deviceID);
            Preferences.setString(getApplicationContext(),"deviceID",deviceID);

        }

        String sign = Preferences.getString(SlidingActivity.this, "sign", null);
        if (!TextUtils.isEmpty(sign)){
            mSign.setText(sign);
        }

    }


    //高德地图定位功能

    public void getLocation(){
        //定位初始化
        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();

        //高精度定位模式：会同时使用网络定位和GPS定位，优先返回最高精度的定位结果，以及对应的地址描述信息。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        //低功耗定位模式：不会使用GPS和其他传感器，只会使用网络定位（Wi-Fi和基站定位）；
        //mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        //仅用设备定位模式：不需要连接网络，只使用GPS进行定位，这种模式下不支持室内环境的定位，自 v2.9.0 版本支持返回地址描述信息。
        //mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);

        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

    }



    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sliding, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_connection) {
            // Handle the camera action

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_introduce) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        StandardVideoPlayer.pauseVideo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MyEvent event){
        if (event.getIcon_url() != null) {
            Glide.with(this).load(event.getIcon_url()).into(mHeaderIcon);
            Log.i(TAG, "onEventMainThread: " + "头像更改完成！！！");
        }

        if (!TextUtils.isEmpty(event.getSign()))
        mSign.setText(event.getSign());
    }


}
