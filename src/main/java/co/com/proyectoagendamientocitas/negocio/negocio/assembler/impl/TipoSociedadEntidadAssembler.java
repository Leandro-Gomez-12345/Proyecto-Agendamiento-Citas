package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.TipoSociedadDominio;
import co.com.proyectoagendamientocitas.entidad.TipoSociedadEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class TipoSociedadEntidadAssembler implements EntidadAssembler<TipoSociedadDominio, TipoSociedadEntidad> {

	private static final EntidadAssembler<TipoSociedadDominio, TipoSociedadEntidad> INSTANCIA = new TipoSociedadEntidadAssembler();

	private TipoSociedadEntidadAssembler() {

	}

	public static EntidadAssembler<TipoSociedadDominio, TipoSociedadEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public TipoSociedadEntidad convertirAEntidad(final TipoSociedadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new TipoSociedadDominio.Builder().build());
		var entidad = new TipoSociedadEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setNombre(dominioTmp.getNombre());
		entidad.setSufijo(dominioTmp.getSufijo());
		return entidad;
	}

	@Override
	public TipoSociedadDominio convertirADominio(final TipoSociedadEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new TipoSociedadEntidad());
		return new TipoSociedadDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.sufijo(entidadTmp.getSufijo())
				.build();
	}
}
