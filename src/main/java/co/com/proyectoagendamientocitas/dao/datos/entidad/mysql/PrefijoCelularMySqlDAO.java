package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.PrefijoCelularDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.PrefijoCelularEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class PrefijoCelularMySqlDAO extends SqlDAO implements PrefijoCelularDAO {

	private static final String SQL_CONSULTAR = "SELECT id, prefijo FROM prefijoCelular";

	public PrefijoCelularMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public PrefijoCelularEntidad consultarPorId(final UUID id) {
		var filtro = new PrefijoCelularEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new PrefijoCelularEntidad() : resultados.get(0);
	}

	@Override
	public List<PrefijoCelularEntidad> consultarPorFiltro(final PrefijoCelularEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PrefijoCelularEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("prefijo", filtroSeguro.getPrefijo());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_PREFIJO_CELULAR);
	}

	@Override
	public List<PrefijoCelularEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_PREFIJO_CELULAR);
	}

	private PrefijoCelularEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new PrefijoCelularEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setPrefijo(resultados.getString("prefijo"));
		return entidad;
	}
}
