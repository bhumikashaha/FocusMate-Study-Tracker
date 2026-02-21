DROP DATABASE IF EXISTS focusmate;

CREATE DATABASE focusmate;
USE focusmate;

-- USERS TABLE
CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(120) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert your existing user (for login)
INSERT INTO users (username, name, email, password)
VALUES ('Bhumi', 'Bhumika Shaha', 'bhumikashah601@gmail.com', '2005');


-- DAILY GOAL TABLE
CREATE TABLE daily_goal (
    daily_goal_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    goal_text VARCHAR(255),
    goal_date DATE NOT NULL,
    completed BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


-- GOAL TABLE
CREATE TABLE goal (
    goal_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    target_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


-- SESSION RECORD TABLE
CREATE TABLE session_record (
    record_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    start_time DATETIME NOT NULL,
    end_time DATETIME,
    total_minutes INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


-- STREAK TABLE
CREATE TABLE streak (
    streak_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    current_streak INT DEFAULT 0,
    last_updated DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


-- ANALYTICS TABLE
CREATE TABLE analytics (
    analytics_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    study_hours_month INT DEFAULT 0,
    completed_goals INT DEFAULT 0,
    productivity_score INT DEFAULT 0,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
