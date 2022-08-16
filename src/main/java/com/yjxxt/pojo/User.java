package com.yjxxt.pojo;

import org.omg.CORBA.PRIVATE_MEMBER;

public class User {
    private Integer id;
    private String userName;
    private String userPwd;
    private String nick;
    private String mood;
    private String head;

    public User(Integer id, String userName, String userPwd, String nike, String mood, String head) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.nick = nike;
        this.mood = mood;
        this.head = head;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", nike='" + nick + '\'' +
                ", mood='" + mood + '\'' +
                ", head='" + head + '\'' +
                '}';
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
