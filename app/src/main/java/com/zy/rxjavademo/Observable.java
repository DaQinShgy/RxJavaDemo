package com.zy.rxjavademo;

/**
 * Author: zy
 * Date: 2019/12/5 11:25
 * Description: 场景
 * T 动作
 */
public class Observable<T> {

    private OnSubscribe<T> onSubscribe;

    public Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<>(onSubscribe);
    }

    public void subscribe(Subscribe<? super T> subscribe) {
        onSubscribe.call(subscribe);
    }
}
