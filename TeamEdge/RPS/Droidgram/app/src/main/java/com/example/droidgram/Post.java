package com.example.droidgram;

import android.util.Log;

import java.util.ArrayList;

public class Post {

    private int likes;
    private String postName;
    private ArrayList<String> messagesArray;
    private int imgName;




    public Post() {
    }

    public Post(int likes, String username, ArrayList<String> messagesArray, int imgName) {
        this.likes = likes;
        this.postName = username;
        this.messagesArray = messagesArray;
        this.imgName = imgName;
    }

    public int getLikes() {

        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public ArrayList<String> getMessagesArray() {
        return messagesArray;
    }

    public void setMessagesArray(ArrayList<String> messagesArray) {
        this.messagesArray = messagesArray;
        Log.d("Messags Array has", ""+ messagesArray);
    }

    public int getImgName() {
        return imgName;
    }

    public void setImgName(int imgName) {
        this.imgName = imgName;
    }
}
