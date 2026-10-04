package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public final class UtilHora {

	public static final LocalTime HORA_DEFECTO = LocalTime.MIDNIGHT;

	private UtilHora() {

	}

	public static LocalTime obtenerValorDefecto(final LocalTime hora, final LocalTime valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(hora, valorDefecto);
	}

	public static LocalTime obtenerValorDefecto(final LocalTime hora) {
		return obtenerValorDefecto(hora, HORA_DEFECTO);
	}

	public static LocalTime obtenerHoraActual() {
		return LocalTime.now(UtilFecha.ZONA_HORARIA).truncatedTo(ChronoUnit.MINUTES);
	}

	public static boolean esAnterior(final LocalTime hora, final LocalTime horaReferencia) {
		return obtenerValorDefecto(hora).isBefore(obtenerValorDefecto(horaReferencia));
	}

	public static boolean esPosterior(final LocalTime hora, final LocalTime horaReferencia) {
		return obtenerValorDefecto(hora).isAfter(obtenerValorDefecto(horaReferencia));
	}

	public static boolean estaEnRango(final LocalTime hora, final LocalTime horaInicial,
			final LocalTime horaFinal) {
		return !esAnterior(hora, horaInicial) && !esPosterior(hora, horaFinal);
	}

	public static LocalTime sumarMinutos(final LocalTime hora, final long minutos) {
		return obtenerValorDefecto(hora).plusMinutes(minutos);
	}
}
