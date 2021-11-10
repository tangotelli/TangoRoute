package com.example.tangoroute.persistence;

import com.example.tangoroute.models.Record;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecordRepository {

    private FirebaseDatabase database;
    private DatabaseReference reference;
    private static RecordRepository repository;

    public final static String RECORD_NODE = "records";

    private RecordRepository() {
        this.database = FirebaseDatabase
                .getInstance("https://fir-fem-d3295-default-rtdb.europe-west1.firebasedatabase.app");
        this.reference = this.database.getReference();
    }

    public static RecordRepository getInstance() {
        if (repository == null) {
            repository = new RecordRepository();
        }
        return repository;
    }

    public void saveRecord(Record record) {
        RecordEntity entity = new RecordEntity(record);
        this.reference.child(RECORD_NODE).push().setValue(entity);
    }
}
