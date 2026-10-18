package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.HorarioSedeDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.HorarioSedeEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class HorarioSedeMySqlDAO extends SqlDAO implements HorarioSedeDAO {

	private static final String SQL_CREAR =
			"INSERT INTO horarioSede (id, sede, diaDeLaSemana, horaApertura, horaCierre, fechaCreacion, fechaDesactivacion, vigente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, sede, diaDeLaSemana, horaApertura, horaCierre, fechaCreacion, fechaDesactivacion, vigente FROM horarioSede";
	private static final String SQL_ACTUALIZAR =
			"UPDATE horarioSede SET sede = ?, diaDeLaSemana = ?, horaApertura = ?, horaCierre = ?, fechaCreacion = ?, fechaDesactivacion = ?, vigente = ? WHERE id = ?";

	public HorarioSedeMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final HorarioSedeEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_HORARIO_SEDE,
				entidad.getId().toString(), entidad.getSede().getId().toString(),
				entidad.getDiaDeLaSemana().getId().toString(), entidad.getHoraApertura(),
				entidad.getHoraCierre(), entidad.getFechaCreacion(), entidad.getFechaDesactivacion(),
				entidad.isVigente());
	}

	@Override
	public HorarioSedeEntidad consultarPorId(final UUID id) {
		var filtro = new HorarioSedeEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new HorarioSedeEntidad() : resultados.get(0);
	}

	@Override
	public List<HorarioSedeEntidad> consultarPorFiltro(final HorarioSedeEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new HorarioSedeEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("sede", filtroSeguro.getSede().getId())
				.conId("diaDeLaSemana", filtroSeguro.getDiaDeLaSemana().getId())
				.conHora("horaApertura", filtroSeguro.getHoraApertura())
				.conHora("horaCierre", filtroSeguro.getHoraCierre())
				.conFecha("fechaCreacion", filtroSeguro.getFechaCreacion())
				.conFecha("fechaDesactivacion", filtroSeguro.getFechaDesactivacion())
				.conBooleano("vigente", filtroSeguro.isVigente(), UtilBooleano.SI);
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_HORARIO_SEDE);
	}

	@Override
	public List<HorarioSedeEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_HORARIO_SEDE);
	}

	@Override
	public void actualizar(final UUID id, final HorarioSedeEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_HORARIO_SEDE,
				entidad.getSede().getId().toString(), entidad.getDiaDeLaSemana().getId().toString(),
				entidad.getHoraApertura(), entidad.getHoraCierre(), entidad.getFechaCreacion(),
				entidad.getFechaDesactivacion(), entidad.isVigente(), id.toString());
	}

	private HorarioSedeEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new HorarioSedeEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getSede().setId(leerUUID(resultados, "sede"));
		entidad.getDiaDeLaSemana().setId(leerUUID(resultados, "diaDeLaSemana"));
		entidad.setHoraApertura(resultados.getObject("horaApertura", LocalTime.class));
		entidad.setHoraCierre(resultados.getObject("horaCierre", LocalTime.class));
		entidad.setFechaCreacion(resultados.getObject("fechaCreacion", LocalDate.class));
		entidad.setFechaDesactivacion(resultados.getObject("fechaDesactivacion", LocalDate.class));
		entidad.setVigente(resultados.getBoolean("vigente"));
		return entidad;
	}
}
