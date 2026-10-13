package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.CitaDominio;
import co.com.proyectoagendamientocitas.dto.CitaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class CitaDTOAssembler implements DTOAssembler<CitaDominio, CitaDTO> {

	private static final DTOAssembler<CitaDominio, CitaDTO> INSTANCIA = new CitaDTOAssembler();

	private CitaDTOAssembler() {

	}

	public static DTOAssembler<CitaDominio, CitaDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public CitaDTO convertirADTO(final CitaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CitaDominio.Builder().build());
		var dto = new CitaDTO();
		dto.setId(dominioTmp.getId());
		dto.setCliente(ClienteDTOAssembler.getInstance().convertirADTO(dominioTmp.getCliente()));
		dto.setAgenda(AgendaDTOAssembler.getInstance().convertirADTO(dominioTmp.getAgenda()));
		dto.setEstado(EstadoDTOAssembler.getInstance().convertirADTO(dominioTmp.getEstado()));
		dto.setHoraInicio(dominioTmp.getHoraInicio());
		dto.setHoraFinEstimada(dominioTmp.getHoraFinEstimada());
		dto.setPorcentajeDescuento(dominioTmp.getPorcentajeDescuento());
		dto.setMulta(dominioTmp.getMulta());
		dto.setTiempoEspera(dominioTmp.getTiempoEspera());
		dto.setPrecioTotal(dominioTmp.getPrecioTotal());
		return dto;
	}

	@Override
	public CitaDominio convertirADominio(final CitaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CitaDTO());
		return new CitaDominio.Builder()
				.id(dtoTmp.getId())
				.cliente(ClienteDTOAssembler.getInstance().convertirADominio(dtoTmp.getCliente()))
				.agenda(AgendaDTOAssembler.getInstance().convertirADominio(dtoTmp.getAgenda()))
				.estado(EstadoDTOAssembler.getInstance().convertirADominio(dtoTmp.getEstado()))
				.horaInicio(dtoTmp.getHoraInicio())
				.horaFinEstimada(dtoTmp.getHoraFinEstimada())
				.porcentajeDescuento(dtoTmp.getPorcentajeDescuento())
				.multa(dtoTmp.getMulta())
				.tiempoEspera(dtoTmp.getTiempoEspera())
				.precioTotal(dtoTmp.getPrecioTotal())
				.build();
	}
}
