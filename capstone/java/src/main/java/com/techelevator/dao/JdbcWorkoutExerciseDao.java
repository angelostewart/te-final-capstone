package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JdbcWorkoutExerciseDao implements WorkoutExerciseDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutExerciseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Workout> allWorkouts() {
        ArrayList<Workout> workouts = new ArrayList<>();
        String sql = "SELECT DISTINCT workout_name FROM workout_exercise";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Workout workout = new Workout();
            workout.setWorkout_name(results.getString("workout_name"));
            workouts.add(workout);
        }
        for (int i = 0; i < workouts.size(); i++) {
            ArrayList<Exercise> exercises = new ArrayList<>();
            String sql2 = "SELECT exercise FROM workout_exercise WHERE workout_name = ?";
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, workouts.get(i).getWorkout_name());
            while (results2.next()) {
                String sql3 = "SELECT * FROM exercise WHERE exercise_id = ?";
                SqlRowSet results3 = jdbcTemplate.queryForRowSet(sql3, results2.getInt("exercise"));
                if (results3.next()) {
                    Exercise exercise = new Exercise();
                    exercise.setExercise_id(results3.getInt("exercise_id"));
                    exercise.setExercise_name(results3.getString("exercise_name"));
                    exercise.setExercise_description(results3.getString("exercise_description"));
                    exercise.setSuggested_weight(results3.getInt("suggested_weight"));
                    exercise.setNum_of_reps(results3.getInt("num_of_reps"));
                    exercise.setDuration(results3.getInt("duration"));
                    exercise.setTarget_area(results3.getString("target_area"));
                    exercises.add(exercise);
                }
            }
            workouts.get(i).setExercises(exercises);
        }
        return workouts;
    }

    @Override
    public Workout getWorkoutByName(String workoutName) {
        Workout workout = new Workout();
        workout.setWorkout_name(workoutName);
        ArrayList<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM workout_exercise WHERE workout_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutName);
        while (results.next()) {
            String sql2 = "SELECT * FROM exercise WHERE exercise_id = ?";
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, results.getInt("exercise"));
            if (results2.next()) {
                Exercise exercise = new Exercise();
                exercise.setExercise_id(results2.getInt("exercise_id"));
                exercise.setExercise_name(results2.getString("exercise_name"));
                exercise.setExercise_description(results2.getString("exercise_description"));
                exercise.setSuggested_weight(results2.getInt("suggested_weight"));
                exercise.setNum_of_reps(results2.getInt("num_of_reps"));
                exercise.setDuration(results2.getInt("duration"));
                exercise.setTarget_area(results2.getString("target_area"));
                exercises.add(exercise);
            }
        }
        workout.setExercises(exercises);
        return workout;
    }

    @Override
    public boolean addExerciseToWorkout(Workout workout, int exercise_id) {
        String sql = "insert into workout_exercise(workout_name, user_id, exercise) VALUES (?,?,?)";
        try{
            jdbcTemplate.queryForObject(sql, Integer.class, workout.getWorkout_name(), 1, exercise_id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public void removeExerciseFromWorkout(String workoutName, int exercise_id) {
        String sql = "DELETE FROM workout_exercise WHERE workout_name = ? AND exercise = ?";
        try {
            jdbcTemplate.update(sql, workoutName, exercise_id);
        } catch (DataAccessException e){
            System.out.println("Failed to delete exercise with id: " + exercise_id + " from " + workoutName + "!");
        }
    }

    @Override
    public void createWorkout(String workout_name) {
        String sql = "insert into workout_exercise(workout_name, user_id, exercise) VALUES (?,?,?)";
        try {
            jdbcTemplate.queryForObject(sql, Integer.class, workout_name, 1, 1);
        } catch (DataAccessException e){
            System.out.println("Failed to create workout!");
        }
    }

    @Override
    public void deleteWorkout(String workout_name) {
        String sql = "DELETE FROM workout_exercise WHERE workout_name = ?";
        try {
            jdbcTemplate.update(sql, workout_name);
        } catch (DataAccessException e){
            System.out.println("Failed to delete " + workout_name + "!");
        }
    }

}
