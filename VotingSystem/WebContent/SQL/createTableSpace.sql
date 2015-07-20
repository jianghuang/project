DROP DATABASE IF EXISTS db_votemanage;
CREATE DATABASE db_votemanage;
USE db_votemanage;

GRANT ALL ON db_votemanage.* TO management@"" IDENTIFIED BY "manage";
