package com.example.dreamnotebook.interfaces;

import com.example.dreamnotebook.model.Dream;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Delete;
import androidx.room.Update;
import androidx.room.Insert;


import java.util.List;


@Dao
public interface DreamDao {


    @Query("SELECT * FROM dreams")
    List<Dream> getDreams();


    @Insert
    Long insertDream(Dream dream);

    @Update
    void updateDream(Dream dream);

    @Delete
    void deleteDream(Dream dream);


    @Delete
    void deleteDreams(Dream... dream);


}
