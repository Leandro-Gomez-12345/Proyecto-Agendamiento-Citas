package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.DiaSemanaDominio;
import co.com.proyectoagendamientocitas.entidad.DiaSemanaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class DiaSemanaEntidadAssembler implements EntidadAssembler<DiaSemanaDominio, DiaSemanaEntidad> {

	private static final EntidadAssembler<DiaSemanaDominio, DiaSemanaEntidad> INSTANCIA = new DiaSemanaEntidadAssembler();

	private DiaSemanaEntidadAssembler() {

	}

	public static EntidadAssembler<DiaSemanaDominio, DiaSemanaEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public DiaSemanaEntidad convertirAEntidad(final DiaSemanaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new DiaSemanaDominio.Builder().build());
		var entidad = new DiaSemanaEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setNombre(dominioTmp.getNombre());
		return entidad;
	}

	@Override
	public DiaSemanaDominio convertirADominio(final DiaSemanaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DiaSemanaEntidad());
		return new DiaSemanaDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.build();
	}
}
