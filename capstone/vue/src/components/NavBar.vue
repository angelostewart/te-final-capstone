<template>
  <div class="nav-bar">
    <div style="height: 92px;"/>
    <nav
      class="navbar navbar-expand-sm navbar-light bg-light shadow-sm py-3 fixed-top"
      id="navbar"
    >
      <router-link class="navbar-brand" v-bind:to="{ name: 'home' }">
        <img src="/img/elevate-health-logo.png"  height="50" alt="" />
      </router-link>

      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav ms-auto">
          <router-link
            class="nav-item nav-link active"
            v-bind:to="{ name: 'home' }"
            v-if="$store.state.token != ''"
            >Home
          </router-link>

          <router-link
            class="home-btn nav-item nav-link active "
            v-bind:to="{ name: 'Exercise' }"
            v-if="$store.state.token != '' && !isTrainer()"
            >Exercises</router-link
          >

           <router-link
            class="home-btn nav-item nav-link active"
            v-bind:to="{ name: 'Trainer' }"
            v-if="$store.state.token != '' && isTrainer()"
            >Trainer</router-link
          >

          <router-link
            class="logout nav-item nav-link active"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
import { isTrainer } from "../util/util.js";
export default {

  methods: {
    isTrainer
  }

};
</script>

<style>
.logout {
  margin-right: 50px;
}

.navbar-brand {
  margin-left: 50px;
}

.navbar-brand:hover img {
  transition: all 0.2s ease-in-out;
  transform: scale(1.1);
}

.nav-item {
  font-size: 20px;
}

.nav-link {
  position: relative;
  color: rgb(143, 143, 143) !important;
}

.nav-link::before {
  content: "";
  position: absolute;
  width: 100%;
  height: 4px;
  border-radius: 1px;
  background-color: rgb(219, 68, 55);
  bottom: 0;
  left: 0;
  transform-origin: right;
  transform: scaleX(0);
  transition: transform 0.3s ease-in-out;
}

.nav-link:hover::before {
  transform-origin: left;
  transform: scaleX(1);
}

.nav-bar {
  margin-bottom: 5px;
}
</style>
