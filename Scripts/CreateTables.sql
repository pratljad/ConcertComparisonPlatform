drop table Artist cascade constraints;
drop table Genre cascade constraints;
drop table AppUser cascade constraints;
drop table Favourites cascade constraints;
drop table Affilation cascade constraints;
drop table Concert cascade constraints;
drop table ConcertLocation cascade constraints;
drop table Takes_Place cascade constraints;

create table Artist (
    AID int primary key,
    AName varchar2(50)
);

create table Genre (
    GID int primary key,
    Description varchar2(500)
);

create table AppUser (
    UserID int primary key,
    Username varchar2(50),
    UPassword varchar2(50)
);

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
    CID int primary key,
    AID int,
    Description varchar2(500),
    foreign key (AID) references Artist(AID)
);

create table ConcertLocation (
    CLID int primary key,
    PLZ int,
    Country varchar2(50),
    City varchar2(50),
    Adress varchar2(50)
);

create table Takes_Place (
    CID int,
    CLID int,
    primary key (CID, CLID),
    foreign key (CID) references Concert(CID),
    foreign key (CLID) references ConcertLocation(CLID)
);

insert into Artist values (1, 'UFO361');
insert into Artist values (2, 'Capital Bra');
insert into Artist values (3, 'Drake');
insert into Artist values (4, 'Trettmann');
insert into Artist values (5, 'Gzuz');

insert into Genre values (1, 'Pop');
insert into Genre values (2, 'Rap');
insert into Genre values (3, 'Jazz');
insert into Genre values (4, 'Rock');
insert into Genre values (5, 'Klassik');



