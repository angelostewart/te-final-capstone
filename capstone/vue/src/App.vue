<template>
  <div id="app">
    
      <!-- <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'Exercise' }" v-if="$store.state.token != ''">Exercises</router-link>&nbsp;
      <router-link class="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      <nav-bar/>
      
    
    <router-view />
  </div>
</template>

<script>
import './global.css'
import NavBar from './components/NavBar.vue'
export default {
  components: { NavBar },

}
</script>




<style scoped>

#nav {
  text-align: center;
  font-size: 20px;
}

a {
  color: black;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}




</style>
