package com.example.tangoroute.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.tangoroute.models.Situation;
import com.example.tangoroute.models.Wonder;

@Entity(tableName = WonderEntity.WONDERS)
public class WonderEntity {

    public static final String WONDERS = "wonders";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Situation situation;
    private String description;
    private int imageId;

    public WonderEntity() {
        //empty from framework
    }

    public WonderEntity(Wonder wonder) {
        this.name = wonder.getName();
        this.situation = wonder.getSituation();
        this.description = wonder.getDescription();
        this.imageId = wonder.getImageId();
    }

    public Wonder toWonder() {
        return Wonder.builder()
                .name(this.name)
                .situation(this.situation)
                .description(this.description)
                .imageId(this.imageId)
                .build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
