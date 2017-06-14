package cn.buildworld.ahlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

import cn.buildworld.ahlive.guide.GuideActivity;
import cn.buildworld.ahlive.utils.Preferences;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

//                if (Preferences.getBoolean(SplashActivity.this,"first_start",true)){
//                    Preferences.setBoolean(SplashActivity.this,"first_start",false);
//                    startActivity(new Intent(SplashActivity.this,GuideActivity.class));
//                }else {
//                    startActivity(new Intent(SplashActivity.this,TabActivity.class));
//                }
                startActivity(new Intent(SplashActivity.this,GuideActivity.class));

                finish();
            }
        };

        timer.schedule(timerTask,1000);
    }
}
