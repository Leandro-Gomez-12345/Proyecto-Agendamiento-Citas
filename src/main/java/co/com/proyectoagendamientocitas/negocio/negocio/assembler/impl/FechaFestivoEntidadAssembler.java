package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.FechaFestivoDominio;
import co.com.proyectoagendamientocitas.entidad.FechaFestivoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class FechaFestivoEntidadAssembler implements EntidadAssembler<FechaFestivoDominio, FechaFestivoEntidad> {

	private static final EntidadAssembler<FechaFestivoDominio, FechaFestivoEntidad> INSTANCIA = new FechaFestivoEntidadAssembler();

	private FechaFestivoEntidadAssembler() {

	}

	public static EntidadAssembler<FechaFestivoDominio, FechaFestivoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public FechaFestivoEntidad convertirAEntidad(final FechaFestivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new FechaFestivoDominio.Builder().build());
		var entidad = new FechaFestivoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setSede(SedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getSede()));
		entidad.setFestivo(FestivoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getFestivo()));
		return entidad;
	}

	@Override
	public FechaFestivoDominio convertirADominio(final FechaFestivoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new FechaFestivoEntidad());
		return new FechaFestivoDominio.Builder()
				.id(entidadTmp.getId())
				.sede(SedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getSede()))
				.festivo(FestivoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getFestivo()))
				.build();
	}
}
