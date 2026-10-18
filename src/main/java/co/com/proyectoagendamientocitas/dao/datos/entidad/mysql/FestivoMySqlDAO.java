package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FestivoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.FestivoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class FestivoMySqlDAO extends SqlDAO implements FestivoDAO {

	private static final String SQL_CREAR = "INSERT INTO festivo (id, fecha, nombre) VALUES (?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, fecha, nombre FROM festivo";
	private static final String SQL_ACTUALIZAR = "UPDATE festivo SET fecha = ?, nombre = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM festivo WHERE id = ?";

	public FestivoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final FestivoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_FESTIVO,
				entidad.getId().toString(), entidad.getFecha(), entidad.getNombre());
	}

	@Override
	public FestivoEntidad consultarPorId(final UUID id) {
		var filtro = new FestivoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new FestivoEntidad() : resultados.get(0);
	}

	@Override
	public List<FestivoEntidad> consultarPorFiltro(final FestivoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new FestivoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conFecha("fecha", filtroSeguro.getFecha())
				.conTexto("nombre", filtroSeguro.getNombre());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_FESTIVO);
	}

	@Override
	public List<FestivoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_FESTIVO);
	}

	@Override
	public void actualizar(final UUID id, final FestivoEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_FESTIVO,
				entidad.getFecha(), entidad.getNombre(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_FESTIVO,
				id.toString());
	}

	private FestivoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new FestivoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setFecha(resultados.getObject("fecha", LocalDate.class));
		entidad.setNombre(resultados.getString("nombre"));
		return entidad;
	}
}
