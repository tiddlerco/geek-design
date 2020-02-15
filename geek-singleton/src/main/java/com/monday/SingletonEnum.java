package com.monday;

public enum SingletonEnum {
    INSTANCE;

    SingletonEnumInstance instance = new SingletonEnumInstance();

    public SingletonEnumInstance getInstance() {
        return instance;
    }

    static class SingletonEnumInstance{}
}
