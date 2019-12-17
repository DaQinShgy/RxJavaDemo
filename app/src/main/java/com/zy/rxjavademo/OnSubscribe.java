package com.zy.rxjavademo;

/**
 * Author: zy
 * Date: 2019/12/5 11:43
 * Description:
 * super 限定参数类型限定，不用于返回
 * extend 限定返回参数类型，不用于参数类型
 */
public interface OnSubscribe<T> extends Action<Subscribe<? super T>> {
}
