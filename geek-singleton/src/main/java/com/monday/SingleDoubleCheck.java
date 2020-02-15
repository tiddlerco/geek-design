package com.monday;

/**
 * 双重校验
 */
public class SingleDoubleCheck {

    private static SingleDoubleCheck instance;

    private SingleDoubleCheck() {

    }

    public static SingleDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingleDoubleCheck.class) {
                if (instance == null) {
                    return new SingleDoubleCheck();
                }
            }
        }
        return instance;
    }
}
