package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.BarberiaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class BarberiaMySqlDAO extends SqlDAO implements BarberiaDAO {

	private static final String SQL_CREAR =
			"INSERT INTO barberia (id, nombreBarberia, razonSocial, nit) VALUES (?, ?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, nombreBarberia, razonSocial, nit FROM barberia";
	private static final String SQL_ACTUALIZAR =
			"UPDATE barberia SET nombreBarberia = ?, razonSocial = ?, nit = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM barberia WHERE id = ?";

	public BarberiaMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final BarberiaEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_BARBERIA,
				entidad.getId().toString(), entidad.getNombreBarberia(), entidad.getRazonSocial(),
				entidad.getNit());
	}

	@Override
	public BarberiaEntidad consultarPorId(final UUID id) {
		var filtro = new BarberiaEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new BarberiaEntidad() : resultados.get(0);
	}

	@Override
	public List<BarberiaEntidad> consultarPorFiltro(final BarberiaEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new BarberiaEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("nombreBarberia", filtroSeguro.getNombreBarberia())
				.conTexto("razonSocial", filtroSeguro.getRazonSocial())
				.conTexto("nit", filtroSeguro.getNit());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BARBERIA);
	}

	@Override
	public List<BarberiaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BARBERIA);
	}

	@Override
	public void actualizar(final UUID id, final BarberiaEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_BARBERIA,
				entidad.getNombreBarberia(), entidad.getRazonSocial(), entidad.getNit(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_BARBERIA,
				id.toString());
	}

	private BarberiaEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new BarberiaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombreBarberia(resultados.getString("nombreBarberia"));
		entidad.setRazonSocial(resultados.getString("razonSocial"));
		entidad.setNit(resultados.getString("nit"));
		return entidad;
	}
}
