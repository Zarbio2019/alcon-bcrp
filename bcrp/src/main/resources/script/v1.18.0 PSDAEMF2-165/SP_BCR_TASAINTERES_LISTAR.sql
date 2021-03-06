create or replace PROCEDURE          "SP_BCR_TASAINTERES_LISTAR" (
P_CODIGOREPORTE 		IN VARCHAR2,
P_NUMEROOPERACION 		IN VARCHAR2,
P_FECHAMOVIMIENTO          IN DATE,
P_IDPRODUCTO 			IN VARCHAR2,
P_CODIGOCLIENTE 		IN VARCHAR2,
P_NOMBRECLIENTE 		IN VARCHAR2,
P_OBSERVACIONES 		IN VARCHAR2,
P_TIPOPROCESO 			IN VARCHAR2,
CURSOR_ 				OUT SYS_REFCURSOR
)
AS


V_IDPRODUCTO VARCHAR2(255);

BEGIN
	IF P_IDPRODUCTO <> '-2' THEN
		SELECT pro.ID INTO V_IDPRODUCTO FROM PRODUCTO pro WHERE pro.CODIGO = P_IDPRODUCTO;
	ELSE
		V_IDPRODUCTO := '-2';
	END IF;

	OPEN CURSOR_ FOR
	SELECT
		o.ID,
		o.ID_CARGA AS IDCARGA,
		o.FECHACONTRATACION AS FECHACONTRATACION,
		o.ID_PRODUCTO AS IDPRODUCTO,
        p.CODIGO AS PRODUCTODESCRIPCION,
		o.NUMEROOPERACION,
		o.ID_CLIENTE AS IDCLIENTE,
		c.CODIGO AS CLIENTECODIGO,
		c.NOMBRE AS CLIENTENOMBRE,
		c.TIPODOCUMENTO,
		CASE
		  WHEN c.TIPODOCUMENTO = 1 OR c.TIPODOCUMENTO = 2 OR c.TIPODOCUMENTO = 3 OR c.TIPODOCUMENTO = 4 OR c.TIPODOCUMENTO = 5 THEN c.NUMERODOCUMENTO
		  WHEN c.TIPODOCUMENTO = 6 THEN c.CODIGOSWIFT
		END AS DOCUMENTOCLIENTE,
		c.SECTOR AS SECTORCLIENTE,
		c.PAISRESIDENCIA AS CLIENTEPAISRESIDENCIA,
		p.TIPOENTREGA,
		o.TIPOOPERACION,
		(	SELECT
				det.DESCRIPCION
			FROM
				PARAMETRO par
					INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
					INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '002'
			WHERE
				val.VALOR = o.TIPOOPERACION
		)  AS TIPOOPERACIONDESCRIPCION,
		o.IDDIVISAENTRADA,
		de.CODIGO AS  DIVISAENTRADADESCRIPCION,
		o.IDDIVISASALIDA,
		ds.CODIGO AS  DIVISASALIDADESCRIPCION,
		o.IMPORTEDIVISAENTRADA,
		o.IMPORTEDIVISASALIDA,
		o.COTIZACION,
		o.PUNTOSSWAP,
		o.BASICA,
		o.CAMBIOREF,
		o.FECHAVALOR,
		o.FECHAVENCIMIENTO,
		o.PLAZO,
		o.FECHAEJERCICIO,
		o.CALLPUT,
		o.PLAZA,
		o.PAISRESIDENCIA,
		o.RIESGOPAIS,
		o.PRIMA,
		o.IDDIVISAPRIMA,
		dp.CODIGO AS  DIVISAPRIMADESCRIPCION,
		o.OBSERVACIONES,
		o.FECHAALTA,
		o.FECHAMODIFICACIONCARGA,
		o.OPERACIONSUSTITUYE,
		o.FECHABAJA,
		o.NIF,
		o.INTERMEDIARIO,
		o.INTERMEDIARIODESCRIPCION,
		o.ESTADO,
		(	SELECT
				det.DESCRIPCION
			FROM
				PARAMETRO par
					INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
					INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '014'
			WHERE
				val.VALOR = o.ESTADO
		)  AS ESTADODESC,
		o.CONTRATO,
		o.RESIDENTE,
		o.ESTILO,
		o.TIPOOPCION,
		o.TIPOPROCESO,
		(	SELECT
				det.DESCRIPCION
			FROM
				PARAMETRO par
					INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
					INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '013'
			WHERE
				val.VALOR = o.TIPOPROCESO
		)  AS TIPOPROCESODESC,
		o.HISTORICO,
		o.FECHAMOVIMIENTO,
		o.USUARIOCARGA,
		o.CODIGOOPERACION,
		o.IMPORTEUSD,
		o.CODIGOREPORTE,
		o.TASAMONEDANACIONAL,
		o.TASAMONEDAEXTRANJERA,
		o.DELTA,
		o.MONTOMONEDAEXTRANJERA,
		o.IDMONEDAEXTRANJERA,
		dex.CODIGO AS  MONEDAEXTRANJERADESCRIPCION,
		o.MONTOPEN,
		o.TIPOCAMBIOSPOT,
		o.TIPOCAMBIOPACTADO,
		o.TIPOCAMBIOVENCIMIENTO,
		o.VALIDACION,
		o.CODIGOAGRUPACION,
		o.TIPOCLIENTE ,
		(SELECT
			det.DESCRIPCION
		FROM
			PARAMETRO par
				INNER JOIN DETALLE_PARAMETRO det ON par.ID = det.ID_PARAMETRO
				INNER JOIN VALOR_PARAMETRO val ON det.ID = val.ID_DETALLE AND par.CODIGO = '004'
		WHERE
			val.VALOR = c.TIPOCLIENTE
		) AS TIPOCLIENTEDESCRIPCION,
		o.TASADIFERENCIAL,
		o.IDFILAARCHIVO,
		o.MENSAJEERROR,
		o.CORRELATIVO,
		o.CODIGOESTADO,
	   -- p.CODIGO AS PRODUCTOCODIGO,
	   -- c.CODIGO AS CLIENTECODIGO,
	   -- c.NOMBRE AS CLIENTENOMBRE,

		o.RECIBETASAFIJASPREAD,
		o.RECIBETFIJA,
		o.RECIBEIDENTIFICADORFRECUENCIA,
		o.PAGATASAFIJASPREAD,
		o.PAGATFIJA,
		o.PAGAIDENTIFICADORFRECUENCIA,
		o.VOLATILIDAD,
		o.INTENCIONCONTRATACION

	FROM TASA_INTERES o
		INNER JOIN PRODUCTO p ON p.ID = o.ID_PRODUCTO
		INNER JOIN CLIENTE c ON c.ID = o.ID_CLIENTE
		INNER JOIN DIVISA de ON de.ID = o.IDDIVISAENTRADA
		INNER JOIN DIVISA ds ON ds.ID = o.IDDIVISASALIDA
		LEFT JOIN DIVISA dp ON dp.ID = o.IDDIVISAPRIMA
		LEFT JOIN DIVISA dex ON dex.ID = o.IDMONEDAEXTRANJERA

	WHERE
		o.CODIGOESTADO = 1
		AND (UPPER(TRIM(o.NUMEROOPERACION))LIKE '%' || UPPER(TRIM(P_NUMEROOPERACION)) || '%' OR UPPER(TRIM(o.OPERACIONSUSTITUYE)) LIKE '%' || UPPER(TRIM(P_NUMEROOPERACION)) || '%')
		AND UPPER(TRIM(o.CODIGOREPORTE)) LIKE '%' || UPPER(TRIM(P_CODIGOREPORTE)) || '%'
		AND ((P_FECHAMOVIMIENTO is null) OR TO_CHAR(o.FECHAMOVIMIENTO, 'dd/mm/yyyy') = TO_CHAR(P_FECHAMOVIMIENTO,'dd/mm/yyyy'))
		--AND o.ID_PRODUCTO = (SELECT p.ID FROM PRODUCTO p WHERE p.CODIGO = 'IRD') --@i_idProductoIRD
		AND o.ID_PRODUCTO = CASE WHEN V_IDPRODUCTO = '-2' THEN o.ID_PRODUCTO ELSE V_IDPRODUCTO END
		AND UPPER(TRIM(c.CODIGO)) LIKE '%' || UPPER(TRIM(P_CODIGOCLIENTE)) || '%'
		AND UPPER(TRIM(c.NOMBRE)) LIKE '%' || UPPER(TRIM(P_NOMBRECLIENTE)) || '%'
		AND o.TIPOPROCESO = 'D'
		AND TO_CHAR(o.FECHAVENCIMIENTO, 'yyyyMMdd') >=  CASE WHEN UPPER(TRIM(P_OBSERVACIONES)) = 'VIGENTES' THEN TO_CHAR(SYSDATE, 'yyyyMMdd') ELSE TO_CHAR(o.FECHAVENCIMIENTO, 'yyyyMMdd') END
		AND ((P_OBSERVACIONES = 'VIGENTES')  OR NVL(UPPER(TRIM(o.OBSERVACIONES)),' ') LIKE '%' || UPPER(TRIM(P_OBSERVACIONES)) || '%')

	ORDER BY
	o.NUMEROOPERACION;

END;

