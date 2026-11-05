package co.com.proyectoagendamientocitas.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.negocio.negocio.BarberiaNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl.BarberiaEntidadAssembler;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarDenominacionBarberiaNoExistaRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarFormatoBarberiaValidoRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarIdBarberiaUnicoRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarNitBarberiaNoExistaRule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia.AsegurarTipoSociedadBarberiaExisteRule;

public class BarberiaNegocioImpl implements BarberiaNegocio {

	private static final String OPERACION_NO_IMPLEMENTADA = "Operación pendiente de implementar";
	private static final String SEPARADOR_RAZON_SOCIAL = " ";

	private final DAOFactory daoFactory;

	public BarberiaNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public BarberiaDominio registrarBarberia(BarberiaDominio datos) {
		var barberiaEntidad = BarberiaEntidadAssembler.getInstance().convertirAEntidad(datos);

		AsegurarFormatoBarberiaValidoRule.obtenerInstancia().ejecutar(barberiaEntidad);
		AsegurarTipoSociedadBarberiaExisteRule.obtenerInstancia().ejecutar(barberiaEntidad, daoFactory);
		AsegurarDenominacionBarberiaNoExistaRule.obtenerInstancia().ejecutar(barberiaEntidad, daoFactory);
		AsegurarNitBarberiaNoExistaRule.obtenerInstancia().ejecutar(barberiaEntidad, daoFactory);

		formarRazonSocial(barberiaEntidad);
		AsegurarIdBarberiaUnicoRule.obtenerInstancia().ejecutar(barberiaEntidad, daoFactory);

		daoFactory.obtenerBarberiaDAO().crear(barberiaEntidad);
		return BarberiaEntidadAssembler.getInstance().convertirADominio(barberiaEntidad);
	}

	private static void formarRazonSocial(final BarberiaEntidad barberia) {
		barberia.setRazonSocial(
				barberia.getDenominacion() + SEPARADOR_RAZON_SOCIAL + barberia.getTipoSociedad().getSufijo());
	}

	@Override
	public List<BarberiaDominio> consultarBarberias() {
		return daoFactory.obtenerBarberiaDAO().consultarTodos().stream()
				.map(barberia -> new BarberiaDominio.Builder().id(barberia.getId())
						.nombreBarberia(barberia.getNombreBarberia()).build())
				.toList();
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
