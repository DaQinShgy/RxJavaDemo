package com.zy.rxjavademo;

/**
 * Author: zy
 * Date: 2019/12/17 09:44
 * Description:
 */
public class OnSubscribeLift<T, R> implements OnSubscribe<R> {

    private OnSubscribe<T> onSubscribe;
    private Func1<? super T, ? extends R> transForm;

    public OnSubscribeLift(OnSubscribe<T> onSubscribe, Func1<? super T, ? extends R> transForm) {
        this.onSubscribe = onSubscribe;
        this.transForm = transForm;
    }

    @Override
    public void call(Subscribe<? super R> subscribe) {
        Subscribe<? super T> subscribe1 = new OperaChange<>(subscribe, transForm);
        onSubscribe.call(subscribe1);
    }


    class OperaChange<T, R> extends Subscribe<T> {

        //替代者
        private Subscribe<? super R> action1;
        //转换
        private Func1<? super T, ? extends R> transForm;

        public OperaChange(Subscribe<? super R> action1, Func1<? super T, ? extends R> transForm) {
            this.action1 = action1;
            this.transForm = transForm;
        }

        @Override
        public void next(T t) {
            //替换
            R r = transForm.call(t);
            action1.next(r);
        }
    }

}
