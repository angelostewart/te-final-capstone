import axios from "axios";
export default {


listExercises() {
 return axios.get(`/exercise`);
},


  getExercises() {
    return axios.get(`/exercise`);
  },

  getExerciseById(id) {
    return axios.get(`/exercise/${id}`);
  },

  addExercise(exercise) {
    return axios.post(`/exercise/add`, exercise);
  },

  editExercise(exercise, id) {
    return axios.put(`/exercise/edit/${id}`, exercise);
  },

  deleteExercise(id) {
    return axios.delete(`/exercise/delete/${id}`);
  },
};
