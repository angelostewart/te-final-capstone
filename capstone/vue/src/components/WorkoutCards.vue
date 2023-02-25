<template>
  <div class="workout-cards">
    <div class="row">
      <!-- Creates a card for each workout in the DB -->
      <div
        v-for="workout in this.workouts"
        :key="workout.workout_id"
        class="col-12 col-sm-6 col-md-4 col-lg-3"
      >
        <!-- Card Container -->
        <div class="workouts shadow-sm">
          <!-- Card Details -->
          <h4 class="card-title">{{ workout.workout_name }}</h4>
          <hr />

          <!--loop through exercsises for the workout -->

          <div class="card-details">
            <h5
              v-for="exercise in workout.exercises"
              :key="exercise.exercise_id"
              class="text-secondary"
            >
              <i class="bi bi-caret-right"></i>
              {{ exercise.exercise_name }}

              <button
                class="btn remove-exercise-btn"
                @click="
                  removeExerciseFromWorkout(
                    workout.workout_name,
                    exercise.exercise_id
                  )
                "
              >
                <i class="bi bi-x-circle"></i>
              </button>
            </h5>
          </div>

          <div class="card-btns">
            <!-- TODO: Create addToWorkout method  -->
            <!-- Add new exercise to workout button -->
            <button
              @click="updateWorkout(workout.workout_name)"
              class="btn btn-primary add-btn"
            >
              <i class="bi bi-plus-square"></i>
            </button>

            <!-- TODO: Create deleteWorkout method -->
            <!-- Delete button -->
            <button
              @click="deleteWorkout(workout.workout_name)"
              class="delete-btn btn"
            >
              <i class="bi bi-trash3"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import service from "../services/WorkoutService.js";
import { isTrainer } from "../util/util.js";
export default {
  // displays the list of workouts when page is loaded
  created() {
    this.getWorkouts();
  },

  data() {
    return {
      exercises: [],
      workout: {},
      workoutName: "",
      workouts: [],
    };
  },
  methods: {
    getWorkouts() {
      service.getWorkouts().then((response) => {
        if (response.status === 200) {
          this.$store.state.workouts = response.data;
          this.workouts = response.data;
        }
      });
    },
    isTrainer,
    updateWorkout(name) {
      this.$router.push({ path: `/update/${name}` });
    },
    deleteWorkout(name) {
      if (
        !window.confirm("Are you sure you would like to delete this workout?")
      )
        return;
      service.deleteWorkout(name).then((response) => {
        if (response.status !== 200) {
          return;
        }
        this.$store.commit("DELETE_WORKOUT", name);
      });
    },
    removeExerciseFromWorkout(workout_name, id) {
      if (
        !window.confirm("Are you sure you would like to remove this exercise?")
      )
        return;
      service.removeExerciseFromWorkout(workout_name, id).then((response) => {
        if (response.status == 200) {
          this.getWorkouts();
        }
        if (response.status !== 200) {
          return;
        }
      });
    },
  },
};
</script>

<style scoped>
.workout-cards {
  margin-bottom: 0px;
  margin-left: 50px;
  margin-right: 50px;
}

.workouts {
  padding: 10px;
  background: rgb(248, 249, 250);
  margin: 10px 10px 10px 10px;
  width: 100%;
  min-height: 270px;
  position: relative;
}

.workouts:hover {
  transition: all 0.2s ease-in-out;
  transform: scale(1.05);
  margin-top: 10px;
}

.card-btns {
  display: flex;
  flex-direction: column;
  position: absolute;
  right: 0;
  bottom: 0;
  margin-right: 5px;
  margin-bottom: 5px;
}

.add-btn {
  color: black;
  padding: 0px;
  border: none;
  background-color: transparent;
}

.add-btn:hover {
  color: rgb(219, 68, 55);
}

.add-btn:active {
  background-color: transparent;
}

.edit-btn {
  color: black;
  padding: 0px;
  border: none;
  background-color: transparent;
}

.edit-btn:hover {
  color: rgb(219, 68, 55);
}

.edit-btn:active {
  background-color: transparent;
}

.delete-btn {
  padding: 0px;
  border: none;
  background-color: transparent;
}

.delete-btn:hover {
  color: rgb(219, 68, 55);
}

.delete-btn:active {
  background-color: transparent;
}

.remove-exercise-btn {
  color: transparent;
  padding: 0px;
  border: none;
  background-color: transparent;
}

h5:hover .remove-exercise-btn {
  color: rgb(219, 68, 55);
}

.remove-exercise-btn {
  position: relative;
  bottom: 1px;
}

i.bi-caret-right {
  color: darkgray;
}

.card-details p {
  margin-top: 0px;
  margin-bottom: 0px;
}

.card-title {
  color: rgb(219, 68, 55);
  font-style: oblique;
  font-weight: bold;
}
</style>
