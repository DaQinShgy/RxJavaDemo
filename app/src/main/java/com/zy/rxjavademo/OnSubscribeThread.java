package com.zy.rxjavademo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: zy
 * Date: 2019/12/17 11:04
 * Description:
 */
public class OnSubscribeThread<T> implements OnSubscribe<T> {

    private static ExecutorService service = Executors.newCachedThreadPool();

    private Observable<T> observable;

    public OnSubscribeThread(Observable<T> observable) {
        this.observable = observable;
    }

    @Override
    public void call(final Subscribe<? super T> subscribe) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                observable.subscribe(subscribe);
            }
        };
        service.submit(runnable);
    }
}
