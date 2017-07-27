create table Articulos
(codigo int,
nombre varchar(50),
costo double not null,
constraint PK_codigo primary key(codigo)
);

insert into articulos (codigo, nombre, costo) values (1, 'detergente', 15);

select * from articulos;

alter table articulos add descripcion varchar(255);

update articulos set descripcion = 'concentrado' where codigo=1;

alter table articulos modify nombre varchar(50) not null default 'sin definir';

insert into articulos (codigo, nombre, costo) values (2, 'shampoo', 45);

insert into articulos (codigo, costo) values (3, 70);

insert into articulos (codigo) values (4);