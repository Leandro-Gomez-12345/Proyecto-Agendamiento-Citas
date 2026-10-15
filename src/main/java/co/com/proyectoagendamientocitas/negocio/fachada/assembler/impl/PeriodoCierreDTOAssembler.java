package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.PeriodoCierreDominio;
import co.com.proyectoagendamientocitas.dto.PeriodoCierreDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class PeriodoCierreDTOAssembler implements DTOAssembler<PeriodoCierreDominio, PeriodoCierreDTO> {

	private static final DTOAssembler<PeriodoCierreDominio, PeriodoCierreDTO> INSTANCIA = new PeriodoCierreDTOAssembler();

	private PeriodoCierreDTOAssembler() {

	}

	public static DTOAssembler<PeriodoCierreDominio, PeriodoCierreDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public PeriodoCierreDTO convertirADTO(final PeriodoCierreDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new PeriodoCierreDominio.Builder().build());
		var dto = new PeriodoCierreDTO();
		dto.setId(dominioTmp.getId());
		dto.setSede(SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede()));
		dto.setFechaHoraInicio(dominioTmp.getFechaHoraInicio());
		dto.setFechaHoraFinal(dominioTmp.getFechaHoraFinal());
		dto.setMotivo(dominioTmp.getMotivo());
		return dto;
	}

	@Override
	public PeriodoCierreDominio convertirADominio(final PeriodoCierreDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PeriodoCierreDTO());
		return new PeriodoCierreDominio.Builder()
				.id(dtoTmp.getId())
				.sede(SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede()))
				.fechaHoraInicio(dtoTmp.getFechaHoraInicio())
				.fechaHoraFinal(dtoTmp.getFechaHoraFinal())
				.motivo(dtoTmp.getMotivo())
				.build();
	}
}
