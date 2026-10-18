package co.com.proyectoagendamientocitas.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.entidad.CitaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FiltroSql;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SqlDAO;
import co.com.proyectoagendamientocitas.entidad.CitaEntidad;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public class CitaMySqlDAO extends SqlDAO implements CitaDAO {

	private static final String SQL_CREAR =
			"INSERT INTO cita (id, cliente, agenda, estado, horaInicio, porcentajeDescuento, multa, tiempoEspera) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_CONSULTAR =
			"SELECT id, cliente, agenda, estado, horaInicio, horaFinEstimada, porcentajeDescuento, multa, tiempoEspera, precioTotal FROM vistaCita";
	private static final String SQL_ACTUALIZAR =
			"UPDATE cita SET cliente = ?, agenda = ?, estado = ?, horaInicio = ?, porcentajeDescuento = ?, multa = ?, tiempoEspera = ? WHERE id = ?";

	public CitaMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final CitaEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_CITA,
				entidad.getId().toString(), entidad.getCliente().getId().toString(),
				entidad.getAgenda().getId().toString(), entidad.getEstado().getId().toString(),
				entidad.getHoraInicio(), entidad.getPorcentajeDescuento(), entidad.getMulta(),
				entidad.getTiempoEspera());
	}

	@Override
	public CitaEntidad consultarPorId(final UUID id) {
		var filtro = new CitaEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new CitaEntidad() : resultados.get(0);
	}

	@Override
	public List<CitaEntidad> consultarPorFiltro(final CitaEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CitaEntidad());
		var consulta = new FiltroSql(SQL_CONSULTAR)
				.conId("id", filtroSeguro.getId())
				.conId("cliente", filtroSeguro.getCliente().getId())
				.conId("agenda", filtroSeguro.getAgenda().getId())
				.conId("estado", filtroSeguro.getEstado().getId())
				.conHora("horaInicio", filtroSeguro.getHoraInicio())
				.conEntero("porcentajeDescuento", filtroSeguro.getPorcentajeDescuento())
				.conEntero("multa", filtroSeguro.getMulta())
				.conEntero("tiempoEspera", filtroSeguro.getTiempoEspera());
		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CITA);
	}

	@Override
	public List<CitaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_CITA);
	}

	@Override
	public void actualizar(final UUID id, final CitaEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_CITA,
				entidad.getCliente().getId().toString(), entidad.getAgenda().getId().toString(),
				entidad.getEstado().getId().toString(), entidad.getHoraInicio(),
				entidad.getPorcentajeDescuento(), entidad.getMulta(), entidad.getTiempoEspera(),
				id.toString());
	}

	private CitaEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new CitaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.getCliente().setId(leerUUID(resultados, "cliente"));
		entidad.getAgenda().setId(leerUUID(resultados, "agenda"));
		entidad.getEstado().setId(leerUUID(resultados, "estado"));
		entidad.setHoraInicio(resultados.getObject("horaInicio", LocalTime.class));
		entidad.setHoraFinEstimada(resultados.getObject("horaFinEstimada", LocalTime.class));
		entidad.setPorcentajeDescuento(resultados.getInt("porcentajeDescuento"));
		entidad.setMulta(resultados.getInt("multa"));
		entidad.setTiempoEspera(resultados.getInt("tiempoEspera"));
		entidad.setPrecioTotal(resultados.getInt("precioTotal"));
		return entidad;
	}
}
