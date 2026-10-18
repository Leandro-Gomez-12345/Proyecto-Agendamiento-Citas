package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.PeriodoCierreDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.PeriodoCierreEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class PeriodoCierreMySqlDAO extends SqlDAO implements PeriodoCierreDAO {

	private static final String SQL_CREAR =
			"INSERT INTO periodoCierre (id, sede, fechaHoraInicio, fechaHoraFinal, motivo) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, sede, fechaHoraInicio, fechaHoraFinal, motivo FROM periodoCierre";
	private static final String SQL_ACTUALIZAR =
			"UPDATE periodoCierre SET sede = ?, fechaHoraInicio = ?, fechaHoraFinal = ?, motivo = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM periodoCierre WHERE id = ?";

	public PeriodoCierreMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PeriodoCierreEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_PERIODO_CIERRE,
				entidad.getId().toString(), entidad.getSede().getId().toString(),
				entidad.getFechaHoraInicio(), entidad.getFechaHoraFinal(), entidad.getMotivo());
	}

	@Override
	public PeriodoCierreEntidad consultarPorId(final UUID id) {
		var filtro = new PeriodoCierreEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new PeriodoCierreEntidad() : resultados.get(0);
	}

	@Override
	public List<PeriodoCierreEntidad> consultarPorFiltro(final PeriodoCierreEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PeriodoCierreEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("sede", filtroSeguro.getSede().getId())
				.conFechaHora("fechaHoraInicio", filtroSeguro.getFechaHoraInicio())
				.conFechaHora("fechaHoraFinal", filtroSeguro.getFechaHoraFinal())
				.conTexto("motivo", filtroSeguro.getMotivo());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_PERIODO_CIERRE);
	}

	@Override
	public List<PeriodoCierreEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_PERIODO_CIERRE);
	}

	@Override
	public void actualizar(final UUID id, final PeriodoCierreEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR,
				CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_PERIODO_CIERRE,
				entidad.getSede().getId().toString(), entidad.getFechaHoraInicio(),
				entidad.getFechaHoraFinal(), entidad.getMotivo(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_PERIODO_CIERRE,
				id.toString());
	}

	private PeriodoCierreEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new PeriodoCierreEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getSede().setId(leerUUID(resultados, "sede"));
		entidad.setFechaHoraInicio(resultados.getObject("fechaHoraInicio", LocalDateTime.class));
		entidad.setFechaHoraFinal(resultados.getObject("fechaHoraFinal", LocalDateTime.class));
		entidad.setMotivo(resultados.getString("motivo"));
		return entidad;
	}
}
