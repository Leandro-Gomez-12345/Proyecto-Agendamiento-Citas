package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.MultaDominio;
import co.com.proyectoagendamientocitas.dto.MultaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class MultaDTOAssembler implements DTOAssembler<MultaDominio, MultaDTO> {

	private static final DTOAssembler<MultaDominio, MultaDTO> INSTANCIA = new MultaDTOAssembler();

	private MultaDTOAssembler() {

	}

	public static DTOAssembler<MultaDominio, MultaDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public MultaDTO convertirADTO(final MultaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new MultaDominio.Builder().build());
		var dto = new MultaDTO();
		dto.setId(dominioTmp.getId());
		dto.setCita(CitaDTOAssembler.getInstance().convertirADTO(dominioTmp.getCita()));
		dto.setTipo(TipoMultaDTOAssembler.getInstance().convertirADTO(dominioTmp.getTipo()));
		dto.setMonto(dominioTmp.getMonto());
		dto.setHoraGeneracion(dominioTmp.getHoraGeneracion());
		dto.setFechaHoraPago(dominioTmp.getFechaHoraPago());
		dto.setPagada(dominioTmp.isPagada());
		return dto;
	}

	@Override
	public MultaDominio convertirADominio(final MultaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new MultaDTO());
		return new MultaDominio.Builder()
				.id(dtoTmp.getId())
				.cita(CitaDTOAssembler.getInstance().convertirADominio(dtoTmp.getCita()))
				.tipo(TipoMultaDTOAssembler.getInstance().convertirADominio(dtoTmp.getTipo()))
				.monto(dtoTmp.getMonto())
				.horaGeneracion(dtoTmp.getHoraGeneracion())
				.fechaHoraPago(dtoTmp.getFechaHoraPago())
				.pagada(dtoTmp.isPagada())
				.build();
	}
}
