package com.person.exmple.teskout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {

    private Button mBtnSkip;
    private Handler mHandler=new Handler();

    private Runnable mRunnableToMain=new Runnable() {
        @Override
        public void run() {
         toMainActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        initEvent();

        mHandler.postDelayed(mRunnableToMain,3000);
    }

    private void initEvent() {
        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeCallbacks(mRunnableToMain);
                toMainActivity();
            }
        });
    }

    private void initView() {
        mBtnSkip=findViewById(R.id.btn_skip);
    }

    private void toMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRunnableToMain);
    }
}
