package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Workout {
    @JsonProperty("workout_name")
    private String workout_name;
    private ArrayList<Exercise> exercises;

    public Workout() {}

    public Workout(String workout_name, ArrayList<Exercise> exercises) {
        this.workout_name = workout_name;
        this.exercises = exercises;
    }

    public String getWorkout_name() {
        return workout_name;
    }

    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
