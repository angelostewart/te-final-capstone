import axios from "axios";
export default {
  

  getWorkouts() {
    return axios.get(`/workout`);
  },

  getWorkoutByName(name) {
    return axios.get(`/workout/${name}`)
  },

  addExerciseToWorkout(workout, exercise_id) {
    return axios.post(`/workout/add/${exercise_id}`, workout)
  },

  removeExerciseFromWorkout(workoutName, exercise_id) {
    return axios.delete(`/workout/remove/${workoutName}/${exercise_id}`)
  },

  createWorkout(name) {
    return axios.post(`/workout/create`, {workout_name: name})
  },

  deleteWorkout(name) {
    return axios.delete(`/workout/delete/${name}`)
  },




 
  
  
  
};
