drop schema if exists practica;
drop user if exists usuario_practica;
CREATE SCHEMA practica ;


create user 'usuario_practica'@'%' identified by 'la_Clave.';


grant all privileges on practica.* to 'usuario_practica'@'%';
flush privileges;


create table practica.arbol (
  id_arbol INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  dureza INT NOT NULL,
  tipo varchar(30)NOT NULL,
  ruta_imagen varchar(1024),
  extinto bool,
  PRIMARY KEY (id_arbol))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


INSERT INTO practica.arbol (id_arbol,nombre,dureza,tipo,ruta_imagen,extinto) VALUES 
('1','Roble','3','Árbol de hoja caduca', 'https://infinitanaturaleza.com/wp-content/uploads/2020/11/%C3%A1rbol-de-roble-3.jpg',   true), 
('2','Manzano','2','Caducifolio',  'https://th.bing.com/th/id/OIP.y-hd0fQM4TPgWOuALWVCkQHaEo?pid=ImgDet&rs=1',   true);