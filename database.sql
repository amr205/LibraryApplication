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
					constraint UserBPK primary key (Uname,Upassword),
                    constraint UserFK1 foreign key (UPictureID) references UserImage (ImageID));

create table Book (Name varchar(120) not null,
				   Review varchar(1000),
				   Link varchar(500),
				   Cat varchar(4) not null,
				   Calif float,
				   Cover varchar(500),
				   constraint BookPK primary key (Name, Link),
				   constraint BookFK1 foreign key (Cat) references Category (CveCat));

create table RBook (RName varchar(120) not null,
                    RLink varchar(500) not null,
				    RReview varchar(1000),
					RCat varchar(4) not null,
					RUname varchar(15) not null,
                    RUpassword varchar(15) not null,
					RCover varchar(500),
                    RCalif float,
					constraint RBookPK primary key (RName,RLink),
					constraint RBookFK1 foreign key (RCat) references Category(CveCat),
					constraint RBookFK2 foreign key (RUname,RUpassword) references UserB(Uname,Upassword));


create table Favorites(FUName varchar(15) not null,
                       FUPassword varchar(15) not null,
					   FName varchar(120) not null,
                       FLink varchar(500) not null,
					   constraint FavoritesPK primary key (FUname,FUpassword,FName,FLink),
					   constraint FavoritesFK1 foreign key (FUName,FUPassword) references UserB(UName,UPassword),
					   constraint FavoritesFK2 foreign key (FName,FLink) references Book(Name,Link));

create table Ranking(GUName varchar(15) not null,
                     GUPassword varchar(15) not null,
					 GName varchar(120) not null,
                     GLink varchar(500) not null,
                     GCalif smallint not null,
					 constraint RankingPK primary key (GUname,GUpassword,GName,GLink),
					 constraint RankingFK1 foreign key (GUName,GUPassword) references UserB(UName,UPassword),
					 constraint RankingFK2 foreign key (GName,GLink) references Book(Name,Link));


create table History(HUName varchar(15) not null,
                      HUPassword varchar(15) not null,
					  HName varchar(120) not null,
                      HLink varchar(500) not null,
					  HDate Date,
					  constraint HistoryPK primary key (HUname,HUpassword,HName,HLink),
					  constraint HistoryFK1 foreign key (HUName,HUPassword) references UserB(UName,UPassword),
					  constraint HistoryFK2 foreign key (HName,HLink) references Book(Name,Link));
                      
                      
create table Comments(CUName varchar(15) not null,
                      CUPassword varchar(15) not null,
					  CName varchar(120) not null,
                      CLink varchar(500) not null,
					  COpinion varchar(200) not null,
					  constraint CommentsPK primary key (CUName,CUPassword,CName,CLink,COpinion),
					  constraint CommentsFK1 foreign key (CUName,CUPassword) references UserB(UName,UPassword),
					  constraint CommentsFK2 foreign key (CName,CLink) references Book(Name,Link));

create table Autor(AName varchar(50) not null,
				   ABirthDate date,
                   ACveCountry varchar(3) not null,
                   constraint AutorPK primary key (AName),
                   constraint AutorFK1 foreign key (ACveCountry) references Country(CveCountry));
                   
                   

create table Owners(OName varchar (120) not null,
			        OLink varchar (500) not null,
                    OAName varchar(50) not null,
                    constraint OwnersPK primary key (OName,OLink,OAName),
                    constraint OwnersFK1 foreign key (OName,OLink) references Book (Name,Link),
                    constraint OwnersFK2 foreign key (OAName) references Autor(AName));

create table ROwners(ROName varchar (120) not null,
			         ROLink varchar (500) not null,
                     ROAName varchar(50) not null,
                     constraint ROwnersPK primary key (ROName,ROLink,ROAName),
                     constraint ROwnersFK1 foreign key (ROName,ROLink) references RBook (RName,RLink));
                     
