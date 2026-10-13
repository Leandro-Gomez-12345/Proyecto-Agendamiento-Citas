package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.DepartamentoDominio;
import co.com.proyectoagendamientocitas.dto.DepartamentoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class DepartamentoDTOAssembler implements DTOAssembler<DepartamentoDominio, DepartamentoDTO> {

	private static final DTOAssembler<DepartamentoDominio, DepartamentoDTO> INSTANCIA = new DepartamentoDTOAssembler();

	private DepartamentoDTOAssembler() {

	}

	public static DTOAssembler<DepartamentoDominio, DepartamentoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public DepartamentoDTO convertirADTO(final DepartamentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new DepartamentoDominio.Builder().build());
		var dto = new DepartamentoDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		return dto;
	}

	@Override
	public DepartamentoDominio convertirADominio(final DepartamentoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DepartamentoDTO());
		return new DepartamentoDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.build();
	}
}
