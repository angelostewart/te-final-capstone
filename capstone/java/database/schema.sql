BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE exercise (
	exercise_id SERIAL,
	exercise_name varchar(50) NOT NULL UNIQUE,
	exercise_description varchar(1000) NOT NULL,
	suggested_weight int,
	num_of_reps int,
	duration int,
	target_area varchar (50),
	
	CONSTRAINT PK_exercise PRIMARY KEY (exercise_id)
);

CREATE TABLE workout_stats (
    workout_stats_id SERIAL,
    user_id int,
    workout_date varchar(50),
    biceps_duration int,
    triceps_duration int,
    chest_duration int,
    shoulders_duration int,
    back_duration int,
    legs_duration int,
    abs_duration int,
    cardio_duration int,

    CONSTRAINT PK_workout_stats PRIMARY KEY (workout_stats_id),
    CONSTRAINT FK_workout_stats FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE trainer (
    trainer_id int,
    about_me varchar(1000)
);

CREATE TABLE user_trainer (
    assignment_id SERIAL,
    user_id int,
    trainer_id int
);

CREATE TABLE workout_exercise (
    workout_exercise_id SERIAL,
    workout_name varchar(50),
    user_id int,
    exercise int,

    CONSTRAINT PK_workout_exercise PRIMARY KEY (workout_exercise_id)
);

COMMIT TRANSACTION;
