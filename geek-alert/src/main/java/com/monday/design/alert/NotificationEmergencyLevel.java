package com.monday.design.alert;

public enum NotificationEmergencyLevel {

    TRIVIAL("无关紧要"),
    NORMAL("普通"),
    URGENCY("紧急"),
    SEVERE("严重");

    private String name;

    NotificationEmergencyLevel(String name) {
        this.name = name;
    }

}
