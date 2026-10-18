package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.BarberoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.BarberoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class BarberoMySqlDAO extends SqlDAO implements BarberoDAO {

	private static final String SQL_CREAR =
			"INSERT INTO barbero (id, primerNombre, segundoNombre, primerApellido, segundoApellido, prefijo, celular, elNumeroCelularEsCorrecto, vigente, sedeDeTrabajo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, primerNombre, segundoNombre, primerApellido, segundoApellido, prefijo, celular, elNumeroCelularEsCorrecto, vigente, sedeDeTrabajo FROM barbero";
	private static final String SQL_ACTUALIZAR =
			"UPDATE barbero SET primerNombre = ?, segundoNombre = ?, primerApellido = ?, segundoApellido = ?, prefijo = ?, celular = ?, elNumeroCelularEsCorrecto = ?, vigente = ?, sedeDeTrabajo = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM barbero WHERE id = ?";

	public BarberoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final BarberoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_BARBERO,
				entidad.getId().toString(), entidad.getPrimerNombre(), entidad.getSegundoNombre(),
				entidad.getPrimerApellido(), entidad.getSegundoApellido(),
				entidad.getPrefijo().getId().toString(), entidad.getCelular(),
				entidad.isElNumeroCelularEsCorrecto(), entidad.isVigente(),
				entidad.getSedeDeTrabajo().getId().toString());
	}

	@Override
	public BarberoEntidad consultarPorId(final UUID id) {
		var filtro = new BarberoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new BarberoEntidad() : resultados.get(0);
	}

	@Override
	public List<BarberoEntidad> consultarPorFiltro(final BarberoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new BarberoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conTexto("primerNombre", filtroSeguro.getPrimerNombre())
				.conTexto("segundoNombre", filtroSeguro.getSegundoNombre())
				.conTexto("primerApellido", filtroSeguro.getPrimerApellido())
				.conTexto("segundoApellido", filtroSeguro.getSegundoApellido())
				.conId("prefijo", filtroSeguro.getPrefijo().getId())
				.conTexto("celular", filtroSeguro.getCelular())
				.conBooleano("elNumeroCelularEsCorrecto", filtroSeguro.isElNumeroCelularEsCorrecto(), UtilBooleano.NO)
				.conBooleano("vigente", filtroSeguro.isVigente(), UtilBooleano.SI)
				.conId("sedeDeTrabajo", filtroSeguro.getSedeDeTrabajo().getId());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BARBERO);
	}

	@Override
	public List<BarberoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_BARBERO);
	}

	@Override
	public void actualizar(final UUID id, final BarberoEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_BARBERO,
				entidad.getPrimerNombre(), entidad.getSegundoNombre(), entidad.getPrimerApellido(),
				entidad.getSegundoApellido(), entidad.getPrefijo().getId().toString(), entidad.getCelular(),
				entidad.isElNumeroCelularEsCorrecto(), entidad.isVigente(),
				entidad.getSedeDeTrabajo().getId().toString(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_BARBERO,
				id.toString());
	}

	private BarberoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new BarberoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setPrimerNombre(resultados.getString("primerNombre"));
		entidad.setSegundoNombre(resultados.getString("segundoNombre"));
		entidad.setPrimerApellido(resultados.getString("primerApellido"));
		entidad.setSegundoApellido(resultados.getString("segundoApellido"));
		entidad.getPrefijo().setId(leerUUID(resultados, "prefijo"));
		entidad.setCelular(resultados.getString("celular"));
		entidad.setElNumeroCelularEsCorrecto(resultados.getBoolean("elNumeroCelularEsCorrecto"));
		entidad.setVigente(resultados.getBoolean("vigente"));
		entidad.getSedeDeTrabajo().setId(leerUUID(resultados, "sedeDeTrabajo"));
		return entidad;
	}
}
