package com.zy.rxjavademo;

/**
 * Author: zy
 * Date: 2019/12/5 11:46
 * Description:
 */
public interface Subscribe<T> {

    public abstract void next(T t);

}
