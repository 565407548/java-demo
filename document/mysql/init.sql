CREATE DATABASE IF NOT EXISTS demo;
USE demo;

drop table if exists user;
CREATE TABLE IF NOT EXISTS user
(
  id       INT PRIMARY KEY,
  name     VARCHAR(100) NOT NULL ,
  password VARCHAR(100) NOT NULL,
  gender   INT          NOT NULL,
  role_id  INT          NOT NULL
);

drop table if exists role_auth;
CREATE TABLE IF NOT EXISTS role_auth
(
  role_id INT NOT NULL,
  auth_id INT NOT NULL
);

drop table if exists role;
CREATE TABLE IF NOT EXISTS role
(
  id   INT PRIMARY KEY AUTO_INCREMENT,
  role VARCHAR(100) NOT NULL UNIQUE
);

drop table if exists auth;
CREATE TABLE IF NOT EXISTS auth
(
  id   INT PRIMARY KEY AUTO_INCREMENT,
  auth VARCHAR(100) NOT NULL UNIQUE
);

insert role (id, role)
values (1, "admin");
insert role (id, role)
values (2, "user");
insert role (id, role)
values (3, "test");

insert auth (id, auth) values (1, "user:create");
insert auth (id, auth)
values (2, "user:update");
insert auth (id, auth)
values (3, "user:delete");
insert auth (id, auth)
values (4, "user:get");

insert role_auth (role_id, auth_id) values (1,1);
insert role_auth (role_id, auth_id) values (1,2);
insert role_auth (role_id, auth_id) values (1,3);
insert role_auth (role_id, auth_id) values (1,4);
insert role_auth (role_id, auth_id) values (2,1);
insert role_auth (role_id, auth_id) values (2,2);
insert role_auth (role_id, auth_id) values (3,1);
insert role_auth (role_id, auth_id) values (3,2);
insert role_auth (role_id, auth_id) values (3,3);
insert role_auth (role_id, auth_id) values (3,4);

insert user (name, password, gender, role_id) values ("zhengcj","123",0,1);
insert user (name, password, gender, role_id) values ("dongyc","321",1,2);
