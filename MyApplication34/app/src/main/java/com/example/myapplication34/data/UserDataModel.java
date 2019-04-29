package com.example.myapplication34.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user_list")
public class UserDataModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "google_map_link")
    public String googleMapLink;

    @ColumnInfo(name = "birthday")
    public String birthday;

    @ColumnInfo(name = "sex")
    public Boolean sex;

    @ColumnInfo(name = "sensor_number")
    public String sensorNumber;

    @ColumnInfo(name = "sensor_secret_code")
    public String sensorSecretCode;

    @ColumnInfo(name = "features")
    public String features;

    @ColumnInfo(name = "image",typeAffinity = ColumnInfo.BLOB)
    public byte[] image;
}
