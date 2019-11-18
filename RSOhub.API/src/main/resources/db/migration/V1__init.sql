-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

use RSOhub;

CREATE TABLE comment (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ref_user_id INT(6) UNSIGNED,
    ref_event_id INT(6) UNSIGNED,
    text VARCHAR(255),
    rating INT(6),
    time VARCHAR(255)
);

CREATE TABLE event (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ref_location_id INT(6) UNSIGNED,
    time VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    event_type ENUM('PUBLIC', 'PRIVATE', 'RSO') default NULL
);

CREATE TABLE location (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE rso (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    is_active BOOLEAN,
    member_count INT(6) UNSIGNED
);

CREATE TABLE university (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ref_location_id INT(6) UNSIGNED,
    name VARCHAR(255) UNIQUE,
    description VARCHAR(255),
    number_of_students INT(6)
);

CREATE TABLE user (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ref_university_id INT(6) UNSIGNED NULL,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    user_type ENUM('STANDARD', 'ADMIN', 'SUPER_ADMIN') default NULL
);

CREATE TABLE rso_membership (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ref_rso_id INT(6) UNSIGNED NULL,
    ref_user_id INT(6) UNSIGNED NULL
);

CREATE TABLE rso_petition (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ref_rso_id INT(6) UNSIGNED NULL,
    ref_user_id INT(6) UNSIGNED NULL
);
