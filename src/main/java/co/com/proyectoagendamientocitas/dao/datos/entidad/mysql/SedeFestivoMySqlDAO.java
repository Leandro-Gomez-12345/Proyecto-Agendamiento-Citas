package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.SedeFestivoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.SedeFestivoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class SedeFestivoMySqlDAO extends SqlDAO implements SedeFestivoDAO {

	private static final String SQL_CREAR = "INSERT INTO sedeFestivo (id, sede, festivo) VALUES (?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, sede, festivo FROM sedeFestivo";
	private static final String SQL_ELIMINAR = "DELETE FROM sedeFestivo WHERE id = ?";

	public SedeFestivoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SedeFestivoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_FECHA_FESTIVO,
				entidad.getId().toString(), entidad.getSede().getId().toString(),
				entidad.getFestivo().getId().toString());
	}

	@Override
	public SedeFestivoEntidad consultarPorId(final UUID id) {
		var filtro = new SedeFestivoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new SedeFestivoEntidad() : resultados.get(0);
	}

	@Override
	public List<SedeFestivoEntidad> consultarPorFiltro(final SedeFestivoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new SedeFestivoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("sede", filtroSeguro.getSede().getId())
				.conId("festivo", filtroSeguro.getFestivo().getId());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_FECHA_FESTIVO);
	}

	@Override
	public List<SedeFestivoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_FECHA_FESTIVO);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_FECHA_FESTIVO,
				id.toString());
	}

	private SedeFestivoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new SedeFestivoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getSede().setId(leerUUID(resultados, "sede"));
		entidad.getFestivo().setId(leerUUID(resultados, "festivo"));
		return entidad;
	}
}
