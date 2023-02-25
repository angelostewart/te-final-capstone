<template>
  <div class="container">
    <div class="row justify-content-between">
      <div class="mx-auto" style="width: 250px">
        <h1>My Trainer</h1>

        <tr><button class="btn btn-primary mt-md"> Suggested Workouts</button> </tr>
      <tr><button class="btn btn-primary mt-2"> Trainer Chat</button> </tr>
          </div>
    <div class="col-6">
    <div class="text-center">
    <h1>What would you like to hit today?</h1>

        <div class="target-btns">
            <button class="btn btn-primary mx-2" v-for= "(btn, index) in buttons" v-bind:key="btn.id" @click="toggleActiveClass(index)" :class= "{active: btn.active}">
                {{btn.name}}

            </button>
          </div>
          <button
            class="btn btn-primary mx-5"
            :class="{ active: isActive }"
            @click="isActive = !isActive"
          >
            I'm Feeling Lucky!
          </button>
        </div>
<<<<<<< HEAD
=======

>>>>>>> main
            <button class="btn btn-primary mx-5" :class="{active:luckyButton.active}" @click="toggleImFeelingLucky">I'm Feeling Lucky!</button>
            </div> 
            </div>
    <div class="mx-auto" style="width: 220px;">
    <h2> My Account </h2>
 <tr> <button class="btn btn-primary mt-2"> My Workouts</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Workout History</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Exercise Suggestions Form</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Exercise Suggestions Status</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Blocked Workouts</button></tr> 
</div>
    </div>
    
  
</template>

<script>
export default {
    data() {
        return{
            luckyButton: {name: 'Im feeling lucky!', active: false},
            buttons: [{name: 'Legs', active: false}, 
            {name: 'Shoulders', active: false}, 
            {name: 'Biceps', active: false}, 
            {name: 'Triceps', active: false}, 
            {name: 'Chest', active: false}, 
            {name: 'Back', active: false}, 
            {name: 'Cardio', active: false}, 
            {name: 'Abs', active: false}]
        };
    },
    methods: {
       toggleActiveClass: function(index){
     this.buttons[index].active=!this.buttons[index].active;
        },
        toggleImFeelingLucky: function() {
            this.luckyButton.active=!this.luckyButton.active;
            this.buttons.forEach(function(button) {
                button.active = false;
            })
        }
    }

}
</script>

<style scoped>
.col-6 {
  font-size: 3rem;
}
.h1 {
  font-size: 70px;
}
.container {
  font-weight: 0px;
  background-color: azure;
  border-block: 10rem;
  margin: 10rem 6rem;
}

.body{
    background-color: cornflowerblue;
}

.active {
  background-color: cyan;
}
</style>
