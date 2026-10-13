package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.DiaSemanaDominio;
import co.com.proyectoagendamientocitas.dto.DiaSemanaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class DiaSemanaDTOAssembler implements DTOAssembler<DiaSemanaDominio, DiaSemanaDTO> {

	private static final DTOAssembler<DiaSemanaDominio, DiaSemanaDTO> INSTANCIA = new DiaSemanaDTOAssembler();

	private DiaSemanaDTOAssembler() {

	}

	public static DTOAssembler<DiaSemanaDominio, DiaSemanaDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public DiaSemanaDTO convertirADTO(final DiaSemanaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new DiaSemanaDominio.Builder().build());
		var dto = new DiaSemanaDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		return dto;
	}

	@Override
	public DiaSemanaDominio convertirADominio(final DiaSemanaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DiaSemanaDTO());
		return new DiaSemanaDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.build();
	}
}
