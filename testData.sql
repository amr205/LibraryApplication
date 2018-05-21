use Bookstore;
insert into UserImage (ImageID, ImageDesc)
		values (1,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (2,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (3,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (4,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (5,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (6,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (7,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (8,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (9,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');
        
insert into UserImage (ImageID, ImageDesc)
		values (10,'https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100');

insert into UserB (UName, UPassword, UNameCo, UEmail, UDate, UType, UPictureID) 
		values ('admin','Cookies','Administrador Universal','alejandromedinamx@gmail.com','1998-02-05','A',1);

insert into Category values ("comc","comic books");

insert into Category values ("gggg","gggg books");


insert into Book values ("Drawing Cartoons and Comics For Dummies",
						"Brian Farrington",
                        "A unique reference for creating and marketing original cartoons and comics An original American art form, comics thrill millions of people across the globe. Combining step-by-step instruction with expert tips and advice, Drawing Cartoons & Comics For Dummies is a one-stop reference for creating and marketing original cartoons and comics. While many books tend to focus on specific characters or themes, this thorough guide focuses instead on helping aspiring artists master ... ",
                        "http://cache.pdfdrive.com/dl.php?id=10783856&h=6e2fddac442a0ce0fb4f3eeb677715b5&u=cache",
                        "comc",
                        0,
                        "https://s.pdfdrive.com/assets/thumbs/0a6/0a651ad3962e9c34fef58a56e9001f16.jpg");
                        
insert into Book values ("fff",
						"dd ff",
                        "ffle across the globe. Combining step-by-step instruction with expert tips and advice, Drawing Cartoons & Comics For Dummies is a one-stop reference for creating and marketing original cartoons and comics. While many books tend to focus on specific characters or themes, this thorough guide focuses instead on helping aspiring artists master ... ",
                        "http://cache.pdfdrive.com/dl.php?id=107838f2fddac442a0ce0fb4f3eeb677715b5&u=cache",
                        "gggg",
                        0,
                        "https://books.google.com.mx/books/content?id=kRuxDAAAQBAJ&printsec=frontcover&img=1&zoom=1&imgtk=AFLRE72QvwYiv0Zg_J8rizmTMKuXM6PnFvj7agV-4w201MlFESz5hrllkVmLEY1GrBSBfWrieiUi6fsHg-kq3ejh4KMnLgsxLlY3oRUTiInSbSfF-C2ICDngVpXbNCsSguHd37rSCG9v");

select * from UserB u inner join UserImage i on u.UPictureID = i.ImageID where UName = 'admin' and UPassword = 'Cookies';

update UserB set  UNameCo = ?, UEmail = ?, UDate = ?, UType = ?, UPictureID = ? where UName = ? and UPassword = ?;

update UserB set UNameCo = 'admin pro scope 360', UEmail = 'no email', UDate = '1998-02-05', UType = 'A', UPictureID = 1 where UName = 'admin' and UPassword = 'Cookies';update UserB set UName = 'admin2', UPassword = 'Cookies', UNameCo = 'admin pro scope 360', UEmail = 'no email', UDate = '1998-03-05', UType = 'A', UPictureID = 1 where UName = 'admin' and UPassword = 'Cookies';