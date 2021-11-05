package com.example.tangoroute.models;

import java.io.Serializable;

public class Wonder implements Serializable {

    private String name;
    private Situation situation;
    private String description;
    private int imageId;

    public static WonderBuilders.Name builder() {
        return new WonderBuilder();
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

    @Override
    public String toString() {
        return "Wonder{" +
                "name='" + name + '\'' +
                ", " + situation.toString() +
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
        public WonderBuilders.Optional situation(Situation situation) {
            this.wonder.setSituation(situation);
            return this;
        }

        @Override
        public WonderBuilders.Optional description(String description) {
            this.wonder.setDescription(description);
            return this;
        }

        @Override
        public WonderBuilders.Optional imageId(int imageId) {
            this.wonder.setImageId(imageId);
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
