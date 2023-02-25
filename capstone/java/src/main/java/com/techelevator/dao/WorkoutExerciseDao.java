package com.techelevator.dao;

import com.techelevator.model.Workout;

import java.util.ArrayList;

public interface WorkoutExerciseDao {
    ArrayList<Workout> allWorkouts();

    Workout getWorkoutByName(String workout_name);

    boolean addExerciseToWorkout(Workout workout, int exercise_id);

    void removeExerciseFromWorkout(String workoutName, int exercise_id);

    void createWorkout(String workout_name);

    void deleteWorkout(String workout_name);
}
