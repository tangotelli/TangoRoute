package com.example.tangoroute.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.tangoroute.models.Location;
import com.example.tangoroute.models.Wonder;

@Entity(tableName = WonderEntity.WONDERS)
public class WonderEntity {

    public static final String WONDERS = "wonders";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Location location;
    private String description;

    public WonderEntity() {
        //empty from framework
    }

    public WonderEntity(Wonder wonder) {
        this.name = wonder.getName();
        this.location = wonder.getLocation();
        this.description = wonder.getDescription();
    }

    public Wonder toWonder() {
        return Wonder.builder()
                .name(this.name)
                .location(this.location)
                .description(this.description)
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
