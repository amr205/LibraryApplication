create database Bookstore;
use Bookstore;

create table Country(CveCountry varchar(3) not null,
					 DescCountry varchar(25),
                     constraint CountryPK primary key (CveCountry));

create table Category (CveCat varchar(4) not null,
                       DescCat varchar(20),
					   constraint CategoryPK primary key (CveCat));

create table UserImage (ImageID smallint not null,
						ImageDesc varchar(300) not null,
                        constraint UserImagePK primary key (ImageID));

create table UserB (UName varchar(15) not null,
                    UPassword varchar(15) not null,
					UNameCo varchar(100),
					UEmail varchar(200),
					UDate Date,
					UType varchar(1),
					UPictureID smallint,
					constraint UserBPK primary key (Uname),
          constraint UserFK1 foreign key (UPictureID) references UserImage (ImageID));

create table Book (Name varchar(120) not null,
				   Review varchar(1000),
				   Link varchar(500),
				   Cat varchar(4) not null,
				   Calif float,
				   Cover varchar(500),
				   constraint BookPK primary key (Name),
				   constraint BookFK1 foreign key (Cat) references Category (CveCat));

create table RBook (RName varchar(120) not null,
                    RLink varchar(500) not null,
				    RReview varchar(1000),
					RCat varchar(4) not null,
					RUname varchar(15) not null,
					RCover varchar(500),
                    RCalif float,
					constraint RBookPK primary key (RName),
					constraint RBookFK1 foreign key (RCat) references Category(CveCat),
					constraint RBookFK2 foreign key (RUname) references UserB(Uname));


create table Favorites(FUName varchar(15) not null,
					   FName varchar(120) not null,
					   constraint FavoritesPK primary key (FUname,FName),
					   constraint FavoritesFK1 foreign key (FUName) references UserB(UName),
					   constraint FavoritesFK2 foreign key (FName) references Book(Name));

create table Ranking(GUName varchar(15) not null,
					 GName varchar(120) not null,
                     GCalif smallint not null,
					 constraint RankingPK primary key (GUname,GName),
					 constraint RankingFK1 foreign key (GUName) references UserB(UName),
					 constraint RankingFK2 foreign key (GName) references Book(Name));


create table History(HUName varchar(15) not null,
					  HName varchar(120) not null,
					  HDate Date,
					  constraint HistoryPK primary key (HUname,HName),
					  constraint HistoryFK1 foreign key (HUName) references UserB(UName),
					  constraint HistoryFK2 foreign key (HName) references Book(Name));


create table Comments(CUName varchar(15) not null,
					  CName varchar(120) not null,
					  COpinion varchar(200) not null,
					  constraint CommentsPK primary key (CUName,CName,COpinion),
					  constraint CommentsFK1 foreign key (CUName) references UserB(UName),
					  constraint CommentsFK2 foreign key (CName) references Book(Name));

create table Autor(AName varchar(50) not null,
				   ABirthDate date,
                   ACveCountry varchar(3) not null,
                   constraint AutorPK primary key (AName),
                   constraint AutorFK1 foreign key (ACveCountry) references Country(CveCountry));

create table Owners(OName varchar (120) not null,
                    OAName varchar(50) not null,
                    constraint OwnersPK primary key (OName,OAName),
                    constraint OwnersFK1 foreign key (OName) references Book (Name),
                    constraint OwnersFK2 foreign key (OAName) references Autor(AName));

create table ROwners(ROName varchar (120) not null,
                     ROAName varchar(50) not null,
                     constraint ROwnersPK primary key (ROName,ROAName),
                     constraint ROwnersFK1 foreign key (ROName) references RBook (RName));

CREATE VIEW user_v AS SELECT * FROM UserB where UName = USER();

CREATE USER 'guest@localhost' IDENTIFIED BY '123';
GRANT SELECT ON Bookstore.* TO 'guest@localhost';
GRANT INSERT, SELECT ON Bookstore.UserB TO 'guest@localhost';

CREATE ROLE 'usuarios', 'administradores';
GRANT ALL ON Bookstore.* TO 'administradores';
GRANT SELECT ON Bookstore.* TO 'usuarios';
GRANT INSERT ON Bookstore.RBook TO 'usuarios';
GRANT INSERT ON Bookstore.Comments TO 'usuarios';
GRANT INSERT ON Bookstore.History TO 'usuarios';
GRANT INSERT, DELETE ON Bookstore.Favorites TO 'usuarios';
GRANT INSERT, UPDATE ON Bookstore.Ranking TO 'usuarios';
GRANT UPDATE ON Bookstore.user_v TO 'usuarios';

CREATE TRIGGER create_user AFTER INSERT ON UserB
FOR EACH ROW
BEGIN
	CREATE USER NEW.UName@'localhost' IDENTIFIED BY NEW.UPassword;
	GRANT 'usuarios' TO NEW.UName@'localhost';
END;//


CREATE TRIGGER update_user_password AFTER UPDATE ON user_v
FOR EACH ROW
BEGIN
	SET PASSWORD = NEW.UPassword;
END;//


CREATE TRIGGER update_ranking AFTER INSERT ON Ranking
FOR EACH ROW
BEGIN
	UPDATE Book
		SET Calif = (SELECT AVG(GCalif) FROM Ranking WHERE GName = NEW.GName)
		WHERE Name = NEW.GName;
END;//


CREATE TRIGGER update_ranking AFTER UPDATE ON Ranking
FOR EACH ROW
BEGIN
	UPDATE Book
		SET Calif = (SELECT AVG(GCalif) FROM Ranking WHERE GName = NEW.GName)
		WHERE Name = NEW.GName;
END;//
