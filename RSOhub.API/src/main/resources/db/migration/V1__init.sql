-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

use RSOhub;

CREATE TABLE value (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    number INT(36) NOT NULL
);

CREATE TABLE comment (
    commentId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refUserId INT(6) UNSIGNED,
    refEventId INT(6) UNSIGNED,
    text VARCHAR(255),
    rating INT(6),
    time VARCHAR(255)
);

CREATE TABLE event (
    eventId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refLocationId INT(6) UNSIGNED,
    time VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    eventType VARCHAR(255)
);

CREATE TABLE location (
    locationId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE rso (
    rsoId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    isActive BOOLEAN,
    memberCount INT(6) UNSIGNED
);

CREATE TABLE university (
    universityId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refLocationId INT(6) UNSIGNED,
    name VARCHAR(255),
    description VARCHAR(255),
    numberOfStudents INT(6)
);

CREATE TABLE user (
    userId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    refUniversityId INT(6) UNSIGNED,
    username VARCHAR(255),
    password VARCHAR(255),
    userType VARCHAR(255)
);
