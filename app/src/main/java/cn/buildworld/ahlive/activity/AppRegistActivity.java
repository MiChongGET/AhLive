package cn.buildworld.ahlive.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.vondear.rxtools.RxAnimationUtils;
import com.vondear.rxtools.RxKeyboardUtils;
import com.vondear.rxtools.activity.AndroidBug5497Workaround;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.buildworld.ahlive.R;

import static cn.buildworld.ahlive.R.id.service_1;

public class AppRegistActivity extends AppCompatActivity {

    @BindView(R.id.logo_2)
    ImageView mLogo;
    @BindView(R.id.et_mobile_2)
    EditText mEtMobile;
    @BindView(R.id.iv_clean_phone_2)
    ImageView mIvCleanPhone;
    @BindView(R.id.et_password_2)
    EditText mEtPassword;
    @BindView(R.id.et_password_a)
    EditText mEtPassword_a;
    @BindView(R.id.clean_password_2)
    ImageView mCleanPassword;
    @BindView(R.id.clean_password_a)
    ImageView mCleanPassword_a;
//    @BindView(R.id.iv_show_pwd)
//    ImageView mIvShowPwd;
    @BindView(R.id.btn_login_2)
    Button mBtnLogin;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.forget_password_2)
    TextView mForgetPassword;
    @BindView(R.id.content_2)
    LinearLayout mContent;
    @BindView(R.id.scrollView_2)
    ScrollView mScrollView;
    @BindView(service_1)
    LinearLayout mService;
    @BindView(R.id.root_2)
    RelativeLayout mRoot;
//    @BindView(clean_username)
//    TextView clean_name;

    private int screenHeight = 0;//屏幕高度
    private int keyHeight = 0; //软件盘弹起后所占高度
    private float scale = 0.6f; //logo缩放比例
    private int height = 0;
    private String mPasswd2;
    private String mPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_regist);
        ButterKnife.bind(this);

        if (isFullScreen(this)) {
            AndroidBug5497Workaround.assistActivity(this);
        }

        initView();
        initEvent();
    }
    private void initView(){
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyHeight = screenHeight / 3;//弹起高度为屏幕高度的1/3
    }


    private void initEvent() {
        mEtMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && mIvCleanPhone.getVisibility() == View.GONE) {
                    mIvCleanPhone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    mIvCleanPhone.setVisibility(View.GONE);
                }
            }
        });
        mEtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && mCleanPassword.getVisibility() == View.GONE) {
                    mCleanPassword.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    mCleanPassword.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty())
                    return;
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    mPasswd = s.toString();
                    Toast.makeText(AppRegistActivity.this, "请输入数字或字母", Toast.LENGTH_SHORT).show();
                    s.delete(mPasswd.length() - 1, mPasswd.length());
                    mEtPassword.setSelection(s.length());
                }
            }
        });

        mEtPassword_a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && mCleanPassword_a.getVisibility() == View.GONE) {
                    mCleanPassword_a.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    mCleanPassword_a.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty())
                    return;
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    mPasswd2 = s.toString();
                    Toast.makeText(AppRegistActivity.this, "请输入数字或字母", Toast.LENGTH_SHORT).show();
                    s.delete(mPasswd2.length() - 1, mPasswd2.length());
                    mEtPassword_a.setSelection(s.length());
                }
            }
        });

        /**
         * 禁止键盘弹起的时候可以滚动
         */
        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        mScrollView.addOnLayoutChangeListener(new ViewGroup.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
              /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
                if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
                    Log.e("wenzhihao", "up------>" + (oldBottom - bottom));
                    int dist = mContent.getBottom() - bottom;
                    if (dist > 0) {
                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(mContent, "translationY", 0.0f, -dist);
                        mAnimatorTranslateY.setDuration(300);
                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                        mAnimatorTranslateY.start();
                        RxAnimationUtils.zoomIn(mLogo, 0.6f, dist);
                    }
                    mService.setVisibility(View.INVISIBLE);

                } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
                    Log.e("wenzhihao", "down------>" + (bottom - oldBottom));
                    if ((mContent.getBottom() - oldBottom) > 0) {
                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(mContent, "translationY", mContent.getTranslationY(), 0);
                        mAnimatorTranslateY.setDuration(300);
                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                        mAnimatorTranslateY.start();
                        //键盘收回后，logo恢复原来大小，位置同样回到初始位置
                        RxAnimationUtils.zoomOut(mLogo, 0.6f);
                    }
                    mService.setVisibility(View.VISIBLE);
                }
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!TextUtils.isEmpty(mEtPassword.getText().toString())) &&
                        (!TextUtils.isEmpty(mEtPassword_a.getText().toString())) &&
                        (!TextUtils.isEmpty(mEtMobile.getText().toString()))){
                    Toast.makeText(AppRegistActivity.this, "用户名密码不能为空！！！", Toast.LENGTH_SHORT).show();

                }
                else if (mEtPassword.getText().toString().equals(mEtPassword_a.getText().toString()) && !TextUtils.isEmpty(mEtMobile.getText().toString())){
                    RxKeyboardUtils.hideSoftInput(AppRegistActivity.this);
                    Toast.makeText(AppRegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AppRegistActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppRegistActivity.this, "登录", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AppRegistActivity.this,AppLoginActivity.class));
                finish();
            }
        });
    }

    public boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags &
                WindowManager.LayoutParams.FLAG_FULLSCREEN) == WindowManager.LayoutParams.FLAG_FULLSCREEN;
    }

    @OnClick({R.id.iv_clean_phone_2, R.id.clean_password_2, R.id.clean_password_a})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_clean_phone_2:
                mEtMobile.setText("");
                break;
            case R.id.clean_password_2:
                mEtPassword.setText("");
                break;

            case R.id.clean_password_a:
                mEtPassword_a.setText("");
                break;
//            case R.id.iv_show_pwd:
//                if (mEtPassword.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
//                    mEtPa xssword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                    mIvShowPwd.setImageResource(R.drawable.pass_visuable);
//                } else {
//                    mEtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    mIvShowPwd.setImageResource(R.drawable.pass_gone);
//                }
//                String pwd = mEtPassword.getText().toString();
//                if (!TextUtils.isEmpty(pwd))
//                    mEtPassword.setSelection(pwd.length());
//                break;
        }
    }
}
