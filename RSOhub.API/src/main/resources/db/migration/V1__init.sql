-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

use RSOhub;

CREATE TABLE value (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    number INT(36) NOT NULL
);

CREATE TABLE comment (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refUserId INT(6) UNSIGNED,
    refEventId INT(6) UNSIGNED,
    text VARCHAR(255),
    rating INT(6),
    time VARCHAR(255)
);

CREATE TABLE event (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refLocationId INT(6) UNSIGNED,
    time VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    eventType  ENUM('PUBLIC', 'PRIVATE', 'RSO') default NULL
);

CREATE TABLE location (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE rso (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    isActive BOOLEAN,
    memberCount INT(6) UNSIGNED
);

CREATE TABLE university (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refLocationId INT(6) UNSIGNED,
    name VARCHAR(255),
    description VARCHAR(255),
    numberOfStudents INT(6)
);

CREATE TABLE user (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refUniversityId INT(6) UNSIGNED NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    userType ENUM('STANDARD', 'ADMIN', 'SUPER_ADMIN') default NULL
);
