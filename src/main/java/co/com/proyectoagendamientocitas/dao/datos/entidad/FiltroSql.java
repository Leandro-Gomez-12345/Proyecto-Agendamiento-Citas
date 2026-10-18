package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class FiltroSql {

	private final StringBuilder sentencia;
	private final List<Object> parametros = new ArrayList<>();

	public FiltroSql(final String sentenciaBase) {
		sentencia = new StringBuilder(sentenciaBase).append(" WHERE 1=1");
	}

	public FiltroSql conId(final String columna, final UUID valor) {
		if (!UtilUUID.obtenerUUIDDefecto().equals(valor)) {
			agregar(columna, valor.toString());
		}
		return this;
	}

	public FiltroSql conTexto(final String columna, final String valor) {
		if (!UtilTexto.esVacia(valor)) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conEntero(final String columna, final int valor) {
		if (valor != UtilNumero.CERO) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conBooleano(final String columna, final boolean valor, final boolean valorDefecto) {
		if (valor != valorDefecto) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conHora(final String columna, final LocalTime valor) {
		if (!UtilHora.HORA_DEFECTO.equals(valor)) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conFecha(final String columna, final LocalDate valor) {
		if (!UtilFecha.esValorDefecto(valor)) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conFechaHora(final String columna, final LocalDateTime valor) {
		if (!UtilFechaHora.esValorDefecto(valor)) {
			agregar(columna, valor);
		}
		return this;
	}

	public String getSentencia() {
		return sentencia.toString();
	}

	public List<Object> getParametros() {
		return parametros;
	}

	private void agregar(final String columna, final Object valor) {
		sentencia.append(" AND ").append(columna).append(" = ?");
		parametros.add(valor);
	}
}
