package co.com.proyectoagendamientocitas.negocio.negocio.impl;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.SedeDominio;
import co.com.proyectoagendamientocitas.negocio.negocio.SedeNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl.SedeEntidadAssembler;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede.AsegurarBarberiaSedeExisteRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede.AsegurarCiudadSedeExisteRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede.AsegurarFormatoSedeValidoRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede.AsegurarIdSedeUnicoRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede.AsegurarNombreSedeNoExistaRule;

public class SedeNegocioImpl implements SedeNegocio {

	private static final String OPERACION_NO_IMPLEMENTADA = "Operación pendiente de implementar";

	private final DAOFactory daoFactory;

	public SedeNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public SedeDominio registrarSede(SedeDominio datos) {
		var sedeEntidad = SedeEntidadAssembler.getInstance().convertirAEntidad(datos);

		AsegurarFormatoSedeValidoRule.obtenerInstancia().ejecutar(sedeEntidad);
		AsegurarBarberiaSedeExisteRule.obtenerInstancia().ejecutar(sedeEntidad, daoFactory);
		AsegurarCiudadSedeExisteRule.obtenerInstancia().ejecutar(sedeEntidad, daoFactory);
		AsegurarNombreSedeNoExistaRule.obtenerInstancia().ejecutar(sedeEntidad, daoFactory);
		AsegurarIdSedeUnicoRule.obtenerInstancia().ejecutar(sedeEntidad, daoFactory);

		daoFactory.obtenerSedeDAO().crear(sedeEntidad);
		return SedeEntidadAssembler.getInstance().convertirADominio(sedeEntidad);
	}

	@Override
	public SedeDominio consultarDatosSede(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public SedeDominio cambiarNombreSede(UUID id, SedeDominio datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public SedeDominio cambiarDireccionSede(UUID id, SedeDominio datos) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

	@Override
	public void darDeBajaSede(UUID id) {
		throw new UnsupportedOperationException(OPERACION_NO_IMPLEMENTADA);
	}

}
