package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.CiudadDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.CiudadEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class CiudadMySqlDAO extends SqlDAO implements CiudadDAO {

	private static final String SQL_CONSULTAR = "SELECT id, nombre, departamento FROM ciudad";

	public CiudadMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public CiudadEntidad consultarPorId(final UUID id) {
		var filtro = new CiudadEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new CiudadEntidad() : resultados.get(0);
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(final CiudadEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CiudadEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombre", filtroSeguro.getNombre())
				.conId("departamento", filtroSeguro.getDepartamento().getId());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CIUDAD);
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CIUDAD);
	}

	private CiudadEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new CiudadEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("nombre"));
		entidad.getDepartamento().setId(leerUUID(resultados, "departamento"));
		return entidad;
	}
}
