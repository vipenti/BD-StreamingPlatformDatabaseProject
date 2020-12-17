create schema StreamingPlatform;
use StreamingPlatform;

create table AccountUser
(
	username varchar(50) PRIMARY KEY NOT NULL,
    nome varchar(50) NOT NULL,
    cognome varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    passw varchar(50) NOT NULL,
    dataNascita date,
    nazionalita varchar(50) NOT NULL
);


create table Streamer
(
	username varchar(50) NOT NULL,
    visualizzazioniTotali int NOT NULL,
    PRIMARY KEY(username),
    FOREIGN KEY(username) REFERENCES AccountUser(username) ON UPDATE cascade ON DELETE cascade
);

create table Viewer
(
	username varchar(50)NOT NULL,
    oreGuardate int NOT NULL,
    PRIMARY KEY(username),
    FOREIGN KEY(username) REFERENCES AccountUser(username) ON UPDATE cascade ON DELETE cascade
);

create table Sponsor
(
	nome varchar(50) PRIMARY KEY NOT NULL,
    partitaIva varchar(11) NOT NULL,
    percentualeTrattenuta int NOT NULL
);

create table Categoria 
(
	nome varchar(50) PRIMARY KEY NOT NULL,
    descrizione varchar(255) NOT NULL
);

create table Stream
(
	urlStream varchar(50) PRIMARY KEY NOT NULL,
    nome varchar(50) NOT NULL,
    durata int NOT NULL,
    lingua varchar(50) NOT NULL,
    usernameStreamer varchar(50) NOT NULL,
    nomecategoria varchar(50) NOT NULL,
    FOREIGN KEY(nomecategoria) REFERENCES Categoria(nome) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(usernameStreamer) REFERENCES Streamer(username) ON UPDATE cascade ON DELETE cascade
);
    
create table Prodotto
(
	codice varchar(5) PRIMARY KEY NOT NULL,
    nomeProdotto varchar(50) NOT NULL,
    nomeSponsor varchar(50) NOT NULL,
    FOREIGN KEY(nomeSponsor) REFERENCES Sponsor(nome) ON UPDATE cascade ON DELETE cascade
);

create table Sponsorizza
(
	nomeSponsor varchar(50) NOT NULL,
    usernameStreamer varchar(50) NOT NULL,
    importo int NOT NULL,
    PRIMARY KEY(nomeSponsor,usernameStreamer),
    FOREIGN KEY(nomeSponsor) REFERENCES Sponsor(nome) ON UPDATE cascade ON DELETE cascade, 
    FOREIGN KEY(usernameStreamer) REFERENCES Streamer(username) ON UPDATE cascade ON DELETE cascade
);

create table MessaggioInChat
(
	codice int PRIMARY KEY NOT NULL,
    testo varchar(500) NOT NULL,
    minutoInvio int NOT NULL,
    username varchar(50) NOT NULL,
    urlStream varchar(50) NOT NULL,
    FOREIGN KEY(username) REFERENCES AccountUser(username) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(urlStream) REFERENCES Stream(urlStream) ON UPDATE cascade ON DELETE cascade
);


create table Moderatore 
(
	username varchar(50) PRIMARY KEY NOT NULL,
    nome varchar(50) NOT NULL,
    cognome varchar(50) NOT NULL,
    valutazione enum('1','2','3','4','5') NOT NULL
);

create table ModeratoDa
(
	usernameModeratore varchar(50) NOT NULL,
    urlStream varchar(50) NOT NULL,
    PRIMARY KEY(usernameModeratore,urlStream),
    FOREIGN KEY (urlStream) REFERENCES Stream(urlStream) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY (usernameModeratore) REFERENCES Moderatore(username) ON UPDATE cascade ON DELETE cascade
);

create table Clip 
(
	username varchar(50) NOT NULL,
    nome varchar(100) NOT NULL,
    durata int NOT NULL,
    urlStream varchar(50) NOT NULL,
    PRIMARY KEY(urlStream,nome),
    FOREIGN KEY(username) REFERENCES Viewer(username) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(urlStream) REFERENCES Stream(urlStream) ON UPDATE cascade ON DELETE cascade
);

    
-- script per drop
-- drop schema StreamingPlatform;
   
