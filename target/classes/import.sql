INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (1, 'Brice', 'Argenson', 'bargenson@edgenda.com');
INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (2, 'Gregoire', 'Weber', 'gweber@cleverage.com');
INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (3, 'John', 'Doe', 'jdoe@bnc.com');

INSERT INTO EVENT(ID, EVENT_DATE, DESCRIPTION) VALUES (1, '2019-01-31', 'The Spring Framework is an application framework and inversion of control container for the Java platform. ');
INSERT INTO EVENT(ID, EVENT_DATE, DESCRIPTION) VALUES (2, '2019-02-12', 'Representational State Transfer (REST) is an architectural style that defines a set of constraints to be used for creating web services.');
INSERT INTO EVENT(ID, EVENT_DATE, DESCRIPTION) VALUES (3, '2019-03-11', 'Jenkins is an open source automation server written in Java.');

INSERT INTO GUESTS_EVENTS(EVENT_ID, GUEST_ID) VALUES (1, 1);
INSERT INTO GUESTS_EVENTS(EVENT_ID, GUEST_ID)  VALUES (2, 1);
INSERT INTO GUESTS_EVENTS(EVENT_ID, GUEST_ID) VALUES (3, 1);
INSERT INTO GUESTS_EVENTS(EVENT_ID, GUEST_ID) VALUES (2, 2);
INSERT INTO GUESTS_EVENTS(EVENT_ID, GUEST_ID)  VALUES (3, 2);
INSERT INTO GUESTS_EVENTS(EVENT_ID, GUEST_ID) VALUES (3, 3);