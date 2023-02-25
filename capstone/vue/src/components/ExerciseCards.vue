<template>
  <div class="exercise-cards">
    <div class="row">
      <!-- Drop down menu to filter displayed exercises -->
      <div class="target-filter">
        <label for="target-area">Filter by: </label>
        <select
          required
          class="form-select selectpicker"
          id="target-area"
          @change="this.filterExercises"
        >
          <option selected value="">All</option>

          <option
            v-for="exercise in this.filters"
            :key="exercise"
            :value="exercise"
          >
            {{ exercise }}
          </option>
        </select>
      </div>

      <!-- Creates a card for each excercise in the DB -->
      <div
        v-for="exercise in this.exercises"
        :key="exercise.exercise_id"
        class="col-12 col-sm-6 col-md-4 col-lg-3"
      >
        <!-- Card Container -->
        <div id="exercise-card" class="exercises shadow-sm">
          <!-- Card Details -->
          <h4 class="card-title">{{ exercise.exercise_name }}</h4>
          <p>{{ exercise.exercise_description }}</p>
          <hr class="hr">
          <div class="card-details text-secondary">
            <p><span class="fw-bold">Suggested Weight:</span> {{ exercise.suggested_weight }}lbs.</p>
            <p><span class="fw-bold">Number of Reps: </span> {{ exercise.num_of_reps }}</p>
            <p><span class="fw-bold">Duration: </span> {{ exercise.duration }}min.</p>
            <p><span class="fw-bold">Target Area: </span> {{ exercise.target_area }}</p>
          </div>

          <div class="card-btns">
            <!-- TODO: Create addToWorkout method  -->
            <!-- Add to workout button -->
            <button
              class="btn btn-primary add-btn"
              @click="addToWorkout(exercise.exercise_id)"
            >
              <i class="bi bi-plus-square"></i>
            </button>

            <!-- Edit button -->
            <button
              v-if="isTrainer()"
              @click="updateExercise(exercise.exercise_id)"
              class="btn btn-primary edit-btn"
            >
              <i class="bi bi-pencil"></i>
            </button>

            <!-- Delete button -->
            <button
              v-if="isTrainer()"
              @click="deleteExercise(exercise.exercise_id)"
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
import workoutService from "../services/WorkoutService.js";
import service from "../services/ExerciseService.js";
import { isTrainer } from "../util/util.js";
export default {
  // displays the list of exercises when page is loaded
  created() {
    service.getExercises().then((response) => {
      if (response.status === 200) {
        this.$store.state.exercises = response.data;
        this.exercises = response.data;
        const targetAreas = this.exercises.map((exercise) => {
          return exercise.target_area;
        });
        // filters out any duplicate target areas in the array
        this.filters = [...new Set(targetAreas)];
      }
    });
  },
  //this prop is used in AddExerciseToWorkout
  props: { workout: Object },

  data() {
    return {
      exercise: {
        exercise_id: 0,
        exercise_name: "",
        exercise_description: "",
        suggested_weight: 0,
        num_of_reps: 0,
        duration: 0,
        target_area: "",
      },
      exercises: [],
      filters: [],
    };
  },
  methods: {
    deleteExercise(id) {
      if (
        !window.confirm("Are you sure you would like to delete this exercise?")
      )
        return;
      service
        .deleteExercise(id)
        .then((response) => {
          if (response.status !== 200) {
            return;
          }
          this.$store.commit("DELETE_EXERCISE", id);
        })
        .catch((err) => console.log(err));
    },
    isTrainer,
    updateExercise(id) {
      this.$router.push({ path: `/edit/${id}` });
    },
    filterExercises(event) {
      //drop down option value for selected target area
      const target = event.target.value;
      this.exercises = this.$store.state.exercises.filter((exercise) => {
        return exercise.target_area.includes(target);
      });
    },
    addToWorkout(id) {
      workoutService
        .addExerciseToWorkout(this.$props.workout, id)
        .then((response) => {
          if (response.status !== 200) {
            return;
          }
          alert("Exercise Added!");
        });
    },
  },
};
</script>

<style scoped>
.exercise-cards {
  margin-bottom: 0px;
  margin-left: 50px;
  margin-right: 50px;
}

.exercises {
  padding: 10px;
  background: rgb(248, 249, 250);
  margin: 10px 10px 10px 10px;
  width: 100%;
  min-height: 270px;
  position: relative;
  border-radius: 10px;
}

.exercises:hover {
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

.card-details p {
  margin-top: 0px;
  margin-bottom: 0px;
}


.card-title {
  color: rgb(219, 68, 55);
  font-style: oblique;
  font-weight: bold;
  margin-bottom: 10px;
}
</style>
