import axios from "axios";
export default {
  getWorkoutStats() {
    return axios.get(`/workoutStats`);
  },

  addWorkoutStat(user, date, exercise) {
    return axios.post(`/workoutStats/add/${user}/${date}/${exercise}`, user, date, exercise);
  },

  getWorkoutStatsForUser(user, date) {
    return axios.get(`/workoutStats/${user}/${date}`, user, date);
  }
  
};
