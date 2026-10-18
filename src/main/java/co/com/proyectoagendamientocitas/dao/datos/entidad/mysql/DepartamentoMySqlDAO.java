package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.DepartamentoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.DepartamentoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class DepartamentoMySqlDAO extends SqlDAO implements DepartamentoDAO {

	private static final String SQL_CONSULTAR = "SELECT id, nombre FROM departamento";

	public DepartamentoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoEntidad consultarPorId(final UUID id) {
		var filtro = new DepartamentoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new DepartamentoEntidad() : resultados.get(0);
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(final DepartamentoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DepartamentoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombre", filtroSeguro.getNombre());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_DEPARTAMENTO);
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_DEPARTAMENTO);
	}

	private DepartamentoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new DepartamentoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("nombre"));
		return entidad;
	}
}
