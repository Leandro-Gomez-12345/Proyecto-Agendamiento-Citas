package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.BarberoServicioDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.BarberoServicioEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class BarberoServicioMySqlDAO extends SqlDAO implements BarberoServicioDAO {

	private static final String SQL_CREAR =
			"INSERT INTO barberoServicio (id, barbero, servicio, duracionEnHoras, duracionEnMinutos, tiempoExtra, vigente) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, barbero, servicio, duracionEnHoras, duracionEnMinutos, tiempoExtra, vigente FROM barberoServicio";
	private static final String SQL_ACTUALIZAR =
			"UPDATE barberoServicio SET barbero = ?, servicio = ?, duracionEnHoras = ?, duracionEnMinutos = ?, tiempoExtra = ?, vigente = ? WHERE id = ?";

	public BarberoServicioMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final BarberoServicioEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_BARBERO_SERVICIO,
				entidad.getId().toString(), entidad.getBarbero().getId().toString(),
				entidad.getServicio().getId().toString(), entidad.getDuracionEnHoras(),
				entidad.getDuracionEnMinutos(), entidad.getTiempoExtra(), entidad.isVigente());
	}

	@Override
	public BarberoServicioEntidad consultarPorId(final UUID id) {
		var filtro = new BarberoServicioEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new BarberoServicioEntidad() : resultados.get(0);
	}

	@Override
	public List<BarberoServicioEntidad> consultarPorFiltro(final BarberoServicioEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new BarberoServicioEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("barbero", filtroSeguro.getBarbero().getId())
				.conId("servicio", filtroSeguro.getServicio().getId())
				.conEntero("duracionEnHoras", filtroSeguro.getDuracionEnHoras())
				.conEntero("duracionEnMinutos", filtroSeguro.getDuracionEnMinutos())
				.conEntero("tiempoExtra", filtroSeguro.getTiempoExtra())
				.conBooleano("vigente", filtroSeguro.isVigente(), UtilBooleano.SI);
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BARBERO_SERVICIO);
	}

	@Override
	public List<BarberoServicioEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BARBERO_SERVICIO);
	}

	@Override
	public void actualizar(final UUID id, final BarberoServicioEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR,
				CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_BARBERO_SERVICIO,
				entidad.getBarbero().getId().toString(), entidad.getServicio().getId().toString(),
				entidad.getDuracionEnHoras(), entidad.getDuracionEnMinutos(), entidad.getTiempoExtra(),
				entidad.isVigente(), id.toString());
	}

	private BarberoServicioEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new BarberoServicioEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getBarbero().setId(leerUUID(resultados, "barbero"));
		entidad.getServicio().setId(leerUUID(resultados, "servicio"));
		entidad.setDuracionEnHoras(resultados.getInt("duracionEnHoras"));
		entidad.setDuracionEnMinutos(resultados.getInt("duracionEnMinutos"));
		entidad.setTiempoExtra(resultados.getInt("tiempoExtra"));
		entidad.setVigente(resultados.getBoolean("vigente"));
		return entidad;
	}
}
