package com.example.tangoroute.persistence;

import android.app.Application;

import com.example.tangoroute.models.Wonder;

public class WonderRepository {

    private static WonderRepository repository;
    private WonderDAO wonderDAO;

    private WonderRepository(Application application) {
        WonderDatabase database = WonderDatabase.getDatabase(application);
        this.wonderDAO = database.wonderDAO();
    }

    public static WonderRepository getInstance(Application application) {
        if (repository == null) {
            repository = new WonderRepository(application);
        }
        return repository;
    }

    public Long insert(Wonder wonder) {
        return this.wonderDAO.insert(new WonderEntity(wonder));
    }

    public Wonder findByName(String name) {
        return this.wonderDAO.findByName(name).toWonder();
    }
}
