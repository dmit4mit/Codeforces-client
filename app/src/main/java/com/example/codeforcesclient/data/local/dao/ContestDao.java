package com.example.codeforcesclient.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.codeforcesclient.data.local.model.Contest;

import java.util.List;

@Dao
public interface ContestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contest aContest);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contest> aContests);

    @Delete
    void delete(Contest aContest);

    @Query("DELETE FROM contest")
    void deleteAll();

    @Query("DELETE FROM contest WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM contest")
    List<Contest> loadAll();

    @Query("SELECT * FROM contest WHERE name LIKE :contestName LIMIT 1")
    Contest findByName(String contestName);

    @Query("SELECT * FROM contest WHERE id = :aId")
    Contest findById(int aId);
}