package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.EstadoDominio;
import co.com.proyectoagendamientocitas.entidad.EstadoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class EstadoEntidadAssembler implements EntidadAssembler<EstadoDominio, EstadoEntidad> {

	private static final EntidadAssembler<EstadoDominio, EstadoEntidad> INSTANCIA = new EstadoEntidadAssembler();

	private EstadoEntidadAssembler() {

	}

	public static EntidadAssembler<EstadoDominio, EstadoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public EstadoEntidad convertirAEntidad(final EstadoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new EstadoDominio.Builder().build());
		var entidad = new EstadoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setNombre(dominioTmp.getNombre());
		entidad.setDescripcion(dominioTmp.getDescripcion());
		return entidad;
	}

	@Override
	public EstadoDominio convertirADominio(final EstadoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new EstadoEntidad());
		return new EstadoDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.descripcion(entidadTmp.getDescripcion())
				.build();
	}
}
