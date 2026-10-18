package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SedeDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class SedeMySqlDAO extends SqlDAO implements SedeDAO {

	private static final String SQL_CREAR =
			"INSERT INTO sede (id, ciudad, barberia, nombre, direccion) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, ciudad, barberia, nombre, direccion FROM sede";
	private static final String SQL_ACTUALIZAR =
			"UPDATE sede SET ciudad = ?, barberia = ?, nombre = ?, direccion = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM sede WHERE id = ?";

	public SedeMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SedeEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_SEDE,
				entidad.getId().toString(), entidad.getCiudad().getId().toString(),
				entidad.getBarberia().getId().toString(), entidad.getNombre(), entidad.getDireccion());
	}

	@Override
	public SedeEntidad consultarPorId(final UUID id) {
		var filtro = new SedeEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new SedeEntidad() : resultados.get(0);
	}

	@Override
	public List<SedeEntidad> consultarPorFiltro(final SedeEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new SedeEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("ciudad", filtroSeguro.getCiudad().getId())
				.conId("barberia", filtroSeguro.getBarberia().getId())
				.conTexto("nombre", filtroSeguro.getNombre())
				.conTexto("direccion", filtroSeguro.getDireccion());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_SEDE);
	}

	@Override
	public List<SedeEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_SEDE);
	}

	@Override
	public void actualizar(final UUID id, final SedeEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_SEDE,
				entidad.getCiudad().getId().toString(), entidad.getBarberia().getId().toString(),
				entidad.getNombre(), entidad.getDireccion(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_SEDE,
				id.toString());
	}

	private SedeEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new SedeEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getCiudad().setId(leerUUID(resultados, "ciudad"));
		entidad.getBarberia().setId(leerUUID(resultados, "barberia"));
		entidad.setNombre(resultados.getString("nombre"));
		entidad.setDireccion(resultados.getString("direccion"));
		return entidad;
	}
}
