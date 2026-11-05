package co.com.proyectoagendamientocitas.negocio.fachada.impl;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dto.SedeDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.SedeFachada;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl.SedeDTOAssembler;
import co.com.proyectoagendamientocitas.negocio.negocio.SedeNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.impl.SedeNegocioImpl;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasFachadaExcepcion;
import co.com.proyectoagendamientocitas.transversal.logger.AgendamientoCitasLogger;

public class SedeFachadaImpl implements SedeFachada {

	private static final AgendamientoCitasLogger logger = AgendamientoCitasLogger.obtener(SedeFachadaImpl.class);
	private static final String OPERACION_NO_IMPLEMENTADA = "Operación no implementada";

	private final DAOFactory daoFactory;
	private final SedeNegocio sedeNegocio;

	public SedeFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		sedeNegocio = new SedeNegocioImpl(daoFactory);
	}

	@Override
	public SedeDTO registrarSede(SedeDTO datos) {
		try {
			daoFactory.iniciarTransaccion();
			return registrarConfirmandoTransaccion(datos);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	private SedeDTO registrarConfirmandoTransaccion(SedeDTO datos) {
		try {
			var sedeDominio = SedeDTOAssembler.getInstance().convertirADominio(datos);
			var sedeRegistrada = sedeNegocio.registrarSede(sedeDominio);
			daoFactory.confirmarTransaccion();
			logger.info("Sede registrada con id {}", sedeRegistrada.getId());
			return SedeDTOAssembler.getInstance().convertirADTO(sedeRegistrada);
		} catch (AgendamientoCitasExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();

			var mensajeUsuario = CatalogoMensajes.SedeImpl.USUARIO_ERROR_REGISTRANDO_SEDE;
			throw AgendamientoCitasFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public SedeDTO consultarDatosSede(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public SedeDTO cambiarNombreSede(UUID id, SedeDTO datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public SedeDTO cambiarDireccionSede(UUID id, SedeDTO datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public void darDeBajaSede(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}
}
