use Bookstore;

insert into UserImage (ImageID, ImageDesc)
		values (1,'https://image.ibb.co/j8GK6T/avatar10.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (2,'https://image.ibb.co/iT9vfo/avatar9.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (3,'https://image.ibb.co/eLcsRT/avatar8.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (4,'https://image.ibb.co/cV3o0o/avatar7.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (5,'https://image.ibb.co/cMnFfo/avatar6.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (6,'https://image.ibb.co/cw6mmT/avatar5.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (7,'https://image.ibb.co/cZuHt8/avatar4.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (8,'https://image.ibb.co/hYHFfo/avatar3.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (9,'https://image.ibb.co/hkNFfo/avatar1.png');
        
insert into UserImage (ImageID, ImageDesc)
		values (10,'https://image.ibb.co/cMUvfo/avatar2.png');

insert into UserB (UName, UPassword, UNameCo, UEmail, UDate, UType, UPictureID) 
		values ('admin','Cookies','Administrador Universal','alejandromedinamx@gmail.com','1998-02-05','A',1);
        
insert into Category values ("scie","Science");

insert into Category values ("phys","Physics");

insert into Category values ("busi","Business");

insert into Category values ("econ","Economy");

insert into Category values ("hist","History");

insert into Category values ("phil","Philosophy");

insert into Category values ("humo","Humor");

insert into Category values ("nove","Novels");

insert into Category values ("fict","Fiction");

insert into Category values ("adve","Adventures");

insert into Category values ("clas","Classics");

insert into Category values ("kids","Kids");

INSERT INTO Country					
	VALUES(	"ctg",	"Cartagena"		),
	(	"chl",	"Chile"			),
	(	"esc",	"Escocia"		),
	(	"esp",	"España"		),
	(	"esu",	"Estados Unidos"	),
	(	"fra",	"Francia"		),
	(	"hun",	"Hungria"		),
	(	"ing",	"Inglaterra"		),
	(	"que",	"Quebec"		),
	(	"rgb",	"Reino de Gran Bretaña"	),
	(	"reu",	"Reino Unido"		),
	(	"tur",	"Turquia"		),
	(	"war",	"Warwickshire"		);
    
insert into Country values ('pru','Prusia');
insert into Country values ('rom','Roma');
insert into Country values ('gre','Grecia');
insert into Country values ('ita','Italia');

INSERT INTO Autor										
	VALUES(	"Daniel Defoe"			,'1660-10-10'		,"rgb"	),			
	(	"Julio Verne"			,'1828-02-08'		,"fra"	),			
	(	"Horace Walpole"		,'1717-09-24'		,"rgb"	),				
	(	"Robert L. Stevenson"		,'1850-11-13'		,"esc"	),				
	(	"Baroness Emmuska Orczy"	,'1865-09-23'		,"hun"	),				
	(	"Arturo Pérez Reverte"		,'1951-11-25'		,"esp"	),				
	(	"Walter Isaacson"		,'1952-05-20'		,"esu"	),			
	(	"Charles Dickens"		,'1812-02-07'		,"ing"	),			
	(	"William Shakespeare"		,'1564-04-26'		,"reu"	),			
	(	"George Eliot"			,'1819-11-22'		,"war"	),			
	(	"Kate Raworth"			,'1970-12-15'		,"esu"	),
	(	"Joseph E. Stiglitz"		,'1943-02-09'		,"esu"	),
	(	"Adam Smith"			,'1723-06-16'		,"reu"	),
	(	"Daron Acemoglu"		,'1967-09-03'		,"tur"	),
	(	"J. K. Rowling"			,'1965-07-31'		,"reu"	),
	(	"H.P.Lovecraft"			,'1890-08-20'		,"esu"	),
	(	"Luis Miguel Pérez Adán"	,'1961-08-08'		,"war"	),
	(	"Stanley G.Payne"		,'1934-09-09'		,"esu"	),
	(	"José Ortega y Gasset"		,'1883-05-09'		,"esp"	),
	(	"Mauricio Rojas"		,'1950-12-12'		,"chl"	),
	(	"Pío Moa"			,'1948-07-09'		,"esp"	),
	(	"Nicolas Dickner"		,'1972-01-08'		,"que"	),
	(	"Ana Ribera García Rubio"	,'1973-01-05'		,"esp"	);
    
insert into Autor values ('Margarita de Valois','1553-05-14','fra');
insert into Autor values ('Oscar Wilde','1854-10-16','ing');
insert into Autor values ('Mark Twain','1835-11-30','esu');
insert into Autor values ('Pictocuentos','2010-01-01','esp');
insert into Autor values ('Jeanne Marie','1711-04-26','fra');
insert into Autor values ('Panzuela','2013-04-02','esp');
insert into Autor values ('Paloma Bordons','1964-05-03','esp');
insert into Autor values ('Terry McMillan','1951-08-31','esu');
insert into Autor values ('J. D. Salinger','1919-01-01','esu');
insert into Autor values ('John Katzenbach','1950-06-23','esu');
insert into Autor values ('Anatole France','1844-04-16','fra');
insert into Autor values ('R Cherry','1984-05-21','esp');
insert into Autor values ('Immanuel Kant','1724-04-22','pru');
insert into Autor values ('Arthur Schopenhauer','1788-02-22','pru');
insert into Autor values ('Marco Aurelio','121-04-26','rom');
insert into Autor values ('Aristoteles','384-04-22','gre');
insert into Autor values ('Santo Tomas de Aquino','1225-04-07','ita');
insert into Autor values ('Sonia Fernandez Vidal','1984-03-12','esp');
insert into Autor values ('Stephen Hawking','1942-01-08','ing');
insert into Autor values ('Robert P. Crease','1953-10-22','esu');
insert into Autor values ('Oliver Sacks','1933-07-09','ing');
insert into Autor values ('Daniel Goleman','1946-03-07','esu');
insert into Autor values ('Marvin Harris','1927-08-18','esu');
insert into Autor values ('Desmons Morris','1928-01-24','esu');

/*1*/
insert into Book values ("Observe a su perro(gato)",
						
                        "En el conjunto de la historia humana sólo dos animales han tenido libertad para en nuestros hogares: el perro y el gato, se les ha permitido errar de habitación en habitación e ir y venir a su propio antojo. En Occidente la vida de los perros ha tenido un desarrollo más bien feliz, las primeras tereas encomendadas han ido perdiendo importancia y viene realizando un nuevo papel. El perro con tareas de labor ha sido mayormente reemplazado por el perro doméstico.",
                        "http://www.librosmaravillosos.com/observeasugato/pdf/Observe%20a%20su%20gato%20-%20Desmond%20Morris.pdf",
                        "scie",
                        0,
                        "https://image.ibb.co/fuYd38/scie1.png");
/*2*/
insert into Book values ("La práctica de la inteligencia emocional",
						
                        "Habiendo tenido acceso a directores empresariales de todo el mundo, y tras haber estudiado el funcionamiento de más de quinientas organizaciones, Goleman revela las aptitudes que definen a los profesionales más competentes. Su conclusión es que, desde los puestos de trabajo más modestos hasta los altos cargos directivos, el factor determinante no es ni el cociente intelectual, ni los diplomas universitarios, ni la pericia técnica: es la inteligencia emocional.",
                        "https://training.crecimiento.ws/wp-content/uploads/2017/09/EBOOK_Daniel_Goleman_-_La_Practica_De_La_Inteligencia_Emocional.pdf",
                        "SCIE",
                        0,
                        "https://image.ibb.co/chUUAo/scie3.png");


/*4*/
insert into Book values ("El hombre que confundió a su mujer con un sombrero",
						
                        "En este libro, Oliver Sacks narra veinte historiales médicos de pacientes perdidos en el mundo extraño y aparentemente irremediable de las enfermedades neurológicas. Se trata de casos de individuos aquejados por inauditas aberraciones de la percepción que han perdido la memoria, y con ella, la mayor parte de su pasado; que son incapaces de reconocer a sus familiares o los objetos cotidianos: que han sido descartados como retrasados mentales y que, sin embargo, poseen insólitos dones artísticos o científicos. Por extraños que parezcan estos casos, el doctor Sacks los relata con pasión humana y gran talento literario.",
                        "http://mimosa.pntic.mec.es/~sferna18/EJERCICIOS/2013-14/Sacks_Oliver-El_Hombre_Que_Confundio_a_Su_Mujer_Con_Un_Sombrero.pdf",
                        "SCIE",
                        0,
                        "https://image.ibb.co/iJKUAo/scie4.png");

/*5*/
insert into Book values ("Nuestra especie",
						
                        "¿Cómo eran las primeras sociedades y los primeros lenguajes humanos? ¿Qué aspectos de la condición humana están inscritos en nuestros genes y cuáles forman parte de nuestra herencia cultural? Este volumen es un riguroso compendio del estado actual de nuestros conocimientos sobre la identidad de Nuestra especie, en el que el prestigioso antropólogo Marvin Harris aborda interrogantes y enigmas que afectan por igual a toda la humanidad desde una perspectiva panhumana, biosocial y evolutiva» que, a partir del dato concreto y local, le permite presentar un amplio panorama de la evolución material y cultural del hombre.",
                        "http://www.proarhep.com.ar/wp-content/uploads/Harris_Marvin-Nuestra_especie.pdf",
                        "SCIE",
                        0,
                        "https://image.ibb.co/bW0fGT/scie5.png");
                        
/* 6 */
insert into Book values ("El heptameron",
						
                        "El Heptamerón es un libro escrito por Margarita de Valois (1492-1549). Margarita era una mujer de gran cultura, dominaba varios idiomas lo que le permitió leer el Decamerón de Boccaccio en italiano (ella fue quién impulsó su traducción al francés). Inspirándose en el Decamerón escribió su obra en la que describe como un grupo de personas, al quedar aisladas, deciden pasar el tiempo contando historias. Éstas son setenta y dos, narradas en el transcurso de siete días. Calificadas de licenciosas, estas historias sin embargo no sobrepasan lo permitido en el tiempo en que fueron escritas y aunque su moralidad puede ser discutida si se mira desde el punto de vista actual, no hace más que describir su época sin artificios ni hipocresías. ",
                        "https://dialnet.unirioja.es/descarga/articulo/1150769.pdf",
                        "humo",
                        0,
                        "https://image.ibb.co/c21nwT/humo1.png");
                        
/*7*/
insert into Book values ("Cosas que le pasan a una madre sin superpoderes",
						
                        "Antes de tener hijos, tres horas te parecían muchísimo tiempo. Ir en silencio en el coche, algo aburrido. Creías que eras más paciente, no veías a tu madre como una heroína y el columpio y el tobogán te resultaban inofensivos.",
                        "http://www.esferalibros.com/uploads/ficheros/libros/primeras-paginas/201304/primeras-paginas-paginas-del-libro_7-es.pdf",
                        "humo",
                        0,
                        "https://image.ibb.co/mdkyqo/R8.png");
/* 8*/
insert into Book values ("Apocalipsis para principiantes",
						
                        "Entre Canadá y Japón, entre la más aguda disección de la realidad y el surrealismo más hilarante, Apocalipsis para principiantes es una comedia romántica entrañable e inteligente sobre dos grandes amigos que podrían llegar a ser novios si no fuera porque uno de ellos está plenamente convencido de que el fin del mundo se acerca.",
                        "http://www.siruela.com/archivos/fragmentos/Apocalipsis_para_principiantes.pdf",
                        "humo",
                        0,
                        "https://image.ibb.co/hqpJ38/humo3.png");
    
/* 9 */
insert into Book values ("Un yanqui en la corte del rey arturo",
						
                        "Tras intervernir en una pelea y sufrir un golpe en la cabeza, el protagonista, Hank Morgan, es transportado hacia atrás en el tiempo llevando consigo todo el conocimiento tecnológico del siglo XIX y su ideología republicana y protestante al siglo VI en la corte de las leyendas artúricas. Hank es condenado a morir en la hoguera. Sin embargo, tomando ventaja del conocimiento ...",
                        "http://www.librosmaravillosos.com/unyankienlacortedelreyarturo/pdf/Un%20yanqui%20en%20la%20corte%20del%20Rey%20Arturo%20-%20Mark%20Twain.pdf",
                        "humo",
                        0,
                        "https://image.ibb.co/cnrRAo/30618627.jpg");
                        
/* 10 */
insert into Book values ("La importancia de llamarse Ernesto",
						
                        "Ubicada en la Inglaterra de la época victoriana, la trama se desarrolla alrededor del protagonista John (o Jack) y Ernest, su hermano ficticio. Las obras anteriores de Wilde lo habían encumbrado en la cima del éxito, por lo que no se esperaba algo nuevo del dramaturgo. En aquel entonces,, la prensa era feroz en su búsqueda de nuevos personajes y argumentos, prestando gran atención a los detalles. Para combatirla, Wilde bautizó la obra bajo el título de Lady Lancing y usó nombres de pueblos costeros para los personajes principales y la ubicación de la obra (el apellido del protagonista, Worthing, está tomado de la ciudad donde Wilde residía cuando escribió la obra). Fue la última comedia que escribió Wilde y está considerada uno de sus mejores trabajos. Se estrenó por primera vez en el 14 de febrero de 1895 en el St. James Theatre de Londres, tres meses antes de que Wilde fuera condenado a prisión por indecencia grave.",
                        "http://bibliotecadigital.tamaulipas.gob.mx/archivos/descargas/31000001002.PDF",
                        "humo",
                        0,
                        "https://image.ibb.co/hKQ8O8/0486264785_01_lzzzzzzz1.jpg");
                        
/* 11 */
insert into Book values ("Casi me olvido de ti",
						
                        "La protagonista de Casi me olvido de ti, la optometrista afroamericana Georgia Young, una mujer madura, exitosa, con hijos mayores, muchos amigos y la vida resuelta, pero profundamente insatisfecha, decide enfrentarse a sus miedos y cambiar de rumbo. Desde abandonar su trabajo y su casa hasta abrir la puerta al amor intentando establecer contacto con sus antiguas parejas. Y demostrando, con valentía, que nunca es tarde para asumir riesgos. ",
                        "https://www.adnovelas.com/catalogos/capitulos_promocion/LN00002701_9999971721.pdf",
                        "nove",
                        0,
                        "https://image.ibb.co/bVmbqo/nove1.png");
/* 12 */
insert into Book values ("La rebelión de los ángeles",
						
                        "Narrada con delicioso estilo e ironía venenosa, La Rebelión de los Ángeles nos sitúa en el centro de la más audaz y quimérica de las empresas imaginables: destronar al anciano y todopoderoso soberano: el Dios de la mitología judeocristiana, el tirano del universo, el cruel Ialdabaoth. ",
                        "http://bibliotecadigital.tamaulipas.gob.mx/archivos/descargas/31000000459.PDF",
                        "nove",
                        0,
                        "https://image.ibb.co/cycubT/nove2.png");
/* 13 */
insert into Book values ("Mi dulce locura",
						
                        " Natalia es una chica normal, con una vida tranquila y relajada. Junto a su mejor amiga, es dueña de una cafetería llamada Jubilee, o como dice ella Bibliotería o una Cafeteca (ya que es mitad cafetería mitad biblioteca). Cientos de dudas, temores, pesadillas y sueños rotos volverán a ella con tanta fuerza que la harán parecer pequeña, diminuta. Solo con la ayuda de él, y de la gente a la que quiere podrá olvidar todo lo que un día ocurrió. ¿Será capaz de afrontarlo y dejarse llevar por J.D Collins?",
                        "http://librosonlineparaleer.com/wp-content/uploads/2017/02/Mi-Dulce-Locura-Serie-Mi-Locura-1-R.-Cherry.pdf",
                        "nove",
                        0,
                        "https://image.ibb.co/fLmWO8/nove3.png");
/* 14 */
insert into Book values ("El psicoanalista",
						
                        "«Feliz aniversario, doctor. Bienvenido al primer día de su muerte.» Así comienza el anónimo que recibe el psicoanalista Frederick Starks, y que le obliga a emplear toda su astucia y rapidez para, en quince días, averiguar quién es el autor de esa amenazadora misiva que promete hacerle la vida imposible. De no conseguir su objetivo, deberá elegir entre suicidarse o ser testigo de cómo, uno tras otro, sus familiares y conocidos mueren por obra de un psicópata decidido a llevar hasta el final su sed de venganza. Dando un inesperado giro a la relación entre médico y paciente, John Katzenbach nos ofrece una novela emblemática del mejor suspense psicológico. La edición publicada en 2012 para conmemorar el décimo aniversario de la primera edición original de El psicoanalista, incluye un epílogo que John Katzenbach ha escrito especialmente para los lectores en lengua española.",
                        "http://fundaciondhyana.weebly.com/uploads/3/0/0/8/30085277/el_psicoanalista.pdf",
                        "nove",
                        0,
                        "https://image.ibb.co/cUJjwT/image_1165_1_69029.jpg");
                        
/* 15 */
insert into Book values ("EL guardian entre el centeno",
						
                        "La novela cuenta la historia de Holden Caulfield, un joven neoyorquino de 16 años que acaba de ser expulsado de Pencey Prep, su escuela preparatoria. Está narrada en la voz de Holden, un joven que se ha caracterizado por tener malos resultados en sus estudios (ya había sido expulsado de varios colegios) y quien cree que la mayoría de la gente es «falsa», salvo algunas excepciones (se destaca el gran amor que siente hacia sus hermanos, uno de los cuales está muerto). La historia comienza un sábado, poco antes de Navidad. A Holden se le ha informado que no podrá volver a su colegio (ubicado en Pensilvania) después de las vacaciones. Tras una pelea con su compañero de habitación, decide no esperar hasta el miércoles para volver a Nueva York (donde vive con sus padres), marchándose esa misma noche.",
                        "http://www.formarse.com.ar/libros/Libros-recomendados-pdf/El%20guardi%C3%A1n%20entre%20el%20centeno%20de%20J.%20D.%20Salinger%20-.pdf",
                        "nove",
                        0,
                        "https://image.ibb.co/exFWbT/7db9f4172b3d8a05da4c48f674abadff_300x451.jpg");
/* 16 */
insert into Book values ("La bella y la bestia",
						
                        "Ningún cuento de hadas es, quizÃ¡s, mÃ¡s conocido queÂ La Bella y la Bestia. La literatura y el cine se han encargado de difundir universalmente las terribles y encantadoras aventuras de una joven virtuosa que debe sacrificarse por su padre, entregÃ¡ndose a un monstruo, para descubrir feliz e inevitablemente que su horrible prometido es el mÃ¡s hermoso de los príncipes. ",
                        "http://cie.chron.com/pdfs/clubchron/Beauty_and_the_Beast_Spanish.pdf",
                        "kids",
                        0,
                        "https://image.ibb.co/jPerbT/9788416279074.jpg");
                        

/* 17 */
insert into Book values ("Ricitos de oro",
						
                        "Una niñita atrevida y curiosa, una casita en el bosque y sus tres peludos inquilinos son los protagonistas de este cuento tradicional que habla del respeto, de la intimidad y del compartir, entre otras cosas.",
                        "https://www.pictocuentos.com/descargas/pdf-ricitos/pictocuentos-ricitos-de-oro.pdf",
                        "kids",
                        0,
                        "https://image.ibb.co/d4SSGT/9788467582352.jpg");
                        
/* 18 */
insert into Book values ("La fuerza de la gacela",
						
                        "La llegada de un feroz tigre extranjero a la selva de Congolandia rompe la tranquilidad de los animales del bosque. Entre todos los animales acuerdan enviar un grupo guerrero para enfrentar al terrible felino, pero es derrotado. Al final será la inofensiva gacela quien enfrentará al fiero tigre.",
                        "https://pazuela.files.wordpress.com/2014/07/10-la-fuerza-de-la-gacela-texto.pdf",
                        "kids",
                        0,
                        "https://image.ibb.co/mLAa38/9788434820401.jpg");
                        
/* 19 */
insert into Book values ("Quiero ser famosa",
						
                        "Ana es una niña que quiere ser famosa. Pero no sabe cómo conseguirlo. De momento se conforma con llamar la atención para que se fijen en ella. Un día consigue sus propósitos, pero será un poco distinto a lo que se imaginaba. ¿Hasta que punto se puede diferenciar la realidad de los sueños? Un relato que muestra la importancia de aceptarse a uno mismo.",
                        "https://recursosparaelprofesor.files.wordpress.com/2018/04/quiero-ser-famosa-paloma-bordons.pdf",
                        "kids",
                        0,
                        "https://image.ibb.co/jAkWbT/9788434844001.jpg");
                        
/* 20 */
insert into Book values ("Caperucita roja",
						
                        "Caperucita Roja es el cuento de hadas de transmisión oral que mejor ha sobrevivido al paso del tiempo. Tiene muchas lecturas, pero ante todo es un cuento para jóvenes que, de alguna manera, simboliza el paso de la niñez a la adolescencia. Esta edición reúne las tres principales versiones del cuento: En 1697 Charles Perrault fue el primero en incluir en un volumen de cuentos la historia de Caperucita. En 1812 Jacob y Wilhelm Grimm retomaron el cuento y su versión es la más conocida hoy en día. Por último publicamos una rareza, la versión dramática y en verso que el gran escritor alemán Ludwig Tieck escribió en 1800. ",
                        "https://www.pictocuentos.com/descargas/pdf-caperucita/pictocuentos-caperucita.pdf",
                        "kids",
                        0,
                        "https://image.ibb.co/eFfQ38/20150701101706_290x400.jpg");
                        
                        /*21*/

insert into Book values ("Animales fantasticos y donde encontrarlos",
						
                        "El explorador y magizoólogo Newt Scamander llega a Nueva York con la intención de permanecer unos pocos días. Pero cuando pierde su maleta y algunos de sus animales fantásticos se escapan de ella, una serie de acontecimientos extraordinarios se desatan, poniendo en vilo a la gran ciudad",
                        "http://salamandra.info/sites/default/files/books/previews/animales_fantasticos_y_donde_encontrarlos-1os_capitulos.pdf",
                        "FICT",
                        0,
                        "https://image.ibb.co/cfA838/fict1.png");

/*22*/

insert into Book values ("Harry Poter y la piedra filosofal",
						
                        "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley. Harry se siente muy triste y solo, hasta que un buen día recibe una carta que cambiará su vida para siempre. En ella le comunican que ha sido aceptado como alumno en el colegio interno Hogwarts de magia y hechicería.",
                        "http://laprensadelazonaoeste.com/LIBROS/Letra.R/R/Rowling,%20J.K%20-%2001%20-%20Harry%20Potter%20y%20la%20Piedra%20Filos.pdf",
                        "FICT",
                        0,
                        "https://image.ibb.co/c6QZfo/R1.png");

/*23*/

insert into Book values ("Harry Potter y la cámara secreta",
						
                        "Tras derrotar una vez más a lord Voldemort, su siniestro enemigo en Harry Potter y la piedra filosofal, Harry espera impaciente en casa de sus insoportables tíos el inicio del segundo curso del Colegio Hogwarts de Magia y hechicería. Sin embargo, la espera dura poco, pues un elfo aparece en su habitación y le advierte que una amenaza mortal se cierne sobre la escuela. ",
                        "http://www.alconet.com.ar/varios/libros/e-book_h/Harry_Potter_y_La_Camara_Secreta_02.pdf",
                        "FICT",
                        0,
                        "https://image.ibb.co/ejeufo/R2.png");

/*24*/

insert into Book values ("Harry Potter y el prisionero de Azkabán",
						
                        "Por la cicatriz que lleva en la frente, sabemos que Harry Potter no es un niño como los demás, sino el héroe que venció a lord Voldemort, el mago más temible y maligno de todos los tiempos y culpable de la muerte de los padres de Harry. Desde entonces, Harry no tiene más remedio que vivir con sus pesados tíos y su insoportable primo Dudley, todos ellos muggles, o sea, personas no magas, que desprecian a su sobrino debido a sus poderes.",
                        "http://www.alconet.com.ar/varios/libros/e-book_h/Harry_Potter_y_El_Prisionero_de_Azkaban_03.pdf",
                        "FICT",
                        0,
                        "https://image.ibb.co/g0Jy6T/R3.png");

/*25*/

insert into Book values ("Quidditch a través de los tiempos",
						
                        "Si alguna vez te has preguntado de dónde proviene la snitch dorada, cómo adquieren vida las bugglers o por qué los Wigtown Wanderers llevan un cuchillo de carnicero dibujado en el uniforme, entonces querrás leer QUIDDITCH A TRAVÉS DE LOS TIEMPOS. Esta edición limitada es una copia del ejemplar que está en la biblioteca del Colegio Hogwarts y que los jóvenes fanáticos del quidditch consultan casi a diario.",
                        "http://www.nparangaricutiro.gob.mx/Libros/09.-%20Quidditch%20A%20Traves%20De%20Los%20Tiempos.pdf",
                        "FICT",
                        0,
                        "https://image.ibb.co/k2ZeAo/fict5.png");

/*26*/

insert into Book values ("Los cuentos de Beedle el Bardo",
						
                        "Los cuentos de Beedle el Bardo contienen cinco cuentos de hadas muy diferentes, cada uno con su propio carácter mágico, que deleitarán al lector con su humor y la emoción del peligro de muerte.",
                        "http://salamandra.info/sites/default/files/books/previews/cuentos_beedle_el_bardo-1os_capitulos.pdf",
                        "FICT",
                        0,
                        "https://image.ibb.co/jL7MO8/fict6.png");

/*27*/

insert into Book values ("Lenin y el totalitarismo",
						
                        "Al conmemorarse el centenario de la Revolución rusa, Mauricio Rojas presenta un polémico y agudo perfil sobre Lenin. A partir de una reflexión histórica sobre la situación política y social en Rusia desde finales del siglo XIX y principios del XX, el autor describe la creación y auge del partido bolchevique y, principalmente, lo que denomina contrarrevolución de octubre, es decir, el paso del ideal revolucionario iniciado con los sóviets al terror contra el pueblo ruso.",
                        "https://bibliotecademauriciorojas.files.wordpress.com/2012/03/m-rojas-articulo-marx-lenin-y-el-totalitarismo-3-copia.pdf",
                        "HIST",
                        0,
                        "https://image.ibb.co/dffai8/hist1.png");

/*28*/

insert into Book values ("Los mitos de la Guerra Civil",
						
                        "La amena exposición de los contenidos, y la facilidad narrativa, mantienen el interés en la lectura de este libro de síntesis, que recoge las novedades historiográficas y realiza el noble ejercicio de la crítica histórica. ",
                        "http://www.fundacionfaes.org/file_upload/publication/pdf/201304231418151934-comienza-la-guerra-civil-en-torno-al-libro-de-pio-moa.pdf",
                        "HIST",
                        0,
                        "https://image.ibb.co/np920o/R4.png");

/*29*/

insert into Book values ("Guerra Civil española",
						
                        "Breve y completo relato del conflicto armado, sus complejos orígenes, el derrumbe de la segunda república y el desarrollo de la dictadura franquista.",
                        "http://www.redalyc.org/pdf/3241/324127626006.pdf",
                        "HIST",
                        0,
                        "https://image.ibb.co/k7NY6T/R5.png");

/*30*/

insert into Book values ("La rebelión de las masas",
						
                        "En él, aspectos filosóficos, sociales, políticos y morales se vinculan de tal modo que es difícil, aun hoy, permanecer indiferente. Masas, fascismo, técnica, liberalismo, unidad europea o pacifismo son algunos de los temas que recorren la obra y, en su análisis, pasado, presente y futuro se confunden: LA REBELIÓN DE LAS MASAS disecciona su tiempo, y, con ello, nos permite entender el nuestro.",
                        "http://juango.es/files/La-rebelion-de-las-masas.pdf",
                        "HIST",
                        0,
                        "https://image.ibb.co/jCurt8/R6.png");

/*31*/

insert into Book values ("El hundimiento del Castillo Olite",
						
                        "El general Franco vio una oportunidad única de finalizar gloriosamente la Guerra Civil con una acción espectacular: El desembarco y captura de la principal Base Naval de la República, donde se había producido una sublevación contra el gobierno de Juan Negrín que rápidamente se transformó en franquista. ",
                        "http://www.armada.mde.es/archivo/mardigitalrevistas/rhn/2009/2009106.pdf",
                        "HIST",
                        0,
                        "https://image.ibb.co/csuqGT/hist5.png");

/*32*/

insert into Book values ("El prisma y el péndulo",
						
                        "La ciencia es un delicado y complejo equilibrio entre lo experimental y lo teórico, entre las observaciones que realizamos y los sistemas lógico-simbólicos que construimos para relacionar todo aquello que medimos en la naturaleza. No hay ciencia sin observaciones, sin experimentos. Y sin embargo, son las teorías, y los teóricos los que más atención y popularidad consiguen.",
                        "https://www.primercapitulo.com/pdf/2016/1362-el-prisma-y-el-pendulo.pdf",
                        "PHYS",
                        0,
                        "https://image.ibb.co/eu0mRT/R7.png");

/*33*/

insert into Book values ("El origen del universo",
						
                        "El mayor experimento científico de la Historia está en marcha ¡Y George y Annie lo verán desde primera fila! Acompañarán a Eric, el padre de Annie, que está trabajando en el Centro Europeo de Investigaciones Nucleares, en Suiza. Allí se encuentra el gran colisionador de partículas, capaz de explorar los primeros instantes del universo: el Big Bang. Científicos de todo el mundo llevan años trabajando en el experimento y nada puede salir mal ¡hasta que George y Annie descubren un plan para sabotearlo! ¿Llegarán a tiempo para impedirlo?",
                        "http://www.universohawking.com/docs/El-gran-diseno-opusculo.pdf",
                        "PHYS",
                        0,
                        "https://image.ibb.co/bKBLGT/phys2.png");

/*34*/

insert into Book values ("El tesoro cósmico",
						
                        "Algo no marcha bien. Eric, el antiguo vecino de George, está en Florida trabajando en un proyecto científico para descubrir si hay vida en el planeta Marte y en otros lugares del Sistema Solar. El robot encargado de la misión actúa de forma muy extraña y, según le cuenta Annie a George, ¡un alien les ha enviado un mensaje para decirles que deben volver al espacio si no quieren que el mundo se acabe! Una vez más, Annie y George deberán enfundarse sus trajes espaciales y seguir las pistas que les conducirán hasta un peligrosísimo y siniestro personaje...",
                        "https://educalibre.info/wp-content/uploads/2018/03/El-tesoro-cosmico-Lucy-y-Stephen-Hawking.pdf",
                        "PHYS",
                        0,
                        "https://image.ibb.co/d12SwT/phys3.png");

/*35*/

insert into Book values ("La clave secreta del universo",
						
                        "A George nada le gusta más en el mundo que mirar las estrellas: también le encantaría tener un ordenador con el que navegar y conocer más sobre el Universo, pero sabe que eso es misión imposible. En casa, sus padres son tan ecologistas que no quieren ni oír hablar del progreso y la ciencia. Pero lo que ellos no saben es que el enemigo está muy cerca: acaba de llegar un nuevo vecino que, ¡horror!, es un eminente científico, e eso, para los padres de George solo significa una cosa: peligro. Si hubiera imaginado lo que le esperaba a su hijo, nunca le habrían dejado entrar en su casa...",
                        "https://educalibre.info/wp-content/uploads/2018/03/La-clave-secreta-del-universo-Lucy-y-Stephen-Hawking.pdf",
                        "PHYS",
                        0,
                        "https://image.ibb.co/nmVEbT/phys4.png");

/*36*/

insert into Book values ("Desayuno con partículas",
						
                        "Un excitante y revelador viaje a través de la física cuántica al interior de la mente y a los orígenes de la vida. Una fascinante lectura para aprender a sacar partido a nuestro cerebro y aplicarlo a los problemas de nuestra vida cotidiana. Tienes en las manos un ensayo sobre física cuántica, así es. Un momento, por favor, ¡espera! No dejes que eso te asuste y sueltes el libro de golpe. ¿Aceptarías una invitación a desayunar?",
                        "http://fernandez-vidal.com/inc/downloads/desayuno_con_particulas_cap1_es.pdf",
                        "PHYS",
                        0,
                        "https://image.ibb.co/mfDNVo/phys5.png");

/*37*/

insert into Book values ("Patente de corso",
						
                        "Desde 1994, cuatro millones de lectores de numerosos periódicos españoles leen cada fin de semana el artículo que Arturo Pérez-Reverte publica en el suplemento dominical El Semanal: su polémica, original y personalísima página de opinión. Patente de corso recoge una amplia selección de esos textos, de los que el propio autor ha dicho: Escribo con tanta libertad que me sorprende que me dejen.",
                        "https://archivos.juridicas.unam.mx/www/bjv/libros/1/154/7.pdf",
                        "BUSI",
                        0,
                        "https://image.ibb.co/hvNAGT/busi1.png");

/*38*/

insert into Book values ("Con ánimo de ofender",
						
                        "Después de Patente de corso, este Con ánimo de ofender continúa recopilando la polémica, original y personalísima página de opinión de Arturo Pérez-Reverte en el suplemento dominical El Semanal, que llega a más de cuatro millones de lectores. Su compromiso personal, su honestidad y su coherencia quedan recogidos en esta selección apasionante de textos que miran tanto a la literatura como a las más variadas caras de la sociedad contemporánea.",
                        "http://www.perezreverte.com/upload/ficheros/libros/201304/con_animo_de_ofender.pdf",
                        "BUSI",
                        0,
                        "https://image.ibb.co/d6CAGT/busi2.png");

/*39*/

insert into Book values ("Cuando éramos honrados mercenarios",
						
                        "Después de Patente de corso, Con ánimo de ofender y No me cogeréis vivo, este Cuando éramos honrados mercenarios continúa recopilando la polémica, original y personalísima página de opinión de Arturo Pérez-Reverte en el suplemento dominical El Semanal, que llega a más de cuatro millones de lectores. Su compromiso personal, su honestidad y su coherencia quedan recogidos en esta selección apasionante de textos que miran tanto a la literatura como a las más variadas caras de la sociedad contemporánea.",
                        "http://www.perezreverte.com/upload/ficheros/libros/201001/cuando_ramos_honrados_mercenarios.pdf",
                        "BUSI",
                        0,
                        "https://image.ibb.co/cMSzAo/busi3.png");

/*40*/

insert into Book values ("Lecciones de liderazgo",
						
                        "El nombre de Steve Jobs es sinónimo de innovación, liderazgo y éxito. Su personalidad arrolladora, su intuición para los negocios y su carisma hicieron de él un gurú de la tecnología, que logró convertir a su empresa, Apple, en la compañía de innovación tecnológica más importante del mundo.",
                        "https://tlridnewscchoriente.files.wordpress.com/2016/01/steve-jobs-lecciones-de-liderazgo.pdf",
                        "BUSI",
                        0,
                        "https://image.ibb.co/h5hMO8/busi4.png");
                        


insert into Book values ("Fundamentos de economia",
						
                        "La economía, al igual que el aire que respiramos, no es objeto de gran atención de las personas, pese a que muchas cuestiones económicas tienen un efecto decisivo en la sociedad. Con esta reflexión da inicio este nuevo libro de Marcela Astudillo y Jorge Paniagua; se establece el objetivo central que es ayudar al lector no solamente a comprender mejor la ciencia económica contemporánea, sino también a informar con precisión ciertos conceptos que, aunque son utilizados actualmente de manera cotidiana, son quizás poco entendidos o hasta ignorados.",
                        "http://ru.iiec.unam.mx/2462/1/FundamentosDeEconomiaSecuenciaCorrecta.pdf",
                        "ECON",
                        0,
                        "https://image.ibb.co/e5DZD8/fundamentos_de_economia_marcela_astudillo_moya_lv.jpg");


insert into Book values ("El precio de la desigualdad",
						
                        "El 1 % de la población disfruta de las mejores viviendas, la mejor educación, los mejores médicos y el mejor nivel de vida, pero hay una cosa que el dinero no puede comprar: la comprensión de que su destino esta ligado a cómo vive el otro 99 %. A lo largo de la historia esto es algo que esa minoría solo ha logrado entender cuando ya era demasiado tarde.",
                        "http://depa.fquim.unam.mx/amyd/archivero/EPreciodelaDesigualdad_27245.pdf",
                        "ECON",
                        0,
                        "https://image.ibb.co/bz7AGT/econ2.png");


insert into Book values ("Porque fracasan los países",
						
                        "Hay tres clases de libros: los que hay que consultar una vez, los que merecen una lectura en la vida y los que hay que tener. Por qué fracasan los países (Why nations fail) de Daron Acemoglu y James A. Robinson (2012) pertenece a la última categoría. Es de esos que deben ser atesorados en la biblioteca para revisar y leer una y otra vez, tal como sugieren los elocuentes elogios recibidos.",
                        "https://federalismoygobernabilidad.files.wordpress.com/2015/11/acemoglu.pdf",
                        "ECON",
                        0,
                        "https://image.ibb.co/kKbMt8/9788423412662.jpg");


insert into Book values ("La riqueza de las naciones",
						
                        "Básicamente, La Riqueza de las Naciones es un tratado sobre economía política, que en sus once capítulos trata de abarcar distintos tópicos, como la estructura de la producción, el salario, la pertenencia de la tierra, entre otros factores que para su autor resultan determinantes en la tarea de producir, generar, acumular y repartir riqueza dentro de una nación.",
                        "http://ceiphistorica.com/wp-content/uploads/2016/04/Smith-Adam-La-Riqueza-de-las-Naciones.pdf",
                        "ECON",
                        0,
                        "https://image.ibb.co/kzEKfo/9788416938391.jpg");


insert into Book values ("Economía Rosquilla",
						
                        "¿Es posible arreglarla? En Economía dónut, la académica de Oxford Kate Raworth identifica siete aspectos cruciales en los que la economía convencional nos ha llevado por el mal camino, y establece una hoja de ruta para conducir a la humanidad a un punto ideal donde puedan satisfacerse las necesidades de todos con los medios del planeta. En este trayecto, la autora revela cómo la obsesión por el equilibrio ha dejado a los economistas indefensos a la hora de afrontar el auge y caída de la economía del mundo real y, al mismo tiempo, crea un modelo económico de vanguardia apropiado para el siglo xxi; un modelo en el que una brújula en forma de dónut señala el camino hacia el progreso humano.",
                        "https://www.primercapitulo.com/pdf/2018/3688-economia-rosquilla.pdf",
                        "ECON",
                        0,
                        "https://image.ibb.co/eD1AmT/portada_economia_rosquilla_kate_raworth_201712041316.jpg");



insert into Book values ("Metafisica",
						
                        "Todos los hombres tienen por naturaleza el deseo de saber. Con estas palabras se inicia el libro primero de la Metafísica de Aristóteles. Ese deseo de saber culmina en la adquisición de la sabiduría que consiste, para Aristóteles, en el conocimiento de las causas y los principios del ser. Y ese conocimiento es el objeto de la metafísica, de la ciencia de las primeras causas y principios del ser, el conocimiento del ser en cuanto ser, el conocimiento de la causa última de la naturaleza y de la realidad.",
                        "http://cmap.upb.edu.co/rid=1GM19TDTV-2QXBB0-V3Y/Aristoteles%20-%20Metafisica.pdf",
                        "PHIL",
                        0,
                        "https://image.ibb.co/imfQLo/51_y_ZS628k_L_SX331_BO1_204_203_200.jpg");


insert into Book values ("Meditaciones",
						
                        "Su obra pensamientos es el resultado de sus meditaciones morales y reflexiones realizadas casi al final de su vida, en ella se pueda apreciar su estilo bastante influido por los maestros estoicos, sus meditaciones son duras y secas. La obra se divide en doce libros, escritos originalmente en griego. Los textos son pequeños párrafos que describen un tono  muy personal y una reflexión  muy   íntima y critica que no se complementa del todo con la disciplina estoica.",
                        "http://www.nueva-acropolis.com/filiales/libros/Marco_Aurelio-Meditaciones.pdf",
                        "PHIL",
                        0,
                        "https://image.ibb.co/mzMnY8/51u_DXsf8rg_L_SX331_BO1_204_203_200.jpg");


insert into Book values ("Crítica de la razón pura",
						
                        "Tras una larga gestación de once años, el gran filósofo alemán Immanuel Kant (1724-1804) publicó en 1781 la obra filosófica más influyente de los dos últimos siglos: Crítica de la razón pura. Partiendo de una síntesis superadora del racionalismo y del empirismo que caracterizaron el siglo XVIII, con esta obra Kant se propone dotar a la metafísica de un método científico similar al que habían alcanzado las matemáticas y la física y que necesita para volver a ocupar su posición anterior como ciencia fundamental para la comprensión del universo.",
                        "http://www.biblioteca.org.ar/libros/89799.pdf",
                        "PHIL",
                        0,
                        "https://image.ibb.co/juaEbT/phil3.png");


insert into Book values ("El mundo como voluntad y representación",
						
                        "El tratado se divide en cuatro libros más un apéndice con críticas a la filosofía kantiana, precedidos de un prólogo. El primer libro trata sobre teoría del conocimiento. Schopenhauer presenta en él una teoría rudimentaria y torpe si se compara con la kantiana. Kant calificaría de metafísica el contenido del segundo, el tercero trata sobre el arte y el cuarto sobre la ética. Nosotros nos ocuparemos únicamente de los dos primeros, y del prólogo, que tiene su morbo.",
                        "http://juango.es/files/Arthur-Schopenhauer---El-mundo-como-voluntad-y-representacion.pdf",
                        "PHIL",
                        0,
                        "https://image.ibb.co/dbQs0o/9788446003977.jpg");


insert into Book values ("Suma Teológica",
					
                        "La estructura de la Suma Teológica sigue la estructura de la realidad. Dios es el principio y comienzo. En esta primera parte se tratan las pruebas de la existencia divina, su esencia, su manera de actuar y a naturaleza de su trinidad. Tras esto se trata la creación y las criaturas, entre ellas el Hombre como criatura superior; pues esta creado a imagen y semejanza de Dios. Pasando después al retorno del hombre a Dios desde la religión y la moral.",
                        "https://www.dominicos.org/media/uploads/recursos/libros/suma/1.pdf",
                        "PHIL",
                        0,
                        "https://image.ibb.co/bWWMt8/61w9_VAg_GLBL.jpg");


insert into Book values ("La pimpinela escarlata",
						
                        "La que nos ocupa es una obra publicada en Londres en 1905, que trata -y es una de las primeras en hacerlo-, de un personaje mítico, un héroe salvador de vidas y luchador contra la injusticia, en este caso, la producida por el Terror revolucionario. Como en otras de este estilo, y me vienen a la mente Scaramouche, el Tulipán Negro, Dick Turpin, El Zorro, y otros héroes que, camuflados bajo un disfraz que despista respecto a su identidad, ponen todo su valor y esfuerzo, seguidos de bravos compañeros, en luchar contra los malvados y favorecer a los perseguidos injustamente.",
                        "http://10millibrosparadescargar.com/bibliotecavirtual/libros/LETRA%20O/Orczy,%20Baronesa%20de%20-%20La%20pimpinela%20escarlata.pdf",
                        "ADVE",
                        0,
                        "https://image.ibb.co/fOTHwT/adve1.png");


insert into Book values ("El castillo de Otranto",
						
                        "El castillo de Otranto, cuya acción se desarrolla en la Italia medieval, narra la historia del tirano Manfred, cuya estirpe arrastra una maldición desde que su abuelo usurpara el poder del castillo a sus legítimos poseedores. Manfred trata de perpetuar su herencia casando a su débil hijo Conrad con la princesa Isabella, pero poco antes de la boda ocurre un accidente fatal de origen aparentemente mágico que frustra sus designios. A partir de este suceso, se desencadenarán una serie de misteriosos fenómenos sobrenaturales y pasiones encendidas que tendrán como escenario el asfixiante y siniestro decorado del castillo, uno de los principales personajes del relato: puertas chirriantes, pasadizos oscuros y criptas secretas hacen su aparición por primera vez. Había nacido la literatura de terror.",
                        "https://www.biblioteca.org.ar/libros/154027.pdf",
                        "ADVE",
                        0,
                        "https://image.ibb.co/nhwMt8/9788420649351.jpg");


insert into Book values ("La isla del tesoro",
						
                        "Se trata de una auténtica novela de piratas, con pata de palo, lorito parlanchín, mapa de tesoro escondido, estribillo de canción, y bandera Jolly Roger ondeando al viento. Todos los ingredientes necesarios para una buena historia de este género.",
                        "https://www.getafe.es/wp-content/uploads/Stevenson-Robert-Louis-La-Isla-Del-Tesoro.pdf",
                        "ADVE",
                        0,
                        "https://image.ibb.co/jZrAmT/9788467028935.jpg");


insert into Book values ("Aventuras de Robinson Crusoe",
						
                        "Robinson Crusoe escrita por Daniel Defoe en 1719, es considerada la precursora de las novelas en Inglaterra. Sin embargo su verdadero nombre, que apareció en la portada de su primera edición, es el siguiente: La vida e increíbles aventuras de Robinson Crusoe, de York, marinero, quien vivió veintiocho años completamente solo en una isla deshabitada en las Costas de América, cerca de la Desembocadura del Gran Río Orinoco",
                        "http://www.biblioteca.org.ar/libros/133467.pdf",
                        "ADVE",
                        0,
                        "https://image.ibb.co/jFdO6T/I1_0_35_1_0_20080101042800.jpg");


insert into Book values ("De la Tierra a la Luna",
						
                        "Publicada en 1865, esta obra clave en la bibliografía de Julio Verne, introduce al lector en el mundo de la pasión y la admiración por al ciencia. Es una de sus novelas más conocidas y también es un ejemplo típico del tejido de fantasía y conocimientos que convirtieron a Verne en el fundador de una ciencia-ficción que la realidad se encargó de confirmar en gran parte.",
                        "http://www.biblioteca.org.ar/libros/656256.pdf",
                        "ADVE",
                        0,
                        "https://image.ibb.co/frfQLo/9788497866231.jpg");


insert into Book values ("Hamlet",
						
                        "Obra en la que el genio de William Shakespeare brilla con especial fuerza. La tragedia de Hamlet traza el admirable retrato de un legendario príncipe de Dinamarca soñador y contemplativo, sumido en dudas e irresoluciones, que, obligado a esclarecer los motivos que llevaron a la muerte de su padre, sucumbe ante la fatalidad de las circunstancias.",
                        "http://aix1.uottawa.ca/~jmruano/hamlet.ruano.trad.pdf",
                        "CLAS",
                        0,
                        "https://image.ibb.co/koNo38/clas1.png");


insert into Book values ("Otelo",
						
                        "La historia original del moro de Venecia, de Gianbattista Giraldi Cinthio (1565), sirvió a William Shakespeare para crear Otelo, la única de sus «grandes tragedias» basada en una obra de ficción. Contraviniendo la imagen isabelina del «moro», Shakespeare invierte los papeles de los protagonistas y otorga al moro Otelo el carácter de hombre noble y aristocrático, mientras que reserva para el italiano Yago la perversidad y la hipocresía",
                        "http://www.biblioteca.org.ar/libros/88741.pdf",
                        "CLAS",
                        0,
                        "https://image.ibb.co/hW14bT/clas2.png");


insert into Book values ("Macbeth",
						
                        "Compuesta entre 1605 y 1606, Macbeth es sin duda una de las cumbres de la producción de William Shakespeare. Concebida en el ambiente medieval escocés, la obra logra anclarse perfectamente a la realidad que busca representar, y de ahí la presencia de brujas, profecías, desenfrenadas ambiciones, traiciones, asesinatos ",
                        "http://www.biblioteca.org.ar/libros/133661.pdf",
                        "CLAS",
                        0,
                        "https://image.ibb.co/hhijbT/clas5.png");


insert into Book values ("Middlemarch",
						
                        "Yo por bien tengo que cosas tan señaladas, y por ventura nunca oídas ni vistas, vengan a noticia de muchos y no se entierren en la sepultura del olvido, pues podría ser que alguno que las lea halle algo que le agrade, y a los que no ahondaren tanto los deleite. Y a este propósito dice Plinio que no hay libro, por malo que sea, que no tenga alguna cosa buena; mayormente que los gustos no son todos unos, mas lo que uno no come, otro se pierde por ello.",
                        "http://www.biblioteca.org.ar/libros/131374.pdf",
                        "CLAS",
                        0,
                        "https://image.ibb.co/mWzCVo/clas3.png");


insert into Book values ("El grillo del hogar",
						
                        "En esta ocasión, con una estructura casi teatral, Dickens construye un cuento fantástico en el que un grillo se transmuta en sucesivas hadas. La historia se desarrolla en tres días y está dividida en tres cantos. El grillo, símbolo de la paz en los hogares humildes, es el eje del relato",
                        "http://www.biblioteca.org.ar/libros/89405.pdf",
                        "CLAS",
                        0,
                        "https://image.ibb.co/iSQKAo/clas4.png");

----fallo insert into Owners values ("Observe a su perro(gato)","http://www.librosmaravillosos.com/observeasugato/pdf/Observe%20a%20su%20gato%20-%20Desmond%20Morris.pdf","Desmond Morris");
insert into Owners values ("La práctica de la inteligencia emocional","https://training.crecimiento.ws/wp-content/uploads/2017/09/EBOOK_Daniel_Goleman_-_La_Practica_De_La_Inteligencia_Emocional.pdf","Daniel Goleman");
insert into Owners values ("El hombre que confundió a su mujer con un sombrero","http://mimosa.pntic.mec.es/~sferna18/EJERCICIOS/2013-14/Sacks_Oliver-El_Hombre_Que_Confundio_a_Su_Mujer_Con_Un_Sombrero.pdf","Oliver Sacks");
insert into Owners values ("Nuestra especie","http://www.proarhep.com.ar/wp-content/uploads/Harris_Marvin-Nuestra_especie.pdf","Marvin Harris");
insert into Owners values ("El heptameron","https://dialnet.unirioja.es/descarga/articulo/1150769.pdf","Margarita de Valois");
insert into Owners values ("Cosas que le pasan a una madre sin superpoderes","http://www.esferalibros.com/uploads/ficheros/libros/primeras-paginas/201304/primeras-paginas-paginas-del-libro_7-es.pdf","Ana Ribera García Rubio ");
insert into Owners values ("Apocalipsis para principiantes","http://www.siruela.com/archivos/fragmentos/Apocalipsis_para_principiantes.pdf","Nicolas Dickner");
insert into Owners values ("Un yanqui en la corte del rey arturo","http://www.librosmaravillosos.com/unyankienlacortedelreyarturo/pdf/Un%20yanqui%20en%20la%20corte%20del%20Rey%20Arturo%20-%20Mark%20Twain.pdf","Mark Twain");
insert into Owners values ("La importancia de llamarse Ernesto","http://bibliotecadigital.tamaulipas.gob.mx/archivos/descargas/31000001002.PDF","Oscar Wilde");
insert into Owners values ("Casi me olvido de ti","https://www.adnovelas.com/catalogos/capitulos_promocion/LN00002701_9999971721.pdf","Terry McMillan");
insert into Owners values ("La rebelión de los ángeles","http://bibliotecadigital.tamaulipas.gob.mx/archivos/descargas/31000000459.PDF","Anatole France");
insert into Owners values ("Mi dulce locura","http://librosonlineparaleer.com/wp-content/uploads/2017/02/Mi-Dulce-Locura-Serie-Mi-Locura-1-R.-Cherry.pdf","R Cherry");
insert into Owners values ("El psicoanalista","http://fundaciondhyana.weebly.com/uploads/3/0/0/8/30085277/el_psicoanalista.pdf","John Katzenbach");
insert into Owners values ("EL guardian entre el centeno","http://www.formarse.com.ar/libros/Libros-recomendados-pdf/El%20guardi%C3%A1n%20entre%20el%20centeno%20de%20J.%20D.%20Salinger%20-.pdf","J. D. Salinger");
insert into Owners values ("La bella y la bestia","http://cie.chron.com/pdfs/clubchron/Beauty_and_the_Beast_Spanish.pdf","Jeanne Marie");
insert into Owners values ("Ricitos de oro","https://www.pictocuentos.com/descargas/pdf-ricitos/pictocuentos-ricitos-de-oro.pdf","Pictocuentos");
insert into Owners values ("La fuerza de la gacela","https://pazuela.files.wordpress.com/2014/07/10-la-fuerza-de-la-gacela-texto.pdf","Panzuela");
insert into Owners values ("Quiero ser famosa","https://recursosparaelprofesor.files.wordpress.com/2018/04/quiero-ser-famosa-paloma-bordons.pdf","Paloma Bordons");
insert into Owners values ("Caperucita roja","https://www.pictocuentos.com/descargas/pdf-caperucita/pictocuentos-caperucita.pdf","Pictocuentos");
insert into Owners values ("Animales fantasticos y donde encontrarlos","http://salamandra.info/sites/default/files/books/previews/animales_fantasticos_y_donde_encontrarlos-1os_capitulos.pdf","J. K. Rowling");
insert into Owners values ("Harry Poter y la piedra filosofal","http://laprensadelazonaoeste.com/LIBROS/Letra.R/R/Rowling,%20J.K%20-%2001%20-%20Harry%20Potter%20y%20la%20Piedra%20Filos.pdf","J. K. Rowling");
insert into Owners values ("Harry Potter y la cámara secreta","http://www.alconet.com.ar/varios/libros/e-book_h/Harry_Potter_y_La_Camara_Secreta_02.pdf","J. K. Rowling");
insert into Owners values ("Harry Potter y el prisionero de Azkabán","http://www.alconet.com.ar/varios/libros/e-book_h/Harry_Potter_y_El_Prisionero_de_Azkaban_03.pdf","J. K. Rowling");
insert into Owners values ("Quidditch a través de los tiempos","http://www.nparangaricutiro.gob.mx/Libros/09.-%20Quidditch%20A%20Traves%20De%20Los%20Tiempos.pdf","J. K. Rowling");
insert into Owners values ("Los cuentos de Beedle el Bardo","http://salamandra.info/sites/default/files/books/previews/cuentos_beedle_el_bardo-1os_capitulos.pdf","J. K. Rowling");
insert into Owners values ("Lenin y el totalitarismo","https://bibliotecademauriciorojas.files.wordpress.com/2012/03/m-rojas-articulo-marx-lenin-y-el-totalitarismo-3-copia.pdf","Mauricio Rojas");
insert into Owners values ("Los mitos de la Guerra Civil","http://www.fundacionfaes.org/file_upload/publication/pdf/201304231418151934-comienza-la-guerra-civil-en-torno-al-libro-de-pio-moa.pdf","Pío Moa");
insert into Owners values ("Guerra Civil española","http://www.redalyc.org/pdf/3241/324127626006.pdf","Stanley G.Payne");
insert into Owners values ("La rebelión de las masas","http://juango.es/files/La-rebelion-de-las-masas.pdf","José Ortega y Gasset");
insert into Owners values ("El hundimiento del Castillo Olite","http://www.armada.mde.es/archivo/mardigitalrevistas/rhn/2009/2009106.pdf","Luis Miguel Pérez Adán");
insert into Owners values ("El prisma y el péndulo","https://www.primercapitulo.com/pdf/2016/1362-el-prisma-y-el-pendulo.pdf","Robert P. Crease");
insert into Owners values ("El origen del universo","http://www.universohawking.com/docs/El-gran-diseno-opusculo.pdf","Stephen Hawking");
insert into Owners values ("El tesoro cósmico","https://educalibre.info/wp-content/uploads/2018/03/El-tesoro-cosmico-Lucy-y-Stephen-Hawking.pdf","Stephen Hawking");
insert into Owners values ("La clave secreta del universo","https://educalibre.info/wp-content/uploads/2018/03/La-clave-secreta-del-universo-Lucy-y-Stephen-Hawking.pdf","Stephen Hawking");
insert into Owners values ("Desayuno con partículas","http://fernandez-vidal.com/inc/downloads/desayuno_con_particulas_cap1_es.pdf","Sonia Fernández Vidal");
insert into Owners values ("Patente de corso","https://archivos.juridicas.unam.mx/www/bjv/libros/1/154/7.pdf","Arturo Pérez Reverte");
insert into Owners values ("Con ánimo de ofender","http://www.perezreverte.com/upload/ficheros/libros/201304/con_animo_de_ofender.pdf","Arturo Pérez Reverte");
insert into Owners values ("Cuando éramos honrados mercenarios","http://www.perezreverte.com/upload/ficheros/libros/201001/cuando_ramos_honrados_mercenarios.pdf","Arturo Pérez Reverte");
insert into Owners values ("Lecciones de liderazgo","https://tlridnewscchoriente.files.wordpress.com/2016/01/steve-jobs-lecciones-de-liderazgo.pdf","Walter Isaacson");
----fallo insert into Owners values ("Fundamentos de economia","http://ru.iiec.unam.mx/2462/1/FundamentosDeEconomiaSecuenciaCorrecta.pdf","Federico Paniagua");
insert into Owners values ("El precio de la desigualdad","http://depa.fquim.unam.mx/amyd/archivero/EPreciodelaDesigualdad_27245.pdf","Joseph E. Stiglitz");
insert into Owners values ("Porque fracasan los países","https://federalismoygobernabilidad.files.wordpress.com/2015/11/acemoglu.pdf","Daron Acemoglu");
insert into Owners values ("La riqueza de las naciones","http://ceiphistorica.com/wp-content/uploads/2016/04/Smith-Adam-La-Riqueza-de-las-Naciones.pdf","Adam Smith");
insert into Owners values ("Economía Rosquilla","https://www.primercapitulo.com/pdf/2018/3688-economia-rosquilla.pdf","Kate Raworth");
insert into Owners values ("Metafisica","http://cmap.upb.edu.co/rid=1GM19TDTV-2QXBB0-V3Y/Aristoteles%20-%20Metafisica.pdf","Aristoteles");
insert into Owners values ("Meditaciones","http://www.nueva-acropolis.com/filiales/libros/Marco_Aurelio-Meditaciones.pdf","Marco Aurelio");
insert into Owners values ("Crítica de la razón pura","http://www.biblioteca.org.ar/libros/89799.pdf","Immanuel Kant");
insert into Owners values ("El mundo como voluntad y representación","http://juango.es/files/Arthur-Schopenhauer---El-mundo-como-voluntad-y-representacion.pdf","Arthur Schopenhauer");
insert into Owners values ("Suma Teológica","https://www.dominicos.org/media/uploads/recursos/libros/suma/1.pdf","Santo Tomas de Aquino");
insert into Owners values ("La pimpinela escarlata","http://10millibrosparadescargar.com/bibliotecavirtual/libros/LETRA%20O/Orczy,%20Baronesa%20de%20-%20La%20pimpinela%20escarlata.pdf","Baroness Emmuska Orczy");
insert into Owners values ("El castillo de Otranto","https://www.biblioteca.org.ar/libros/154027.pdf","Horace Walpole");
insert into Owners values ("La isla del tesoro","https://www.getafe.es/wp-content/uploads/Stevenson-Robert-Louis-La-Isla-Del-Tesoro.pdf","Robert L. Stevenson");
insert into Owners values ("Aventuras de Robinson Crusoe","http://www.biblioteca.org.ar/libros/133467.pdf","Daniel Defoe");
insert into Owners values ("De la Tierra a la Luna","http://www.biblioteca.org.ar/libros/656256.pdf","Julio Verne");
insert into Owners values ("Hamlet","http://aix1.uottawa.ca/~jmruano/hamlet.ruano.trad.pdf","William Shakespeare");
insert into Owners values ("Otelo","http://www.biblioteca.org.ar/libros/88741.pdf","William Shakespeare");

insert into Owners values ("Macbeth","http://www.biblioteca.org.ar/libros/133661.pdf","William Shakespeare");
insert into Owners values ("Middlemarch","http://www.biblioteca.org.ar/libros/131374.pdf","George Eliot");
insert into Owners values ("El grillo del hogar","http://www.biblioteca.org.ar/libros/89405.pdf","Charles Dickens");