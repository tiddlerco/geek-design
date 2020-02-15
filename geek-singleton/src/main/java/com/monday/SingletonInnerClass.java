package com.monday;

public class SingletonInnerClass {

    private SingletonInnerClass() {

    }

    public static SingletonInnerClass getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }
}
