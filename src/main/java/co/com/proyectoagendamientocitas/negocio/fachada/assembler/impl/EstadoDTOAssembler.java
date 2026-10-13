package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.EstadoDominio;
import co.com.proyectoagendamientocitas.dto.EstadoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class EstadoDTOAssembler implements DTOAssembler<EstadoDominio, EstadoDTO> {

	private static final DTOAssembler<EstadoDominio, EstadoDTO> INSTANCIA = new EstadoDTOAssembler();

	private EstadoDTOAssembler() {

	}

	public static DTOAssembler<EstadoDominio, EstadoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public EstadoDTO convertirADTO(final EstadoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new EstadoDominio.Builder().build());
		var dto = new EstadoDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setDescripcion(dominioTmp.getDescripcion());
		return dto;
	}

	@Override
	public EstadoDominio convertirADominio(final EstadoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new EstadoDTO());
		return new EstadoDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.descripcion(dtoTmp.getDescripcion())
				.build();
	}
}
