INSERT INTO PCBCRP.DETALLE_PARAMETRO (ID, CODIGO, DESCRIPCION, VISIBLE, ID_PARAMETRO, CODIGOESTADO) VALUES (SYS_GUID(), '016', 'INFOREPORT OTFX' ,'1', '17', 1);
INSERT INTO PCBCRP.VALOR_PARAMETRO (ID, VALOR, ID_DETALLE, ORDEN, CODIGOESTADO) VALUES (SYS_GUID(), '16', (SELECT ID FROM PCBCRP.DETALLE_PARAMETRO WHERE CODIGO = '016' AND ID_PARAMETRO = '17'), 1, 1);
INSERT INTO PCBCRP.DETALLE_PARAMETRO (ID, CODIGO, DESCRIPCION, VISIBLE, ID_PARAMETRO, CODIGOESTADO) VALUES (SYS_GUID(), '017', 'INFOREPORT DIVAS' ,'1', '17', 1);
INSERT INTO PCBCRP.VALOR_PARAMETRO (ID, VALOR, ID_DETALLE, ORDEN, CODIGOESTADO) VALUES (SYS_GUID(), '17', (SELECT ID FROM PCBCRP.DETALLE_PARAMETRO WHERE CODIGO = '017' AND ID_PARAMETRO = '17'), 1, 1);