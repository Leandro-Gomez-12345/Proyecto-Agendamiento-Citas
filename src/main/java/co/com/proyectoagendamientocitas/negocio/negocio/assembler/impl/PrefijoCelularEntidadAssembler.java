package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.PrefijoCelularDominio;
import co.com.proyectoagendamientocitas.entidad.PrefijoCelularEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class PrefijoCelularEntidadAssembler implements EntidadAssembler<PrefijoCelularDominio, PrefijoCelularEntidad> {

	private static final EntidadAssembler<PrefijoCelularDominio, PrefijoCelularEntidad> INSTANCIA = new PrefijoCelularEntidadAssembler();

	private PrefijoCelularEntidadAssembler() {

	}

	public static EntidadAssembler<PrefijoCelularDominio, PrefijoCelularEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public PrefijoCelularEntidad convertirAEntidad(final PrefijoCelularDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new PrefijoCelularDominio.Builder().build());
		var entidad = new PrefijoCelularEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setPrefijo(dominioTmp.getPrefijo());
		return entidad;
	}

	@Override
	public PrefijoCelularDominio convertirADominio(final PrefijoCelularEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PrefijoCelularEntidad());
		return new PrefijoCelularDominio.Builder()
				.id(entidadTmp.getId())
				.prefijo(entidadTmp.getPrefijo())
				.build();
	}
}
