<template>
  <div class="home">
   <!-- <user-column /> -->
    <user-hero />
    <!-- <my-workouts/> -->
    <workout-cards/>
    <create-workout/>
  </div>
</template>

<script>
// import UserColumn from "../components/UserColumn.vue";
import WorkoutCards from "../components/WorkoutCards.vue";

import CreateWorkout from '../components/CreateWorkout.vue';
import UserHero from '../components/UserHero.vue';

export default {
  name: "Home",
  components: {
    // UserColumn,
    // MyWorkouts,
    WorkoutCards,
    CreateWorkout,
    UserHero,
  },
};
</script>

<style scoped></style>
