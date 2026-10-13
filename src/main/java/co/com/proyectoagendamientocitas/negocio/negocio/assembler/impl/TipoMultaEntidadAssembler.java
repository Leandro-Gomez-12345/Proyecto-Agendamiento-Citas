package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.TipoMultaDominio;
import co.com.proyectoagendamientocitas.entidad.TipoMultaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class TipoMultaEntidadAssembler implements EntidadAssembler<TipoMultaDominio, TipoMultaEntidad> {

	private static final EntidadAssembler<TipoMultaDominio, TipoMultaEntidad> INSTANCIA = new TipoMultaEntidadAssembler();

	private TipoMultaEntidadAssembler() {

	}

	public static EntidadAssembler<TipoMultaDominio, TipoMultaEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public TipoMultaEntidad convertirAEntidad(final TipoMultaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new TipoMultaDominio.Builder().build());
		var entidad = new TipoMultaEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setNombre(dominioTmp.getNombre());
		entidad.setDescripcion(dominioTmp.getDescripcion());
		return entidad;
	}

	@Override
	public TipoMultaDominio convertirADominio(final TipoMultaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new TipoMultaEntidad());
		return new TipoMultaDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.descripcion(entidadTmp.getDescripcion())
				.build();
	}
}
