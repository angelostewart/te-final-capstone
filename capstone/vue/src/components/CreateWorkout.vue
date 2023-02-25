<template>
  <div class="create-workout">
    <div class="workout-form text-center">
      <button
        class="btn btn-primary show-form-btn shadow-sm"
        v-if="showForm === false"
        v-on:click.prevent="toggleMenu"
      >
        Add Workout
      </button>

      <!-- <div class="workout-form"> -->
      <form @submit.prevent="newWorkout" v-if="showForm === true">
        <div class="form-group mb-2">
          <label for="name">Workout Name: </label>
          <input
            required
            type="text"
            class="form-control"
            id="name"
            v-model="workoutName"
          />
        </div>

        <button
          class="btn btn-primary add-workout-btn shadow-sm"
          v-if="showForm === true"
          type="submit"
        >
          Add Workout
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
import service from "../services/WorkoutService.js";
// import ExerciseCards from "../components/ExerciseCards.vue";

export default {
  components: {
    // ExerciseCards,
  },
  data() {
    return {
      showForm: false,
      workout: {},
      workoutName: "",
      expanded: false,
      btnText: "View Exercises",
    };
  },
  methods: {
    newWorkout() {
      service.createWorkout(this.workoutName).then((response) => {
        if (response.status === 200) {
          this.$store.commit("ADD_WORKOUT", {
            workout_name: this.workoutName,
            exercises: [{ exercise_id: 1, exercise_name: "Warm-Up" }],
          });
          this.workoutName = "";
        }
      });
    },
    resetForm() {
      this.showForm = false;
      this.workout = {};
      document.getElementById("navbar").scrollIntoView();
    },
    toggleMenu() {
      this.showForm = true;
      setTimeout(() => {
        document.getElementById("workout-form").scrollIntoView();
      }, 50);
    },
    toggleView() {
      this.expanded = !this.expanded;

      if (this.expanded) {
        this.btnText = "Hide Exercises";
      } else {
        this.btnText = "View Exercises";
      }
    },
  },
};
</script>

<style scoped>

.create-workout {
  width: 50%;
  min-width: 200px;
  max-width: 300px;
  top: 40%;
  margin-top: 50px;
  margin-left: auto;
  margin-right: auto;
}

.show-exercises-btn {
  width: 50%;
  min-width: 300px;
  max-width: 400px;
  width: 100;
}

.show-form-btn {
  margin-top: 50px;
  min-width: 300px;
  max-width: 400px;
}


.add-workout-btn {
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
