package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.TipoSociedadDAO;
import co.com.proyectoagendamientocitas.entidad.TipoSociedadEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class TipoSociedadMySqlDAO extends SqlDAO implements TipoSociedadDAO {

	private static final String SQL_CONSULTAR = "SELECT id, nombre, sufijo FROM tipoSociedad";

	public TipoSociedadMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoSociedadEntidad consultarPorId(final UUID id) {
		var filtro = new TipoSociedadEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new TipoSociedadEntidad() : resultados.get(0);
	}

	@Override
	public List<TipoSociedadEntidad> consultarPorFiltro(final TipoSociedadEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new TipoSociedadEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombre", filtroSeguro.getNombre())
				.conTexto("sufijo", filtroSeguro.getSufijo());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_TIPO_SOCIEDAD);
	}

	@Override
	public List<TipoSociedadEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_TIPO_SOCIEDAD);
	}

	private TipoSociedadEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new TipoSociedadEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("nombre"));
		entidad.setSufijo(resultados.getString("sufijo"));
		return entidad;
	}
}
