CREATE TABLE `loginform`.`user` ( `user_id` INT NOT NULL AUTO_INCREMENT , `fname` VARCHAR(50) NOT NULL , `lname` VARCHAR(50) NOT NULL , `dob` DATE NOT NULL , `email` VARCHAR(60) NOT NULL , `country` VARCHAR(50) NOT NULL , `city_id` INT NOT NULL , `phone` INT NOT NULL , `username` VARCHAR(20) NOT NULL , `password` VARCHAR(15) NOT NULL , `group_id` INT NOT NULL , PRIMARY KEY (`user_id`)) ENGINE = InnoDB; 

-----------------create user table--------------------------------------------------------------------------------------------------
CREATE TABLE `user` (user_id int(10) NOT NULL AUTO_INCREMENT, fname varchar(50) NOT NULL, lname varchar(50), dob date NOT NULL, email varchar(60) NOT NULL, country varchar(50) NOT NULL, city_id int(2) NOT NULL, phone int(11) NOT NULL, username varchar(20) NOT NULL UNIQUE, password varchar(15) NOT NULL, group_id int(2) NOT NULL, PRIMARY KEY (user_id),FOREIGN KEY (user_id) REFERENCES user_group(useruser_id),FOREIGN KEY (city_id) REFERENCES city(city_id)) engine=InnoDB;

-----------------create user table--------------------------------------------------------------------------------------------------
CREATE TABLE city (city_id int(2) NOT NULL AUTO_INCREMENT, city_name varchar(30) NOT NULL UNIQUE, country varchar(50) NOT NULL, PRIMARY KEY (city_id)) engine=InnoDB;

-----------------create group table--------------------------------------------------------------------------------------------------
CREATE TABLE `group` (group_id int(2) NOT NULL AUTO_INCREMENT, group_name varchar(50) NOT NULL UNIQUE, PRIMARY KEY (group_id),FOREIGN KEY (group_id) REFERENCES user_group(groupgroup_id),FOREIGN KEY (group_id) REFERENCES group_permission(groupgroup_id)) engine=InnoDB;


-----------------create permisssion table--------------------------------------------------------------------------------------------------
CREATE TABLE permission (permission_id int(5) NOT NULL AUTO_INCREMENT, permission_name varchar(50) NOT NULL UNIQUE, PRIMARY KEY (permission_id)) engine=InnoDB;

-----------------create user_group table--------------------------------------------------------------------------------------------------
CREATE TABLE user_group (useruser_id int(10) NOT NULL, groupgroup_id int(2) NOT NULL, PRIMARY KEY (useruser_id, groupgroup_id)) engine=InnoDB;

-----------------create group_permission table--------------------------------------------------------------------------------------------------
CREATE TABLE group_permission (groupgroup_id int(2) NOT NULL, permissionpermission_id int(5) NOT NULL, PRIMARY KEY (groupgroup_id, permissionpermission_id),FOREIGN KEY (groupgroup_id) REFERENCES group(group_id)) engine=InnoDB;

CREATE TABLE group_permission (groupgroup_id int(2) NOT NULL, permissionpermission_id int(5) NOT NULL, PRIMARY KEY (groupgroup_id, permissionpermission_id),FOREIGN KEY (groupgroup_id) REFERENCES group (group_id),FOREIGN KEY (permissionpermission_id) REFERENCES permission(permission_id)) engine=InnoDB;

ALTER TABLE `user_group` ADD CONSTRAINT `groupgroup_id` FOREIGN KEY (`groupgroup_id`) REFERENCES `login_form`.`group`(`group_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `user_group` DROP FOREIGN KEY `groupgroup_id`; ALTER TABLE `user_group` ADD CONSTRAINT `groupgroup_id` FOREIGN KEY (`groupgroup_id`) REFERENCES `login_form`.`group`(`group_id`) ON DELETE RESTRICT ON UPDATE CASCADE; ALTER TABLE `user_group` DROP FOREIGN KEY `useruser_id`; ALTER TABLE `user_group` ADD CONSTRAINT `useruser_id` FOREIGN KEY (`useruser_id`) REFERENCES `login_form`.`user`(`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE;



