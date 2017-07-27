use sakila;
select title, release_year from film where release_year = 2006;
select distinct title, replacement_cost from film;
select max(replacement_cost) from film;
select title, replacement_cost from film where replacement_cost = (select max(replacement_cost) from film);
-- listar de dos maneras las tres primeras películas que tienen más costo de reemplazo
select title, replacement_cost from film where replacement_cost <= (select max(replacement_cost) from film) limit 3;
select title, replacement_cost from film order by replacement_cost desc limit 3;
-- contar la cantidad de películas según el tipo de rating
select rating, count(film_id) as cantidad from film group by rating;

-- todas las películas de 2015
select title from film where year(last_update) = 2015;

-- todas las películas con fecha menor o igual a la de hoy
select title from film where (last_update <= now());

-- todas las peliculas cuya fecha de actualizacion es desde hoy hasta 500 dias atras

select title, last_update from film where (datediff(curdate(), last_update) <= 500);
select title, last_update from film where last_update >= (curdate() - interval 500 day);

delete from film where film_id = 1;

use ejemplo;
delete from persona where idPersona = 1;
select * from persona;

use sakila;
update actor set first_name = 'Ignacio' where actor_id=1;
select first_name from actor where actor_id=1;

-- join, left join, right join