package com.techelevator.model;

public class WorkoutStats {
    private int workout_stats_id;
    private int user_id;
    private String workout_date;
    private int biceps_duration;
    private int triceps_duration;
    private int chest_duration;
    private int shoulders_duration;
    private int back_duration;
    private int legs_duration;
    private int abs_duration;
    private int cardio_duration;

    public WorkoutStats() {}

    public WorkoutStats(int workout_stats_id, int user_id, String workout_date, int biceps_duration, int triceps_duration, int chest_duration, int shoulders_duration, int back_duration, int legs_duration, int abs_duration, int cardio_duration) {
        this.workout_stats_id = workout_stats_id;
        this.user_id = user_id;
        this.workout_date = workout_date;
        this.biceps_duration = biceps_duration;
        this.triceps_duration = triceps_duration;
        this.chest_duration = chest_duration;
        this.shoulders_duration = shoulders_duration;
        this.back_duration = back_duration;
        this.legs_duration = legs_duration;
        this.abs_duration = abs_duration;
        this.cardio_duration = cardio_duration;
    }

    public int getWorkout_stats_id() {
        return workout_stats_id;
    }

    public void setWorkout_stats_id(int workout_stats_id) {
        this.workout_stats_id = workout_stats_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getWorkout_date() {
        return workout_date;
    }

    public void setWorkout_date(String workout_date) {
        this.workout_date = workout_date;
    }

    public int getBiceps_duration() {
        return biceps_duration;
    }

    public void setBiceps_duration(int biceps_duration) {
        this.biceps_duration = biceps_duration;
    }

    public int getTriceps_duration() {
        return triceps_duration;
    }

    public void setTriceps_duration(int triceps_duration) {
        this.triceps_duration = triceps_duration;
    }

    public int getChest_duration() {
        return chest_duration;
    }

    public void setChest_duration(int chest_duration) {
        this.chest_duration = chest_duration;
    }

    public int getShoulders_duration() {
        return shoulders_duration;
    }

    public void setShoulders_duration(int shoulders_duration) {
        this.shoulders_duration = shoulders_duration;
    }

    public int getBack_duration() {
        return back_duration;
    }

    public void setBack_duration(int back_duration) {
        this.back_duration = back_duration;
    }

    public int getLegs_duration() {
        return legs_duration;
    }

    public void setLegs_duration(int legs_duration) {
        this.legs_duration = legs_duration;
    }

    public int getAbs_duration() {
        return abs_duration;
    }

    public void setAbs_duration(int abs_duration) {
        this.abs_duration = abs_duration;
    }

    public int getCardio_duration() {
        return cardio_duration;
    }

    public void setCardio_duration(int cardio_duration) {
        this.cardio_duration = cardio_duration;
    }
}
