create database advfot;

INSERT INTO advfot.generos VALUES 
('Accion'),
('Comedia'),
('Drama'),
('Intriga'),
('Policiaca'),
('Thriller');

INSERT INTO advfot.fotogramas (archivo, tit_pelicula, anyo_estreno, director, genero) VALUES
('chacal.jpg','Chacal',1973,'Fred Zinnemann','Policiaca'),
('ciudadano.jpg','Un ciudadano ejemplar',2009,'F. Gary Gray','Intriga'),
('diablo.jpg','Diablo',2003,'F. Gary Gray','Accion'),
('romperstomper.jpg','Romper stomper',1992,'Geoffrey Wright','Accion'),
('invicto3.jpg','Invicto 3',2010,'Isaac Florentine','Accion'),
('scout.jpg','El ultimo boy scout',1991,'Tony Scott','Accion'),
('tirador.jpg','El tirador',2007,'Antoine Fuqua','Thriller'),
('vecinos.jpg','Vecinos invasores',2006,'Tim Johnson','Comedia'),
('england.jpg','This is England',2006,'Shane Meadows','Drama'),
('gladiator.jpg','Gladiator',2000,'Ridley Scott','Accion');
