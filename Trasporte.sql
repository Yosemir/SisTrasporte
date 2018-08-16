create database Trasporte
go

use Trasporte
go

CREATE TABLE Bus (
    idbus int identity(1,1) ,
    PlacaBus varchar(7)  ,
    AsientBus int  ,
    MarcaBus varchar(10)  ,
    EstaBus char(1)  ,
    CONSTRAINT Bus_pk PRIMARY KEY  (idbus)
);
go
-- Table: Cliente
CREATE TABLE Cliente (
    idClie int  ,
    NomCli varchar(50)  ,
    ApelliCli varchar(50)  ,
    TipoDoc char(3)  ,
    NumDoc varchar(9)  ,
    FecViaje date  ,
    TipoServi char(3)  ,
    CONSTRAINT Cliente_pk PRIMARY KEY  (idClie)
);
go
-- Table: DetalleBoleto
CREATE TABLE DetalleBoleto (
    Bus_idbus int  identity(1,1),
    Rutas_idrutas int  ,
    Cliente_idClie int  ,
    Precio int  ,
    CONSTRAINT DetalleBoleto_pk PRIMARY KEY  (Bus_idbus)
);
go
-- Table: Personal
CREATE TABLE Personal (
    idper int  identity(1,1),
    NomPer varchar(100)  ,
    ApePer varchar(100)  ,
    TipDoc char(3)  ,
    NumDoc varchar(9)  ,
    SexPer char(1)  ,
    FecNacPer date  ,
    CelularPer varchar(9)  ,
    DirecPer varchar(100)  ,
    TipoPer varchar(10)  ,
    EstaPer char(1)  ,
    Bus_idbus int  ,
    CONSTRAINT Personal_pk PRIMARY KEY  (idper)
);
go
-- Table: Rutas
CREATE TABLE Rutas (
    idrutas int  identity(1,1),
    NomRut varchar(50)  ,
    EstRut char(1)  ,
    CONSTRAINT Rutas_pk PRIMARY KEY  (idrutas)
);
go


insert into Rutas (NomRut,EstRut)values('Lima-Cañete','A')

