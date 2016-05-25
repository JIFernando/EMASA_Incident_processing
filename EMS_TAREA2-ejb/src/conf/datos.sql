INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (1,'C','Snow','Jon','snow',1)
INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (22334455,'O','Stark','Bran','stark',2)
INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (3,'O','Stark','Sansa','stark',2)
INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (12345678,'S','Austen','Katherine Anne','plane',0)
INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (8,'C','James','Rayna','country',1)
INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (9,'O','Barnes','Juliette','country',2)
INSERT INTO APP.EMPLEADO (ID_EMPL, DTYPE, APELLIDO1, NOMBRE, PASSWORD, ROL) VALUES (23456789,'S','Simmons','Jemma','fitz',0)

INSERT INTO APP.SUPERVISOR (S_EMPLEADOID) VALUES (12345678)
INSERT INTO APP.SUPERVISOR (S_EMPLEADOID) VALUES (23456789)

INSERT INTO APP.CONTRATA (ID_CONTRATA, NIF, NOMBRE, SEDE) VALUES (1, '02345678', 'Los Otros', 'Dharma')
INSERT INTO APP.CONTRATA (ID_CONTRATA, NIF, NOMBRE, SEDE) VALUES (2, '12345678', 'Emasa', 'Malaga')
INSERT INTO APP.CONTRATA (ID_CONTRATA, NIF, NOMBRE, SEDE) VALUES (3, '22345678', 'North remembers S.L.', 'Invernalia')

INSERT INTO APP.CAPATAZ (C_EMPLEADOID) VALUES (1)
INSERT INTO APP.CAPATAZ (C_EMPLEADOID) VALUES (8)
INSERT INTO APP.CAPATAZ (C_EMPLEADOID) VALUES (1)

INSERT INTO APP.BRIGADA (ID_BRIGADA, CAPATAZ_ID_EMPL, CONTRATA_BRIGADA_ID_CONTRATA) VALUES (1,1,3)
INSERT INTO APP.BRIGADA (ID_BRIGADA, CAPATAZ_ID_EMPL, CONTRATA_BRIGADA_ID_CONTRATA) VALUES (2,8,1)
INSERT INTO APP.BRIGADA (ID_BRIGADA, CAPATAZ_ID_EMPL, CONTRATA_BRIGADA_ID_CONTRATA) VALUES (3,12,1)

INSERT INTO APP.OPERARIO (O_EMPLEADOID, BRIGADA_OPERARIO_ID_BRIGADA) VALUES (2,3)
INSERT INTO APP.OPERARIO (O_EMPLEADOID, BRIGADA_OPERARIO_ID_BRIGADA) VALUES (3,3)
INSERT INTO APP.OPERARIO (O_EMPLEADOID, BRIGADA_OPERARIO_ID_BRIGADA) VALUES (9,1)
INSERT INTO APP.OPERARIO (O_EMPLEADOID, BRIGADA_OPERARIO_ID_BRIGADA) VALUES (11,2)

INSERT INTO APP.DIAGNOSTICO (ID_DIAG, NOMBRE) VALUES (1, 'Arqueta rota')
INSERT INTO APP.DIAGNOSTICO (ID_DIAG, NOMBRE) VALUES (2, 'Tuberia rota')
INSERT INTO APP.DIAGNOSTICO (ID_DIAG, NOMBRE) VALUES (3, 'Fuga de agua')
INSERT INTO APP.DIAGNOSTICO (ID_DIAG, NOMBRE) VALUES (4, 'Desborde de presa')
INSERT INTO APP.DIAGNOSTICO (ID_DIAG, NOMBRE) VALUES (5, 'Canaleta rota')

INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (25, 0, 'Las tuber�as se encuentran en mal estado por �xido. Reemplazar las arquetas.', 1, 1, 12345678, '2016-04-02', null, 'Ciudad Jardín')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (26, 1, 'Comprar arqueta de 8mm. Volver el d�a 25 para revisi�n.', 2, 1, 12345678, '2016-05-21', null, 'El Palo')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (27, 0, 'Las tuber�as se encuentran en mal estado por �xido. Reemplazar urgentemente. Riesgo de fuga', 1, 1, 12345678, '2016-05-30', null, 'Málaga Centro')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (28, 2, 'Revisar per�odicamente.', 0, 2, 23456789, '2016-06-02', '2016-06-11', null, 'Málaga Centro')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (29, 0, 'Las tuber�as se encuentran en mal estado por �xido. Reemplazar las arquetas.', 1, 2, 23456789, '2016-02-02', null, 'El Puerto')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (30, 0, 'Revisar per�odicamente.', 1, 1, 12345678, '2016-04-02', null, 'Málaga Centro')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION) VALUES (31, 2, 'Las tuber�as se encuentran en mal estado por �xido. Reemplazar las arquetas.', 1, 2, 23456789, '2016-01-03', '2016-01-09', 'Ciudad Jardín')
INSERT INTO APP.AVISO (ID_AVISO, ESTADO, OBSERVACIONES, PRIORIDAD, BRIGADA_ID_BRIGADA, SUPERVISOR_ID_EMPL, FECHA_CREACION, FIN_AVERIA, UBICACION, COORDENADA) VALUES (32, 2, 'Las tuber�as se encuentran en mal estado por �xido. Reemplazar las arquetas.', 1, 2, 23456789, '2016-01-03', '2016-01-09', 'Ciudad Jardín', '36.7173705,-4.4707854')

INSERT INTO APP.AVISO_REFLEXIVO (AVISO_REF_FK, AVISO_REF_2_FK) VALUES (25,31)

INSERT INTO APP.ORDENTRABAJO (ID_OT, ESTADO, FECHA_CREAC, MOTIVO, PRIORIDAD, UBICACION, AVISO_ID_AVISO, BRIGADA_OT_ID_BRIGADA) VALUES (50, 1, '2016-04-03', 'Ejecución acometidas', 1, 'Ciudad Jardín', 25, 1)
INSERT INTO APP.ORDENTRABAJO (ID_OT, ESTADO, FECHA_CREAC, MOTIVO, PRIORIDAD, UBICACION, AVISO_ID_AVISO, BRIGADA_OT_ID_BRIGADA) VALUES (51, 1, '2016-04-03', 'Revisión', 1, 'Ciudad Jardín', 25, 1)