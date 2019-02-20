package com.example.admin.myopencvdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class GrayScaleActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_scale);
        if (OpenCVLoader.initDebug()){
            Toast.makeText(this,"opencv已更新",Toast.LENGTH_SHORT).show();
        }
        imageView = findViewById(R.id.img2);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert2Grey();
            }
        });
    }


    private void convert2Grey() {
        Mat src = new Mat();//Mat是OpenCV的一种图像格式
        Mat temp = new Mat();
        Mat dst = new Mat();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.timg);
        Utils.bitmapToMat(bitmap, src);
        Imgproc.cvtColor(src, temp, Imgproc.COLOR_RGB2BGR);
        Imgproc.cvtColor(temp, dst, Imgproc.COLOR_BGR2GRAY);
        Utils.matToBitmap(dst, bitmap);
        imageView.setImageBitmap(bitmap);
        //
        src.release();
        temp.release();
        dst.release();
    }


}
