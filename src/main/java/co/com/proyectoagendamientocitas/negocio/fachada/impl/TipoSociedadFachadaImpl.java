package co.com.proyectoagendamientocitas.negocio.fachada.impl;

import java.util.List;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dto.TipoSociedadDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.TipoSociedadFachada;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl.TipoSociedadDTOAssembler;
import co.com.proyectoagendamientocitas.negocio.negocio.TipoSociedadNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.impl.TipoSociedadNegocioImpl;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasFachadaExcepcion;

public class TipoSociedadFachadaImpl implements TipoSociedadFachada {

	private final DAOFactory daoFactory;
	private final TipoSociedadNegocio tipoSociedadNegocio;

	public TipoSociedadFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		tipoSociedadNegocio = new TipoSociedadNegocioImpl(daoFactory);
	}

	@Override
	public List<TipoSociedadDTO> consultarTodosLosTiposSociedad() {
		try {
			var tiposSociedad = tipoSociedadNegocio.consultarTodosLosTiposSociedad();
			return TipoSociedadDTOAssembler.getInstance().convertirADTO(tiposSociedad);
		} catch (AgendamientoCitasExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoSociedadImpl.USUARIO_ERROR_CONSULTANDO_TIPOS_SOCIEDAD;
			throw AgendamientoCitasFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
