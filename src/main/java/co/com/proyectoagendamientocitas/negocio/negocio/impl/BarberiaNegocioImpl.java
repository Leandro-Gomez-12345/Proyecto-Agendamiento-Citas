package co.com.proyectoagendamientocitas.negocio.negocio.impl;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.negocio.negocio.BarberiaNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl.BarberiaEntidadAssembler;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarDenominacionBarberiaNoExistaRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarIdBarberiaUnicoRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarNitBarberiaNoExistaRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarTipoSociedadBarberiaExisteRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.FormarRazonSocialBarberiaRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.ValidarDatosRegistrarBarberiaRule;

public class BarberiaNegocioImpl implements BarberiaNegocio {

	private static final String OPERACION_NO_IMPLEMENTADA = "Operación pendiente de implementar";

	private final DAOFactory daoFactory;

	public BarberiaNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public BarberiaDominio registrarBarberia(final BarberiaDominio datos) {
		ValidarDatosRegistrarBarberiaRule.obtenerInstancia().ejecutar(datos);

		var barberiaEntidad = BarberiaEntidadAssembler.getInstance().convertirAEntidad(datos);
		AsegurarTipoSociedadBarberiaExisteRule.obtenerInstancia().ejecutar(barberiaEntidad, daoFactory);
		AsegurarDenominacionBarberiaNoExistaRule.obtenerInstancia().ejecutar(datos, daoFactory);
		AsegurarNitBarberiaNoExistaRule.obtenerInstancia().ejecutar(datos, daoFactory);

		FormarRazonSocialBarberiaRule.obtenerInstancia().ejecutar(barberiaEntidad);
		AsegurarIdBarberiaUnicoRule.obtenerInstancia().ejecutar(barberiaEntidad, daoFactory);

		daoFactory.obtenerBarberiaDAO().crear(barberiaEntidad);
		return BarberiaEntidadAssembler.getInstance().convertirADominio(barberiaEntidad);
	}

	@Override
	public String consultarNombreBarberia(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDominio consultarRazonSocialYNitBarberia(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDominio cambiarNombreBarberia(UUID id, BarberiaDominio datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDominio cambiarRazonSocialBarberia(UUID id, BarberiaDominio datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public BarberiaDominio cambiarNitBarberia(UUID id, BarberiaDominio datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public void darDeBajaBarberia(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}
}
