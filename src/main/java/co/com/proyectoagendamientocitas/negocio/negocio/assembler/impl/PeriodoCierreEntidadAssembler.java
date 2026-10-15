package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.PeriodoCierreDominio;
import co.com.proyectoagendamientocitas.entidad.PeriodoCierreEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class PeriodoCierreEntidadAssembler implements EntidadAssembler<PeriodoCierreDominio, PeriodoCierreEntidad> {

	private static final EntidadAssembler<PeriodoCierreDominio, PeriodoCierreEntidad> INSTANCIA = new PeriodoCierreEntidadAssembler();

	private PeriodoCierreEntidadAssembler() {

	}

	public static EntidadAssembler<PeriodoCierreDominio, PeriodoCierreEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public PeriodoCierreEntidad convertirAEntidad(final PeriodoCierreDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new PeriodoCierreDominio.Builder().build());
		var entidad = new PeriodoCierreEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setSede(SedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getSede()));
		entidad.setFechaHoraInicio(dominioTmp.getFechaHoraInicio());
		entidad.setFechaHoraFinal(dominioTmp.getFechaHoraFinal());
		entidad.setMotivo(dominioTmp.getMotivo());
		return entidad;
	}

	@Override
	public PeriodoCierreDominio convertirADominio(final PeriodoCierreEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PeriodoCierreEntidad());
		return new PeriodoCierreDominio.Builder()
				.id(entidadTmp.getId())
				.sede(SedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getSede()))
				.fechaHoraInicio(entidadTmp.getFechaHoraInicio())
				.fechaHoraFinal(entidadTmp.getFechaHoraFinal())
				.motivo(entidadTmp.getMotivo())
				.build();
	}
}
