-- INICIO SEBASTIAN

--------------------------------------------------------
--  DELETE STORED PROCEDURES
--------------------------------------------------------
DROP PROCEDURE "PCBCRP"."SP_BCR_REPORTE4_ANEXO8";
DROP PROCEDURE "PCBCRP"."SP_BCR_REPORTE4_ANEXO8_IRC";
--------------------------------------------------------
--  DDL for Procedure SP_BCR_REPORTE4_ANEXO8
--------------------------------------------------------
    
create PROCEDURE  "PCBCRP"."SP_BCR_REPORTE4_ANEXO8" (
P_IDPOSICIONCAMBIARIA	IN VARCHAR2,
P_FECHA                 IN DATE,
P_TIPOPROCESO           IN VARCHAR2,
CURSOR_ 	OUT SYS_REFCURSOR
)

AS

V_CODIGOBCR		    VARCHAR2(2);
V_TIPOOPERACION	    VARCHAR2(1);
V_TIPOCLIENTE	    VARCHAR2(1);
V_RESIDENTE		    VARCHAR2(1);
V_TIPOENTREGA	    VARCHAR2(1);
V_CALLPUT		    VARCHAR2(1);
V_IDDIVISA          INTEGER;

BEGIN


   SELECT ID INTO V_IDDIVISA FROM DIVISA WHERE CODIGO = 'PEN';

    --SELECT NVL(CODIGOBCR, ' '),  NVL(TIPO_OPERACION, ' ') , NVL(TIPO_CLIENTE, ' ') ,
    --NVL(RESIDENTE, ' ') , NVL(TIPO_ENTREGA, ' ') , NVL(CALL_PUT, ' ')
    --INTO V_CODIGOBCR, V_TIPOOPERACION, V_TIPOCLIENTE,
    --V_RESIDENTE, V_TIPOENTREGA, V_CALLPUT
    --FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA;

