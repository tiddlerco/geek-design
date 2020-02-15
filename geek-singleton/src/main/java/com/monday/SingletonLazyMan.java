package com.monday;

/***
 * 懒汉式
 */
public class SingletonLazyMan {

    private static SingletonLazyMan instance;

    private SingletonLazyMan() {

    }

    public synchronized static SingletonLazyMan  getInstance() {
        if (instance == null) {
            return new SingletonLazyMan();
        }
        return instance;
    }

}
