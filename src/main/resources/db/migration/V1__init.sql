CREATE TABLE students (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name NVARCHAR(100) NOT NULL,
  age INT NOT NULL,
  PRIMARY KEY (id));

INSERT INTO students (name, age) VALUES
('Коля', 20),
('Петя', 22),
('Света', 21);