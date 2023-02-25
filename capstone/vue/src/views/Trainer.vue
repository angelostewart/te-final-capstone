<template>
  <div>
      <trainer-hero />
      <exercise-cards />
      <create-exercise />

  </div>
</template>

<script>
import ExerciseCards from '../components/ExerciseCards.vue'
import CreateExercise from '../components/CreateExercise.vue'
import TrainerHero from '../components/TrainerHero.vue'
export default {
  components: { TrainerHero, CreateExercise, ExerciseCards },
    name: "Trainer"

}
</script>

<style>

</style>