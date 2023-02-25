<template>
  <div class="exercise-form">
    <div id="exercise-form">
      <form @submit.prevent="updateExercise">
        <div class="form-group mb-2">
          <label for="name">Exercise Name: </label>
          <input
            required
            type="text"
            class="form-control"
            id="name"
            v-model="currentExercise.exercise_name"
          />
        </div>

        <div class="form-group mb-2">
          <label for="description">Exercise Description: </label>
          <textarea
            required
            class="form-control"
            rows="3"
            id="description"
            maxlength="140"
            v-model="currentExercise.exercise_description"
          />
        </div>

        <div class="form-group mb-2">
          <label for="weight">Suggested Weight: </label>
          <input
            required
            type="text"
            class="form-control"
            id="weight"
            v-model="currentExercise.suggested_weight"
          />
        </div>

        <div class="form-group mb-2">
          <label for="reps">Number of Reps: </label>
          <input
            required
            type="text"
            class="form-control"
            id="reps"
            v-model="currentExercise.num_of_reps"
          />
        </div>

        <div class="form-group mb-2">
          <label for="duration">Duration: </label>
          <input
            required
            type="text"
            class="form-control"
            id="duration"
            v-model="currentExercise.duration"
          />
        </div>

        <div class="form-group">
          <label for="target-area">Target Area: </label>
          <select
            required
            class="form-select selectpicker"
            id="target-area"
            v-model="currentExercise.target_area"
          >
            <option>Biceps</option>
            <option>Triceps</option>
            <option>Chest</option>
            <option>Shoulders</option>
            <option>Abs</option>
            <option>Legs</option>
            <option>Back</option>
            <option>Cardio</option>
          </select>
        </div>

        <button
          class="btn btn-primary add-exercise-btn shadow-sm"
          type="submit"
        >
          Submit
        </button>

        <button
          class="btn btn-primary btn-danger cancel-btn shadow-sm"
          v-on:click.prevent="cancelEdit"
        >
          Cancel
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import service from "../services/ExerciseService.js";

export default {
  created() {
    const idPassed = this.$route.params.id;
    service.getExerciseById(idPassed).then((response) => {
      this.currentExercise = response.data;
      
    });
  },
  data() {
    return {
      currentExercise: {},
    };
  },
  methods: {
    newExercise() {
      service.addExercise(this.exercise).then((response) => {
        if (response.status === 200) {
          // using the ADD_EXERCISE mutator updates the state when adding a new exercise
          // new exercise is available to view on the page without a refresh

          this.$store.commit("ADD_EXERCISE", response.data);
          this.exercise = {};
          // this.$router.push({ name: "Exercise" });
          document.getElementById("navbar").scrollIntoView();
          this.showForm = false;
        }
      });
    },
    cancelEdit() {
      this.$router.push({ name: "Trainer" });
    },
    toggleMenu() {
      this.showForm = true;
      setTimeout(() => {
        document.getElementById("exercise-form").scrollIntoView();
      }, 50);
    },
    updateExercise() {
      service
        .editExercise( this.currentExercise, this.$route.params.id)
        .then(() => {
          // window.alert("Exercise updated.");
          this.$router.push({ name: "Trainer" });
        })
        .catch((err) => {
          if (err.response) {
            window.alert("Uh oh, something went wrong. Please try again.");
          }
        });
    },
  },
};
</script>

<style scoped>
.exercise-form {
  width: 50%;
  min-width: 200px;
  max-width: 300px;
  top: 40%;
  margin-top: 50px;
  margin-left: auto;
  margin-right: auto;
  text-align: ce;
}

.show-form-btn {
  width: 50%;
  min-width: 300px;
  max-width: 400px;
  width: 100;
}

.add-exercise-btn {
  background-color: rgb(182, 182, 182);
  border-color: rgb(173, 173, 173);
  width: 100%;
  margin-top: 30px;
}

.add-exercise-btn:hover {
  background-color: rgb(128, 128, 128);
  border-color: rgb(100, 100, 100);
}

.cancel-btn {
  width: 100%;
  margin-top: 10px;
  margin-bottom: 40px;
}
</style>
