package co.com.proyectoagendamientocitas.dao.factoria.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

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
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.AgendaMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.BarberiaMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.BarberoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.BarberoServicioMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.BloqueoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.CitaMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.CitaServicioMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.CiudadMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.ClienteMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.DepartamentoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.DiaSemanaMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.EstadoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.FechaFestivoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.FestivoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.HorarioBarberoMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.HorarioSedeMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.MultaMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.PeriodoCierreMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.PrefijoCelularMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.SedeMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.ServicioMySqlDAO;
import co.com.proyectoagendamientocitas.dao.datos.entidad.mysql.TipoMultaMySqlDAO;
import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasDatosExcepcion;

public class MySqlDAOFactory extends DAOFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/agendamientocitas";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";

	@Override
	protected void abrirConexion() {
		try {
			setConexion(DriverManager.getConnection(URL, USUARIO, CONTRASENA));
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_ABRIENDO_CONEXION;
			throw AgendamientoCitasDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public BarberiaDAO obtenerBarberiaDAO() {
		return new BarberiaMySqlDAO(getConexion());
	}

	@Override
	public DiaSemanaDAO obtenerDiaSemanaDAO() {
		return new DiaSemanaMySqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoMySqlDAO(getConexion());
	}

	@Override
	public EstadoDAO obtenerEstadoDAO() {
		return new EstadoMySqlDAO(getConexion());
	}

	@Override
	public PrefijoCelularDAO obtenerPrefijoCelularDAO() {
		return new PrefijoCelularMySqlDAO(getConexion());
	}

	@Override
	public TipoMultaDAO obtenerTipoMultaDAO() {
		return new TipoMultaMySqlDAO(getConexion());
	}

	@Override
	public FestivoDAO obtenerFestivoDAO() {
		return new FestivoMySqlDAO(getConexion());
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new ClienteMySqlDAO(getConexion());
	}

	@Override
	public CiudadDAO obtenerCiudadDAO() {
		return new CiudadMySqlDAO(getConexion());
	}

	@Override
	public SedeDAO obtenerSedeDAO() {
		return new SedeMySqlDAO(getConexion());
	}

	@Override
	public BarberoDAO obtenerBarberoDAO() {
		return new BarberoMySqlDAO(getConexion());
	}

	@Override
	public HorarioSedeDAO obtenerHorarioSedeDAO() {
		return new HorarioSedeMySqlDAO(getConexion());
	}

	@Override
	public ServicioDAO obtenerServicioDAO() {
		return new ServicioMySqlDAO(getConexion());
	}

	@Override
	public PeriodoCierreDAO obtenerPeriodoCierreDAO() {
		return new PeriodoCierreMySqlDAO(getConexion());
	}

	@Override
	public FechaFestivoDAO obtenerFechaFestivoDAO() {
		return new FechaFestivoMySqlDAO(getConexion());
	}

	@Override
	public BarberoServicioDAO obtenerBarberoServicioDAO() {
		return new BarberoServicioMySqlDAO(getConexion());
	}

	@Override
	public BloqueoDAO obtenerBloqueoDAO() {
		return new BloqueoMySqlDAO(getConexion());
	}

	@Override
	public HorarioBarberoDAO obtenerHorarioBarberoDAO() {
		return new HorarioBarberoMySqlDAO(getConexion());
	}

	@Override
	public AgendaDAO obtenerAgendaDAO() {
		return new AgendaMySqlDAO(getConexion());
	}

	@Override
	public CitaDAO obtenerCitaDAO() {
		return new CitaMySqlDAO(getConexion());
	}

	@Override
	public CitaServicioDAO obtenerCitaServicioDAO() {
		return new CitaServicioMySqlDAO(getConexion());
	}

	@Override
	public MultaDAO obtenerMultaDAO() {
		return new MultaMySqlDAO(getConexion());
	}
}
