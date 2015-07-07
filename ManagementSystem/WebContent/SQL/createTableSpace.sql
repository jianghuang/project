DROP DATABASE IF EXISTS db_managementSystem;
CREATE DATABASE db_managementSystem;
USE db_managementSystem;

GRANT ALL ON db_managementSystem.* TO management@"" IDENTIFIED BY "manage";
