	create database Dentsoft;
	show Databases;
use dentsoft;

create table dentista(
idDentista INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
password VARCHAR(15),
user VARCHAR(15), 
nombres VARCHAR(50),
apellidos VARCHAR(50), 
cedula VARCHAR(50),
telefono VARCHAR(12),
correoDentista varchar(60),
especialidad VARCHAR(30));

describe dentista;


create table paciente(
idPaciente INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
dentistaAsignado INT NOT NULL, 
nombres VARCHAR(50),
apellidos VARCHAR(50), 
edad INT,
sexo VARCHAR(12),
domicilio VARCHAR(120),
CURP VARCHAR(18),
telefono VARCHAR(12),
email VARCHAR(60),
mostrar BOOLEAN,
cantidadPagada FLOAT,
FOREIGN KEY (dentistaAsignado) REFERENCES dentista (idDentista)
);

describe paciente;

create table tratamientos(
idTratamiento INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
idPaciente INT NOT NULL,
duracion INT,
descripcion VARCHAR(100),
tratamientoActual BOOLEAN,
fechaInicio DATE,
finalizado BOOLEAN,
FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente)
);

describe tratamientos;

create table costos(
idOperacion INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
cantidad FLOAT,
descripcion VARCHAR(100),
idPaciente INT NOT NULL,
FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente)
);

describe costos;

create table odontograma(
idOdontograma INT NOT NULL PRIMARY KEY, 
diente1 INT,
diente2 INT,
diente3 INT,
diente4 INT,
diente5 INT,
diente6 INT,
diente7 INT,
diente8 INT,
diente9 INT,
diente10 INT,
diente11 INT,
diente12 INT,
diente13 INT,
diente14 INT,
diente15 INT,
diente16 INT,
diente17 INT,
diente18 INT,
diente19 INT,
diente20 INT,
diente21 INT,
diente22 INT,
diente23 INT,
diente24 INT,
diente25 INT,
diente26 INT,
diente27 INT,
diente28 INT,
diente29 INT,
diente30 INT,
diente31 INT,
diente32 INT,
FOREIGN KEY (idOdontograma) REFERENCES paciente (idPaciente)
);

describe odontograma;

create table imagenes(
idImagen INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
fechaImagen DATE,
idPaciente INT,
tipoImagen VARCHAR(15),
FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente)
);

describe imagenes;

create table citas (
idCita INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
idDentista INT,
idPaciente INT,
fecha DATE,
hora INT,
media BOOLEAN,
actual BOOLEAN,
Descripción VARCHAR(150),
FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente),
FOREIGN KEY (idDentista) REFERENCES dentista (idDentista)
);

describe citas;




insert into dentista VALUES (1,'password','re2ds','Mario Tomás','Islas Castro',1234567,5519056188,'mario.tomas.1996@gmail.com','Odontologo');
insert into dentista value(2, 'anto85', 'AntoRico', 'Antonio', 'Rico López', '2237695', '55250178', 'anto_rico85@outlook.com', 'Ortodoncista');
insert into dentista values(3, 'Mesa55', 'MesaJes55', 'Jesus', 'Mesa Rodrigo', '2539615', '5559515253', 'Mesa_Jes55@gmail.com', 'Maxillofacial');
insert into dentista value(4,'12345','Martha','Martha','cordero','1234567','55443322','mcorderol@ipn.mx','ortodoncista');

