create database Trasporte
go

use Trasporte
go
-- Table: Bus
CREATE TABLE Bus (
    idbus int identity(1,1),
    PlacaBus varchar(7),
    AsientBus int,
    MarcaBus varchar(10),
    EstaBus char(1),
    CONSTRAINT Bus_pk PRIMARY KEY  (idbus)
);
go
-- Table: Cliente
CREATE TABLE Cliente (
    idClie int identity(1,1),
    NomCli varchar(50),
    ApelliCli varchar(50),
    TipoDoc varchar(3),
    NumDoc varchar(9),
    FecViaje date,
    HoraviaCli time,
    TipoServi varchar(3),
    PrecioViaCli varchar(6),
    CONSTRAINT Cliente_pk PRIMARY KEY  (idClie)
);
go
-- Table: DetalleBoleto
CREATE TABLE DetalleBoleto (
    Bus_idbus int identity(1,1),
    Rutas_idrutas int,
    Cliente_idClie int,
    CONSTRAINT DetalleBoleto_pk PRIMARY KEY  (Bus_idbus)
);
go
-- Table: Personal
CREATE TABLE Personal (
    idper int identity(1,1),
    NomPer varchar(100),
    ApePer varchar(100),
    TipDoc char(3),
    NumDoc varchar(9),
    SexPer char(1),
    FecNacPer date,
    CelularPer varchar(9),
    DirecPer varchar(100),
    TipoPer varchar(10),
    EstaPer char(1),
    Bus_idbus int,
    CONSTRAINT Personal_pk PRIMARY KEY  (idper)
);
go
-- Table: Rutas
CREATE TABLE Rutas (
    idrutas int identity(1,1),
    NomRut varchar(50),
    EstRut char(1),
    CONSTRAINT Rutas_pk PRIMARY KEY  (idrutas)
);
go
insert into Cliente(NomCli,ApelliCli,TipoDoc,NumDoc,FecViaje,HoraviaCli,TipoServi,PrecioViaCli)values
('Yosemir','Lermo','DNI','9087365','12-12-2018','12:20','VIP','12.80')

select * from Cliente

