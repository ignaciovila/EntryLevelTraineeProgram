-- 1 crear tablas según esquema con integridad referencial

CREATE TABLE regions (
  region_id   INT PRIMARY KEY AUTO_INCREMENT,
  region_name VARCHAR(50)
);

CREATE TABLE countries (
  country_id   INT PRIMARY KEY AUTO_INCREMENT,
  country_name VARCHAR(50),
  region_id    INT NOT NULL,
  FOREIGN KEY (region_id) REFERENCES regions (region_id)
);

CREATE TABLE locations (
  location_id    INT PRIMARY KEY AUTO_INCREMENT,
  street_adress  VARCHAR(100),
  postal_code    VARCHAR(25),
  city           VARCHAR(50),
  state_province VARCHAR(50),
  country_id     INT NOT NULL,
  FOREIGN KEY (country_id) REFERENCES countries (country_id)
);

CREATE TABLE departmens (
  department_id   INT PRIMARY KEY AUTO_INCREMENT,
  department_name VARCHAR(50),
  location_id     INT NOT NULL,
  FOREIGN KEY (location_id) REFERENCES locations (location_id)
);

-- 2 insertar datos

INSERT INTO regions (region_name) VALUES ('LATAM'), ('NORTH AMERICA'), ('EUROPE'), ('MIDDLE EAST');
INSERT INTO countries (country_name, region_id)
VALUES ('ARGENTINA', 1), ('USA', 2), ('UNITED KINGDOM', 3), ('INDIA', 4);
INSERT INTO locations (street_adress, postal_code, city, state_province, country_id)
VALUES ('Tucuman 3720', '1189', 'CABA', 'CABA', 1);
INSERT INTO locations (street_adress, postal_code, city, state_province, country_id)
VALUES ('129 E street', '0000', 'Washington', 'D.C.', 2);
INSERT INTO locations (street_adress, postal_code, city, state_province, country_id)
VALUES ('3-5 Charing Cross Road', 'WC2H 0HA', 'London', 'London', 3);
INSERT INTO locations (street_adress, postal_code, city, state_province, country_id)
VALUES ('Siempreviva 123', '1111', 'New Delhi', 'New Delhi', 4);
INSERT INTO departmens (department_name, location_id) VALUES ('HR', 1), ('IT', 4), ('Finances', 2), ('Sales', 3), ('Production', 2);

-- 3 listado de regiones con paises, de regiones con paises y ubicaciones, etc.

SELECT
  departmens.department_name AS Departamento,
  locations.street_adress    AS Dirección,
  locations.city             AS Ciudad,
  countries.country_name     AS País,
  regions.region_name        AS Región
FROM locations
  LEFT JOIN countries ON locations.country_id = countries.country_id
  LEFT JOIN regions ON countries.region_id = regions.region_id
  LEFT JOIN departmens ON locations.location_id = departmens.location_id;

-- 4 contar los departamentos que hay por país

SELECT
  country_name         AS País,
  count(department_id) AS CantidadDepartamentos
FROM countries
  LEFT JOIN locations ON countries.country_id = locations.country_id
  LEFT JOIN departmens ON locations.location_id = departmens.location_id
GROUP BY countries.country_id;

-- 5 hacer una vista con esa consulta

CREATE VIEW CantDepPa AS
  SELECT
    country_name         AS País,
    count(department_id) AS CantidadDepartamentos
  FROM countries
    LEFT JOIN locations ON countries.country_id = locations.country_id
    LEFT JOIN departmens ON locations.location_id = departmens.location_id
  GROUP BY countries.country_id;

SELECT *
FROM CantDepPa;

-- 6 hacer un procedimiento de almacenado que dé de alta una región (averiguar cómo se busca el último ID)

CREATE PROCEDURE nueva_region(IN nombre VARCHAR(50))
  BEGIN
    INSERT INTO regions (region_name) VALUES (nombre);
  END;

CALL nueva_region('CHINA');

SELECT *
FROM regions;

-- 7 ídem con una región y un país

CREATE PROCEDURE nuevo_pais_region (IN nom_pais VARCHAR(50), IN nom_region VARCHAR(50))
  BEGIN
    INSERT INTO regions (region_name) VALUE (nom_region);
    INSERT INTO countries (country_name, region_id) VALUES (nom_pais, LAST_INSERT_ID());
  END;

CALL nuevo_pais_region('Japón', 'Far East');

-- 8 recuperar los tres primeros países que más ubicaciones tiene

SELECT country_name AS País, count(locations.country_id) as SumaLoc FROM locations
RIGHT JOIN countries ON locations.country_id = countries.country_id
GROUP BY locations.country_id ORDER BY SumaLoc DESC LIMIT 3;

SELECT country_name AS País, count(departmens.department_id) as SumaDep from departmens
RIGHT JOIN locations ON departmens.location_id = locations.location_id RIGHT JOIN countries ON locations.country_id = countries.country_id
GROUP BY locations.country_id ORDER BY SumaDep DESC;

-- 9 recuperar todos los departamentos que están en alguna calle que contiene la palabra 'street'

SELECT departmens.department_name as Departamentos
FROM departmens LEFT JOIN locations on departmens.location_id = locations.location_id WHERE street_adress LIKE '%street%';

-- 10 qué es una función, cómo se programa

CREATE FUNCTION funcion()
  RETURNS INT
BEGIN
  RETURN 3720;
END;

-- transactions
-- cursores
-- trigger