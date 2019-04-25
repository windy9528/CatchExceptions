package com.bwie;

import android.content.SyncStatusObserver;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

public class MainActivity extends AppCompatActivity implements UncaughtExceptionHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //模拟报错
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = null;
                System.out.print(str.length()/0);
            }
        });
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i("catch", e.getMessage());
        Log.i("catch", "线程名字" + t.getName());
        Log.i("catch", "sd卡路径" + Environment.getExternalStorageDirectory().getAbsolutePath());
        //把日志打印出来
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"error.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(e.getMessage());  //写入报错日志
            Log.i("catch", "写入成功");
            fileWriter.flush(); //刷新
            fileWriter.close();  //关闭流
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