insert into paciente value(1, 1, 'Pamela', 'Sánchez Rodríguez', 23, 'M', 'Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616461','pame293@hotmail.com',1, 0);
insert into paciente value(2, 1, 'Daniela Alejandra', 'Berlanga Castro', 20 , 'M', 'Calle Aguete No. 547, Azcapotzalco, CDMX','BEBD950827CSSHMR01','5516754215','Daniela45@hotmail.com',1, 0);
insert into paciente value(3, 1, 'Nadia Hortencia', 'Torres Victoria', 54, 'M', 'Tacuba 19, Tacuba, Miguel Hidalgo, CDMX','TOVN960223MDFRCI01','55457890','nadis.torres8@gmail.com',1, 0);
insert into paciente value(4, 1, 'Paola Jazmín', 'Sánchez Rodríguez', 37, 'M', 'Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616462','pao.jaz9312@hotmail.com',1, 0);
insert into paciente value(5, 1, 'Atanasio', 'Ceballos Reséndez', 32, 'H', 'Bulevar Galdran, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','53771074','hwnogaledo22@gmail.com',1, 0);
insert into paciente value(6, 1, 'Paloma Daniela', 'Islas Rodriguez', 15, 'M', 'Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616461','pal_Dan@hotmail.com',1, 0);
insert into paciente value(7, 1, 'Marisela', 'Domínguez Herrera', 31, 'M', 'Saturno, No. 487, Gustavo A. Madero, CDMX','DOHM791212MDFMRI08','55887943','marisela213@hotmail.com',1, 0);
insert into paciente value(8, 1, 'Efrain', 'Gamez Islas', 21, 'H', 'Calle Reliquia No. 236, Iztacalco, CDMX','HUGA961105MDFERI04','59666507','efra0@gmail.com',1, 0);
insert into paciente value(9, 1, 'Daniel', 'Aguilar Aguas', 22, 'H', 'Calle Santo,Numero 26, Miguel Hidalgo, CDMX','MAFJ961217HDFRUE06','51558730','DanielAguila213@gmail.com',1, 0);
insert into paciente value(10, 1, 'Rocio', 'Montalva Carbajal', 31, 'M', 'Bulevar Chacartegui No. 661, Azcapotzalco, CDMX','RORH870412MDFSSA08','55003995','ffdiegogustavo5@gmail.com',1, 0);
insert into paciente value(11, 1, 'Sandra', 'Cordero Olmos', 25, 'M', 'Real del Amazonas No. 191, Chimahualcan, CDMX','SOME780516HDFLRC07','57778869','cktu123mbaco10@gmail.com',1, 0);
insert into paciente value(12, 1, 'Nadia Daniela', 'Sanches Medina', 38, 'M', 'Calle Santo, Coyoacan, CDMX','PORS960802HDFZTG05','57665767','cuper1ez20@gmail.com',1, 0);
insert into paciente value(13, 1, 'Guadalupe', 'Covarrubias Linares', 19, 'M', 'Calle Ceperuelo, Tlalpan, CDMX','PABJ960827HDFRRG02','54336300','drbal1le17@gmail.com',1, 0);
insert into paciente value(14, 1, 'Cesar', 'Perez Herrera', 46, 'H', 'Calle Santo del Andorra, Azcapotzalco, CDMX','NIGE690305HDFEAI09','56000858','jkac1hahboun10@gmail.com',1, 0);
insert into paciente value(15, 1, 'Roberto', 'Chacón Mateo', 23, 'M', 'Mitre No. 680, Cuahutemoc, CDMX','ISCM960719HDFLSI03','55110444','jiludov1co8@gmail.com',1, 0);
insert into paciente value(16, 1, 'Netanel', 'Sanches Medina', 38, 'H', 'Calle Santo, Coyoacan, CDMX','PORS960802HDFZTG05','57665767','cuperez20@gmail.com',1, 0);
insert into paciente value(17, 1, 'Andres', 'Ceballero Reséndiz', 38, 'H', 'Bulevar Galdran, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','53771074','hwnogaledo22@gmail.com',1, 0);
insert into paciente value(18, 1, 'Esperanza', 'Diaz Linares', 19, 'H', 'Calle Ceperuelo, Tlalpan, CDMX','DILE960827HDFRRG02','54336300','drballe17@gmail.com',1, 0);
insert into paciente value(19, 1, 'Néstor Eduardo', 'Paredes Carrera', 46, 'H', 'Calle Santo del Andorra, Azcapotzalco, CDMX','NIGE690305HDFEAI09','56000858','jkachahboun10@gmail.com',1, 0);
insert into paciente value(20, 1, 'Leonel', 'Sánchez Antonio', 20, 'H', 'Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARL960108HDFNDN05','55616461','leoipn_1996@hotmail.com',1, 0);

