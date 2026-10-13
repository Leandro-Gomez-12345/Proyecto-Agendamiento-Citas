package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.ServicioDominio;
import co.com.proyectoagendamientocitas.entidad.ServicioEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class ServicioEntidadAssembler implements EntidadAssembler<ServicioDominio, ServicioEntidad> {

	private static final EntidadAssembler<ServicioDominio, ServicioEntidad> INSTANCIA = new ServicioEntidadAssembler();

	private ServicioEntidadAssembler() {

	}

	public static EntidadAssembler<ServicioDominio, ServicioEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public ServicioEntidad convertirAEntidad(final ServicioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ServicioDominio.Builder().build());
		var entidad = new ServicioEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setSede(SedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getSede()));
		entidad.setNombre(dominioTmp.getNombre());
		entidad.setDescripcion(dominioTmp.getDescripcion());
		entidad.setPrecio(dominioTmp.getPrecio());
		entidad.setDisponible(dominioTmp.isDisponible());
		return entidad;
	}

	@Override
	public ServicioDominio convertirADominio(final ServicioEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ServicioEntidad());
		return new ServicioDominio.Builder()
				.id(entidadTmp.getId())
				.sede(SedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getSede()))
				.nombre(entidadTmp.getNombre())
				.descripcion(entidadTmp.getDescripcion())
				.precio(entidadTmp.getPrecio())
				.disponible(entidadTmp.isDisponible())
				.build();
	}
}
