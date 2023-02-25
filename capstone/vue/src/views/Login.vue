<template>
  <div class="row g-0">
    <div class="col-4 d-none d-md-block">
      <div class="welcome-container text-center">

        <div class="welcome-info text-start">
          <div class="title-container">
            <h1 class="text-light title">
              Elevate
            </h1>

            <h1 class="text-light title">
              Your
            </h1>

            <h1 class="text-light title">
              Health
            </h1>

            <h2 class="text-light fw-lighter">
              The quickest ride <br />
              to the the top floor <br />of your health.
            </h2>
          </div>
        </div>
      </div>
    </div>
    <div id="login" class="text-center col-xs-12 col-md-8">
      <form class="form-signin" @submit.prevent="login">
        <img src="/img/elevate-health-icon.png" width="100" /><br /><br />
        <h1 class="h3 mb-3 font-weight-normal text-secondary">
          Please Sign In
        </h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <router-link :to="{ name: 'register' }">Need an account?</router-link
        ><br />
        <button class="login-btn btn btn-primary btn-block" type="submit">
          Sign in
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import { isTrainer } from "../util/util.js";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            if (isTrainer(response.data.user)) {
              this.$router.push("trainer");
            } else {
              this.$router.push("/");
            }
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
  isTrainer,
};
</script>

<style scoped>
.form-signin {
  width: 300px;
  margin: 17% auto 0px auto;
}

.login-btn {
  width: 300px;
}

.welcome-container {
  height: calc(100vh - 97px);
  background-color: rgb(219, 68, 55);
  /* border-top-right-radius: 10px;
  border-bottom-right-radius: 10px; */
}

.welcome-info {
  display: flex;
  justify-content: center;
  align-items: center;
}

.title-container {
  margin: 35% auto;
}


.title {
  font-size: 100px;
  font-weight: bold;
  margin-top: -40px;
}
</style>
