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
insert into permiso (codigo,nombre,descripcion) values ('P07','Modulo Usuarios', '');
insert into permiso (codigo,nombre,descripcion) values ('P08','Modulo Roles', '');
insert into permiso (codigo,nombre,descripcion) values ('P09','Modulo Gastos Comunes', '');
insert into permiso (codigo,nombre,descripcion) values ('P10','Modulo Zonas Comunes', '');
insert into permiso (codigo,nombre,descripcion) values ('P11','Modulo Mantenciones', '');
insert into permiso (codigo,nombre,descripcion) values ('P12','Modulo Gestion comunitaria', '');

insert into relacion_rol_permiso (idrol,idpermiso) values (1,1);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,2);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,3);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,4);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,5);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,6);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,7);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,8);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,9);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,10);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,11);
insert into relacion_rol_permiso (idrol,idpermiso) values (1,12);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,4);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,5);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,6);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,9);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,10);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,11);
insert into relacion_rol_permiso (idrol,idpermiso) values (2,12);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,4);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,5);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,6);
insert into relacion_rol_permiso (idrol,idpermiso) values (3,12);

insert into usuario (nombre_usuario, contrasena, idrol) values ('admin', '$2a$10$XQ2RizMhFwhYutihQ0q98OOS/h6TTjqmrrsc49QN4.3g4TIGSXGsS', 1);
insert into usuario (nombre_usuario, contrasena, idrol) values ('conser', '$2a$10$XQ2RizMhFwhYutihQ0q98OOS/h6TTjqmrrsc49QN4.3g4TIGSXGsS', 2);
insert into usuario (nombre_usuario, contrasena, idrol) values ('presi', '$2a$10$XQ2RizMhFwhYutihQ0q98OOS/h6TTjqmrrsc49QN4.3g4TIGSXGsS', 3);

insert into tipo_unidad (nombre) values ('Departamento');
insert into tipo_unidad (nombre) values ('Estacionamiento');

insert into unidad (numero,piso,rating,sector,idtipounidad) values ('101',1,1,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('102',1,1.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('103',1,2,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('104',1,2.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('201',1,1,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('202',1,1.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('203',1,2,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('204',1,2.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('301',1,1,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('302',1,1.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('303',1,2,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('304',1,2.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('401',1,1,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('402',1,1.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('403',1,2,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('404',1,2.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('501',1,1,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('502',1,1.5,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('503',1,2,'Torre A',1);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('504',1,2.5,'Torre A',1);

insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E11',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E12',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E13',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E14',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E21',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E22',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E23',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E24',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E31',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E32',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E33',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E34',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E41',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E42',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E43',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E44',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E51',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E52',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E53',1,0.0,'Torre A',2);
insert into unidad (numero,piso,rating,sector,idtipounidad) values ('E54',1,0.0,'Torre A',2);

insert into item_gasto_comun (nombre,descripcion) values ('Conserje 1','');
insert into item_gasto_comun (nombre,descripcion) values ('Conserje 2','');
insert into item_gasto_comun (nombre,descripcion) values ('Mantenimiento Porton','');
insert into item_gasto_comun (nombre,descripcion) values ('Luz areas comunes','');
insert into item_gasto_comun (nombre,descripcion) values ('Mantenimiento ascensor','');
insert into persona(apellido_materno,apellido_paterno,correo,direccion,fecha_nacimiento,nacionalidad,nombres,run,telefono)
values('Lora','Torres','lora@gmail.com','estado 34','1980-12-31','Chilena','Angel Alfonso','23767623','232323');
insert into persona(apellido_materno,apellido_paterno,correo,direccion,fecha_nacimiento,nacionalidad,nombres,run,telefono)
values('Jama','Luka','jalu@gmail.com','bandera 324','1970-11-20','Chilena','Eusebio Do Santos','1213394','1982823');
insert into persona (nombres, apellido_paterno, apellido_materno, run, fecha_nacimiento, nacionalidad, telefono, correo)
values ('Lissett', 'Muñoz','Cortez', '23475188-3', '1984-01-08', 'Ecuatoriana', '987456543', 'lissett@gmail.com');
insert into persona (nombres, apellido_paterno, apellido_materno, run, fecha_nacimiento, nacionalidad, telefono, correo)
values ('Victor', 'Morales','Rosales', '15775152-2', '1984-03-29', 'Chilena', '765423658', 'vmorales@gmail.com');

insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion) values('ocupado','2019-10-10',1,'arriendo');
insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion) values('ocupado','2019-04-22',2,'propietario');
insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion) values('vacio','2019-11-20',1,'arriendo');
insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion) values('vacio','2019-08-01',2,'propietario');

insert into relacion_asignacion_unidad values(1,1);
insert into relacion_asignacion_unidad values(2,2);
insert into relacion_asignacion_unidad values(3,3);
insert into relacion_asignacion_unidad values(4,4);

insert into gasto_comun (periodo, estado) values('2020-01-01', 'Abierto');

insert into plantilla_gastos_ordinarios (iditemgastocomun, monto, activo) values (1, 380000, true);
insert into plantilla_gastos_ordinarios (iditemgastocomun, monto, activo) values (2, 400000, true);