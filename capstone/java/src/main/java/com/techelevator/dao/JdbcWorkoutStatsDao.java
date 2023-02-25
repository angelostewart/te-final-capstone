package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.WorkoutStats;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutStatsDao implements WorkoutStatsDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutStatsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WorkoutStats> allWorkoutStats() {
        List<WorkoutStats> workoutStats = new ArrayList<>();
        String sql = "SELECT * FROM workout_stats";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            WorkoutStats workoutStat = mapRowToWorkoutStat(results);
            workoutStats.add(workoutStat);
        }
        return workoutStats;
    }

    @Override
    public WorkoutStats getWorkoutStatsById(int workoutId) {
        String sql = "SELECT * FROM workout_stats WHERE workout_stats_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);
        if (results.next()) {
            return mapRowToWorkoutStat(results);
        } else {
            return null;
        }
    }

    @Override
    public WorkoutStats createWorkoutStats(int user_id, String date, int exercise_id) {
        WorkoutStats workoutStats = new WorkoutStats();
        workoutStats.setUser_id(user_id);
        workoutStats.setWorkout_date(date);
        workoutStats.setBiceps_duration(0);
        workoutStats.setTriceps_duration(0);
        workoutStats.setChest_duration(0);
        workoutStats.setShoulders_duration(0);
        workoutStats.setBack_duration(0);
        workoutStats.setLegs_duration(0);
        workoutStats.setAbs_duration(0);
        workoutStats.setCardio_duration(0);

        String exercisesql = "SELECT * FROM exercise WHERE exercise_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(exercisesql, exercise_id);
        if (results.next()) {
            if(results.getString("target_area").equals("biceps")) {
                workoutStats.setBiceps_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("triceps")) {
                workoutStats.setTriceps_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("chest")) {
                workoutStats.setChest_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("shoulders")) {
                workoutStats.setShoulders_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("back")) {
                workoutStats.setBack_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("legs")) {
                workoutStats.setLegs_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("abs")) {
                workoutStats.setAbs_duration(results.getInt("duration"));
            }
            if(results.getString("target_area").equals("cardio")) {
                workoutStats.setCardio_duration(results.getInt("duration"));
            }
        }

        String sql = "insert into workout_stats(user_id, workout_date, biceps_duration, triceps_duration, chest_duration, shoulders_duration, back_duration, legs_duration, abs_duration, cardio_duration) VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING workout_stats_id";
        Integer newId;
        try {
            newId = jdbcTemplate.queryForObject(sql,
                    Integer.class, workoutStats.getUser_id(), workoutStats.getWorkout_date(), workoutStats.getBiceps_duration(), workoutStats.getTriceps_duration(), workoutStats.getChest_duration(), workoutStats.getShoulders_duration(), workoutStats.getBack_duration(), workoutStats.getLegs_duration(), workoutStats.getAbs_duration(), workoutStats.getCardio_duration());
            workoutStats.setWorkout_stats_id(newId);
        } catch (DataAccessException e){
           return workoutStats;
        }
        return workoutStats;
//        String password_hash = new BCryptPasswordEncoder().encode(password);
//        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
    }

    @Override
    public int[] getWorkoutStatsForUser(int user_id, String date) {
        int[] workoutStats = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        String sql = "SELECT * FROM workout_stats WHERE user_id = ? AND workout_date = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id, date);
        while (results.next()) {
            workoutStats[0]++;
            workoutStats[1] += results.getInt("biceps_duration");
            workoutStats[2] += results.getInt("triceps_duration");
            workoutStats[3] += results.getInt("chest_duration");
            workoutStats[4] += results.getInt("shoulders_duration");
            workoutStats[5] += results.getInt("back_duration");
            workoutStats[6] += results.getInt("legs_duration");
            workoutStats[7] += results.getInt("abs_duration");
            workoutStats[8] += results.getInt("cardio_duration");
        }
        return workoutStats;
    }

    private WorkoutStats mapRowToWorkoutStat(SqlRowSet rs) {
        WorkoutStats workoutStat = new WorkoutStats();
        workoutStat.setWorkout_stats_id(rs.getInt("workout_stats_id"));
        workoutStat.setUser_id(rs.getInt("user_id"));
        workoutStat.setWorkout_date(rs.getString("workout_date"));
        workoutStat.setBiceps_duration(rs.getInt("biceps_duration"));
        workoutStat.setTriceps_duration(rs.getInt("triceps_duration"));
        workoutStat.setChest_duration(rs.getInt("chest_duration"));
        workoutStat.setShoulders_duration(rs.getInt("shoulders_duration"));
        workoutStat.setBack_duration(rs.getInt("back_duration"));
        workoutStat.setLegs_duration(rs.getInt("legs_duration"));
        workoutStat.setAbs_duration(rs.getInt("abs_duration"));
        workoutStat.setCardio_duration(rs.getInt("cardio_duration"));

        return workoutStat;
    }

}
