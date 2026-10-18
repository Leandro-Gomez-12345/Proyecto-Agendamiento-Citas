package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.BloqueoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.BloqueoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class BloqueoMySqlDAO extends SqlDAO implements BloqueoDAO {

	private static final String SQL_CREAR =
			"INSERT INTO bloqueo (id, barbero, fechaHoraInicio, fechaHoraFinal) VALUES (?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, barbero, fechaHoraInicio, fechaHoraFinal FROM bloqueo";
	private static final String SQL_ACTUALIZAR =
			"UPDATE bloqueo SET barbero = ?, fechaHoraInicio = ?, fechaHoraFinal = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM bloqueo WHERE id = ?";

	public BloqueoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final BloqueoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_BLOQUEO,
				entidad.getId().toString(), entidad.getBarbero().getId().toString(),
				entidad.getFechaHoraInicio(), entidad.getFechaHoraFinal());
	}

	@Override
	public BloqueoEntidad consultarPorId(final UUID id) {
		var filtro = new BloqueoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new BloqueoEntidad() : resultados.get(0);
	}

	@Override
	public List<BloqueoEntidad> consultarPorFiltro(final BloqueoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new BloqueoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("barbero", filtroSeguro.getBarbero().getId())
				.conFechaHora("fechaHoraInicio", filtroSeguro.getFechaHoraInicio())
				.conFechaHora("fechaHoraFinal", filtroSeguro.getFechaHoraFinal());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BLOQUEO);
	}

	@Override
	public List<BloqueoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BLOQUEO);
	}

	@Override
	public void actualizar(final UUID id, final BloqueoEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_BLOQUEO,
				entidad.getBarbero().getId().toString(), entidad.getFechaHoraInicio(),
				entidad.getFechaHoraFinal(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_BLOQUEO,
				id.toString());
	}

	private BloqueoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new BloqueoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getBarbero().setId(leerUUID(resultados, "barbero"));
		entidad.setFechaHoraInicio(resultados.getObject("fechaHoraInicio", LocalDateTime.class));
		entidad.setFechaHoraFinal(resultados.getObject("fechaHoraFinal", LocalDateTime.class));
		return entidad;
	}
}
