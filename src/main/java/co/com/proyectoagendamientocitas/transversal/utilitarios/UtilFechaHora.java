package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public final class UtilFechaHora {

	public static final LocalDateTime FECHA_HORA_DEFECTO = combinar(UtilFecha.FECHA_DEFECTO, UtilHora.HORA_DEFECTO);

	private UtilFechaHora() {

	}

	public static LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora,
			final LocalDateTime valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fechaHora, valorDefecto);
	}

	public static LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora) {
		return obtenerValorDefecto(fechaHora, FECHA_HORA_DEFECTO);
	}

	public static boolean esValorDefecto(final LocalDateTime fechaHora) {
		return FECHA_HORA_DEFECTO.isEqual(obtenerValorDefecto(fechaHora));
	}

	public static LocalDateTime obtenerFechaHoraActual() {
		return LocalDateTime.now(UtilFecha.ZONA_HORARIA).truncatedTo(ChronoUnit.MINUTES);
	}

	public static boolean esAnterior(final LocalDateTime fechaHora, final LocalDateTime fechaHoraReferencia) {
		return obtenerValorDefecto(fechaHora).isBefore(obtenerValorDefecto(fechaHoraReferencia));
	}

	public static boolean esPosterior(final LocalDateTime fechaHora, final LocalDateTime fechaHoraReferencia) {
		return obtenerValorDefecto(fechaHora).isAfter(obtenerValorDefecto(fechaHoraReferencia));
	}

	public static boolean seSolapan(final LocalDateTime inicioPrimerRango, final LocalDateTime finPrimerRango,
			final LocalDateTime inicioSegundoRango, final LocalDateTime finSegundoRango) {
		return esAnterior(inicioPrimerRango, finSegundoRango) && esAnterior(inicioSegundoRango, finPrimerRango);
	}
	
	private static LocalDateTime combinar(final LocalDate fecha, final LocalTime hora) {
		return LocalDateTime.of(UtilFecha.obtenerValorDefecto(fecha), UtilHora.obtenerValorDefecto(hora));
	}
}
