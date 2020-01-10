insert into rol (nombre) values ('Administrador');
insert into rol (nombre) values ('Conserje');
insert into rol (nombre) values ('Presidente');
insert into rol (nombre) values ('Tesorero');
insert into rol (nombre) values ('Secretrario');

insert into permiso (codigo,nombre,descripcion) values ('P01','Listar usuarios', '');
insert into permiso (codigo,nombre,descripcion) values ('P02','Crear usuario', '');
insert into permiso (codigo,nombre,descripcion) values ('P03','Eliminar usuario', '');
insert into permiso (codigo,nombre,descripcion) values ('P04','Listar Unidades', '');
insert into permiso (codigo,nombre,descripcion) values ('P05','Listar detalle gasto comun', '');
insert into permiso (codigo,nombre,descripcion) values ('P06','Listar gasto comun periodo', '');

insert into relacion_rol_permiso (idrol,idpermiso) values (1,1);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,2);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,3);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,4);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,5);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,6);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,4);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,5);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,6);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,4);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,5);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,6);

insert into usuario (nombre_usuario, contrasena, idrol) values ('juanito', '123', 1);
insert into usuario (nombre_usuario, contrasena, idrol) values ('dio', '123', 2);
insert into usuario (nombre_usuario, contrasena, idrol) values ('pepe', '123', 3);

insert into tipo_unidad (nombre) values ('Departamento');
insert into tipo_unidad (nombre) values ('Estacionamiento');

insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('101',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('102',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('103',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('104',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('201',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('202',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('203',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('204',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('301',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('302',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('303',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('304',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('401',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('402',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('403',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('404',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('501',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('502',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('503',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('504',1,0.2,'Torre A',1);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E11',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E12',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E13',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E14',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E21',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E22',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E23',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E24',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E31',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E32',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E33',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E34',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E41',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E42',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E43',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E44',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E51',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E52',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E53',1,0.2,'Torre A',2);
insert into unidad (numero,piso,prorrateo,sector,idtipounidad) values ('E54',1,0.2,'Torre A',2);

insert into item_gasto_comun (nombre,descripcion) values ('Conserje 1','');
insert into item_gasto_comun (nombre,descripcion) values ('Conserje 2','');
insert into item_gasto_comun (nombre,descripcion) values ('Mantenimiento Porton','');
insert into item_gasto_comun (nombre,descripcion) values ('Luz areas comunes','');
insert into item_gasto_comun (nombre,descripcion) values ('Mantenimiento ascensor','');
