package com.example.tangoroute.models;

import java.io.Serializable;

public class Wonder implements Serializable {

    private String name;
    private Location location;
    private String description;

    public static WonderBuilders.Name builder() {
        return new WonderBuilder();
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

    @Override
    public String toString() {
        return "Wonder{" +
                "name='" + name + '\'' +
                ", " + location.toString() +
                '}';
    }

    public static class WonderBuilder implements WonderBuilders.Name, WonderBuilders.WonderLocation,
            WonderBuilders.Optional {

        private final Wonder wonder;

        public WonderBuilder() {
            this.wonder = new Wonder();
        }

        @Override
        public WonderBuilders.WonderLocation name(String name) {
            this.wonder.setName(name);
            return this;
        }

        @Override
        public WonderBuilders.Optional location(Location location) {
            this.wonder.setLocation(location);
            return this;
        }

        @Override
        public WonderBuilders.Optional description(String description) {
            this.wonder.setDescription(description);
            return this;
        }

        @Override
        public Wonder build() {
            if (this.wonder.getDescription() == null) {
                this.wonder.setDescription("");
            }
            return this.wonder;
        }
    }

}
