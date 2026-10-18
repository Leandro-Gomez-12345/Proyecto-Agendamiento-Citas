package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.DiaSemanaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.DiaSemanaEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class DiaSemanaMySqlDAO extends SqlDAO implements DiaSemanaDAO {

	private static final String SQL_CONSULTAR = "SELECT id, nombre FROM diaSemana";

	public DiaSemanaMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public DiaSemanaEntidad consultarPorId(final UUID id) {
		var filtro = new DiaSemanaEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new DiaSemanaEntidad() : resultados.get(0);
	}

	@Override
	public List<DiaSemanaEntidad> consultarPorFiltro(final DiaSemanaEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DiaSemanaEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombre", filtroSeguro.getNombre());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_DIA_SEMANA);
	}

	@Override
	public List<DiaSemanaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_DIA_SEMANA);
	}

	private DiaSemanaEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new DiaSemanaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("nombre"));
		return entidad;
	}
}
