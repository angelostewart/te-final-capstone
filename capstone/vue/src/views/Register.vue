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

    <div id="register" class="text-center col-xs-12 col-8">
      <form class="form-register" @submit.prevent="register">
        <img src="/img/elevate-health-icon.png" width="100" /><br /><br />

        <h1 class="h3 mb-3 font-weight-normal text-secondary">
          Create Account
        </h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
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
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <router-link :to="{ name: 'login' }">Have an account?</router-link
        ><br />
        <button class="logout-btn btn btn-primary btn-block" type="submit">
          Create Account
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-register {
  width: 300px;
  margin: 17% auto 0px auto;
}

.logout-btn {
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
