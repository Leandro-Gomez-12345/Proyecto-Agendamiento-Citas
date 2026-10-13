package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.MultaDominio;
import co.com.proyectoagendamientocitas.entidad.MultaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class MultaEntidadAssembler implements EntidadAssembler<MultaDominio, MultaEntidad> {

	private static final EntidadAssembler<MultaDominio, MultaEntidad> INSTANCIA = new MultaEntidadAssembler();

	private MultaEntidadAssembler() {

	}

	public static EntidadAssembler<MultaDominio, MultaEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public MultaEntidad convertirAEntidad(final MultaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new MultaDominio.Builder().build());
		var entidad = new MultaEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setCita(CitaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCita()));
		entidad.setTipo(TipoMultaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getTipo()));
		entidad.setMonto(dominioTmp.getMonto());
		entidad.setHoraGeneracion(dominioTmp.getHoraGeneracion());
		entidad.setFechaHoraPago(dominioTmp.getFechaHoraPago());
		entidad.setPagada(dominioTmp.isPagada());
		return entidad;
	}

	@Override
	public MultaDominio convertirADominio(final MultaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new MultaEntidad());
		return new MultaDominio.Builder()
				.id(entidadTmp.getId())
				.cita(CitaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCita()))
				.tipo(TipoMultaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getTipo()))
				.monto(entidadTmp.getMonto())
				.horaGeneracion(entidadTmp.getHoraGeneracion())
				.fechaHoraPago(entidadTmp.getFechaHoraPago())
				.pagada(entidadTmp.isPagada())
				.build();
	}
}
