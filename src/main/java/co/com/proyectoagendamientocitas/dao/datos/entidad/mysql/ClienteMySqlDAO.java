package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.ClienteDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.ClienteEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class ClienteMySqlDAO extends SqlDAO implements ClienteDAO {

	private static final String SQL_CREAR =
			"INSERT INTO cliente (id, primerNombre, segundoNombre, primerApellido, segundoApellido, prefijoCelular, celular, elNumeroCelularEsCorrecto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, primerNombre, segundoNombre, primerApellido, segundoApellido, prefijoCelular, celular, elNumeroCelularEsCorrecto FROM cliente";
	private static final String SQL_ACTUALIZAR =
			"UPDATE cliente SET primerNombre = ?, segundoNombre = ?, primerApellido = ?, segundoApellido = ?, prefijoCelular = ?, celular = ?, elNumeroCelularEsCorrecto = ? WHERE id = ?";

	public ClienteMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_CLIENTE,
				entidad.getId().toString(), entidad.getPrimerNombre(), entidad.getSegundoNombre(),
				entidad.getPrimerApellido(), entidad.getSegundoApellido(),
				entidad.getPrefijoCelular().getId().toString(), entidad.getCelular(),
				entidad.isElNumeroCelularEsCorrecto());
	}

	@Override
	public ClienteEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new ClienteEntidad() : resultados.get(0);
	}

	@Override
	public List<ClienteEntidad> consultarPorFiltro(final ClienteEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("primerNombre", filtroSeguro.getPrimerNombre())
				.conTexto("segundoNombre", filtroSeguro.getSegundoNombre())
				.conTexto("primerApellido", filtroSeguro.getPrimerApellido())
				.conTexto("segundoApellido", filtroSeguro.getSegundoApellido())
				.conId("prefijoCelular", filtroSeguro.getPrefijoCelular().getId())
				.conTexto("celular", filtroSeguro.getCelular())
				.conBooleano("elNumeroCelularEsCorrecto", filtroSeguro.isElNumeroCelularEsCorrecto(), UtilBooleano.NO);
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CLIENTE);
	}

	@Override
	public List<ClienteEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CLIENTE);
	}

	@Override
	public void actualizar(final UUID id, final ClienteEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_CLIENTE,
				entidad.getPrimerNombre(), entidad.getSegundoNombre(), entidad.getPrimerApellido(),
				entidad.getSegundoApellido(), entidad.getPrefijoCelular().getId().toString(),
				entidad.getCelular(), entidad.isElNumeroCelularEsCorrecto(), id.toString());
	}

	private ClienteEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new ClienteEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setPrimerNombre(resultados.getString("primerNombre"));
		entidad.setSegundoNombre(resultados.getString("segundoNombre"));
		entidad.setPrimerApellido(resultados.getString("primerApellido"));
		entidad.setSegundoApellido(resultados.getString("segundoApellido"));
		entidad.getPrefijoCelular().setId(leerUUID(resultados, "prefijoCelular"));
		entidad.setCelular(resultados.getString("celular"));
		entidad.setElNumeroCelularEsCorrecto(resultados.getBoolean("elNumeroCelularEsCorrecto"));
		return entidad;
	}
}
