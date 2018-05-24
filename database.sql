create database Bookstore;
use Bookstore;

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
					constraint UserBPK primary key (Uname,Upassword),
                    constraint UserFK1 foreign key (UPictureID) references UserImage (ImageID));

create table Book (Name varchar(120) not null,
                   Autor varchar(100) not null,
				   Review varchar(1000),
				   Link varchar(500),
				   Cat varchar(4) not null,
				   Calif float,
				   Cover varchar(500),
				   constraint BookPK primary key (Name,Autor),
				   constraint BookFK1 foreign key (Cat) references Category (CveCat));

create table RBook (RName varchar(120) not null,
                    RAutor varchar(100) not null,
				    RReview varchar(1000),
				    RLink varchar(500),
					RCat varchar(4) not null,
					RUname varchar(15) not null,
                    RUpassword varchar(15) not null,
					RCover varchar(500),
					constraint RBookPK primary key (RName,RAutor),
					constraint RBookFK1 foreign key (RCat) references Category(CveCat),
					constraint RBookFK2 foreign key (RUname,RUpassword) references UserB(Uname,Upassword));


create table Favorites(FUName varchar(15) not null,
                       FUPassword varchar(15) not null,
					   FName varchar(120) not null,
                       FAutor varchar(100) not null,
					   constraint FavoritesPK primary key (FUname,FUpassword,FName,FAutor),
					   constraint FavoritesFK1 foreign key (FUName,FUPassword) references UserB(UName,UPassword),
					   constraint FavoritesFK2 foreign key (FName,FAutor) references Book(Name,Autor));

create table Ranking(GUName varchar(15) not null,
                     GUPassword varchar(15) not null,
					 GName varchar(120) not null,
                     GAutor varchar(100) not null,
                     GCalif smallint not null,
					 constraint RankingPK primary key (GUname,GUpassword,GName,GAutor),
					 constraint RankingFK1 foreign key (GUName,GUPassword) references UserB(UName,UPassword),
					 constraint RankingFK2 foreign key (GName,GAutor) references Book(Name,Autor));


create table History(HUName varchar(15) not null,
                      HUPassword varchar(15) not null,
					  HName varchar(120) not null,
                      HAutor varchar(100) not null,
					  HDate Date,
					  constraint HistoryPK primary key (HUname,HUpassword,HName,HAutor),
					  constraint HistoryFK1 foreign key (HUName,HUPassword) references UserB(UName,UPassword),
					  constraint HistoryFK2 foreign key (HName,HAutor) references Book(Name,Autor));
                      

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

insert into Category values ("class","Classics");

insert into Category values ("kids","Kids");