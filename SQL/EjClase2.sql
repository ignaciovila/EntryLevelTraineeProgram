/*
NORMALIZACIÓN
desmenuzar, separar para evitar redundancias y mantener la integridad relacional
(evita que se ingresen datos incorrectos o que se borren datos relacionados)

PLAN DE EJECUCIÓN
output de los procesos de la base de datos para debuggear
*/
use world;

-- todas las ciudades con sus países

select city.Name as Ciudad, country.Name as País from city, country where city.CountryCode = country.Code order by country.Name, city.Name;

-- todas las ciudades con sus países y sus lenguajes

select city.Name as Ciudad, country.Name as País, countrylanguage.Language as Idioma from city, country, countrylanguage where city.CountryCode = country.Code AND city.CountryCode = countrylanguage.CountryCode AND countrylanguage.IsOfficial = true order by country.Name, city.Name;

-- ver campos de una tabla
desc country;

select city.Name as Ciudad, country.Name as País from city inner join country on city.CountryCode = country.Code order by country.Name, city.Name;

select city.Name as Ciudad, country.Name as País, countrylanguage.Language as Idioma from city inner join country on city.CountryCode = country.Code inner join countrylanguage on city.CountryCode = countrylanguage.CountryCode where countrylanguage.IsOfficial = true order by country.Name, city.Name;

delete from countrylanguage where countrycode = 'ARG';

select country.Name as País from country inner join countrylanguage on country.Code = countrylanguage.CountryCode where country.Code = 'ARG';

select country.Name as País from country inner join countrylanguage on country.Code = countrylanguage.CountryCode group by country.Name order by country.Name;

select country.Name as País, ifnull(countrylanguage.Language, 'Sin datos') as Idioma from country left join countrylanguage on country.Code = countrylanguage.CountryCode where country.Code = 'ARG';

-- todos los paises con todas las ciudades y todos los idiomas
select city.Name as Ciudad, country.Name as País, countrylanguage.Language as Idioma from city left join country on city.CountryCode = country.Code left join countrylanguage on city.CountryCode = countrylanguage.CountryCode;

-- listar todos los paises con todas las ciudades que no tienen idioma
select city.Name as Ciudad, country.Name as País from city left join country on city.CountryCode = country.Code left join countrylanguage on city.CountryCode = countrylanguage.CountryCode where countrylanguage.Language is null;

-- contar la cantidad de idiomas que se hablan en cada país incluyendo los que no hablan ninguno
select country.Name as País, count(countrylanguage.Language) as CantidadIdiomas from country left join countrylanguage on countrylanguage.CountryCode = country.Code group by country.Name;

-- ídem pero solo los paises que hablan más de tres idiomas
select country.Name as País, count(countrylanguage.Language) as CantidadIdiomas from country left join countrylanguage on countrylanguage.CountryCode = country.Code group by country.Name having CantidadIdiomas > 3;

-- ídem pero agregando código, continente y población. NOMBRE, CODIGO, CONTINENTE, CANTIDAD DE IDIOMAS, POBLACION
select country.Name, country.Code, country.Continent, Idiomas.CantidadIdiomas, country.Population
from(
select country.Code as codigo, count(countrylanguage.Language) as CantidadIdiomas from country left join countrylanguage on countrylanguage.CountryCode = country.Code group by country.Name
) as Idiomas inner join country on Idiomas.codigo = country.Code;

use sakila;

-- listar todos los actores con sus peliculas
select actor.first_name as Nombre, actor.last_name as Apellido, film.title as Título from film_actor inner join film on film.film_id = film_actor.film_id inner join actor on actor.actor_id = film_actor.actor_id;

select concat(actor.first_name, ' ', actor.last_name) as Nombre, film.title as Título from film_actor inner join film on film.film_id = film_actor.film_id inner join actor on actor.actor_id = film_actor.actor_id;

-- agregar idioma
select actor.first_name as Nombre, actor.last_name as Apellido, film.title as Título, language.name as Idioma from film inner join film_actor on film.film_id = film_actor.film_id inner join actor on film_actor.actor_id = actor.actor_id inner join language on film.language_id = language.language_id;

-- agregar idioma original
select actor.first_name as Nombre, actor.last_name as Apellido, film.title as Título, language.name as Idioma, IdiomaOriginal.name as IdiomaOriginal from film inner join film_actor on film.film_id = film_actor.film_id inner join actor on film_actor.actor_id = actor.actor_id left join language on film.language_id = language.language_id left join language as IdiomaOriginal on IdiomaOriginal.language_id = film.original_language_id;

-- nombre y apellido y cantidad de peliculas de cada actor
select tabla.Nombre, tabla.Apellido, tabla.cantidadP
from (
select actor.first_name as Nombre, actor.last_name as Apellido, count(film.film_id) as cantidadP from film_actor
inner join film on film.film_id = film_actor.film_id
inner join actor on actor.actor_id = film_actor.actor_id
group by Apellido, Nombre) as tabla;

-- VISTAS
use world;

create view HabitantesArgentina as select name, CountryCode from city where CountryCode = 'ARG';

select * from HabitantesArgentina;

drop view habitantesargentina;

-- STORED PROCEDURES

call sp_buscar_por_id(5);

-- dar de alta un idioma que reciba por parametro los datos

use sakila;

call sp_insertar_idioma('Spanish (Argentina)');

select name from language;