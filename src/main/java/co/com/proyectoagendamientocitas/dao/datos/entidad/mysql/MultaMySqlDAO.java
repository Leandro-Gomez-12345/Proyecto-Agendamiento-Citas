package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.MultaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.MultaEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class MultaMySqlDAO extends SqlDAO implements MultaDAO {

	private static final String SQL_CREAR =
			"INSERT INTO multa (id, cita, tipo, monto, horaGeneracion, fechaHoraPago, pagada) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, cita, tipo, monto, horaGeneracion, fechaHoraPago, pagada FROM multa";
	private static final String SQL_ACTUALIZAR =
			"UPDATE multa SET cita = ?, tipo = ?, monto = ?, horaGeneracion = ?, fechaHoraPago = ?, pagada = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM multa WHERE id = ?";

	public MultaMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final MultaEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_MULTA,
				entidad.getId().toString(), entidad.getCita().getId().toString(),
				entidad.getTipo().getId().toString(), entidad.getMonto(), entidad.getHoraGeneracion(),
				entidad.getFechaHoraPago(), entidad.isPagada());
	}

	@Override
	public MultaEntidad consultarPorId(final UUID id) {
		var filtro = new MultaEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new MultaEntidad() : resultados.get(0);
	}

	@Override
	public List<MultaEntidad> consultarPorFiltro(final MultaEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new MultaEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("cita", filtroSeguro.getCita().getId())
				.conId("tipo", filtroSeguro.getTipo().getId())
				.conEntero("monto", filtroSeguro.getMonto())
				.conHora("horaGeneracion", filtroSeguro.getHoraGeneracion())
				.conFechaHora("fechaHoraPago", filtroSeguro.getFechaHoraPago())
				.conBooleano("pagada", filtroSeguro.isPagada(), UtilBooleano.NO);
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_MULTA);
	}

	@Override
	public List<MultaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_MULTA);
	}

	@Override
	public void actualizar(final UUID id, final MultaEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_MULTA,
				entidad.getCita().getId().toString(), entidad.getTipo().getId().toString(),
				entidad.getMonto(), entidad.getHoraGeneracion(), entidad.getFechaHoraPago(),
				entidad.isPagada(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_MULTA,
				id.toString());
	}

	private MultaEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new MultaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getCita().setId(leerUUID(resultados, "cita"));
		entidad.getTipo().setId(leerUUID(resultados, "tipo"));
		entidad.setMonto(resultados.getInt("monto"));
		entidad.setHoraGeneracion(resultados.getObject("horaGeneracion", LocalTime.class));
		entidad.setFechaHoraPago(resultados.getObject("fechaHoraPago", LocalDateTime.class));
		entidad.setPagada(resultados.getBoolean("pagada"));
		return entidad;
	}
}