insert into paciente value(21, 2, 'Itzia', 'Ramos Vázquez', 20, 'M', 'Calzada Azcapotzalco 13, Azcapotzalco, CDMX','RAVI960527MDFMZI04','55632188','itziaramos_96@hotmail.com',1, 0);
insert into paciente value(22, 2, 'Hanna Zuriebal', 'Rosas Rosas', 31, 'M', 'Ticoman 27, Gustavo A. Madero, CDMX','RORH870412MDFSSA08','55981123','hannar.87@gmail.com',1, 0);
insert into paciente value(23, 2, 'Eric', 'Solís Miranda', 25, 'H', 'El Rosario 56, Azcapotzalco Norte, CDMX','SOME780516HDFLRC07','55438721','eric_solis45@yahoo.com.mx',1, 0);
insert into paciente value(24, 2, 'Nicholas Raphael', 'Jiménez Farías', 28, 'H', 'El Cerro 80, Gustavo A. Madero, CDMX','FAJN820224HDFRMO09','55782314','nicorafa67@hotmail.com',1, 0);
insert into paciente value(25, 2, 'Marcela', 'Castro Flores', 22, 'M', 'Tezozomoc 13, Azcapotzalco, CDMX','CAFM900430MDFSOC05','55112590','march_castro1@gmail.com',1, 0);
insert into paciente value(26, 2, 'Luis Alfonso', 'Rivera Pérez', 35, 'H', 'Farolito 34, Chimahualcan, EDOMEX','RIPL960617HDFVRS01','55348900','poncho_rivera@hotmail.com',1, 0);
insert into paciente value(27, 2, 'José Antonio', 'Martínez Faustinos', 40, 'H', 'San Cosme 67, Miguel Hidalgo, CDMX','MAFJ961217HDFRUE06','55953320','faus-joseph15@yahoo.com.mx',1, 0);
insert into paciente value(28, 2, 'Adriana Marisol', 'Huerta Garrido', 32, 'M', 'Oceania 12, Iztacalco, CDMX','HUGA961105MDFERI04','55693415','mary_williams19@hotmail.com',1, 0);
insert into paciente value(29, 2, 'Sagrario', 'Hernández Mata', 23, 'M', 'La Piramide 77, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','55871236','sagrario-hernan96@yahoo.com.mx',1, 0);
insert into paciente value(30, 2, 'Nadia Hortencia', 'Torres Victoria', 47, 'M', 'Tacuba 19, Tacuba, Miguel Hidalgo, CDMX','TOVN960223MDFRCI01','55457890','nadis.torres8@gmail.com',1, 0);
insert into paciente value(31, 2, 'Uziel', 'Velasco Parada', 50, 'H', 'Aquiles Serdan 99, Azcapotzalco. CDMX','VEPU730620HDFLRE04','55002947','uzi_vela9@hotmail.com',1, 0);
insert into paciente value(32, 2, 'Roberto', 'Macuil Hérnandez', 67, 'H', 'Aquiles Serdan 99, Azcapotzalco, CDMX','MAHR901012HDFCRE03','55341189','robert_macuin89@hotmail.com',1, 0);
insert into paciente value(33, 2, 'Isis', 'Hérnandez Garibay', 37, 'M', 'Parque Via 51, Azcapotzalco, CDMX','HEGI760106MDFRRS05','55239998','isis_god78@yahoo.com.mx',1, 0);
insert into paciente value(34, 2, 'Brenda', 'Martínez Sánchez', 24, 'M', 'Edificios Sur 34-F, Iztapalapa, CDMX','MASB910929MDFRNN07','55091267','brenda.mtz3@gmail.com',1, 0);
insert into paciente value(35, 2, 'María Alejandra', 'Domínguez Hernández', 35, 'M', 'Zacatenco 9, Gustavo A. Madero, CDMX','DOHM791212MDFMRI08','55887943','madh-45@hotmail.com',1, 0);
insert into paciente value(36, 2, 'Enrique', 'Nieto Granados', 46, 'H', 'Vallejo 69, Azcapotzalco, CDMX','NIGE690305HDFEAI09','55673445','quique_69@gmail.com',1, 0);
insert into paciente value(37, 2, 'Mario Tomás', 'Islas Castro', 20, 'H', 'La Raza 37, Cuahutemoc, CDMX','ISCM960719HDFLSI03','55565758','mtic.90@yahoo.com.mx',1, 0);
insert into paciente value(38, 2, 'Sergio', 'Pózos Retana', 20, 'H', 'Perisur 88, Coyoacan, CDMX','PORS960802HDFZTG05','55010203','spr_ipn23@gmail.com',1, 0);
insert into paciente value(39, 2, 'Jorge', 'Paredes Bermúdez', 20, 'H', 'Coapa 50, Tlalpan, CDMX','PABJ960827HDFRRG02','55451290','jpbermudez-99@hotmail.com',1, 0);
insert into paciente value(40, 2, 'Paola Jazmín', 'Sánchez Rodríguez', 23, 'M', 'Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616461','pao.jaz93@hotmail.com',1, 0);

