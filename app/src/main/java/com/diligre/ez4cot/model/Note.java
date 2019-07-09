package com.diligre.ez4cot.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String born;
    private String from;
    private String location;
    private String studies;
    private String phone;
    private String bio;


    public Note(int id, String name, String born, String from, String location, String studies, String phone, String bio) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.from = from;
        this.location = location;
        this.studies = studies;
        this.phone = phone;
        this.bio = bio;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBorn() {
        return born;
    }

    public String getFrom() {
        return from;
    }

    public String getLocation() {
        return location;
    }

    public String getStudies() {
        return studies;
    }

    public String getPhone() {
        return phone;
    }

    public String getBio() {
        return bio;
    }
}
