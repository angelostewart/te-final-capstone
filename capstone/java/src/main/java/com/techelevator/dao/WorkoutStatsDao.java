package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.WorkoutStats;

import java.util.ArrayList;
import java.util.List;

public interface WorkoutStatsDao {

    List<WorkoutStats> allWorkoutStats();

    WorkoutStats getWorkoutStatsById(int workoutId);

    WorkoutStats createWorkoutStats(int user_id, String date, int exercise_id);

    int[] getWorkoutStatsForUser(int id, String date);

}
