create database estacionamento;
use estacionamento; 
create table carro (
	placa char(7) not null primary key,
	cor varchar(20), 
	descricao varchar(100) 
);

CREATE USER 'app_estacionamento'@'localhost'
IDENTIFIED BY 'Estacionamento2026!';

GRANT SELECT, INSERT, UPDATE, DELETE
ON estacionamento.carro
TO 'app_estacionamento'@'localhost';

SELECT user, host
FROM mysql.user
WHERE user = 'app_estacionamento';

ALTER USER 'app_estacionamento'@'localhost'
IDENTIFIED BY 'Estacionamento2026!';

GRANT SELECT, INSERT, UPDATE, DELETE
ON estacionamento.carro
TO 'app_estacionamento'@'localhost';