BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('john','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('steve','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');





INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Warm-Up', 'Begin your workout with a quick jog and stretch to warm-up and prepare your body for aerobic activities.'
		, 0, 0, 5, 'Cardio');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Pull-Up', 'Hang from a pull-up bar by your hands with your palms facing away from you, and lifting your entire body up with your arm and back muscles.', 150, 8, 5, 'Biceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Dumbell Curl', 'Slowly curl the weight up by bending your elbow, keeping your elbow close to your body. Then slowly lower the weight to the starting position.', 30, 10, 5, 'Biceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Hammer Curl', 'Hammer curls are biceps curls performed with your hands facing each other. They’re beneficial to add mass to your arms and can help focus more attention on the short head of the biceps.', 30, 8, 6, 'Biceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Preacher Curl', 'A weightlifting exercise for the biceps in which a barbell is lifted by flexing the elbows, with the upper arms resting on an angled bench.', 60, 8, 5, 'Biceps');




INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Tricep Extension', 'Point your upper arm toward the ceiling, with your elbow bent to 90 degrees. Slowly straighten the elbow, moving the weight upward. Then slowly lower the weight to the starting position.', 20, 10, 5, 'Triceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Push-Ups', 'Keeping a prone position, with the hands palms down under the shoulders, the balls of the feet on the ground, and the back straight, pushes the body up and lets it down by an alternate straightening and bending of the arms.', 0, 10, 5, 'Triceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Skull Crushers', 'Performed by lying on your back on a flat bench and lifting dumbbells from behind your head to full extension above you.', 25, 8, 8, 'Triceps');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Tricep Dips', 'Performed on parallel bars at your gym or even on a playground. You hold your entire body weight up with your arms extended and feet hovering over the floor, ankles crossed.', 0, 10, 4, 'Triceps');




INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Bench Press', 'Lying down on a flat bench, press the barbell up and down at chest height. It works the pectoral muscles, shoulders, and arms.
', 160, 10, 5, 'Chest');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Bodyweight Dip', 'The bodyweight dip is a compound upper-body pressing exercise that strengthens the shoulders, chest, and triceps. Leaning forward targets the chest while an upright position targets the triceps.', 0, 15, 6, 'Chest');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Dumbbell Bench Press', 'Lie back on a flat bench with a dumbbell in each hand. Hold the weights at shoulder-level. Then press the weights straight up.', 25, 12, 6, 'Chest');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Cable Crossover', 'Stand between two facing cable stations with both pulleys set midway between the top and bottom of the station. Keep your elbows slightly bent, and step forward so there’s tension on the cables.
Flex your pecs as you bring your hands together out in front of your chest. Alternate stretching and flexing after each set. ', 50, 10, 6, 'Chest');




INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Lateral Raise', 'Grab weighted dumbbells and lift them away from your body, bring your arms into a T-pose. Slowly lower your arms back to your sides to complete one repetition.'
		, 15, 8, 1, 'Shoulders');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Handstand Push-Up', 'While in a handstand, slowly lower yourself until your head touches the ground, then push until you are back into the handstand position.'
		, 0, 4, 1, 'Shoulders');
		
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Military Press', 'Lift a barbell to shoulder height and then smoothly lift it overhead.'
		, 45, 8, 1, 'Shoulders');
		
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Dumbbell Front Raise', 'Grab a dumbbell in each arm and then raise your arms up in front of you.'
		, 15, 8, 1, 'Shoulders');

INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Push-Up', 'In a prone position, with the hands down under the shoulders, the balls of the feet on the ground, and the back straight.
', 150, 20, 10, 'Shoulders');


INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Russian Twist', 'Sit on the floor with your knees bent and feet flat on the ground, hold your hands together in front of your chest and rotate side to side to complete one rep. ', 0, 20, 5, 'Abs');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Scissor Kicks', 'Lie flat on your back with your arms at your sides and legs straight up in the air. Lower your left leg until it is a few inches off the ground. Switch legs by lifting your left leg and lowering your right leg to complete one rep. ', 0, 20, 5, 'Abs');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Mountain Climbers', 'Start in a push-up position with your hands shoulder-width apart. Bring your right knee to your chest, keeping your foot off the ground. Return to starting position and repeat with your left leg to complete one rep. ', 0, 20, 5, 'Abs');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Leg Raise', 'Lie flat on your back with arms at your sides and legs straight. Lift your legs until they are perpendicular to the ground. Lower your legs back to the starting position to complete one rep.', 0, 20, 5, 'Abs');




INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Squats', 'Stand with feet shoulder-width apart, holding a barbell or dumbbells at your shoulders. Lower your hips back and down as if you were sitting in a chair. Keep your back straight and your weight on your heels. Push back up to the starting position', 200, 12, 10, 'Legs');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Lunges', 'Stand with your feet hip-width apart and your hands on your hips. Take a large step forward with your right foot. Lower your body until your right thigh is parallel to the ground. Push back up to the starting position and repeat with your left leg to complete one rep.', 0, 12, 10, 'Legs');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Deadlifts', 'Stand with feet hip-width apart, holding a barbell in front of your thighs. Keeping your back straight, bend at the hips and lower the bar to the ground. Push through your heels to return to the starting position.', 200, 12, 10, 'Legs');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) VALUES ('Calf Raises', 'Stand with feet hip-width apart, holding a barbell or dumbbells for added resistance. Raise your heels off the ground as high as you can. Lower your heels back to the starting position.', 100, 12, 10, 'Legs');






INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Lat Pulldown', 'While seated, you pull a hanging bar toward you to reach chin level, then release it back up with control for one repetition.'
		, 50, 8, 1, 'Back');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Wide-Grip Pull-Up', 'Do a pull-up with a wider grip than usual.'
		, 0, 4, 1, 'Back');
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Deadlift', 'Lift a loaded barbell off the ground to the level of the hips, torso perpendicular to the floor, before being placed back on the ground.'
		, 95, 8, 1, 'Back');
		
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Bent-Over Row', 'Hing your hips and lean foward to lift a weighted barbell toward your body with a rowing movement pattern.'
		, 30, 8, 1, 'Back');




INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Running', 'Move at a speed faster than a walk, never having both feet on the ground at the same time.'
		, 0, 1, 15, 'Cardio');
		
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Jogging', 'Run at a steady gentle pace.'
		, 0, 1, 30, 'Cardio');
		
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Swimming', 'Propel yourself through a pool of water using your limbs.'
		, 0, 1, 15, 'Cardio');
		
INSERT INTO exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area)
VALUES ('Jumping Jacks', 'Jump into a position with your legs spread wide and your hands going overhead, then return to the standing position with your feet together and arms at your sides.'
		, 0, 60, 1, 'Cardio');





COMMIT TRANSACTION;
