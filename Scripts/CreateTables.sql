--drop tabless
drop table Artist cascade constraints;
drop table Genre cascade constraints;
drop table AppUser cascade constraints;
drop table Favourites cascade constraints;
drop table Affilation cascade constraints;
drop table Concert cascade constraints;
drop table ConcertLocation cascade constraints;
drop table Takes_Place cascade constraints;

--drop sequences
DROP SEQUENCE artist_seq;
DROP SEQUENCE genre_seq;
DROP SEQUENCE appUser_seq;
DROP SEQUENCE concert_seq;
DROP SEQUENCE concertLocation_seq;

--create tables
create table Artist (
    AID NUMBER(10) ,
    AName varchar2(50)
);
ALTER TABLE Artist ADD (
CONSTRAINT art_pk PRIMARY KEY (AID));

create table Genre (
    GID int,
    Description varchar2(500)
);
ALTER TABLE Genre ADD (
CONSTRAINT genre_pk PRIMARY KEY (GID));

create table AppUser (
    UserID int,
    Username varchar2(50),
    UPassword varchar2(50)
);
ALTER TABLE AppUser ADD (
CONSTRAINT appUser_pk PRIMARY KEY (UserID));

create table Favourites (
    UserID int,
    AID int,
    primary key (UserID, AID),
    foreign key (UserID) references AppUser(UserID),
    foreign key (AID) references Artist(AID)
);

create table Affilation (
    AID int,
    GID int,
    primary key (AID, GID),
    foreign key (GID) references Genre(GID),
    foreign key (AID) references Artist(AID)
);

create table Concert (
    CID int,
    AID int,
    ConcertDate date,
    Description varchar2(500),
    foreign key (AID) references Artist(AID)
);
ALTER TABLE Concert ADD (
CONSTRAINT concert_pk PRIMARY KEY (CID));

create table ConcertLocation (
    CLID int,
    PLZ int,
    Country varchar2(50),
    City varchar2(50),
    Adress varchar2(50)
);
ALTER TABLE ConcertLocation ADD (
CONSTRAINT concertLocation_pk PRIMARY KEY (CLID));

create table Takes_Place (
    CID int,
    CLID int,
    primary key (CID, CLID),
    foreign key (CID) references Concert(CID),
    foreign key (CLID) references ConcertLocation(CLID)
);

--create sequences
CREATE SEQUENCE artist_seq START WITH 1;
CREATE SEQUENCE genre_seq START WITH 1;
CREATE SEQUENCE appUser_seq START WITH 1;
CREATE SEQUENCE concert_seq START WITH 1;
CREATE SEQUENCE concertLocation_seq START WITH 1;

--Trigger
CREATE OR REPLACE TRIGGER ART_AI 
BEFORE INSERT ON Artist 
FOR EACH ROW
BEGIN
  SELECT artist_seq.NEXTVAL
  INTO   :new.aid
  FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER Genre_Trig 
BEFORE INSERT ON Genre 
FOR EACH ROW
BEGIN
  SELECT genre_seq.NEXTVAL
  INTO   :new.gid
  FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER AppUser_Trig 
BEFORE INSERT ON AppUser 
FOR EACH ROW
BEGIN
  SELECT appUser_seq.NEXTVAL
  INTO   :new.userid
  FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER Concert_Trig 
BEFORE INSERT ON Concert 
FOR EACH ROW
BEGIN
  SELECT concert_seq.NEXTVAL
  INTO   :new.cid
  FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER ConcertLocation_Trig 
BEFORE INSERT ON ConcertLocation 
FOR EACH ROW
BEGIN
  SELECT concertLocation_seq.NEXTVAL
  INTO   :new.clid
  FROM   dual;
END;
/



--Inserts
insert into Artist values (-1, 'UFO361');
insert into Artist values (-1, 'Capital Bra');
insert into Artist values (-1, 'Drake');
insert into Artist values (-1, 'Trettmann');
insert into Artist values (-1, 'Gzuz');

insert into Genre values (-1, 'Pop');
insert into Genre values (-1, 'Rap');
insert into Genre values (-1, 'Jazz');
insert into Genre values (-1, 'Rock');
insert into Genre values (-1, 'Klassik');

insert into AppUser values(-1, 'einsUser', 'einsPassword');
insert into AppUser values(-1, 'zweiUser', 'zweiPassword');
insert into AppUser values(-1, 'dreiUser', 'dreiPassword');
insert into AppUser values(-1, 'vierUser', 'vierPassword');
insert into AppUser values(-1, 'fuenfUser', 'fuenfPassword');

insert into Favourites values (1,1);
insert into Favourites values (2,2);
insert into Favourites values (3,3);
insert into Favourites values (4,4);
insert into Favourites values (5,5);

insert into Affilation values (1,1);
insert into Affilation values (2,2);
insert into Affilation values (3,3);
insert into Affilation values (4,4);
insert into Affilation values (5,5);

insert into Concert values (-1,1, TO_DATE('01.01-2018','DD.MM.YYYY'),'RIP Ufo361');
insert into Concert values (-1,2, TO_DATE('04.02.2018','DD.MM.YYYY'), 'Nur noch Gucci');
insert into Concert values (-1,3, TO_DATE('05.03.2018','DD.MM.YYYY'),'Unwichtig');
insert into Concert values (-1,4,TO_DATE('12.05.2018','DD.MM.YYYY'), 'Bla Bla');
insert into Concert values (-1,5,TO_DATE('21.06.2018','DD.MM.YYYY'),'Bleampe Tour');

insert into ConcertLocation values (-1, 9500, 'Austria', 'Villach', 'Muldenweg 20');
insert into ConcertLocation values (-1, 9241, 'Austria', 'Wernberg', 'Wasenweg 2');
insert into ConcertLocation values (-1, 1220, 'Austria', 'Wien', 'Kärntner Straße 4');
insert into ConcertLocation values (-1, 9020, 'Austria', 'Klagenfurt', 'Südring 6');
insert into ConcertLocation values (-1, 9500, 'Austria', 'Villach', 'Tschinowitscherweg 2');

insert into Takes_Place values (1,1);
insert into Takes_Place values (2,2);
insert into Takes_Place values (3,3);
insert into Takes_Place values (4,4);
insert into Takes_Place values (5,5);


commit;
