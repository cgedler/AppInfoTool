
/**
 * Author:  cge
 * Created: 14 nov 2024
 */

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username CHAR(50) NOT NULL, 
    pwd CHAR(50)
); 


INSERT INTO users(username, pwd) VALUES('cgedler', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');

INSERT INTO users(username, pwd) VALUES('Maria', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');
INSERT INTO users(username, pwd) VALUES('Pedro', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');
INSERT INTO users(username, pwd) VALUES('Jose', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');
INSERT INTO users(username, pwd) VALUES('Francisco', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');
INSERT INTO users(username, pwd) VALUES('Valentina', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');
INSERT INTO users(username, pwd) VALUES('Juan', '$2a$10$fgdFjZAb.yQcE40axolRqOOfAovzBwonCSJ3OUDaMfILdirBVBj0e');