package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.AgendaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.AgendaEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class AgendaMySqlDAO extends SqlDAO implements AgendaDAO {

	private static final String SQL_CREAR =
			"INSERT INTO agenda (id, horarioDelBarbero, fecha) VALUES (?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, horarioDelBarbero, fecha FROM agenda";

	public AgendaMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final AgendaEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_AGENDA,
				entidad.getId().toString(), entidad.getHorarioDelBarbero().getId().toString(),
				entidad.getFecha());
	}

	@Override
	public AgendaEntidad consultarPorId(final UUID id) {
		var filtro = new AgendaEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new AgendaEntidad() : resultados.get(0);
	}

	@Override
	public List<AgendaEntidad> consultarPorFiltro(final AgendaEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new AgendaEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("horarioDelBarbero", filtroSeguro.getHorarioDelBarbero().getId())
				.conFecha("fecha", filtroSeguro.getFecha());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_AGENDA);
	}

	@Override
	public List<AgendaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_AGENDA);
	}

	private AgendaEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new AgendaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getHorarioDelBarbero().setId(leerUUID(resultados, "horarioDelBarbero"));
		entidad.setFecha(resultados.getObject("fecha", LocalDate.class));
		return entidad;
	}
}
