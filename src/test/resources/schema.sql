DROP TABLE IF EXISTS gods;
CREATE TABLE gods
( id integer GENERATED  ALWAYS AS IDENTITY(START WITH 1),
  name varchar(256),
  age integer);
