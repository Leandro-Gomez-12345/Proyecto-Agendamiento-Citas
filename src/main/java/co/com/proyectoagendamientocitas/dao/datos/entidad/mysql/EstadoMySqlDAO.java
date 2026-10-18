package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.EstadoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.EstadoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class EstadoMySqlDAO extends SqlDAO implements EstadoDAO {

	private static final String SQL_CONSULTAR = "SELECT id, nombre, descripcion FROM estado";
	private static final String SQL_ACTUALIZAR = "UPDATE estado SET nombre = ?, descripcion = ? WHERE id = ?";

	public EstadoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public EstadoEntidad consultarPorId(final UUID id) {
		var filtro = new EstadoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new EstadoEntidad() : resultados.get(0);
	}

	@Override
	public List<EstadoEntidad> consultarPorFiltro(final EstadoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new EstadoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombre", filtroSeguro.getNombre())
				.conTexto("descripcion", filtroSeguro.getDescripcion());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_ESTADO);
	}

	@Override
	public List<EstadoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_ESTADO);
	}

	@Override
	public void actualizar(final UUID id, final EstadoEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_ESTADO,
				entidad.getNombre(), entidad.getDescripcion(), id.toString());
	}

	private EstadoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new EstadoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("nombre"));
		entidad.setDescripcion(resultados.getString("descripcion"));
		return entidad;
	}
}
