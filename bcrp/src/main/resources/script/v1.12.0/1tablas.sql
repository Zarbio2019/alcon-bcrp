
  CREATE TABLE "PCBCRP"."CFG_POSRF" 
   ("ID" VARCHAR2(255 BYTE), 
	"CARTERA" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"CLASE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"DIVISA" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"CUENTA" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"IMPORTE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CODIGOESTADO" NUMBER(10,0), 
	"ACTUALIZADO_POR" VARCHAR2(255 BYTE), 
	"CREADO_POR" VARCHAR2(255 BYTE), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
	 CONSTRAINT "CFG_POSRF_PK" PRIMARY KEY ("ID")
	);
	
	CREATE TABLE "PCBCRP"."CFG_POSRV" 
   ("ID" VARCHAR2(255 BYTE), 
	"CARTERA" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"CLASE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"DIVISA" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"IMPORTE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CUENTA" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CODIGOESTADO" NUMBER(10,0), 
	"ACTUALIZADO_POR" VARCHAR2(255 BYTE), 
	"CREADO_POR" VARCHAR2(255 BYTE), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
	 CONSTRAINT "CFG_POSRV_PK" PRIMARY KEY ("ID")
   ) ;
   
   
  CREATE TABLE "PCBCRP"."CFG_RCD02" 
   ("ID" VARCHAR2(255 BYTE), 
	"FILAINICIO" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"FILAFIN" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"DIVISA" VARCHAR2(15 BYTE) NOT NULL ENABLE, 
	"CUENTA" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CODIGOESTADO" NUMBER(10,0), 
	"ACTUALIZADO_POR" VARCHAR2(255 BYTE), 
	"CREADO_POR" VARCHAR2(255 BYTE), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
	 CONSTRAINT "CFG_RCD02_PK" PRIMARY KEY ("ID")
   ) ;

    
  CREATE TABLE "PCBCRP"."CFG_RCD07" 
   (	"ID" VARCHAR2(255 BYTE), 
	"FILAINICIO" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"FILAFIN" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"DIVISA" VARCHAR2(15 BYTE) NOT NULL ENABLE, 
	"CUENTA" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CODIGOESTADO" NUMBER(10,0), 
	"ACTUALIZADO_POR" VARCHAR2(255 BYTE), 
	"CREADO_POR" VARCHAR2(255 BYTE), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
	 CONSTRAINT "CFG_RCD07_PK" PRIMARY KEY ("ID")
   )  ;
   
   
  CREATE TABLE "PCBCRP"."CFG_SPEFRAIR" 
   (	"ID" VARCHAR2(255 BYTE), 
	"SUBPRODUCTO" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
	"OPERACION" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"DIVISA" VARCHAR2(25 BYTE) NOT NULL ENABLE, 
	"IMPORTE" VARCHAR2(25 BYTE) NOT NULL ENABLE, 
	"RECIBO" VARCHAR2(10 BYTE), 
	"CUENTA" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CODIGOESTADO" NUMBER(10,0), 
	"ACTUALIZADO_POR" VARCHAR2(255 BYTE), 
	"CREADO_POR" VARCHAR2(255 BYTE), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
	 CONSTRAINT "CFG_SPEFRAIR_PK" PRIMARY KEY ("ID")
   )  ;

 GRANT UPDATE,SELECT,INSERT,DELETE ON "PCBCRP"."CFG_SPEFRAIR" TO "APP_PCBCRP";
 GRANT UPDATE,SELECT,INSERT,DELETE ON "PCBCRP"."CFG_RCD07" TO "APP_PCBCRP";
 GRANT UPDATE,SELECT,INSERT,DELETE ON "PCBCRP"."CFG_RCD02" TO "APP_PCBCRP";
 GRANT UPDATE,SELECT,INSERT,DELETE ON "PCBCRP"."CFG_POSRV" TO "APP_PCBCRP";
 GRANT UPDATE,SELECT,INSERT,DELETE ON "PCBCRP"."CFG_POSRF" TO "APP_PCBCRP";


