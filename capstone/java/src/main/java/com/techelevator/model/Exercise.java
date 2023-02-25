package com.techelevator.model;

public class Exercise {

    private int exercise_id;
    private String exercise_name;
    private String exercise_description;
    private int suggested_weight;
    private int num_of_reps;
    private int duration;
    private String target_area;

    public Exercise() {}

    public Exercise(int exercise_id, String exercise_name, String exercise_description, int suggested_weight, int num_of_reps, int duration, String target_area) {
        this.exercise_id = exercise_id;
        this.exercise_name = exercise_name;
        this.exercise_description = exercise_description;
        this.suggested_weight = suggested_weight;
        this.num_of_reps = num_of_reps;
        this.duration = duration;
        this.target_area = target_area;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getExercise_description() {
        return exercise_description;
    }

    public void setExercise_description(String exercise_description) {
        this.exercise_description = exercise_description;
    }

    public int getSuggested_weight() {
        return suggested_weight;
    }

    public void setSuggested_weight(int suggested_weight) {
        this.suggested_weight = suggested_weight;
    }

    public int getNum_of_reps() {
        return num_of_reps;
    }

    public void setNum_of_reps(int num_of_reps) {
        this.num_of_reps = num_of_reps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTarget_area() {
        return target_area;
    }

    public void setTarget_area(String target_area) {
        this.target_area = target_area;
    }
}
