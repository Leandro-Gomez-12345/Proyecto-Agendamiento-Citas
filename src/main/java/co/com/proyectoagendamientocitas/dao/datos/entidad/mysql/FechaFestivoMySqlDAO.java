package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FechaFestivoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.FechaFestivoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class FechaFestivoMySqlDAO extends SqlDAO implements FechaFestivoDAO {

	private static final String SQL_CREAR = "INSERT INTO fechaFestivo (id, sede, festivo) VALUES (?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, sede, festivo FROM fechaFestivo";
	private static final String SQL_ELIMINAR = "DELETE FROM fechaFestivo WHERE id = ?";

	public FechaFestivoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final FechaFestivoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_FECHA_FESTIVO,
				entidad.getId().toString(), entidad.getSede().getId().toString(),
				entidad.getFestivo().getId().toString());
	}

	@Override
	public FechaFestivoEntidad consultarPorId(final UUID id) {
		var filtro = new FechaFestivoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new FechaFestivoEntidad() : resultados.get(0);
	}

	@Override
	public List<FechaFestivoEntidad> consultarPorFiltro(final FechaFestivoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new FechaFestivoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("sede", filtroSeguro.getSede().getId())
				.conId("festivo", filtroSeguro.getFestivo().getId());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_FECHA_FESTIVO);
	}

	@Override
	public List<FechaFestivoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_FECHA_FESTIVO);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_FECHA_FESTIVO,
				id.toString());
	}

	private FechaFestivoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new FechaFestivoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getSede().setId(leerUUID(resultados, "sede"));
		entidad.getFestivo().setId(leerUUID(resultados, "festivo"));
		return entidad;
	}
}
