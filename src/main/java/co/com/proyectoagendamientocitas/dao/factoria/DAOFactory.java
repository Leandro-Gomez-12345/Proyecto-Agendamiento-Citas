package co.com.proyectoagendamientocitas.dao.factoria;

import java.sql.Connection;

import co.com.proyectoagendamientocitas.dao.datos.entidad.AgendaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.BarberiaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.BarberoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.BarberoServicioDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.BloqueoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.CitaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.CitaServicioDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.CiudadDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.ClienteDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.DepartamentoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.DiaSemanaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.EstadoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FechaFestivoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.FestivoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.HorarioBarberoDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.HorarioSedeDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.MultaDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.PeriodoCierreDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.PrefijoCelularDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.SedeDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.ServicioDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.TipoMultaDAO;
import co.com.proyectoagendamientocitas.dao.factoria.enums.FactoriaEnum;
import co.com.proyectoagendamientocitas.dao.factoria.impl.MySqlDAOFactory;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasDatosExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

	private static final FactoriaEnum FACTORIA = FactoriaEnum.MYSQL;

	private Connection conexion;

	public static DAOFactory obtenerFactoria() {
		switch (FACTORIA) {
		case MYSQL: {
			return new MySqlDAOFactory();
		}
		default:
			throw AgendamientoCitasDatosExcepcion.crear(CatalogoMensajes.Datos.USUARIO_ERROR_FACTORIA_NO_HABILITADA);
		}
	}

	protected DAOFactory() {
		abrirConexion();
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		UtilSQL.asegurarConexionValida(conexion);
		this.conexion = conexion;
	}

	protected abstract void abrirConexion();

	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	public abstract BarberiaDAO obtenerBarberiaDAO();

	public abstract DiaSemanaDAO obtenerDiaSemanaDAO();

	public abstract DepartamentoDAO obtenerDepartamentoDAO();

	public abstract EstadoDAO obtenerEstadoDAO();

	public abstract PrefijoCelularDAO obtenerPrefijoCelularDAO();

	public abstract TipoMultaDAO obtenerTipoMultaDAO();

	public abstract FestivoDAO obtenerFestivoDAO();

	public abstract ClienteDAO obtenerClienteDAO();

	public abstract CiudadDAO obtenerCiudadDAO();

	public abstract SedeDAO obtenerSedeDAO();

	public abstract BarberoDAO obtenerBarberoDAO();

	public abstract HorarioSedeDAO obtenerHorarioSedeDAO();

	public abstract ServicioDAO obtenerServicioDAO();

	public abstract PeriodoCierreDAO obtenerPeriodoCierreDAO();

	public abstract FechaFestivoDAO obtenerFechaFestivoDAO();

	public abstract BarberoServicioDAO obtenerBarberoServicioDAO();

	public abstract BloqueoDAO obtenerBloqueoDAO();

	public abstract HorarioBarberoDAO obtenerHorarioBarberoDAO();

	public abstract AgendaDAO obtenerAgendaDAO();

	public abstract CitaDAO obtenerCitaDAO();

	public abstract CitaServicioDAO obtenerCitaServicioDAO();

	public abstract MultaDAO obtenerMultaDAO();
}
