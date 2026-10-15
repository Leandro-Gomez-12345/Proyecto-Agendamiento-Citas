package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.FestivoDominio;
import co.com.proyectoagendamientocitas.entidad.FestivoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class FestivoEntidadAssembler implements EntidadAssembler<FestivoDominio, FestivoEntidad> {

	private static final EntidadAssembler<FestivoDominio, FestivoEntidad> INSTANCIA = new FestivoEntidadAssembler();

	private FestivoEntidadAssembler() {

	}

	public static EntidadAssembler<FestivoDominio, FestivoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public FestivoEntidad convertirAEntidad(final FestivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new FestivoDominio.Builder().build());
		var entidad = new FestivoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setFecha(dominioTmp.getFecha());
		entidad.setNombre(dominioTmp.getNombre());
		return entidad;
	}

	@Override
	public FestivoDominio convertirADominio(final FestivoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new FestivoEntidad());
		return new FestivoDominio.Builder()
				.id(entidadTmp.getId())
				.fecha(entidadTmp.getFecha())
				.nombre(entidadTmp.getNombre())
				.build();
	}
}
