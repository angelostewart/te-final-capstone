package com.techelevator.dao;

import com.techelevator.model.Exercise;

import java.util.List;

public interface ExerciseDao {

    List<Exercise> allExercises();

    Exercise getExerciseById(int exerciseId);

    boolean createExercise(Exercise exercise);

    Exercise updateExercise(Exercise exercise, int id);

    void deleteExercise(int id);


}
