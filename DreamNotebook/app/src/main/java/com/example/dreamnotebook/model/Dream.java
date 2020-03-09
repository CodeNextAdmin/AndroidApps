package com.example.dreamnotebook.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dream {


    @PrimaryKey(autoGenerate = true)
    private int dreamID;


    private String dreamTitle;

    @ColumnInfo(name = "dream_content") // column name will be "note_content" instead of "content" in table
    private String dreamContent;


    public Dream(int dreamID, String dreamTitle, String dreamContent) {
        this.dreamID = dreamID;
        this.dreamTitle = dreamTitle;
        this.dreamContent = dreamContent;
    }

    public int getDreamID() {
        return dreamID;
    }

    public void setDreamID(int dreamID) {
        this.dreamID = dreamID;
    }

    public String getDreamTitle() {
        return dreamTitle;
    }

    public void setDreamTitle(String dreamTitle) {
        this.dreamTitle = dreamTitle;
    }

    public String getDreamContent() {
        return dreamContent;
    }

    public void setDreamContent(String dreamContent) {
        this.dreamContent = dreamContent;
    }
}
