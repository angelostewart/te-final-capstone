package com.techelevator.controller;

import com.techelevator.dao.WorkoutStatsDao;
import com.techelevator.model.Exercise;
import com.techelevator.model.WorkoutStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WorkoutStatsController {

    @Autowired
    WorkoutStatsDao workoutStatsDao;

    @RequestMapping(path = "/workoutStats", method = RequestMethod.GET)
    public List<WorkoutStats> listWorkoutStats() {
        return workoutStatsDao.allWorkoutStats();
    }

    @RequestMapping(path = "/workoutStats/add/{user}/{date}/{exercise}", method = RequestMethod.POST)
    public WorkoutStats addNewWorkoutStat(@PathVariable int user, @PathVariable String date, @PathVariable int exercise) {
        return workoutStatsDao.createWorkoutStats(user, date, exercise);
    }

    @RequestMapping(path = "/workoutStats/{user}/{date}", method = RequestMethod.GET)
    public int[] getWorkoutStatsForUser(@PathVariable int user, @PathVariable String date) {
        return workoutStatsDao.getWorkoutStatsForUser(user, date);
    }

}
