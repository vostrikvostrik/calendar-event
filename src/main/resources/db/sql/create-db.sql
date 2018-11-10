DROP TABLE UserEvent IF EXISTS;

CREATE TABLE UserEvent (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  title VARCHAR(30),
  className  VARCHAR(50),
  allDay BOOLEAN,
  year INTEGER,
  month INTEGER,
  day INTEGER,
  hour INTEGER,
  minute INTEGER,
  start  DATE
);

