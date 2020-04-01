package com.monday.observer.eventbus;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {

    /**
     * key   -- 消息对象类型
     * value -- 注册了key中类型消息的方法
     */
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    /***
     * 注册.
     * @param observer
     */
    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            CopyOnWriteArraySet<ObserverAction> actions;
            if ((actions = registry.get(entry.getKey())) == null) {
                actions = new CopyOnWriteArraySet<>();
                registry.put(entry.getKey(), actions);
            }
            actions.addAll(entry.getValue());
        }
    }

    /**
     *  获取匹配的观察者信息.
     * @param event
     * @return
     */
    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        List<Method> matchedMethods = getMatchedMethods(observer.getClass());
        for (Method method : matchedMethods) {
            Class<?> eventType = method.getParameterTypes()[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new CopyOnWriteArraySet<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private List<Method> getMatchedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                checkArgument(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }

    private void checkArgument(boolean b, String s, Method method, int length) {
        // TODO... 引用Preconditions工具类
    }
}
