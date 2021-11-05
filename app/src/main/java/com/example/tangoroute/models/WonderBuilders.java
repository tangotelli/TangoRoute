package com.example.tangoroute.models;

public interface WonderBuilders {

    interface Name {
        WonderBuilders.WonderLocation name(String name);
    }

    interface WonderLocation {
        WonderBuilders.Optional situation(Situation situation);
    }

    interface Optional {
        WonderBuilders.Optional description(String description);

        WonderBuilders.Optional imageId(int imageId);

        Wonder build();
    }
}
