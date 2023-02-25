<template>
  <div class="trainer-hero">
    <div class="row">
      <div class="col-12 col-lg-6">
        <h1 class="welcome">Welcome Back</h1>
        <div class="welcome-body">
          <p>
            Welcome to your fitness journey! We are excited to have you as a
            member of our community. Your user page is your personal hub for
            tracking your progress and setting your fitness goals. With our app,
            you’ll have access to a variety of workout routines and a supportive
            community to keep you motivated. Let’s get started on your path to a
            healthier, happier you!
          </p>
        </div>
      </div>

      <div class="col-12 col-lg-6 text-center">
        <div class="profile-image text-center">
          <img src="/img/profile.png" height="75" />
        </div>
        <h1 class="trainer-info">Your Trainer</h1>
        <div class="trainer-body text-start">
          <p>
            Steve is a highly experienced and knowledgeable personal trainer
            with a passion for helping people achieve their fitness goals. He
            has been in the industry for over a decade and has helped countless
            individuals transform their bodies and improve their overall health.
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.row {
  background-color: rgb(219, 68, 55);
  margin-right: 0px;
  margin-left: 0px;
}

.welcome {
  color: white;
  width: 300px;
  margin: 50px auto auto 50px;
}

.welcome-body {
  color: ghostwhite;
  width: 400px;
  margin: auto auto 50px 50px;
}

.trainer-info {
  color: white;
  margin: auto auto auto auto;
}

.trainer-body {
  color: ghostwhite;
  width: auto;
  max-width: 400px;
  margin: auto auto auto auto;
}

.profile-image {
  margin: 40px auto auto auto;
}
</style>
