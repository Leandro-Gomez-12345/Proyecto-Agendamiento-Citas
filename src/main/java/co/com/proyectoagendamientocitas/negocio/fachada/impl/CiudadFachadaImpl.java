package co.com.proyectoagendamientocitas.negocio.fachada.impl;

import java.util.List;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dto.CiudadDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.CiudadFachada;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl.CiudadDTOAssembler;
import co.com.proyectoagendamientocitas.negocio.negocio.CiudadNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.impl.CiudadNegocioImpl;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasFachadaExcepcion;

public class CiudadFachadaImpl implements CiudadFachada {

	private final DAOFactory daoFactory;
	private final CiudadNegocio ciudadNegocio;

	public CiudadFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		ciudadNegocio = new CiudadNegocioImpl(daoFactory);
	}

	@Override
	public List<CiudadDTO> consultarCiudades() {
		try {
			var ciudades = ciudadNegocio.consultarCiudades();
			return CiudadDTOAssembler.getInstance().convertirADTO(ciudades);
		} catch (AgendamientoCitasExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadImpl.USUARIO_ERROR_CONSULTANDO_CIUDADES;
			throw AgendamientoCitasFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
