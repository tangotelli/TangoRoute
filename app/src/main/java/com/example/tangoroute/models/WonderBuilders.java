package com.example.tangoroute.models;

public interface WonderBuilders {

    interface Name {
        WonderBuilders.WonderLocation name(String name);
    }

    interface WonderLocation {
        WonderBuilders.Optional location(Location location);
    }

    interface Optional {
        WonderBuilders.Optional description(String description);

        Wonder build();
    }
}
