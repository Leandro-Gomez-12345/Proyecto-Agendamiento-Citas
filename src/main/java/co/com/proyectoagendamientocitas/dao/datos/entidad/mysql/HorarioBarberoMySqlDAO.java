package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.HorarioBarberoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.HorarioBarberoEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class HorarioBarberoMySqlDAO extends SqlDAO implements HorarioBarberoDAO {

	private static final String SQL_CREAR =
			"INSERT INTO horarioBarbero (id, barbero, horarioDeLaSede, horaInicio, horaFinal, fechaCreacion, fechaDesactivacion, vigente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, barbero, horarioDeLaSede, horaInicio, horaFinal, fechaCreacion, fechaDesactivacion, vigente FROM horarioBarbero";
	private static final String SQL_ACTUALIZAR =
			"UPDATE horarioBarbero SET barbero = ?, horarioDeLaSede = ?, horaInicio = ?, horaFinal = ?, fechaCreacion = ?, fechaDesactivacion = ?, vigente = ? WHERE id = ?";

	public HorarioBarberoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final HorarioBarberoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_HORARIO_BARBERO,
				entidad.getId().toString(), entidad.getBarbero().getId().toString(),
				entidad.getHorarioDeLaSede().getId().toString(), entidad.getHoraInicio(),
				entidad.getHoraFinal(), entidad.getFechaCreacion(), entidad.getFechaDesactivacion(),
				entidad.isVigente());
	}

	@Override
	public HorarioBarberoEntidad consultarPorId(final UUID id) {
		var filtro = new HorarioBarberoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new HorarioBarberoEntidad() : resultados.get(0);
	}

	@Override
	public List<HorarioBarberoEntidad> consultarPorFiltro(final HorarioBarberoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new HorarioBarberoEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("barbero", filtroSeguro.getBarbero().getId())
				.conId("horarioDeLaSede", filtroSeguro.getHorarioDeLaSede().getId())
				.conHora("horaInicio", filtroSeguro.getHoraInicio())
				.conHora("horaFinal", filtroSeguro.getHoraFinal())
				.conFecha("fechaCreacion", filtroSeguro.getFechaCreacion())
				.conFecha("fechaDesactivacion", filtroSeguro.getFechaDesactivacion())
				.conBooleano("vigente", filtroSeguro.isVigente(), UtilBooleano.SI);
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_HORARIO_BARBERO);
	}

	@Override
	public List<HorarioBarberoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_HORARIO_BARBERO);
	}

	@Override
	public void actualizar(final UUID id, final HorarioBarberoEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR,
				CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_HORARIO_BARBERO,
				entidad.getBarbero().getId().toString(), entidad.getHorarioDeLaSede().getId().toString(),
				entidad.getHoraInicio(), entidad.getHoraFinal(), entidad.getFechaCreacion(),
				entidad.getFechaDesactivacion(), entidad.isVigente(), id.toString());
	}

	private HorarioBarberoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new HorarioBarberoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getBarbero().setId(leerUUID(resultados, "barbero"));
		entidad.getHorarioDeLaSede().setId(leerUUID(resultados, "horarioDeLaSede"));
		entidad.setHoraInicio(resultados.getObject("horaInicio", LocalTime.class));
		entidad.setHoraFinal(resultados.getObject("horaFinal", LocalTime.class));
		entidad.setFechaCreacion(resultados.getObject("fechaCreacion", LocalDate.class));
		entidad.setFechaDesactivacion(resultados.getObject("fechaDesactivacion", LocalDate.class));
		entidad.setVigente(resultados.getBoolean("vigente"));
		return entidad;
	}
}
