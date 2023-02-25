import axios from "axios";
export default {
  getTrainers() {
    return axios.get(`/trainer/all`);
  },

  assignTrainer(user_id, trainer) {
    return axios.post(`/trainer/assign/${user_id}`, user_id, trainer);
  },
};
