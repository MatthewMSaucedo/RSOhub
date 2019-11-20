use RSOhub;

/* id, userId, eventId, text, rating, time */
insert into comment
VALUES (1, 1, 1, 'test comment 1', 5, '5:30PM');
insert into comment
VALUES (2, 3, 2, 'test comment 2', 5, '8:30PM');

/* id, locationId, rsoId, time, name, descr, eventType */
insert into event
VALUES (1, 1, 1, '5:00PM', 'test event', 'this is a test event', 'PUBLIC');
insert into event
VALUES (2, 3, 2, '8:00PM', 'test event 2', 'this is a second test event', 'PUBLIC');

/* id, name */
insert into location
VALUES (1, 'event location');
insert into location
VALUES (2, 'university city');
insert into location
VALUES (3, 'event location 2');
insert into location
VALUES (4, 'university city 2');

/* id, rsoId, isActive, memberCount */
insert into rso
VALUES (1, 'testRso1', TRUE, 2);
insert into rso
VALUES (2, 'testRso2', TRUE, 2);

/* id, locationId, name, descr, numStudents */
insert into university
VALUES (1, 2, 'test university', 'this is a test university', 2);
insert into university
VALUES (2, 4, 'test university 2', 'this is a second test university', 2);

/* id, universityId, username, hashedPassword, userType */
insert into user
VALUES (1, 1, 'testUser1', 'hashedPassword1', 'STANDARD');
insert into user
VALUES (2, 1, 'adminUser1', 'hashedPassword2', 'ADMIN');
insert into user
VALUES (3, 2, 'testUser2', 'hashedPassword3', 'STANDARD');
insert into user
VALUES (4, 2, 'adminUser2', 'hashedPassword4', 'ADMIN');
insert into user
VALUES (5, 1, 'superAdminUser1', 'hashedPassword5', 'SUPER_ADMIN');
insert into user
VALUES (6, 2, 'superAdminUser2', 'hashedPassword6', 'SUPER_ADMIN');

/* id, rsoId, userId */
insert into rso_membership
VALUES (1, 1, 1);
insert into rso_membership
VALUES (2, 1, 2);
insert into rso_membership
VALUES (3, 2, 3);
insert into rso_membership
VALUES (4, 2, 4);

/* id, rsoId, userId */
insert into rso_petition
VALUES (1, 1, 2);
insert into rso_petition
VALUES (2, 2, 4);
