package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.TipoMultaDAO;
import co.com.proyectoagendamientocitas.entidad.TipoMultaEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class TipoMultaMySqlDAO extends SqlDAO implements TipoMultaDAO {

	private static final String SQL_CONSULTAR = "SELECT id, nombre, descripcion FROM tipoMulta";

	public TipoMultaMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoMultaEntidad consultarPorId(final UUID id) {
		var filtro = new TipoMultaEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new TipoMultaEntidad() : resultados.get(0);
	}

	@Override
	public List<TipoMultaEntidad> consultarPorFiltro(final TipoMultaEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new TipoMultaEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombre", filtroSeguro.getNombre())
				.conTexto("descripcion", filtroSeguro.getDescripcion());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_TIPO_MULTA);
	}

	@Override
	public List<TipoMultaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_TIPO_MULTA);
	}

	private TipoMultaEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new TipoMultaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("nombre"));
		entidad.setDescripcion(resultados.getString("descripcion"));
		return entidad;
	}
}
