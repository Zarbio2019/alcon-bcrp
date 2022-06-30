package pe.grupobbva.alcon.mantenimiento.entity;

public enum TipoCarga {

	TIPOCAMBIOTRC(1), 
	CLIENTES(2), 
	SALDOSCONTABLES(3), 
	RCD_CIUU(4), 
	DELTA(5), 
	INFOREPORTDIARIO(6), 
	INFOREPORTIRC(7),
	TASAS(8), 
	EU(9), 
	INFOREPORTIRCN(10), 
	INFOREPORTDIARIOSPECTRUM(11),
	INFOREPORTEXTRANJERO(12),
	INFOREPORTDERIVADO(13),
	BACKOFFICE(14),
	TASASCURVAS(15),
	INFOREPORTOTFX(16),
	INFOREPORTDIVAS(17),
	INFOREPORTASASMX(18);

	private int numeroTipoCarga;

	private TipoCarga(int numeroTipoCarga) {
		this.numeroTipoCarga = numeroTipoCarga;
	}

	public int getNumeroTipoCarga() {
		return numeroTipoCarga;
	}



}
