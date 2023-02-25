package com.techelevator.model;

public class Trainer {
    private int trainer_id;
    private String about_me;

    public Trainer() {}

    Trainer(int trainer_id, String about_me) {
        this.trainer_id = trainer_id;
        this.about_me = about_me;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }
}
