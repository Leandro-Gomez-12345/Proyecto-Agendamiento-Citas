package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BarberiaEntidadAssembler implements EntidadAssembler<BarberiaDominio, BarberiaEntidad> {

	private static final EntidadAssembler<BarberiaDominio, BarberiaEntidad> INSTANCIA = new BarberiaEntidadAssembler();

	private BarberiaEntidadAssembler() {

	}

	public static EntidadAssembler<BarberiaDominio, BarberiaEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BarberiaEntidad convertirAEntidad(final BarberiaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BarberiaDominio.Builder().build());
		var entidad = new BarberiaEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setTipoSociedad(TipoSociedadEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getTipoSociedad()));
		entidad.setNombreBarberia(dominioTmp.getNombreBarberia());
		entidad.setDenominacion(dominioTmp.getDenominacion());
		entidad.setRazonSocial(dominioTmp.getRazonSocial());
		entidad.setNit(dominioTmp.getNit());
		return entidad;
	}

	@Override
	public BarberiaDominio convertirADominio(final BarberiaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new BarberiaEntidad());
		return new BarberiaDominio.Builder()
				.id(entidadTmp.getId())
				.tipoSociedad(TipoSociedadEntidadAssembler.getInstance().convertirADominio(entidadTmp.getTipoSociedad()))
				.nombreBarberia(entidadTmp.getNombreBarberia())
				.denominacion(entidadTmp.getDenominacion())
				.razonSocial(entidadTmp.getRazonSocial())
				.nit(entidadTmp.getNit())
				.build();
	}
}
