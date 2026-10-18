package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.ServicioDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.ServicioEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class ServicioMySqlDAO extends SqlDAO implements ServicioDAO {

	private static final String SQL_CREAR =
			"INSERT INTO servicio (id, sede, nombre, descripcion, precio, disponible) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, sede, nombre, descripcion, precio, disponible FROM servicio";
	private static final String SQL_ACTUALIZAR =
			"UPDATE servicio SET sede = ?, nombre = ?, descripcion = ?, precio = ?, disponible = ? WHERE id = ?";

	public ServicioMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ServicioEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_SERVICIO,
				entidad.getId().toString(), entidad.getSede().getId().toString(), entidad.getNombre(),
				entidad.getDescripcion(), entidad.getPrecio(), entidad.isDisponible());
	}

	@Override
	public ServicioEntidad consultarPorId(final UUID id) {
		var filtro = new ServicioEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new ServicioEntidad() : resultados.get(0);
	}

	@Override
	public List<ServicioEntidad> consultarPorFiltro(final ServicioEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ServicioEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("sede", filtroSeguro.getSede().getId())
				.conTexto("nombre", filtroSeguro.getNombre())
				.conTexto("descripcion", filtroSeguro.getDescripcion())
				.conEntero("precio", filtroSeguro.getPrecio())
				.conBooleano("disponible", filtroSeguro.isDisponible(), UtilBooleano.SI);
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_SERVICIO);
	}

	@Override
	public List<ServicioEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_SERVICIO);
	}

	@Override
	public void actualizar(final UUID id, final ServicioEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_SERVICIO,
				entidad.getSede().getId().toString(), entidad.getNombre(), entidad.getDescripcion(),
				entidad.getPrecio(), entidad.isDisponible(), id.toString());
	}

	private ServicioEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new ServicioEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getSede().setId(leerUUID(resultados, "sede"));
		entidad.setNombre(resultados.getString("nombre"));
		entidad.setDescripcion(resultados.getString("descripcion"));
		entidad.setPrecio(resultados.getInt("precio"));
		entidad.setDisponible(resultados.getBoolean("disponible"));
		return entidad;
	}
}
