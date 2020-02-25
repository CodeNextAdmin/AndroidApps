package com.example.methodsexamples;

public class Post {

    int likes;
    String names;

    public Post(int likes, String names) {
        this.likes = likes;
        this.names = names;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;


    }
}
