package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.SedeDominio;
import co.com.proyectoagendamientocitas.dto.SedeDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class SedeDTOAssembler implements DTOAssembler<SedeDominio, SedeDTO> {

	private static final DTOAssembler<SedeDominio, SedeDTO> INSTANCIA = new SedeDTOAssembler();

	private SedeDTOAssembler() {

	}

	public static DTOAssembler<SedeDominio, SedeDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public SedeDTO convertirADTO(final SedeDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new SedeDominio.Builder().build());
		var dto = new SedeDTO();
		dto.setId(dominioTmp.getId());
		dto.setCiudad(CiudadDTOAssembler.getInstance().convertirADTO(dominioTmp.getCiudad()));
		dto.setBarberia(BarberiaDTOAssembler.getInstance().convertirADTO(dominioTmp.getBarberia()));
		dto.setNombre(dominioTmp.getNombre());
		dto.setDireccion(dominioTmp.getDireccion());
		return dto;
	}

	@Override
	public SedeDominio convertirADominio(final SedeDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new SedeDTO());
		return new SedeDominio.Builder()
				.id(dtoTmp.getId())
				.ciudad(CiudadDTOAssembler.getInstance().convertirADominio(dtoTmp.getCiudad()))
				.barberia(BarberiaDTOAssembler.getInstance().convertirADominio(dtoTmp.getBarberia()))
				.nombre(dtoTmp.getNombre())
				.direccion(dtoTmp.getDireccion())
				.build();
	}
}
