# Task
*To run the application you need to init some environmental properties which are used in application.properties file at first:*


1) **application_port**  - port on which you want to run the application for example: 8080

2) Settings of PostgreSQL DB:
    - **urlDB_PG** - db url to postgresdb, for example: jdbc:postgresql://localhost:***dbPort***/***dbName***
    - **usernameDB_PG** - user name used in db
    - **passwordDB_PG** - password used in db

3) Settings of H2 DB:
   H2 DB is disabled by default 
    - **urlDB_H2** - db url to h2, for example: jdbc:h2:mem:***dbName***
    - **usernameDB_H2** - user name used in db
    - **passwordDB_H2** - password used in db
