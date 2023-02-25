<template>
  <div>
      <!-- Binds currentWorkout to the workout prop in ExerciseCards -->
      <exercise-cards 
      :workout="this.currentWorkout"
      />
      

  </div>
</template>

<script>
import service from "../services/WorkoutService.js";

import ExerciseCards from './ExerciseCards.vue'
export default {
    created() {
    const namePassed = this.$route.params.name;
    service.getWorkoutByName(namePassed).then((response) => {
      this.currentWorkout = response.data;
      this.exercises = this.currentWorkout.exercises
      
    });
  },
  data() {
      return {
          currentWorkout: null,
          exercises: []
      }

  },
  components: { ExerciseCards },

}
</script>

<style>

</style>