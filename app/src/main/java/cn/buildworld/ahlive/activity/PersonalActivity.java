package cn.buildworld.ahlive.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.vondear.rxtools.RxActivityUtils;
import com.vondear.rxtools.RxBarUtils;
import com.vondear.rxtools.RxFileUtils;
import com.vondear.rxtools.RxImageUtils;
import com.vondear.rxtools.RxPermissionsUtils;
import com.vondear.rxtools.RxPhotoUtils;
import com.vondear.rxtools.RxSPUtils;
import com.vondear.rxtools.activity.ActivityBase;
import com.vondear.rxtools.interfaces.onRequestPermissionsListener;
import com.vondear.rxtools.view.RxTitle;
import com.vondear.rxtools.view.dialog.RxDialog;
import com.vondear.rxtools.view.dialog.RxDialogChooseImage;
import com.vondear.rxtools.view.dialog.RxDialogEditSureCancel;
import com.vondear.rxtools.view.dialog.RxDialogSureCancel;
import com.vondear.rxtools.view.dialog.RxDialogWheelYearMonthDay;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.buildworld.ahlive.R;
import cn.buildworld.ahlive.listener.MyEvent;
import cn.buildworld.ahlive.utils.Preferences;
import cn.buildworld.ahlive.utils.net.XUtils;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.vondear.rxtools.view.dialog.RxDialogChooseImage.LayoutType.TITLE;

public class PersonalActivity extends ActivityBase {


