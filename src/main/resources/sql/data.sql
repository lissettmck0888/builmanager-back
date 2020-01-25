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
insert into tipo_unidad (nombre) values ('Bodega');

insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('101',1,45,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('102',1,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('103',1,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('104',1,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('105',1,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('201',2,45,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('202',2,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('203',2,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('204',2,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('205',2,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('301',3,45,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('302',3,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('303',3,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('304',3,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('305',3,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('401',4,45,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('402',4,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('403',4,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('404',4,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('405',4,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('501',5,45,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('502',5,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('503',5,30,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('504',5,55,'Torre A',1,true,true);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('505',5,55,'Torre A',1,true,true);

insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B01',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B02',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B03',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B04',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B05',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B06',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B07',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B08',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B09',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B10',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B11',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B12',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B13',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B14',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B15',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B16',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B17',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B18',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B19',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B20',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B21',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B22',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B23',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B24',1,12,'Torre A',3,true,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('B25',1,12,'Torre A',3,true,false);

insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E11',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E12',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E13',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E14',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E21',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E22',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E23',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E24',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E31',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E32',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E33',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E34',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E41',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E42',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E43',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E44',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E51',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E52',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E53',1,6,'Torre A',2,false,false);
insert into unidad (numero,piso,metros_cuadrados,sector,idtipounidad,afecto_prorrateo,es_unidad_copropiedad) values ('E54',1,6,'Torre A',2,false,false);

insert into item_gasto_comun (nombre,descripcion,tipo) values ('Conserje 1','','ordinario');
insert into item_gasto_comun (nombre,descripcion,tipo) values ('Conserje 2','','ordinario');
insert into item_gasto_comun (nombre,descripcion,tipo) values ('Mantenimiento Porton','','extraordinario');
insert into item_gasto_comun (nombre,descripcion,tipo) values ('Luz areas comunes','','extraordinario');
insert into item_gasto_comun (nombre,descripcion,tipo) values ('Mantenimiento ascensor','','extraordinario');

insert into persona(apellido_materno,apellido_paterno,correo,direccion,fecha_nacimiento,nacionalidad,nombres,run,telefono)
values('Lora','Torres','lora@gmail.com','estado 34','1980-12-31','Chilena','Angel Alfonso','23767623','232323');
insert into persona(apellido_materno,apellido_paterno,correo,direccion,fecha_nacimiento,nacionalidad,nombres,run,telefono)
values('Jama','Luka','jalu@gmail.com','bandera 324','1970-11-20','Chilena','Eusebio Do Santos','1213394','1982823');
insert into persona (nombres, apellido_paterno, apellido_materno, run, fecha_nacimiento, nacionalidad, telefono, correo)
values ('Lissett', 'Muñoz','Cortez', '23475188-3', '1984-01-08', 'Ecuatoriana', '987456543', 'lissett@gmail.com');
insert into persona (nombres, apellido_paterno, apellido_materno, run, fecha_nacimiento, nacionalidad, telefono, correo)
values ('Victor', 'Morales','Rosales', '15775152-2', '1984-03-29', 'Chilena', '765423658', 'vmorales@gmail.com');

insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion,total_metros_cuadrados_prorrateables) values('habitado','2019-10-10',1,'propietario',35);
insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion,total_metros_cuadrados_prorrateables) values('habitado','2019-04-22',2,'propietario',50);
insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion,total_metros_cuadrados_prorrateables) values('habitado','2019-11-20',3,'propietario',42);
insert into asignacion(estado, fecha_asignacion,idpersona,tipo_asignacion,total_metros_cuadrados_prorrateables) values('habitado','2019-08-01',4,'propietario',50);

insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(1,1, true);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(1,27, false);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(1,53, false);

insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(2,2, true);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(2,28, false);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(2,54, false);

insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(3,3, true);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(3,29, false);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(3,55, false);

insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(4,4, true);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(4,30, false);
insert into asignacion_unidad(id_asignacion,id_unidad, unidad_copropiedad) values(4,56, false);

insert into gasto_comun (periodo, estado) values('2020-01-01', 'Abierto');

insert into plantilla_gastos_ordinarios (iditemgastocomun, monto, activo) values (1, 380000, true);
insert into plantilla_gastos_ordinarios (iditemgastocomun, monto, activo) values (2, 400000, true);