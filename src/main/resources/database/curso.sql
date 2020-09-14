CREATE DATABASE IF NOT EXISTS curso;

USE curso;

ALTER DATABASE curso
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS estudio (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30),
  INDEX(nombre)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS asignatura  (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30),
  estudio_id INT(4) UNSIGNED NOT NULL,
  INDEX(nombre),
  FOREIGN KEY (estudio_id) REFERENCES estudio(id)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS examen  (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30),
  asignatura_id INT(4) UNSIGNED NOT NULL,
  INDEX(nombre),
  FOREIGN KEY (asignatura_id) REFERENCES asignatura(id)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS pregunta  (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30),
  examen_id INT(4) UNSIGNED NOT NULL,
  dificultad VARCHAR(30),
  tiempo VARCHAR(30),
  INDEX(nombre),
  FOREIGN KEY (examen_id) REFERENCES examen(id)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS item  (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30),
  pregunta_id INT(4) UNSIGNED NOT NULL,
  correcto BOOLEAN,
  INDEX(nombre),
  FOREIGN KEY (pregunta_id) REFERENCES pregunta(id)
) engine=InnoDB;




INSERT IGNORE INTO estudio VALUES (1, 'Ingeniería informática');
INSERT IGNORE INTO estudio VALUES (2, 'Ingeniería industrial');



INSERT IGNORE INTO asignatura VALUES (1, 'Introducción a la Programación', 1);
INSERT IGNORE INTO asignatura VALUES (2, 'Bases de Datos', '1');


INSERT IGNORE INTO asignatura VALUES (3, 'Mecánica', 2);
INSERT IGNORE INTO asignatura VALUES (4, 'Electroctenia', 2);

INSERT IGNORE INTO examen VALUES (1, 'Convocatoria Febero', 1);
INSERT IGNORE INTO examen VALUES (2, 'Convocatoria Septiembre', 1);

INSERT IGNORE INTO examen VALUES (3, 'Convocatoria Febero', 2);
INSERT IGNORE INTO examen VALUES (4, 'Convocatoria Septiembre', 2);

INSERT IGNORE INTO examen VALUES (5, 'Convocatoria Febero', 3);
INSERT IGNORE INTO examen VALUES (6, 'Convocatoria Septiembre', 3);

INSERT IGNORE INTO examen VALUES (7, 'Convocatoria Febero', 4);
INSERT IGNORE INTO examen VALUES (8, 'Convocatoria Septiembre', 5);


INSERT IGNORE INTO pregunta VALUES (1, 'Qué tipo de estructura de control es if-then-else', 1, 'fácil', '5');


INSERT IGNORE INTO item VALUES (1, 'Bucle', 1, false);
INSERT IGNORE INTO item VALUES (2, 'Condicional', 1, true);
INSERT IGNORE INTO item VALUES (3, 'Secuencia', 1, false);



INSERT IGNORE INTO pregunta VALUES (2, 'Ley de la gravedad', 5, 'fácil', '5');


INSERT IGNORE INTO item VALUES (4, 'v=s/t', 1, false);
INSERT IGNORE INTO item VALUES (5, 'F=m*g', 1, true);
INSERT IGNORE INTO item VALUES (6, 'a=v/t', 1, false);


INSERT IGNORE INTO pregunta VALUES (3, 'Ley de Ohm', 7, 'fácil', '5');


INSERT IGNORE INTO item VALUES (7, 'e=m*c^2', 1, false);
INSERT IGNORE INTO item VALUES (8, 'I=R*V', 1, true);
INSERT IGNORE INTO item VALUES (9, 'F=m*a', 1, false);




