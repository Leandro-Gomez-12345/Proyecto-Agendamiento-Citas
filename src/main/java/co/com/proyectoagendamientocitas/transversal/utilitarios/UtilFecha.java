package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.time.LocalDate;
import java.time.ZoneId;

public final class UtilFecha {

	public static final LocalDate FECHA_DEFECTO = LocalDate.of(1000, 1, 1);
	public static final ZoneId ZONA_HORARIA = ZoneId.of("America/Bogota");

	private UtilFecha() {

	}

	public static LocalDate obtenerValorDefecto(LocalDate fecha, LocalDate valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fecha, valorDefecto);
	}

	public static LocalDate obtenerValorDefecto(LocalDate fecha) {
		return obtenerValorDefecto(fecha, FECHA_DEFECTO);
	}

	public static boolean esValorDefecto(LocalDate fecha) {
		return FECHA_DEFECTO.isEqual(obtenerValorDefecto(fecha));
	}

	public static LocalDate obtenerFechaActual() {
		return LocalDate.now(ZONA_HORARIA);
	}

	public static boolean esAnterior(LocalDate fecha, LocalDate fechaReferencia) {
		return obtenerValorDefecto(fecha).isBefore(obtenerValorDefecto(fechaReferencia));
	}

	public static boolean esPosterior(LocalDate fecha, LocalDate fechaReferencia) {
		return obtenerValorDefecto(fecha).isAfter(obtenerValorDefecto(fechaReferencia));
	}

	public static boolean estaEnRango(LocalDate fecha, LocalDate fechaInicial,
			final LocalDate fechaFinal) {
		return !esAnterior(fecha, fechaInicial) && !esPosterior(fecha, fechaFinal);
	}

	public static LocalDate sumarDias(LocalDate fecha, long dias) {
		return obtenerValorDefecto(fecha).plusDays(dias);
	}
}
