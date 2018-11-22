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

insert into AppUser values(1, 'einsUser', 'einsPassword');
insert into AppUser values(2, 'zweiUser', 'zweiPassword');
insert into AppUser values(3, 'dreiUser', 'dreiPassword');
insert into AppUser values(4, 'vierUser', 'vierPassword');
insert into AppUser values(5, 'fuenfUser', 'fuenfPassword');

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

insert into Concert values (1,1,'RIP Ufo361');
insert into Concert values (2,2,'Nur noch Gucci');
insert into Concert values (3,3,'Unwichtig');
insert into Concert values (4,4,'Bla Bla');
insert into Concert values (5,5,'Bleampe Tour');

insert into ConcertLocation values (1, 9500, 'Austria', 'Villach', 'Muldenweg 20');
insert into ConcertLocation values (2, 9241, 'Austria', 'Wernberg', 'Wasenweg 2');
insert into ConcertLocation values (3, 1220, 'Austria', 'Wien', 'Kärntner Straße 4');
insert into ConcertLocation values (4, 9020, 'Austria', 'Klagenfurt', 'Südring 6');
insert into ConcertLocation values (5, 9500, 'Austria', 'Villach', 'Tschinowitscherweg 2');

insert into Takes_Place values (1,1);
insert into Takes_Place values (2,2);
insert into Takes_Place values (3,3);
insert into Takes_Place values (4,4);
insert into Takes_Place values (5,5);