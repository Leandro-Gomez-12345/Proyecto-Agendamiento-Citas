package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.CiudadDominio;
import co.com.proyectoagendamientocitas.entidad.CiudadEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class CiudadEntidadAssembler implements EntidadAssembler<CiudadDominio, CiudadEntidad> {

	private static final EntidadAssembler<CiudadDominio, CiudadEntidad> INSTANCIA = new CiudadEntidadAssembler();

	private CiudadEntidadAssembler() {

	}

	public static EntidadAssembler<CiudadDominio, CiudadEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public CiudadEntidad convertirAEntidad(final CiudadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CiudadDominio.Builder().build());
		var entidad = new CiudadEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setNombre(dominioTmp.getNombre());
		entidad.setDepartamento(DepartamentoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getDepartamento()));
		return entidad;
	}

	@Override
	public CiudadDominio convertirADominio(final CiudadEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CiudadEntidad());
		return new CiudadDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.departamento(DepartamentoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getDepartamento()))
				.build();
	}
}
