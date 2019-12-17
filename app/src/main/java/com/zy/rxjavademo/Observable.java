package com.zy.rxjavademo;

/**
 * Author: zy
 * Date: 2019/12/5 11:25
 * Description: 场景盒子
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

    public <R> Observable<R> map(Func1<? super T, ? extends R> func1) {
        return create(new OnSubscribeLift<>(onSubscribe, func1));
    }

    public Observable<T> subscriOnIO() {
        return create(new OnSubscribeThread<>(this));
    }

    public void subscribe(Subscribe<? super T> subscribe) {
        onSubscribe.call(subscribe);
    }
}
