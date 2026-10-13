package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.AgendaDominio;
import co.com.proyectoagendamientocitas.dto.AgendaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class AgendaDTOAssembler implements DTOAssembler<AgendaDominio, AgendaDTO> {

	private static final DTOAssembler<AgendaDominio, AgendaDTO> INSTANCIA = new AgendaDTOAssembler();

	private AgendaDTOAssembler() {

	}

	public static DTOAssembler<AgendaDominio, AgendaDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public AgendaDTO convertirADTO(final AgendaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new AgendaDominio.Builder().build());
		var dto = new AgendaDTO();
		dto.setId(dominioTmp.getId());
		dto.setHorarioDelBarbero(HorarioBarberoDTOAssembler.getInstance().convertirADTO(dominioTmp.getHorarioDelBarbero()));
		dto.setFecha(dominioTmp.getFecha());
		return dto;
	}

	@Override
	public AgendaDominio convertirADominio(final AgendaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new AgendaDTO());
		return new AgendaDominio.Builder()
				.id(dtoTmp.getId())
				.horarioDelBarbero(HorarioBarberoDTOAssembler.getInstance().convertirADominio(dtoTmp.getHorarioDelBarbero()))
				.fecha(dtoTmp.getFecha())
				.build();
	}
}