insert into paciente value(41, 3, 'Giancarla', 'Velázquez Reséndez', 20, 'M', 'Orensanz No. 20, Iztapalapa, CDMX','SARL960108HDFNDN05','55668453','fkmarti10@gmail.com',1, 0);
insert into paciente value(42, 3, 'Panambi', 'Frías Jimínez', 41, 'M', 'Calle Ramisa No. 840, Gustavo A. Madero, CDMX','RAVI960527MDFMZI04','55116985','hmbirch12@gmail.com ',1, 0);
insert into paciente value(43, 3, 'Roxana', 'Montano Carbajal', 31, 'M', 'Bulevar Chacartegui No. 661, Azcapotzalco, CDMX','RORH870412MDFSSA08','55003995','ffdiegogustavo5@gmail.com',1, 0);
insert into paciente value(44, 3, 'Silvano', 'Cordero Olmos', 25, 'H', 'Real del Amazonas No. 191, Chimahualcan, CDMX','SOME780516HDFLRC07','57778869','cktumbaco10@gmail.com',1, 0);
insert into paciente value(45, 3, 'Jackson', 'Botello Caldera', 47, 'H', 'Boulevard Vilarrubias No. 549, Gustavo A. Madero, CDMX','FAJN820224HDFRMO09','58888068','bmdomingot12@gmail.com ',1, 0);
insert into paciente value(46, 3, 'Khalil', 'Díaz Solano', 50, 'M', 'Boulevard Vilarrubias No. 549, Miguel Hidalgo, CDMX','CAFM900430MDFSOC05','58888024','bmdomingot12@gmail.com ',1, 0);
insert into paciente value(47, 3, 'Delfina', 'Ybarra Vera', 35, 'M', 'Boulevard Brunete No. 292, Chimahualcan, EDOMEX','RIPL960617HDFVRS01','54333478','xpericacho23@gmail.com',1, 0);
insert into paciente value(48, 3, 'Dulas', 'Aguilera Aguayo', 24, 'M', 'Calle Santo, Miguel Hidalgo, CDMX','MAFJ961217HDFRUE06','51558730','edcinza3@gmail.com',1, 0);
insert into paciente value(49, 3, 'Eira', 'Gamez Zúñiga', 22, 'M', 'Calle Rabat No. 236, Iztacalco, CDMX','HUGA961105MDFERI04','59666507','eafamadas0@gmail.com',1, 0);
insert into paciente value(50, 3, 'Atanasio', 'Ceballos Reséndez', 38, 'H', 'Bulevar Galdran, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','53771074','hwnogaledo22@gmail.com',1, 0);
insert into paciente value(51, 3, 'Yuqui', 'Aguilera Aguayo', 43, 'M', 'Bull No. 966, Tacuba, Miguel Hidalgo, CDMX','TOVN960223MDFRCI01','50999138','gganghelescu6@gmail.com ',1, 0);
insert into paciente value(52, 3, 'Gema', 'Benítez Leal', 50, 'M', 'Aquiles Serdan 99, Azcapotzalco. CDMX','VEPU730620HDFLRE04','51552319','hksiro10@gmail.com',1, 0);
insert into paciente value(53, 3, 'Reuquén', 'Sedillo Aguilera', 25, 'H', 'Calle Aguete No. 547, Azcapotzalco, CDMX','MAHR901012HDFCRE03','56115981','cnriart13@gmail.com ',1, 0);
insert into paciente value(54, 3, 'Imperio', 'Saavedra Salazar', 50, 'H', 'Privada Nonay, Azcapotzalco, CDMX','HEGI760106MDFRRS05','56990089','inangrill13@gmail.com',1, 0);
insert into paciente value(55, 3, 'Kim', 'Amaya Chávez', 55, 'M', 'Privada Campañon, Iztapalapa, CDMX','MASB910929MDFRNN07','56338915','emcutrin12@gmail.com',1, 0);
insert into paciente value(56, 3, 'Perseo', 'Mayonga Vela', 41, 'H', 'Privada Ulici, Gustavo A. Madero, CDMX','DOHM791212MDFMRI08','52221524','ixbita23@gmail.com',1, 0);
insert into paciente value(57, 3, 'Néstor', 'Paez Carrera', 46, 'H', 'Calle Santo del Andorra, Azcapotzalco, CDMX','NIGE690305HDFEAI09','56000858','jkachahboun10@gmail.com',1, 0);
insert into paciente value(58, 3, 'Roxana', 'Chacón Mateo', 23, 'M', 'Mitre No. 680, Cuahutemoc, CDMX','ISCM960719HDFLSI03','55110444','jiludovico8@gmail.com',1, 0);
insert into paciente value(59, 3, 'Netanel', 'Sanches Medina', 38, 'H', 'Calle Santo, Coyoacan, CDMX','PORS960802HDFZTG05','57665767','cuperez20@gmail.com',1, 0);
insert into paciente value(60, 3, 'Esmirna', 'Covarrubias Linares', 19, 'H', 'Calle Ceperuelo, Tlalpan, CDMX','PABJ960827HDFRRG02','54336300','drballe17@gmail.com',1, 0);


