use world;

-- 1
select distinct CountryCode from city;

-- 2
select Name from city where CountryCode = 'ARG';

-- 3
select Name from city where CountryCode = 'ARG' order by Name DESC;

-- 4
select Name, CountryCode from city where CountryCode in ('ARG', 'USA', 'RUS') order by Name ASC;

-- 5
select Name, Population from city where Population between 3000000 and 4000000;

-- 6
select Name, Population from city where Population > 2000000;

-- 7
select count(ID) from city;

-- 8
select count(ID) from city where CountryCode = 'USA';

-- 9
select sum(Population) from country where Code = 'USA';

-- 10
select CountryCode, sum(Population) from city group by CountryCode;

-- 11
select avg(Population) from city where CountryCode = 'RUS';