--------------------------------------------------------
--  DDL for Table ANEXO_OCHO
--------------------------------------------------------
CREATE TABLE "PCBCRP"."ANEXO_OCHO"
    ( "ID" VARCHAR2(255 CHAR) NOT NULL ENABLE, 
    "ACTUALIZADO_POR" VARCHAR2(255 CHAR), 
	"CODIGOESTADO" NUMBER(10,0), 
	"CREADO_POR" VARCHAR2(255 CHAR), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
    "FUENTE" VARCHAR2(100 CHAR),
    "TIPOOPERACION" VARCHAR2(1 CHAR),
    "REPORTE" NUMBER(2),
    "CODIGO" VARCHAR2(8 CHAR),
    "CODIGOPRODUCTO" VARCHAR2(8 CHAR),
    "CODIGOARCHIVO" VARCHAR2(8 CHAR),
    PRIMARY KEY ("ID")
    );
  
--------------------------------------------------------
--  DDL for Table CUADRE_ANEXO_OCHO
--------------------------------------------------------
  
   CREATE TABLE "PCBCRP"."CUADRE_ANEXO_OCHO" 
   (	"ID" VARCHAR2(255 CHAR) NOT NULL ENABLE, 
	"ACTUALIZADO_POR" VARCHAR2(255 CHAR), 
	"CODIGOESTADO" NUMBER(10,0), 
	"CREADO_POR" VARCHAR2(255 CHAR), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6), 
	"ID_ANEXOOCHO" VARCHAR2(255 CHAR), 
    "FECHA" TIMESTAMP (6), 
	"MONTOPOSICIONCAMBIARIA" NUMBER(20,6), 
	"MONTOANEXO" NUMBER(20,6), 
    "DIFERENCIA" NUMBER(20,6), 
    "PROGRESO" VARCHAR2(255 CHAR), 
    "DESCRIPCION" VARCHAR2(255 CHAR),
	 PRIMARY KEY ("ID")
   );
  
--------------------------------------------------------
--  DDL for Table DETALLE_ANEXO_OCHO
--------------------------------------------------------

CREATE TABLE "PCBCRP"."DETALLE_ANEXO_OCHO" 
   (	"ID" VARCHAR2(255 CHAR) NOT NULL ENABLE, 
	"ACTUALIZADO_POR" VARCHAR2(255 CHAR), 
	"CODIGOESTADO" NUMBER(10,0), 
	"CREADO_POR" VARCHAR2(255 CHAR), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"FECHA_MODIFICACION" TIMESTAMP (6),
	"ID_CUADREANEXOOCHO" VARCHAR2(255 CHAR), 
    "FUENTE" VARCHAR2(255 CHAR), 
    "PRODUCTO" VARCHAR2(255 CHAR), 
    "MONTOPOSICIONCAMBIARIA" NUMBER(20,6), 
	"MONTOANEXO" NUMBER(20,6), 
    "DIFERENCIA" NUMBER(20,6), 
    "NUMEROOPERACION" VARCHAR2(255 CHAR),
    "CODIGOOPERACION" VARCHAR2(255 CHAR),
	"TIPOOPERACION" VARCHAR2(255 CHAR), 
	"MONEDAENTREGA" VARCHAR2(255 CHAR), 
    "MONEDARECIBE" VARCHAR2(255 CHAR), 
    "FECHAINICIO" TIMESTAMP (6), 
    "FECHAVENCIMIENTO" TIMESTAMP (6),
    "CLIENTE" VARCHAR2(255 CHAR),
    "RESIDENTE" VARCHAR2(255 CHAR),
    "PAIS" VARCHAR2(255 CHAR),
    "FINANCIERO" VARCHAR2(255 CHAR),
    "TIPOTASAINTERESRECIBE" VARCHAR2(255 CHAR),
    "TIPOTASAINTERESENTREGA" VARCHAR2(255 CHAR),
    "MONEDA" VARCHAR2(255 CHAR),
    "TASAINTERESRECIBE" NUMBER(20,6),
    "TASAINTERESENTREGA" NUMBER(20,6),
    "OBSERVACION" VARCHAR2(255 CHAR),
	 PRIMARY KEY ("ID")
   );

GRANT SELECT, INSERT, UPDATE, DELETE ON "PCBCRP"."ANEXO_OCHO" TO "APP_PCBCRP"; 
GRANT SELECT, INSERT, UPDATE, DELETE ON "PCBCRP"."CUADRE_ANEXO_OCHO" TO "APP_PCBCRP"; 
GRANT SELECT, INSERT, UPDATE, DELETE ON "PCBCRP"."DETALLE_ANEXO_OCHO" TO "APP_PCBCRP"; 

