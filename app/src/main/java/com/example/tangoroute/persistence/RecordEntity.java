package com.example.tangoroute.persistence;

import com.example.tangoroute.models.Record;

import java.util.List;

public class RecordEntity {

    public String username;
    public int points;

    public RecordEntity() {
        //empty from framework
    }

    public RecordEntity(Record record) {
        this.username = record.getUsername();
        this.points = record.getPoints();
    }

    public Record toRecord() {
        return new Record(this.username, this.points);
    }
}
