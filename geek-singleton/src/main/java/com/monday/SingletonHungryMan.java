package com.monday;

/**
 * 饿汉式
 */
public class SingletonHungryMan {

    private static SingletonHungryMan instance = new SingletonHungryMan();

    private SingletonHungryMan() {

    }

    public static SingletonHungryMan getStance() {
        return instance;
    }

}