insert into citas value(1,1,1,'2016-05-29',8,1,0,'Revisión dental');
insert into citas value(2,1,2,'2016-05-29',12,1,1,'Limpieza dental');
insert into citas value(3,1,3,'2016-05-30',13,0,1,'Eliminar caries');
insert into citas value(4,1,4,'2016-06-1',8,1,1,'Revisión dental');
insert into citas value(5,1,5,'2016-06-2',8,1,1,'chequeo anual');
insert into citas value(6,1,6,'2016-06-3',10,0,1,'Revisión dental');
insert into citas value(7,1,7,'2016-06-1',15,0,1,'chequeo mensual');
insert into citas value(8,1,1,'2016-06-2',14,1,1,'Revisión dental');
insert into citas value(9,2,20,'2016-06-5',15,1,1,'Ver tratamiento');
insert into citas value(10,2,21,'2016-06-1',18,1,1,'Revisión dental');
insert into citas value(11,2,22,'2016-03-30',12,1,1,'Eliminar caries');
UPDATE citas SET actual='0' WHERE actual='1' and idPaciente='1';

insert into odontograma value(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(11,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(13,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(21,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(22,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(24,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(26,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(27,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(28,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(29,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(30,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(31,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(34,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(36,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(37,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(38,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(39,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(41,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(42,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(43,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(44,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(45,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(46,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(47,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(48,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(49,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(51,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(52,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(53,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(54,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(55,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(56,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(57,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(58,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(59,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into odontograma value(60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

insert into costos (cantidad,descripcion,idPaciente) Values (56.45,'Cita',1);
insert into costos (cantidad,descripcion,idPaciente) Values (43.55,'Cita',1);



insert into tratamientos value(1,1,2,'Revision dental',1,'2016-03-31',0);
insert into tratamientos value(2,1,6,'Eliminar caries',0,'2016-03-30',0);


select * from dentista;
select * from paciente;
select * from citas;
select * from odontograma;
select * from tratamientos;