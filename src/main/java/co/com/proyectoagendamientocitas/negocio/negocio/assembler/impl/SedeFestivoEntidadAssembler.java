package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.SedeFestivoDominio;
import co.com.proyectoagendamientocitas.entidad.SedeFestivoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class SedeFestivoEntidadAssembler implements EntidadAssembler<SedeFestivoDominio, SedeFestivoEntidad> {

	private static final EntidadAssembler<SedeFestivoDominio, SedeFestivoEntidad> INSTANCIA = new SedeFestivoEntidadAssembler();

	private SedeFestivoEntidadAssembler() {

	}

	public static EntidadAssembler<SedeFestivoDominio, SedeFestivoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public SedeFestivoEntidad convertirAEntidad(final SedeFestivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new SedeFestivoDominio.Builder().build());
		var entidad = new SedeFestivoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setSede(SedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getSede()));
		entidad.setFestivo(FestivoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getFestivo()));
		return entidad;
	}

	@Override
	public SedeFestivoDominio convertirADominio(final SedeFestivoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new SedeFestivoEntidad());
		return new SedeFestivoDominio.Builder()
				.id(entidadTmp.getId())
				.sede(SedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getSede()))
				.festivo(FestivoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getFestivo()))
				.build();
	}
}
