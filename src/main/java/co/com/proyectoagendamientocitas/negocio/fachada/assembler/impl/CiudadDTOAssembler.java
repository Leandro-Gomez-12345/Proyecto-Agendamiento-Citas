package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.CiudadDominio;
import co.com.proyectoagendamientocitas.dto.CiudadDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class CiudadDTOAssembler implements DTOAssembler<CiudadDominio, CiudadDTO> {

	private static final DTOAssembler<CiudadDominio, CiudadDTO> INSTANCIA = new CiudadDTOAssembler();

	private CiudadDTOAssembler() {

	}

	public static DTOAssembler<CiudadDominio, CiudadDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public CiudadDTO convertirADTO(final CiudadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CiudadDominio.Builder().build());
		var dto = new CiudadDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setDepartamento(DepartamentoDTOAssembler.getInstance().convertirADTO(dominioTmp.getDepartamento()));
		return dto;
	}

	@Override
	public CiudadDominio convertirADominio(final CiudadDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CiudadDTO());
		return new CiudadDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.departamento(DepartamentoDTOAssembler.getInstance().convertirADominio(dtoTmp.getDepartamento()))
				.build();
	}
}
