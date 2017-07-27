/*
REALIZAR LAS SIGUIENTES CONSULTAS
1.       EMPLEADOS CON LA DIRECCION Y EL PAIS EN DONDE TRABAJAN
2.       EMPLEADOS CON LA DIRECCION Y EL NOMBRE DEL CLIENTE RELACIONADO
3.       EMPLEADOS CON EL NOMBRE DE SU SUPERVISOR
4.       EMPLEADOS CON LA CANTIDAD DE CLIENTES QUE CUENTA CADA UNO
5.       EL EMPLEADO QUE + CLIENTES TIENE
6.       LOS 3 PRODUCTOS + BARATOS
7.       EL MONTO TOTAL DE DINERO PAGADO POR CADA CLIENTE
8.       EL MONTO TOTAL DE DINERO PAGADO POR CADA CLIENTE CON EL NOMBRE DEL EMPLEADO RELACIONADO
9.       ACTUALIZAR EL PRECIO DE TODOS LOS PRODUCTOS EN UN 15%
10.   BORRAR TODAS LOS PAGOS DE LOS CLIENTES QUE SE ENCUENTRAN EN “X” STATE

OPCIONALES
1.       LISTAR TODOS LOS CLIENTES QUE NUNCA REALIZARON UN PAGO
2.       LISTAR EL DETALLE DE UNA ORDEN CON EL PRODUCTO, CANTIDAD, PRECIO UNITARIO Y SUBTOTAL
3.       CREAR 3 CONSULTAS SQL LIBREMENTE UTILIZANDO LAS TABLAS
4.       CREAR UNA SP LIBREMENTE
 */

SHOW DATABASES;
USE classicmodels;
SHOW TABLES FROM classicmodels;

-- 1
SELECT
  concat(employees.firstName, ' ', employees.lastName) AS Nombre,
  offices.addressLine1                                 AS LugarDeTrabajo,
  offices.country                                      AS País
FROM employees
  LEFT JOIN offices ON employees.officeCode = offices.officeCode;

-- 2
SELECT
  concat(employees.firstName, ' ', employees.lastName) AS Empleado,
  customers.customerName                               AS Cliente,
  customers.addressLine1                               AS Dirección
FROM employees
  INNER JOIN customers ON employees.employeeNumber = customers.salesRepEmployeeNumber;

-- 3
SELECT
  Empleados.lastName    AS Empleado,
  Supervisores.lastName AS Supervisor
FROM employees AS Empleados
  INNER JOIN employees AS Supervisores ON Empleados.reportsTo = Supervisores.employeeNumber;

-- 4
SELECT
  employees.lastName              AS Empleado,
  count(customers.customerNumber) AS CantidadClientes
FROM customers
  INNER JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
GROUP BY employees.employeeNumber;

-- 5
SELECT employees.lastName AS Empleado
FROM customers
  INNER JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
GROUP BY employees.employeeNumber
ORDER BY count(customers.customerNumber) DESC
LIMIT 1;

-- 6
SELECT
  productName AS Producto,
  buyPrice    AS Precio
FROM products
ORDER BY buyPrice ASC
LIMIT 3;

-- 7
SELECT
  customers.customerName AS Cliente,
  sum(payments.amount)   AS Total
FROM payments
  INNER JOIN customers ON payments.customerNumber = customers.customerNumber
GROUP BY customers.customerNumber;

-- 8
SELECT
  customers.customerName AS Cliente,
  sum(payments.amount)   AS Total,
  employees.lastName     AS Vendedor
FROM payments
  INNER JOIN customers ON payments.customerNumber = customers.customerNumber
  INNER JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
GROUP BY customers.customerNumber;

-- 9
SELECT buyPrice
FROM products;
UPDATE products
SET buyPrice = buyPrice * 1.15;

-- 10
DELETE FROM payments
USING customers
  INNER JOIN payments ON customers.customerNumber = payments.customerNumber
WHERE customers.state = 'NY';

-- OPCIONALES
-- 1 (sin terminar, no funciona)
SELECT customers.customerName
FROM payments
  INNER JOIN customers ON customers.customerNumber = payments.customerNumber
GROUP BY payments.customerNumber HAVING sum(payments.amount) = 0 ORDER BY customerName;

SELECT customers.customerName
FROM payments
  INNER JOIN customers ON customers.customerNumber = payments.customerNumber
GROUP BY payments.customerNumber HAVING (customers.state = 'NY') ORDER BY customerName;