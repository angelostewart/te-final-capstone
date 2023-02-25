<template>
  <div class="create-exercise">
    <div id="exercise-form">
      <button
        class="btn btn-primary show-form-btn shadow-sm"
        v-if="showForm === false"
        v-on:click.prevent="toggleMenu"
      >
        Add Exercise
      </button>

      <form @submit.prevent="newExercise" v-if="showForm === true">
        <div class="form-group mb-2">
          <label for="name">Exercise Name: </label>
          <input
            required
            type="text"
            class="form-control"
            id="name"
            v-model="exercise.exercise_name"
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
            v-model="exercise.exercise_description"
          />
        </div>

        <div class="form-group mb-2">
          <label for="weight">Suggested Weight: </label>
          <input
            required
            type="text"
            class="form-control"
            id="weight"
            v-model="exercise.suggested_weight"
          />
        </div>

        <div class="form-group mb-2">
          <label for="reps">Number of Reps: </label>
          <input
            required
            type="text"
            class="form-control"
            id="reps"
            v-model="exercise.num_of_reps"
          />
        </div>

        <div class="form-group mb-2">
          <label for="duration">Duration: </label>
          <input
            required
            type="text"
            class="form-control"
            id="duration"
            v-model="exercise.duration"
          />
        </div>

        <div class="form-group">
          <label for="target-area">Target Area: </label>
          <select
            required
            class="form-select selectpicker"
            id="target-area"
            v-model="exercise.target_area"
          >
            <option>Select an exercise</option>
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
          v-if="showForm === true"
          type="submit"
        >
          Add Exercise
        </button>

        <button
          class="btn btn-primary btn-danger cancel-btn shadow-sm"
          v-if="showForm === true"
          v-on:click.prevent="resetForm"
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
  data() {
    return {
      showForm: false,
      exercise: {},
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
    resetForm() {
      this.showForm = false;
      this.exercise = {};
      document.getElementById("navbar").scrollIntoView();
    },
    toggleMenu() {
      this.showForm = true;
      setTimeout(() => {
        document.getElementById("exercise-form").scrollIntoView();
      }, 50);
    },
  },
};
</script>

<style scoped>
.create-exercise {
  width: 50%;
  min-width: 200px;
  max-width: 300px;
  top: 40%;
  margin-top: 50px;
  margin-left: auto;
  margin-right: auto;
}

.show-form-btn {
  width: 50%;
  min-width: 300px;
  max-width: 400px;
  width: 100;
  margin-bottom: 50px;
}

.add-exercise-btn {
  width: 100%;
  margin-top: 10px;
}

.cancel-btn {
  background-color: rgb(182, 182, 182);
  border-color: rgb(173, 173, 173);
  width: 100%;
  margin-top: 5px;
  margin-bottom: 10px;
}

.cancel-btn:hover {
  background-color: rgb(128, 128, 128);
  border-color: rgb(100, 100, 100);
}
</style>
