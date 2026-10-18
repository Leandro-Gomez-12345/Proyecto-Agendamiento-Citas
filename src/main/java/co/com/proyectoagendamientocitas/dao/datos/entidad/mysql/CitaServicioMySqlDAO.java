package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.CitaServicioDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.CitaServicioEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class CitaServicioMySqlDAO extends SqlDAO implements CitaServicioDAO {

	private static final String SQL_CREAR =
			"INSERT INTO citaServicio (id, cita, barberoServicio, precioServicio, duracionEnHorasElServicio, duracionEnMinutosElServicio, tiempoExtra) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, cita, barberoServicio, precioServicio, duracionEnHorasElServicio, duracionEnMinutosElServicio, tiempoExtra FROM citaServicio";

	public CitaServicioMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final CitaServicioEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_CITA_SERVICIO,
				entidad.getId().toString(), entidad.getCita().getId().toString(),
				entidad.getBarberoServicio().getId().toString(), entidad.getPrecioServicio(),
				entidad.getDuracionEnHorasElServicio(), entidad.getDuracionEnMinutosElServicio(),
				entidad.getTiempoExtra());
	}

	@Override
	public CitaServicioEntidad consultarPorId(final UUID id) {
		var filtro = new CitaServicioEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new CitaServicioEntidad() : resultados.get(0);
	}

	@Override
	public List<CitaServicioEntidad> consultarPorFiltro(final CitaServicioEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CitaServicioEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("cita", filtroSeguro.getCita().getId())
				.conId("barberoServicio", filtroSeguro.getBarberoServicio().getId())
				.conEntero("precioServicio", filtroSeguro.getPrecioServicio())
				.conEntero("duracionEnHorasElServicio", filtroSeguro.getDuracionEnHorasElServicio())
				.conEntero("duracionEnMinutosElServicio", filtroSeguro.getDuracionEnMinutosElServicio())
				.conEntero("tiempoExtra", filtroSeguro.getTiempoExtra());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CITA_SERVICIO);
	}

	@Override
	public List<CitaServicioEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CITA_SERVICIO);
	}

	private CitaServicioEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new CitaServicioEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getCita().setId(leerUUID(resultados, "cita"));
		entidad.getBarberoServicio().setId(leerUUID(resultados, "barberoServicio"));
		entidad.setPrecioServicio(resultados.getInt("precioServicio"));
		entidad.setDuracionEnHorasElServicio(resultados.getInt("duracionEnHorasElServicio"));
		entidad.setDuracionEnMinutosElServicio(resultados.getInt("duracionEnMinutosElServicio"));
		entidad.setTiempoExtra(resultados.getInt("tiempoExtra"));
		return entidad;
	}
}
