-- CONTINENTE
select * from continente
insert into continente(nombre, abreviatura) values('EUROPA','EU')
-- anadir key unico a un campo
alter table continente add constraint nombre_unico unique(nombre)
SELECT * FROM continente WHERE nombre LIKE '%OCi%' OR abreviatura LIKE '%EU%'
ALTER TABLE continente ALTER COLUMN abreviatura  DROP  NOT NULL
-- cambiar el tipo de dato de abreviatura
alter table continente alter column abreviatura type varchar(3)
--Reiniciar auto incremental
ALTER SEQUENCE continente_continente_id_seq RESTART WITH 1

-- PAIS
select * from pais
INSERT INTO pais(nombre, abreviatura, continente_id) values('TURQUÍA','TUR',1)
-- anadir key unico a un campo
alter table pais add constraint nombre_unico_pais unique(nombre);
alter table continente alter column abreviatura type varchar(3);
-- buscar
SELECT pa.pais_id, pa.nombre, pa.abreviatura, co.continente_id, co.nombre FROM pais pa
INNER JOIN continente co ON pa.continente_id = co.continente_id
WHERE pa.nombre LIKE '%OCi%' 
OR pa.abreviatura LIKE '%EUD%' 
OR co.nombre LIKE '%AMER%'

-- AGENTE
select * from agente
INSERT INTO agente(nombre_completo, direccion, correo, foto) VALUES('RODRIGO GRANJA REQUEJO','AV. AVIACIÓN S/N','RODRIGO_06_27@HOTMAIL.COM','MI FOTO')
delete from agente
ALTER TABLE agente ALTER COLUMN foto TYPE bytea USING foto::bytea
--buscar
SELECT * FROM agente WHERE nombre_completo LIKE '%RODRIGO%'
OR direccion LIKE '%%'
OR correo LIKE '%%'

-- FUTBOLISTA
select * from futbolista
INSERT INTO futbolista(documento_identidad, nombre_completo,nombre_corto,fecha_nacimiento,altura,peso,sexo,pie_dominante,email,foto,pais_id) VALUES()
alter table futbolista alter column estado set default('A')
ALTER TABLE futbolista ALTER COLUMN foto TYPE bytea USING foto::bytea

-- TIPO CONTRATO
select * from tipo_contrato
insert into tipo_contrato(descripcion) values('CUALQUIER COSA')
alter table tipo_contrato add constraint nombre_unico_descripcion unique(descripcion)

-- CUERPO TÉCNICO
alter table cuerpo_tecnico add constraint nombre_unico_cuerpo_tecnico unique(nombre);

-- TIPO PROFESIONAL
alter table tipo_profesional add constraint descripcion_unica_tipo_profesional  unique(descripcion);
alter table tipo_profesional add constraint abreviatura_unica_tipo_profesional  unique(abreviatura);

-- POSICION
alter table posicion add constraint descripcion_unica_posicion  unique(descripcion);
alter table posicion add constraint abreviatura_unica_posicion  unique(abreviatura);

-- EVENTO
alter table evento add constraint nombre_unico_evento unique(nombre);

-- GRUPO
alter table grupo add constraint nombre_unico_grupo unique(nombre);
alter table grupo add constraint abreviatura_unica_grupo unique(abreviatura);

-- Equipo
select * from equipo
alter table equipo alter column ubicacion type character varying (255)
ALTER TABLE equipo ALTER COLUMN foto TYPE bytea USING foto::bytea;
alter table equipo add constraint equipo_unica_nombre_completo  unique(nombre_completo);
insert into equipo(nombre_completo,nombre_corto,fecha_fundacion,apodo,ubicacion,numero_socios,foto) 
values('BARCELONA','BARCA','1978-06-06','NOSE','NOSE',8, (select foto from futbolista where futbolista_id = 4) );

-- CONTRATO
select * from contrato




