package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.DepartamentoDominio;
import co.com.proyectoagendamientocitas.entidad.DepartamentoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class DepartamentoEntidadAssembler implements EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> {

	private static final EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> INSTANCIA = new DepartamentoEntidadAssembler();

	private DepartamentoEntidadAssembler() {

	}

	public static EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public DepartamentoEntidad convertirAEntidad(final DepartamentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new DepartamentoDominio.Builder().build());
		var entidad = new DepartamentoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setNombre(dominioTmp.getNombre());
		return entidad;
	}

	@Override
	public DepartamentoDominio convertirADominio(final DepartamentoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DepartamentoEntidad());
		return new DepartamentoDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.build();
	}
}
