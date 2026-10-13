package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BloqueoDominio;
import co.com.proyectoagendamientocitas.dto.BloqueoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BloqueoDTOAssembler implements DTOAssembler<BloqueoDominio, BloqueoDTO> {

	private static final DTOAssembler<BloqueoDominio, BloqueoDTO> INSTANCIA = new BloqueoDTOAssembler();

	private BloqueoDTOAssembler() {

	}

	public static DTOAssembler<BloqueoDominio, BloqueoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BloqueoDTO convertirADTO(final BloqueoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BloqueoDominio.Builder().build());
		var dto = new BloqueoDTO();
		dto.setId(dominioTmp.getId());
		dto.setBarbero(BarberoDTOAssembler.getInstance().convertirADTO(dominioTmp.getBarbero()));
		dto.setFechaHoraInicio(dominioTmp.getFechaHoraInicio());
		dto.setFechaHoraFinal(dominioTmp.getFechaHoraFinal());
		return dto;
	}

	@Override
	public BloqueoDominio convertirADominio(final BloqueoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new BloqueoDTO());
		return new BloqueoDominio.Builder()
				.id(dtoTmp.getId())
				.barbero(BarberoDTOAssembler.getInstance().convertirADominio(dtoTmp.getBarbero()))
				.fechaHoraInicio(dtoTmp.getFechaHoraInicio())
				.fechaHoraFinal(dtoTmp.getFechaHoraFinal())
				.build();
	}
}
