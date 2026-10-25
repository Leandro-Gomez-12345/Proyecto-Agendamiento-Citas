package co.com.proyectoagendamientocitas.negocio.fachada.impl;

import java.util.UUID;
import java.util.function.Supplier;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.BarberiaFachada;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl.BarberiaDTOAssembler;
import co.com.proyectoagendamientocitas.negocio.negocio.impl.BarberiaNegocioImpl;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasFachadaExcepcion;
import co.com.proyectoagendamientocitas.transversal.logger.Logger;

public class BarberiaFachadaImpl implements BarberiaFachada {
	
	private static final Logger logger = Logger.obtener(BarberiaFachadaImpl.class);
	private static final String OPERACION_NO_IMPLEMENTADA = "Operación pendiente de implementar";

	private final Supplier<DAOFactory> proveedorFactoria;

	public BarberiaFachadaImpl() {
		this(DAOFactory::obtenerFactoria);
	}

	public BarberiaFachadaImpl(Supplier<DAOFactory> proveedorFactoria) {
		this.proveedorFactoria = proveedorFactoria;
	}

	@Override
	public BarberiaDTO registrarBarberia(final BarberiaDTO datos) {
		var daoFactory = proveedorFactoria.get();
		try {
			daoFactory.iniciarTransaccion();
			return registrarConfirmandoTransaccion(daoFactory, datos);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	private BarberiaDTO registrarConfirmandoTransaccion(final DAOFactory daoFactory, final BarberiaDTO datos) {
		try {
			var barberiaDominio = BarberiaDTOAssembler.getInstance().convertirADominio(datos);
			var barberiaRegistrada = new BarberiaNegocioImpl(daoFactory).registrarBarberia(barberiaDominio);
			daoFactory.confirmarTransaccion();
			logger.info("Barbería registrada con id {}", barberiaRegistrada.getId());
			return BarberiaDTOAssembler.getInstance().convertirADTO(barberiaRegistrada);
		} catch (AgendamientoCitasExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();

			var mensajeUsuario = CatalogoMensajes.BarberiaImpl.USUARIO_ERROR_REGISTRANDO_BARBERIA;
			throw AgendamientoCitasFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public String consultarNombreBarberia(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDTO consultarRazonSocialYNitBarberia(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDTO cambiarNombreBarberia(UUID id, BarberiaDTO datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDTO cambiarRazonSocialBarberia(UUID id, BarberiaDTO datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDTO cambiarNitBarberia(UUID id, BarberiaDTO datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public void darDeBajaBarberia(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}
}
