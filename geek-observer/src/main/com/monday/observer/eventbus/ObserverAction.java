package com.monday.observer.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObserverAction {

    private Object observer;

    private Method method;

    public ObserverAction(Object observer, Method method) {
        this.observer = observer;
        this.method = method;
    }

    public void execute(Object event) {
        try {
            method.invoke(observer, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
