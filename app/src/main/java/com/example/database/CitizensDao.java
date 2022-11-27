package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface CitizensDao {

    @Query("SELECT * FROM citizens")
    List<Citizens> getNames();

    @Query("SELECT * FROM cars")
    List<Cars> getCars();

    @Query("SELECT * FROM addresses")
    List<Addresses> getAddresses();

    @Insert
    void insertCitizens(Citizens citizens);

    @Insert
    void insertCars(Cars cars);

    @Insert
    void insertAddresses(Addresses addresses);

    @Delete
    void delete(Citizens citizens);

    @Update
    void update(Citizens citizens);
}

