package pe.grupobbva.alcon.mantenimiento.service.process.util;

import pe.grupobbva.alcon.mantenimiento.dto.process.CampanaDepositoCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.CodigoStarAltamiraCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.DeltaCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionCargaExtranjeroType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionDerivadoCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionDivaCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionOTFXCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionTasasMXCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.SaldoCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.SaldoContableCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.TasaCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.TasaCurvaCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.TipocambioCargaType;

public final class BcrpReader {

	public static BcrpReaderBuilder<OperacionCargaType> inforeportCarga() {
		return BcrpReaderBuilder.create(OperacionCargaType.class);
	}

	public static BcrpReaderBuilder<OperacionCargaExtranjeroType> infoExtranjeroCarga() {
		return BcrpReaderBuilder.create(OperacionCargaExtranjeroType.class);
	}

	public static BcrpReaderBuilder<OperacionOTFXCargaType> infoOTFXCarga() {
		return BcrpReaderBuilder.create(OperacionOTFXCargaType.class);
	}
	
	public static BcrpReaderBuilder<OperacionTasasMXCargaType> infoTasasMXCarga() {
		return BcrpReaderBuilder.create(OperacionTasasMXCargaType.class);
	}
	
	public static BcrpReaderBuilder<OperacionDivaCargaType> infoDivaCarga() {
		return BcrpReaderBuilder.create(OperacionDivaCargaType.class);
	}
	
	public static BcrpReaderBuilder<TipocambioCargaType> tipoCambioCarga() {
		return BcrpReaderBuilder.create(TipocambioCargaType.class);
	}

	public static BcrpReaderBuilder<SaldoContableCargaType> saldoContableCarga() {
		return BcrpReaderBuilder.create(SaldoContableCargaType.class);
	}

	public static BcrpReaderBuilder<DeltaCargaType> deltaCarga() {
		return BcrpReaderBuilder.create(DeltaCargaType.class);
	}

	public static BcrpReaderBuilder<TasaCargaType> tasaCarga() {
		return BcrpReaderBuilder.create(TasaCargaType.class);
	}
	
	public static BcrpReaderBuilder<TasaCurvaCargaType> tasaCurvaCarga() {
		return BcrpReaderBuilder.create(TasaCurvaCargaType.class);
	}

	public static BcrpReaderBuilder<SaldoCargaType> saldoCarga() {
		return BcrpReaderBuilder.create(SaldoCargaType.class);
	}

	public static BcrpReaderBuilder<OperacionDerivadoCargaType> inforeportDerivadoCarga() {
		return BcrpReaderBuilder.create(OperacionDerivadoCargaType.class);
	}

	public static BcrpReaderBuilder<CampanaDepositoCargaType> campanaDepositoCarga() {
		return BcrpReaderBuilder.create(CampanaDepositoCargaType.class);
	}
	
	public static BcrpReaderBuilder<CodigoStarAltamiraCargaType> codigoCentralAltamiraCarga() {
		return BcrpReaderBuilder.create(CodigoStarAltamiraCargaType.class);
	}

}
