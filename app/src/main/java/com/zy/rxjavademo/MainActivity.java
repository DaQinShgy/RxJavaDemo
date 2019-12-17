package com.zy.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 链式调度
     *
     * @param view
     */
    public void onClick(View view) {
        Observable.create(new OnSubscribe<String>() {
            @Override
            public void call(Subscribe<? super String> subscribe) {
                subscribe.next("next >>>");
            }
        }).subscribe(new Subscribe<String>() {
            @Override
            public void next(String s) {
                Log.e("tag", "s >>> " + s);
            }
        });
    }

    /**
     * 事件转换
     *
     * @param view
     */
    public void onClick1(View view) {
        Observable.create(new OnSubscribe<String>() {
            @Override
            public void call(Subscribe<? super String> subscribe) {
                subscribe.next("next >>>");
            }
        }).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.e("tag", "string to bitmap");
                return null;
            }
        }).subscribe(new Subscribe<Bitmap>() {
            @Override
            public void next(Bitmap bitmap) {
                Log.e("tag", "get bitmap");
            }
        });
    }

    /**
     * 线程切换
     *
     * @param view
     */
    public void onClick2(View view) {
        Observable.create(new OnSubscribe<String>() {
            @Override
            public void call(Subscribe<? super String> subscribe) {
                Log.e("tag", "thread:" + Thread.currentThread().getName());
                subscribe.next("next >>>");
            }
        }).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.e("tag", "string to bitmap");
                return null;
            }
        }).subscriOnIO().subscribe(new Subscribe<Bitmap>() {
            @Override
            public void next(Bitmap bitmap) {
                Log.e("tag", "get bitmap");
            }
        });
    }
}
