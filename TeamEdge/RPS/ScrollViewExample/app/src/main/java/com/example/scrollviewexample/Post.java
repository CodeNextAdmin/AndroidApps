package com.example.scrollviewexample;

import java.util.ArrayList;

public class Post {

    private int likes;
    private String username;
    private ArrayList<String> messagesArray;
    private int imgName;




    public Post() {
    }

    public Post(int likes, String username, ArrayList<String> messagesArray, int imgName) {
        this.likes = likes;
        this.username = username;
        this.messagesArray = messagesArray;
        this.imgName = imgName;
    }


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getMessagesArray() {
        return messagesArray;
    }

    public void setMessagesArray(ArrayList<String> messagesArray) {
        this.messagesArray = messagesArray;
    }

    public int getImgName() {
        return imgName;
    }

    public void setImgName(int imgName) {
        this.imgName = imgName;
    }
}