IF P_TIPOPROCESO ='D' THEN
    OPEN CURSOR_ FOR
    SELECT
			OPETEMP.PRODUCTO,
			OPETEMP.OPERACION AS NUMEROOPERACION,
			OPETEMP.CODIGOREPORTE,
			OPETEMP.CLIENTE,
			OPETEMP.NOMBRE,
			OPETEMP.TIPO,
			OPETEMP.DIVENTRADA,
			OPETEMP.DIVSALIDA,
			OPETEMP.IMPENTRADA,
			OPETEMP.IMPSALIDA,
			OPETEMP.TIPOCAMBIO,
			OPETEMP.VALIDACION,
			TO_CHAR(OPETEMP.CONTRATACION,'dd/mm/yyyy') AS CONTRATACION,
			TO_CHAR(OPETEMP.VALOR,'dd/mm/yyyy') AS VALOR,
			TO_CHAR(OPETEMP.VENCIMIENTO,'dd/mm/yyyy') AS VENCIMIENTO,
			OPETEMP.IMPORTEUSD,
			OPETEMP.TIPOCLIENTE
		FROM	(	SELECT

						p.CODIGO AS PRODUCTO,
						o.NUMEROOPERACION AS OPERACION,
						o.CODIGOREPORTE ,
						c.CODIGO AS CLIENTE,
						c.NOMBRE,
						mtto.DESCRIPCION AS TIPO,
						de.CODIGO AS DIVENTRADA,
						ds.CODIGO AS DIVSALIDA,
						o.IMPORTEDIVISAENTRADA AS IMPENTRADA,
						o.IMPORTEDIVISASALIDA AS IMPSALIDA,
						o.CAMBIOREF AS TIPOCAMBIO,
						o.VALIDACION,
						o.FECHACONTRATACION AS CONTRATACION,
						o.FECHAVALOR AS VALOR,
						o.FECHAVENCIMIENTO AS VENCIMIENTO,
						o.IMPORTEUSD,
						mttc.DESCRIPCION AS TIPOCLIENTE,
						o.ESTADO

					FROM
						OPERACION o
						INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
						INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
						INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
						INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
									) mtto ON o.TIPOOPERACION = mtto.VALOR
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
									) mttc ON o.TIPOCLIENTE = mttc.VALOR

						LEFT JOIN DIVISA dp ON dp.ID = o.IDDIVISAPRIMA
						LEFT JOIN DIVISA dex ON dex.ID = o.IDMONEDAEXTRANJERA
					WHERE
						o.ESTADO = 'L'
                        AND (o.IDDIVISAENTRADA = V_IDDIVISA OR o.IDDIVISASALIDA = V_IDDIVISA)
                        AND NVL(o.CODIGOREPORTE,' ') <> ' '
                        AND TRIM(o.TIPOPROCESO) = 'D'
                        AND o.CODIGOESTADO = 1

                        --AND NVL(p.CODIGOBCR,' ') = V_CODIGOBCR
                        --AND NVL(TRIM(o.TIPOOPERACION),' ') = V_TIPOOPERACION
                        --AND NVL(c.TIPOCLIENTE,' ') = V_TIPOCLIENTE
                        --AND NVL(o.RESIDENTE,' ') = CASE WHEN V_RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  V_RESIDENTE END
                        --AND NVL(p.TIPOENTREGA,' ') = V_TIPOENTREGA
                        --AND NVL(o.CALLPUT,' ') = V_CALLPUT
                        AND (NVL(p.CODIGOBCR,' ')|| NVL(TRIM(o.TIPOOPERACION),' ') || NVL(c.TIPOCLIENTE,' ') 
                            || NVL(o.RESIDENTE,' ') || NVL(p.TIPOENTREGA,' ') || NVL(o.CALLPUT,' '))
                        IN (
                            SELECT NVL(CODIGOBCR, ' ')||  NVL(TIPO_OPERACION, ' ') || NVL(TIPO_CLIENTE, ' ') 
                            || NVL(CASE WHEN RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  RESIDENTE END, ' ') 
                            || NVL(TIPO_ENTREGA, ' ') || NVL(CALL_PUT, ' ') AS PARAMETROS
                            FROM POSICION_CAMBIARIA PC
                             WHERE PC.RUBRO like ( SELECT RUBRO FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA )|| '%'
                        )
                        AND TO_DATE(TO_CHAR(o.FECHACONTRATACION, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAVENCIMIENTO, 'dd/mm/yyyy')) > TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND p.id NOT IN  (SELECT ID FROM PRODUCTO WHERE CODIGO='IRC')
                        AND o.NUMEROOPERACION NOT IN (
										SELECT NUMEROOPERACION
										FROM OPERACION
										WHERE
											ESTADO = 'A'
											AND TO_DATE(TO_CHAR(FECHAMOVIMIENTO, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
											AND TRIM(TIPOPROCESO) = 'D'
									)
				) OPETEMP ORDER BY OPETEMP.CODIGOREPORTE ASC , OPETEMP.OPERACION ASC;

ELSIF P_TIPOPROCESO ='A' THEN
    OPEN CURSOR_ FOR
        SELECT
			OPETEMP.PRODUCTO,
			OPETEMP.OPERACION AS NUMEROOPERACION,
			OPETEMP.CODIGOREPORTE,
			OPETEMP.CLIENTE,
			OPETEMP.NOMBRE,
			OPETEMP.TIPO,
			OPETEMP.DIVENTRADA,
			OPETEMP.DIVSALIDA,
			OPETEMP.IMPENTRADA,
			OPETEMP.IMPSALIDA,
			OPETEMP.TIPOCAMBIO,
			OPETEMP.VALIDACION,
			TO_CHAR(OPETEMP.CONTRATACION,'dd/mm/yyyy') AS CONTRATACION,
			TO_CHAR(OPETEMP.VALOR,'dd/mm/yyyy') AS VALOR,
			TO_CHAR(OPETEMP.VENCIMIENTO,'dd/mm/yyyy') AS VENCIMIENTO,
			OPETEMP.IMPORTEUSD,
			OPETEMP.TIPOCLIENTE
		FROM	(	SELECT

						p.CODIGO AS PRODUCTO,
						o.NUMEROOPERACION AS OPERACION,
						o.CODIGOREPORTE ,
						c.CODIGO AS CLIENTE,
						c.NOMBRE,
						mtto.DESCRIPCION AS TIPO,
						de.CODIGO AS DIVENTRADA,
						ds.CODIGO AS DIVSALIDA,
						o.IMPORTEDIVISAENTRADA AS IMPENTRADA,
						o.IMPORTEDIVISASALIDA AS IMPSALIDA,
						o.CAMBIOREF AS TIPOCAMBIO,
						o.VALIDACION,
						o.FECHACONTRATACION AS CONTRATACION,
						o.FECHAVALOR AS VALOR,
						o.FECHAVENCIMIENTO AS VENCIMIENTO,
						o.IMPORTEUSD,
						mttc.DESCRIPCION AS TIPOCLIENTE,
						o.ESTADO

					FROM
						OPERACION o
						INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
						INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
						INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
						INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
									) mtto ON o.TIPOOPERACION = mtto.VALOR
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
									) mttc ON o.TIPOCLIENTE = mttc.VALOR

						LEFT JOIN DIVISA dp ON dp.ID = o.IDDIVISAPRIMA
						LEFT JOIN DIVISA dex ON dex.ID = o.IDMONEDAEXTRANJERA
					WHERE
						o.ESTADO = 'L'
                        AND (o.IDDIVISAENTRADA = V_IDDIVISA OR o.IDDIVISASALIDA = V_IDDIVISA)
                        AND NVL(o.CODIGOREPORTE,' ') <> ' '
                        AND TRIM(o.TIPOPROCESO) = 'D'
                        AND o.CODIGOESTADO = 1

                        --AND NVL(p.CODIGOBCR,' ') = V_CODIGOBCR
                        --AND NVL(TRIM(o.TIPOOPERACION),' ') = V_TIPOOPERACION
                        --AND NVL(c.TIPOCLIENTE,' ') = V_TIPOCLIENTE
                        --AND NVL(o.RESIDENTE,' ') = CASE WHEN V_RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  V_RESIDENTE END
                        --AND NVL(p.TIPOENTREGA,' ') = V_TIPOENTREGA
                        --AND NVL(o.CALLPUT,' ') = V_CALLPUT
                        
                        AND (NVL(p.CODIGOBCR,' ')|| NVL(TRIM(o.TIPOOPERACION),' ') || NVL(c.TIPOCLIENTE,' ') 
                            || NVL(o.RESIDENTE,' ') || NVL(p.TIPOENTREGA,' ') || NVL(o.CALLPUT,' '))
                        IN (
                            SELECT NVL(CODIGOBCR, ' ')||  NVL(TIPO_OPERACION, ' ') || NVL(TIPO_CLIENTE, ' ') 
                            || NVL(CASE WHEN RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  RESIDENTE END, ' ') 
                            || NVL(TIPO_ENTREGA, ' ') || NVL(CALL_PUT, ' ') AS PARAMETROS
                            FROM POSICION_CAMBIARIA PC
                             WHERE PC.RUBRO like ( SELECT RUBRO FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA )|| '%'
                        )
                        
                        AND TO_DATE(TO_CHAR(o.FECHACONTRATACION, 'dd/mm/yyyy')) < TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAVENCIMIENTO, 'dd/mm/yyyy')) > TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy')) < TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND p.id NOT IN  (SELECT ID FROM PRODUCTO WHERE CODIGO='IRC')
                        AND o.NUMEROOPERACION NOT IN (
										SELECT NUMEROOPERACION
										FROM OPERACION
										WHERE
											ESTADO = 'A'
											AND TO_DATE(TO_CHAR(FECHAMOVIMIENTO, 'dd/mm/yyyy')) < TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
											AND TRIM(TIPOPROCESO) = 'D'
									)
                UNION ALL

                SELECT

						p.CODIGO AS PRODUCTO,
						o.NUMEROOPERACION AS OPERACION,
						o.CODIGOREPORTE ,
						c.CODIGO AS CLIENTE,
						c.NOMBRE,
						mtto.DESCRIPCION AS TIPO,
						de.CODIGO AS DIVENTRADA,
						ds.CODIGO AS DIVSALIDA,
						o.IMPORTEDIVISAENTRADA AS IMPENTRADA,
						o.IMPORTEDIVISASALIDA AS IMPSALIDA,
						o.CAMBIOREF AS TIPOCAMBIO,
						o.VALIDACION,
						o.FECHACONTRATACION AS CONTRATACION,
						o.FECHAVALOR AS VALOR,
						o.FECHAVENCIMIENTO AS VENCIMIENTO,
						o.IMPORTEUSD,
						mttc.DESCRIPCION AS TIPOCLIENTE,
						o.ESTADO

					FROM
						OPERACION o
						INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
						INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
						INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
						INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
									) mtto ON o.TIPOOPERACION = mtto.VALOR
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
									) mttc ON o.TIPOCLIENTE = mttc.VALOR

					WHERE
						o.ESTADO = 'L'
                        AND (o.IDDIVISAENTRADA = V_IDDIVISA OR o.IDDIVISASALIDA = V_IDDIVISA)
                        AND NVL(o.CODIGOREPORTE,' ') <> ' '
                        AND TRIM(o.TIPOPROCESO) = P_TIPOPROCESO
                        AND o.CODIGOESTADO = 1

                       -- AND NVL(p.CODIGOBCR,' ') = V_CODIGOBCR
                        --AND NVL(TRIM(o.TIPOOPERACION),' ') = V_TIPOOPERACION
                        --AND NVL(c.TIPOCLIENTE,' ') = V_TIPOCLIENTE
                        --AND NVL(o.RESIDENTE,' ') = CASE WHEN V_RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  V_RESIDENTE END
                        --AND NVL(p.TIPOENTREGA,' ') = V_TIPOENTREGA
                        --AND NVL(o.CALLPUT,' ') = V_CALLPUT

                        AND (NVL(p.CODIGOBCR,' ')|| NVL(TRIM(o.TIPOOPERACION),' ') || NVL(c.TIPOCLIENTE,' ') 
                            || NVL(o.RESIDENTE,' ') || NVL(p.TIPOENTREGA,' ') || NVL(o.CALLPUT,' '))
                        IN (
                            SELECT NVL(CODIGOBCR, ' ')||  NVL(TIPO_OPERACION, ' ') || NVL(TIPO_CLIENTE, ' ') 
                            || NVL(CASE WHEN RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  RESIDENTE END, ' ') 
                            || NVL(TIPO_ENTREGA, ' ') || NVL(CALL_PUT, ' ') AS PARAMETROS
                            FROM POSICION_CAMBIARIA PC
                             WHERE PC.RUBRO like ( SELECT RUBRO FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA )|| '%'
                        )

                        AND TO_CHAR(o.FECHACONTRATACION, 'dd/mm/yyyy') = TO_CHAR(P_FECHA, 'dd/mm/yyyy')
                        AND TO_DATE(TO_CHAR(o.FECHAVENCIMIENTO, 'dd/mm/yyyy')) > TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy') = TO_CHAR(P_FECHA,'dd/mm/yyyy')
                        AND p.id NOT IN  (SELECT ID FROM PRODUCTO WHERE CODIGO='IRC')
                        AND o.NUMEROOPERACION NOT IN (
										SELECT NUMEROOPERACION
										FROM OPERACION
										WHERE
											ESTADO = 'A'
											AND TO_DATE(TO_CHAR(FECHAMOVIMIENTO, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
											AND TRIM(TIPOPROCESO) = P_TIPOPROCESO
									)

				) OPETEMP ORDER BY OPETEMP.CODIGOREPORTE ASC;
    END IF;
END;

/

--------------------------------------------------------
--  DDL for Procedure SP_BCR_REPORTE4_ANEXO8_IRC
--------------------------------------------------------
CREATE PROCEDURE "PCBCRP"."SP_BCR_REPORTE4_ANEXO8_IRC" (
P_IDPOSICIONCAMBIARIA	IN VARCHAR2,
P_FECHA                 IN DATE,
P_TIPOPROCESO           IN VARCHAR2,
CURSOR_ 	OUT SYS_REFCURSOR
)

AS

V_CODIGOBCR		    VARCHAR2(2);
V_TIPOOPERACION	    VARCHAR2(1);
V_TIPOCLIENTE	    VARCHAR2(1);
V_RESIDENTE		    VARCHAR2(1);
V_TIPOENTREGA	    VARCHAR2(1);
V_CALLPUT		    VARCHAR2(1);
V_IDDIVISA          INTEGER;

BEGIN

   SELECT ID INTO V_IDDIVISA FROM DIVISA WHERE CODIGO = 'PEN';

    --SELECT NVL(CODIGOBCR, ' '),  NVL(TIPO_OPERACION, ' ') , NVL(TIPO_CLIENTE, ' ') ,
    --NVL(RESIDENTE, ' ') , NVL(TIPO_ENTREGA, ' ') , NVL(CALL_PUT, ' ')
    --INTO V_CODIGOBCR, V_TIPOOPERACION, V_TIPOCLIENTE,
    --V_RESIDENTE, V_TIPOENTREGA, V_CALLPUT
    --FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA;

IF P_TIPOPROCESO ='D' THEN
    OPEN CURSOR_ FOR
    SELECT
			OPETEMP.PRODUCTO,
            OPETEMP.OPERACION AS NUMEROOPERACION ,
			OPETEMP.CODIGOREPORTE,
			OPETEMP.CLIENTE,
			OPETEMP.NOMBRE,
            OPETEMP.TIPO,
            OPETEMP.DIVENTRADA,
            OPETEMP.DIVSALIDA,
            SUM(OPETEMP.IMPENTRADA) AS IMPENTRADA,
            SUM(OPETEMP.IMPSALIDA) AS IMPSALIDA,
            OPETEMP.TIPOCAMBIO,
            OPETEMP.VALIDACION,
            MAX(TO_CHAR(OPETEMP.CONTRATACION,'dd/mm/yyyy')) AS CONTRATACION,
            MIN(TO_CHAR(OPETEMP.VALOR,'dd/mm/yyyy')) AS VALOR,
            MAX(TO_CHAR(OPETEMP.VENCIMIENTO,'dd/mm/yyyy')) AS VENCIMIENTO,
			SUM(OPETEMP.IMPORTEUSD) AS IMPORTEUSD,
            OPETEMP.TIPOCLIENTE
		FROM	(	SELECT

						p.CODIGO AS PRODUCTO,
						SUBSTR(o.NUMEROOPERACION,0, LENGTH(o.NUMEROOPERACION)-3) AS OPERACION,
						o.CODIGOREPORTE ,
						c.CODIGO AS CLIENTE,
						c.NOMBRE,
						mtto.DESCRIPCION AS TIPO,
						de.CODIGO AS DIVENTRADA,
						ds.CODIGO AS DIVSALIDA,
						o.IMPORTEDIVISAENTRADA AS IMPENTRADA,
						o.IMPORTEDIVISASALIDA AS IMPSALIDA,
						o.CAMBIOREF AS TIPOCAMBIO,
						'' AS VALIDACION,
						o.FECHACONTRATACION AS CONTRATACION,
						o.FECHAVALOR AS VALOR,
						o.FECHAVENCIMIENTO AS VENCIMIENTO,
						o.IMPORTEUSD,
						mttc.DESCRIPCION AS TIPOCLIENTE,
						o.ESTADO

					FROM
						OPERACION o
						INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
						INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
						INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
						INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
									) mtto ON o.TIPOOPERACION = mtto.VALOR
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
									) mttc ON o.TIPOCLIENTE = mttc.VALOR

						LEFT JOIN DIVISA dp ON dp.ID = o.IDDIVISAPRIMA
						LEFT JOIN DIVISA dex ON dex.ID = o.IDMONEDAEXTRANJERA
					WHERE
						o.ESTADO = 'L'
                        AND (o.IDDIVISAENTRADA = V_IDDIVISA OR o.IDDIVISASALIDA = V_IDDIVISA)
                        AND NVL(o.CODIGOREPORTE,' ') <> ' '
                        AND TRIM(o.TIPOPROCESO) = 'D'
                        AND o.CODIGOESTADO = 1

                        --AND NVL(p.CODIGOBCR,' ') = V_CODIGOBCR
                        --AND NVL(TRIM(o.TIPOOPERACION),' ') = V_TIPOOPERACION
                        --AND NVL(c.TIPOCLIENTE,' ') = V_TIPOCLIENTE
                        --AND NVL(o.RESIDENTE,' ') = CASE WHEN V_RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  V_RESIDENTE END
                        --AND NVL(p.TIPOENTREGA,' ') = V_TIPOENTREGA
                        --AND NVL(o.CALLPUT,' ') = V_CALLPUT
                        
                        AND (NVL(p.CODIGOBCR,' ')|| NVL(TRIM(o.TIPOOPERACION),' ') || NVL(c.TIPOCLIENTE,' ') 
                            || NVL(o.RESIDENTE,' ') || NVL(p.TIPOENTREGA,' ') || NVL(o.CALLPUT,' '))
                        IN (
                            SELECT NVL(CODIGOBCR, ' ')||  NVL(TIPO_OPERACION, ' ') || NVL(TIPO_CLIENTE, ' ') 
                            || NVL(CASE WHEN RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  RESIDENTE END, ' ') 
                            || NVL(TIPO_ENTREGA, ' ') || NVL(CALL_PUT, ' ') AS PARAMETROS
                            FROM POSICION_CAMBIARIA PC
                             WHERE PC.RUBRO like ( SELECT RUBRO FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA )|| '%'
                        )
                        
                        AND TO_DATE(TO_CHAR(o.FECHACONTRATACION, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAVENCIMIENTO, 'dd/mm/yyyy')) > TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND p.id IN  (SELECT ID FROM PRODUCTO WHERE CODIGO='IRC')
                        AND o.NUMEROOPERACION NOT IN (
										SELECT NUMEROOPERACION
										FROM OPERACION
										WHERE
											ESTADO = 'A'
											AND TO_DATE(TO_CHAR(FECHAMOVIMIENTO, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
											AND TRIM(TIPOPROCESO) = 'D'
									)
				) OPETEMP
                GROUP BY OPETEMP.PRODUCTO, OPETEMP.OPERACION, OPETEMP.CODIGOREPORTE, OPETEMP.CLIENTE, OPETEMP.NOMBRE,
                OPETEMP.TIPO, OPETEMP.DIVENTRADA, OPETEMP.DIVSALIDA, OPETEMP.TIPOCLIENTE, OPETEMP.TIPOCAMBIO, OPETEMP.VALIDACION
                ORDER BY OPETEMP.CODIGOREPORTE ASC , OPETEMP.OPERACION ASC;

ELSIF P_TIPOPROCESO ='A' THEN
    OPEN CURSOR_ FOR
        SELECT
			OPETEMP.PRODUCTO,
            OPETEMP.OPERACION AS NUMEROOPERACION ,
			OPETEMP.CODIGOREPORTE,
			OPETEMP.CLIENTE,
			OPETEMP.NOMBRE,
            OPETEMP.TIPO,
            OPETEMP.DIVENTRADA,
            OPETEMP.DIVSALIDA,
            SUM(OPETEMP.IMPENTRADA) AS IMPENTRADA,
            SUM(OPETEMP.IMPSALIDA) AS IMPSALIDA,
            OPETEMP.TIPOCAMBIO,
            OPETEMP.VALIDACION,
            MAX(TO_CHAR(OPETEMP.CONTRATACION,'dd/mm/yyyy')) AS CONTRATACION,
            MIN(TO_CHAR(OPETEMP.VALOR,'dd/mm/yyyy')) AS VALOR,
            MAX(TO_CHAR(OPETEMP.VENCIMIENTO,'dd/mm/yyyy')) AS VENCIMIENTO,
			SUM(OPETEMP.IMPORTEUSD) AS IMPORTEUSD,
            OPETEMP.TIPOCLIENTE
		FROM	(	SELECT

						p.CODIGO AS PRODUCTO,
						SUBSTR(o.NUMEROOPERACION,0, LENGTH(o.NUMEROOPERACION)-3) AS OPERACION,
						o.CODIGOREPORTE ,
						c.CODIGO AS CLIENTE,
						c.NOMBRE,
						mtto.DESCRIPCION AS TIPO,
						de.CODIGO AS DIVENTRADA,
						ds.CODIGO AS DIVSALIDA,
						o.IMPORTEDIVISAENTRADA AS IMPENTRADA,
						o.IMPORTEDIVISASALIDA AS IMPSALIDA,
						o.CAMBIOREF AS TIPOCAMBIO,
						'' AS VALIDACION,
						o.FECHACONTRATACION AS CONTRATACION,
						o.FECHAVALOR AS VALOR,
						o.FECHAVENCIMIENTO AS VENCIMIENTO,
						o.IMPORTEUSD,
						mttc.DESCRIPCION AS TIPOCLIENTE,
						o.ESTADO

					FROM
						OPERACION o
						INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
						INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
						INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
						INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
									) mtto ON o.TIPOOPERACION = mtto.VALOR
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
									) mttc ON o.TIPOCLIENTE = mttc.VALOR

						LEFT JOIN DIVISA dp ON dp.ID = o.IDDIVISAPRIMA
						LEFT JOIN DIVISA dex ON dex.ID = o.IDMONEDAEXTRANJERA
					WHERE
						o.ESTADO = 'L'
                        AND (o.IDDIVISAENTRADA = V_IDDIVISA OR o.IDDIVISASALIDA = V_IDDIVISA)
                        AND NVL(o.CODIGOREPORTE,' ') <> ' '
                        AND TRIM(o.TIPOPROCESO) = 'D'
                        AND o.CODIGOESTADO = 1

                        --AND NVL(p.CODIGOBCR,' ') = V_CODIGOBCR
                        --AND NVL(TRIM(o.TIPOOPERACION),' ') = V_TIPOOPERACION
                        --AND NVL(c.TIPOCLIENTE,' ') = V_TIPOCLIENTE
                        --AND NVL(o.RESIDENTE,' ') = CASE WHEN V_RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  V_RESIDENTE END
                        --AND NVL(p.TIPOENTREGA,' ') = V_TIPOENTREGA
                        --AND NVL(o.CALLPUT,' ') = V_CALLPUT
                        
                        AND (NVL(p.CODIGOBCR,' ')|| NVL(TRIM(o.TIPOOPERACION),' ') || NVL(c.TIPOCLIENTE,' ') 
                            || NVL(o.RESIDENTE,' ') || NVL(p.TIPOENTREGA,' ') || NVL(o.CALLPUT,' '))
                        IN (
                            SELECT NVL(CODIGOBCR, ' ')||  NVL(TIPO_OPERACION, ' ') || NVL(TIPO_CLIENTE, ' ') 
                            || NVL(CASE WHEN RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  RESIDENTE END, ' ') 
                            || NVL(TIPO_ENTREGA, ' ') || NVL(CALL_PUT, ' ') AS PARAMETROS
                            FROM POSICION_CAMBIARIA PC
                             WHERE PC.RUBRO like ( SELECT RUBRO FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA )|| '%'
                        )
                        
                        AND TO_DATE(TO_CHAR(o.FECHACONTRATACION, 'dd/mm/yyyy')) < TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAVENCIMIENTO, 'dd/mm/yyyy')) > TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_DATE(TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy')) < TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND p.id IN  (SELECT ID FROM PRODUCTO WHERE CODIGO='IRC')
                        AND o.NUMEROOPERACION NOT IN (
										SELECT NUMEROOPERACION
										FROM OPERACION
										WHERE
											ESTADO = 'A'
											AND TO_DATE(TO_CHAR(FECHAMOVIMIENTO, 'dd/mm/yyyy')) < TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
											AND TRIM(TIPOPROCESO) = 'D'
									)
                UNION

                SELECT

						p.CODIGO AS PRODUCTO,
						SUBSTR(o.NUMEROOPERACION,0, LENGTH(o.NUMEROOPERACION)-3) AS OPERACION,
						o.CODIGOREPORTE ,
						c.CODIGO AS CLIENTE,
						c.NOMBRE,
						mtto.DESCRIPCION AS TIPO,
						de.CODIGO AS DIVENTRADA,
						ds.CODIGO AS DIVSALIDA,
						o.IMPORTEDIVISAENTRADA AS IMPENTRADA,
						o.IMPORTEDIVISASALIDA AS IMPSALIDA,
						o.CAMBIOREF AS TIPOCAMBIO,
						'' AS VALIDACION,
						o.FECHACONTRATACION AS CONTRATACION,
						o.FECHAVALOR AS VALOR,
						o.FECHAVENCIMIENTO AS VENCIMIENTO,
						o.IMPORTEUSD,
						mttc.DESCRIPCION AS TIPOCLIENTE,
						o.ESTADO

					FROM
						OPERACION o
						INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
						INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
						INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
						INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
									) mtto ON o.TIPOOPERACION = mtto.VALOR
						INNER JOIN (SELECT
										det.DESCRIPCION,
										val.VALOR
									FROM
										PARAMETRO par
										INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
										INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
									) mttc ON o.TIPOCLIENTE = mttc.VALOR

					WHERE
						o.ESTADO = 'L'
                        AND (o.IDDIVISAENTRADA = V_IDDIVISA OR o.IDDIVISASALIDA = V_IDDIVISA)
                        AND NVL(o.CODIGOREPORTE,' ') <> ' '
                        AND TRIM(o.TIPOPROCESO) = P_TIPOPROCESO
                        AND o.CODIGOESTADO = 1

                       -- AND NVL(p.CODIGOBCR,' ') = V_CODIGOBCR
                        --AND NVL(TRIM(o.TIPOOPERACION),' ') = V_TIPOOPERACION
                        --AND NVL(c.TIPOCLIENTE,' ') = V_TIPOCLIENTE
                        --AND NVL(o.RESIDENTE,' ') = CASE WHEN V_RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  V_RESIDENTE END
                        --AND NVL(p.TIPOENTREGA,' ') = V_TIPOENTREGA
                        --AND NVL(o.CALLPUT,' ') = V_CALLPUT

                        AND (NVL(p.CODIGOBCR,' ')|| NVL(TRIM(o.TIPOOPERACION),' ') || NVL(c.TIPOCLIENTE,' ') 
                            || NVL(o.RESIDENTE,' ') || NVL(p.TIPOENTREGA,' ') || NVL(o.CALLPUT,' '))
                        IN (
                            SELECT NVL(CODIGOBCR, ' ')||  NVL(TIPO_OPERACION, ' ') || NVL(TIPO_CLIENTE, ' ') 
                            || NVL(CASE WHEN RESIDENTE = 'A' THEN NVL(o.RESIDENTE,' ') ELSE  RESIDENTE END, ' ') 
                            || NVL(TIPO_ENTREGA, ' ') || NVL(CALL_PUT, ' ') AS PARAMETROS
                            FROM POSICION_CAMBIARIA PC
                             WHERE PC.RUBRO like ( SELECT RUBRO FROM POSICION_CAMBIARIA WHERE ID = P_IDPOSICIONCAMBIARIA )|| '%'
                        )

                        AND TO_CHAR(o.FECHACONTRATACION, 'dd/mm/yyyy') = TO_CHAR(P_FECHA, 'dd/mm/yyyy')
                        AND TO_DATE(TO_CHAR(o.FECHAVENCIMIENTO, 'dd/mm/yyyy')) > TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
                        AND TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy') = TO_CHAR(P_FECHA,'dd/mm/yyyy')
                        AND p.id IN  (SELECT ID FROM PRODUCTO WHERE CODIGO='IRC')
                        AND o.NUMEROOPERACION NOT IN (
										SELECT NUMEROOPERACION
										FROM OPERACION
										WHERE
											ESTADO = 'A'
											AND TO_DATE(TO_CHAR(FECHAMOVIMIENTO, 'dd/mm/yyyy')) <= TO_DATE(TO_CHAR(P_FECHA,'dd/mm/yyyy'))
											AND TRIM(TIPOPROCESO) = P_TIPOPROCESO
									)

				) OPETEMP
                GROUP BY OPETEMP.PRODUCTO, OPETEMP.OPERACION, OPETEMP.CODIGOREPORTE, OPETEMP.CLIENTE, OPETEMP.NOMBRE,
                OPETEMP.TIPO, OPETEMP.DIVENTRADA, OPETEMP.DIVSALIDA, OPETEMP.TIPOCLIENTE, OPETEMP.TIPOCAMBIO, OPETEMP.VALIDACION
                ORDER BY OPETEMP.CODIGOREPORTE ASC , OPETEMP.OPERACION ASC;
    END IF;
END;

/
GRANT EXECUTE ON "PCBCRP"."SP_BCR_REPORTE4_ANEXO8" TO "APP_PCBCRP";
GRANT EXECUTE ON "PCBCRP"."SP_BCR_REPORTE4_ANEXO8_IRC" TO "APP_PCBCRP";

-- fin SEBASTIAN