    @BindView(R.id.rx_title)
    RxTitle mRxTitle;
    @BindView(R.id.tv_bg)
    TextView mTvBg;
    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.ll_anchor_left)
    LinearLayout mLlAnchorLeft;
    @BindView(R.id.rl_avatar)
    RelativeLayout mRlAvatar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_constellation)
    TextView mTvConstellation;
    @BindView(R.id.tv_birthday)
    TextView mTvBirthday;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_lables)
    TextView mTvLables;
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.editText2)
    TextView mEditText2;
    @BindView(R.id.btn_exit)
    Button mBtnExit;
    @BindView(R.id.activity_user)
    LinearLayout mActivityUser;
    @BindView(R.id.set_birthday)
    LinearLayout set_birthday;
    @BindView(R.id.xingzuo)
    LinearLayout xingzuo;
    @BindView(R.id.person_sign)
    LinearLayout person_sign;

    private Uri resultUri;
    private String TAG = "个人中心";
    private RxDialogWheelYearMonthDay mRxDialogWheelYearMonthDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarUtils.noTitle(this);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);

        //注册EventBus
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initView();

    }


    //生日修改器
    private void initWheelYearMonthDayDialog() {
        // ------------------------------------------------------------------选择日期开始
        mRxDialogWheelYearMonthDay = new RxDialogWheelYearMonthDay(this, 1990, 2017);
        mRxDialogWheelYearMonthDay.getTv_sure().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (mRxDialogWheelYearMonthDay.getCheckBox_day().isChecked()) {
                            mTvBirthday.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "/"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "/"
                                            + mRxDialogWheelYearMonthDay.getSelectorDay() + "/");
                            Preferences.setString(PersonalActivity.this,"birthday",mRxDialogWheelYearMonthDay.getSelectorYear() + "/"
                                    + mRxDialogWheelYearMonthDay.getSelectorMonth() + "/"
                                    + mRxDialogWheelYearMonthDay.getSelectorDay());
                        } else {
                            mTvBirthday.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "/"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "/");
                            Preferences.setString(PersonalActivity.this,"birthday",mRxDialogWheelYearMonthDay.getSelectorYear() + "/"
                                    + mRxDialogWheelYearMonthDay.getSelectorMonth());
                        }
                        mRxDialogWheelYearMonthDay.cancel();
                    }
                });
        mRxDialogWheelYearMonthDay.getTv_cancle().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        mRxDialogWheelYearMonthDay.cancel();
                    }
                });
        // ------------------------------------------------------------------选择日期结束
    }

    //填写星座
    public void setXingzuo(){
        final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(PersonalActivity.this);//提示弹窗
//               rxDialogEditSureCancel.setContent("123123");
//        rxDialogEditSureCancel.setTitle("星座");
        rxDialogEditSureCancel.getTvSure().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = rxDialogEditSureCancel.getEditText().getText().toString();
                mTvConstellation.setText(s);
                Preferences.setString(PersonalActivity.this,"xingzuo",s);
                rxDialogEditSureCancel.dismiss();
            }
        });
        rxDialogEditSureCancel.getTvCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxDialogEditSureCancel.cancel();
            }
        });
        rxDialogEditSureCancel.show();
    }

    //填写星座
    public void setSign(){
        final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(PersonalActivity.this);//提示弹窗
//               rxDialogEditSureCancel.setContent("123123");
//        rxDialogEditSureCancel.setTitle("星座");
        rxDialogEditSureCancel.getTvSure().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = rxDialogEditSureCancel.getEditText().getText().toString();
                mEditText2.setText(s);
                Preferences.setString(PersonalActivity.this,"sign",s);
                EventBus.getDefault().post(new MyEvent(s));
                rxDialogEditSureCancel.dismiss();
            }
        });
        rxDialogEditSureCancel.getTvCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxDialogEditSureCancel.cancel();
            }
        });
        rxDialogEditSureCancel.show();
    }

    protected void initView() {
        Resources r = mContext.getResources();
        String iconUrl = Preferences.getString(PersonalActivity.this, "header_icon_url", null);
        if (TextUtils.isEmpty(iconUrl)) {
            resultUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + r.getResourcePackageName(R.drawable.elves_ball) + "/"
                    + r.getResourceTypeName(R.drawable.elves_ball) + "/"
                    + r.getResourceEntryName(R.drawable.elves_ball));
        }else {

            resultUri = Uri.parse(iconUrl);
            roadImageView(resultUri, mIvAvatar);
            Log.i(TAG, "initView: "+resultUri);
        }
        mRxTitle.setLeftFinish(mContext);

        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                initDialogOpenAvatar();
                initDialogChooseImage();
            }
        });
        mIvAvatar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                RxImageUtils.showBigImageView(mContext, resultUri);
                return false;
            }
        });


        String birthday = Preferences.getString(PersonalActivity.this, "birthday", null);
        if(!TextUtils.isEmpty(birthday)){
            mTvBirthday.setText(birthday);
        }
        //设置年月日
        set_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initWheelYearMonthDayDialog();
                mRxDialogWheelYearMonthDay.show();
            }
        });

        String name = Preferences.getString(PersonalActivity.this, "name", null);
        if(!TextUtils.isEmpty(name)){
            mTvName.setText(name);
        }

        String city = Preferences.getString(PersonalActivity.this, "City", null);
        if (!TextUtils.isEmpty(city)){
            mTvAddress.setText(city);
        }

       xingzuo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setXingzuo();
           }
       });


        String xingzuo = Preferences.getString(PersonalActivity.this, "xingzuo", null);
        if (!TextUtils.isEmpty(xingzuo))
        mTvConstellation.setText(xingzuo);


        person_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign();
            }
        });
        String sign = Preferences.getString(PersonalActivity.this, "sign", null);
        if (!TextUtils.isEmpty(sign))
            mEditText2.setText(sign);
    }

    /**
     * 选择头像 弹窗
     */
    private void initDialogOpenAvatar() {
        final RxDialog dialog1 = new RxDialog(this);
        dialog1.getLayoutParams().gravity = Gravity.BOTTOM;
        View dialogView1 = LayoutInflater.from(this).inflate(
                R.layout.dialog_picker_pictrue, null);
        TextView tv_camera = (TextView) dialogView1
                .findViewById(R.id.tv_camera);
        TextView tv_file = (TextView) dialogView1
                .findViewById(R.id.tv_file);
        TextView tv_cancelid = (TextView) dialogView1
                .findViewById(R.id.tv_cancel);
        tv_cancelid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog1.cancel();
            }
        });
        tv_camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //请求Camera权限
                RxPermissionsUtils.requestCamera(mContext, new onRequestPermissionsListener() {
                    @Override
                    public void onRequestBefore() {

                    }

                    @Override
                    public void onRequestLater() {
                        RxPhotoUtils.openCameraImage(PersonalActivity.this);
                        dialog1.cancel();
                    }
                });
            }
        });
        tv_file.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                RxPhotoUtils.openLocalImage(PersonalActivity.this);
                dialog1.cancel();
            }
        });
        dialog1.setContentView(dialogView1);
        dialog1.show();
    }

    private void initDialogChooseImage() {
        RxDialogChooseImage dialogChooseImage = new RxDialogChooseImage(mContext, TITLE);

        dialogChooseImage.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoUtils.GET_IMAGE_FROM_PHONE://选择相册之后的处理
                if (resultCode == RESULT_OK) {
//                    RxPhotoUtils.cropImage(ActivityUser.this, );// 裁剪图片
                    initUCrop(data.getData());
                }

                break;
            case RxPhotoUtils.GET_IMAGE_BY_CAMERA://选择照相机之后的处理
                if (resultCode == RESULT_OK) {
                   /* data.getExtras().get("data");*/
//                    RxPhotoUtils.cropImage(ActivityUser.this, RxPhotoUtils.imageUriFromCamera);// 裁剪图片
                    initUCrop(RxPhotoUtils.imageUriFromCamera);
                }

                break;
            case RxPhotoUtils.CROP_IMAGE://普通裁剪后的处理
                Glide.with(mContext).
                        load(RxPhotoUtils.cropImageUri).
                        diskCacheStrategy(DiskCacheStrategy.RESULT).
                        bitmapTransform(new CropCircleTransformation(mContext)).
                        thumbnail(0.5f).
                        placeholder(R.drawable.elves_ball).
                        priority(Priority.LOW).
                        error(R.drawable.elves_ball).
                        fallback(R.drawable.elves_ball).
                        dontAnimate().
                        into(mIvAvatar);
//                RequestUpdateAvatar(new File(RxPhotoUtils.getRealFilePath(mContext, RxPhotoUtils.cropImageUri)));
                break;

            case UCrop.REQUEST_CROP://UCrop裁剪之后的处理
                if (resultCode == RESULT_OK) {
                    resultUri = UCrop.getOutput(data);
                    Preferences.setString(PersonalActivity.this,"header_icon_url", String.valueOf(resultUri));
                    Log.i(TAG, "onActivityResult: "+resultUri);
                    if (resultUri != null) {
                        EventBus.getDefault().post(new MyEvent(resultUri));
                    }
                    roadImageView(resultUri, mIvAvatar);
                    RxSPUtils.putContent(mContext, "AVATAR", resultUri.toString());
                } else if (resultCode == UCrop.RESULT_ERROR) {
                    final Throwable cropError = UCrop.getError(data);
                }
                break;
            case UCrop.RESULT_ERROR://UCrop裁剪错误之后的处理
                final Throwable cropError = UCrop.getError(data);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //从Uri中加载图片 并将其转化成File文件返回
    private File roadImageView(Uri uri, ImageView imageView) {
        Glide.with(mContext).
                load(uri).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                bitmapTransform(new CropCircleTransformation(mContext)).
                thumbnail(0.5f).
                placeholder(R.drawable.elves_ball).
                priority(Priority.LOW).
                error(R.drawable.elves_ball).
                fallback(R.drawable.elves_ball).
                dontAnimate().
                into(imageView);

        return (new File(RxPhotoUtils.getImageAbsolutePath(this, uri)));
    }

    private void initUCrop(Uri uri) {
        //Uri destinationUri = RxPhotoUtils.createImagePathUri(this);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));

        Uri destinationUri = Uri.fromFile(new File(getCacheDir(), imageName + ".jpeg"));

        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置隐藏底部容器，默认显示
        //options.setHideBottomControls(true);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(this, R.color.colorPrimary));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(this, R.color.colorPrimaryDark));

        //开始设置
        //设置最大缩放比例
        options.setMaxScaleMultiplier(5);
        //设置图片在切换比例时的动画
        options.setImageToCropBoundsAnimDuration(666);
        //设置裁剪窗口是否为椭圆
//        options.setOvalDimmedLayer(true);
        //设置是否展示矩形裁剪框
//        options.setShowCropFrame(false);
        //设置裁剪框横竖线的宽度
//        options.setCropGridStrokeWidth(20);
        //设置裁剪框横竖线的颜色
//        options.setCropGridColor(Color.GREEN);
        //设置竖线的数量
//        options.setCropGridColumnCount(2);
        //设置横线的数量
//        options.setCropGridRowCount(one);

        UCrop.of(uri, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(1000, 1000)
                .withOptions(options)
                .start(this);
    }

    @OnClick(R.id.btn_exit)
    public void onClick() {
        final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(this);
//        rxDialogSureCancel.setContentView(R.layout.dialog_view);
//        rxDialogSureCancel.setContent("woshissss");
        rxDialogSureCancel.setContent("你忍心离开吗？");
        rxDialogSureCancel.getTvCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxDialogSureCancel.cancel();
            }
        });
        rxDialogSureCancel.getTvSure().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFileUtils.cleanCustomCache(String.valueOf(resultUri));

                //清空个人信息
                Preferences.setString(PersonalActivity.this,"name",null);
                Preferences.setString(PersonalActivity.this,"birthday", null);
                Preferences.setString(PersonalActivity.this,"City", null);
                Preferences.setString(PersonalActivity.this,"xingzuo", null);
                Preferences.setString(PersonalActivity.this,"sign", null);
                Preferences.setString(PersonalActivity.this,"header_icon_url", null);

//                startActivity(new Intent(PersonalActivity.this,AppLoginActivity.class));
                //干掉之前所有的activity
                RxActivityUtils.skipActivityAndFinishAll(PersonalActivity.this,AppLoginActivity.class);
            }
        });
        rxDialogSureCancel.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MyEvent event){

    }

//    public void upload(){
//        XUtils.UpLoadFile()
//
//    }

}
