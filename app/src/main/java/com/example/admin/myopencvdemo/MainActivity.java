package com.example.admin.myopencvdemo;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //灰度化测试
                Intent intent = new Intent(MainActivity.this,GrayScaleActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MPermissionUtils.requestPermissionsResult(MainActivity.this, 4, new String[]{
                                Manifest.permission.CAMERA}
                        , new MPermissionUtils.OnPermissionListener() {
                            @Override
                            public void onPermissionGranted() {
                                //跳转
                                Intent intent = new Intent(MainActivity.this,OpenCVActtivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onPermissionDenied() {
                                MPermissionUtils.showTipsDialog(MainActivity.this);
                            }
                        });
            }
        });

    }
}
