use ejemplo;

create table Club (
Club_Id int not null primary key auto_increment,
Nombre varchar(30),
Socios int not null default 0);

insert into club (Nombre, Socios) values ('Boca Juniors', 40000), ('River Plate', 30000), ('Racing Club', 50000), ('San Lorenzo', 20000), ('Independiente', 15000);

select * from club;

create table Jugador (
Jugador_Id int not null primary key auto_increment,
Nombre varchar(50),
Edad int,
Camiseta int,
Puesto varchar(20),
Club_Id int,
foreign key (Club_Id) references Club(Club_Id)
);

insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Juan Román Riquelme', 28, 18, 'Volante', 1), ('Hugo Ibarra', 24, 3, 'Defensor', 1);
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Agustín Orión', 20, 1, 'Arquero', 4), ('Pablo Caballero', 22, 10, 'Delantero', 3);
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Rodrigo Palacio', 24, 16, 'Delantero', 1), ('Juan Pablo Carrizo', 22, 17, 'Arquero', 2);
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Diego Cardoso', 25, 8, 'Volante', 2), ('Mauricio Caranta', 34, 1, 'Arquero', 1);
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Omar Merlo', 24, 13, 'Defensor', 2), ('Mauro Boselli', 23, 8, 'Delantero', 1);
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Diego Placente', 28, 4, 'Defensor', 4), ('Aureliano Torres', 22, 11, 'Volante', 4);
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Ariel Ortega', 31, 10, 'Delantero', 2);

select jugador.Nombre, jugador.Edad, jugador.Camiseta, jugador.Puesto, club.Nombre from jugador join club on club.Club_Id = jugador.Club_Id;

-- 1
select * from jugador;

-- 2
select Nombre, Puesto from jugador;

-- 3
select Nombre from club where Socios > 30000;

-- 4
select Nombre from club where Socios >= 30000;

-- 5
select Nombre, Edad from jugador where Camiseta = 8;

-- 6
select Nombre, Puesto from jugador where Puesto = 'Arquero' or Puesto = 'Defensor' order by Puesto;

-- 7
select * from jugador where Nombre like 'Juan%';

-- 8
select Nombre, Edad, Puesto from jugador order by Edad ASC, Camiseta DESC;

-- 9
insert into club (Nombre, Socios) values ('Rosario Central', 25000);

-- 10
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Ramiro Fassi', 26, 2, 'Defensor', 6);
select * from jugador;

-- 11
insert into jugador (Nombre, Edad, Camiseta, Puesto, Club_Id) values ('Martin Palermo', 28, 9, 'Delantero', 23);
-- Error de clave foránea por no tener un club con ese ID

-- 12
select * from jugador;
update jugador set Camiseta = 10 where Jugador_Id = 1;
select * from jugador where Jugador_Id = 1;

-- 13
update jugador set Camiseta = 12 where Puesto = 'Arquero';
select * from jugador where Puesto = 'Arquero';

-- 14
update jugador set Edad = (Edad + 1);

-- 15
delete from jugador where Puesto = 'Volante';