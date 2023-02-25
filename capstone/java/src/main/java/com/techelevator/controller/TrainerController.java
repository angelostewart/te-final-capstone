package com.techelevator.controller;

import com.techelevator.dao.TrainerDao;
import com.techelevator.model.Trainer;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TrainerController {

    @Autowired
    TrainerDao trainerDao;

    @RequestMapping(path = "/trainer/all", method = RequestMethod.GET)
    public List<Trainer> listTrainers() {
        return trainerDao.getAllTrainers();
    }

    @RequestMapping(path = "/trainer/assign/{user_id}", method = RequestMethod.POST)
    public boolean assignTrainer(@PathVariable int user_id, @RequestBody Trainer trainer) {
           return trainerDao.assignToUser(user_id, trainer);
    }
}
