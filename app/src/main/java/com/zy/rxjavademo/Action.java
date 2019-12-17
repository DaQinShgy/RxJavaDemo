package com.zy.rxjavademo;

/**
 * Author: zy
 * Date: 2019/12/5 11:44
 * Description:
 */
public interface Action<T> {

    void call(T t);

}
