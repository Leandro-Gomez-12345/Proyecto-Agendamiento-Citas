package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.TipoSociedadDominio;
import co.com.proyectoagendamientocitas.dto.TipoSociedadDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class TipoSociedadDTOAssembler implements DTOAssembler<TipoSociedadDominio, TipoSociedadDTO> {

	private static final DTOAssembler<TipoSociedadDominio, TipoSociedadDTO> INSTANCIA = new TipoSociedadDTOAssembler();

	private TipoSociedadDTOAssembler() {

	}

	public static DTOAssembler<TipoSociedadDominio, TipoSociedadDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public TipoSociedadDTO convertirADTO(final TipoSociedadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new TipoSociedadDominio.Builder().build());
		var dto = new TipoSociedadDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setSufijo(dominioTmp.getSufijo());
		return dto;
	}

	@Override
	public TipoSociedadDominio convertirADominio(final TipoSociedadDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new TipoSociedadDTO());
		return new TipoSociedadDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.sufijo(dtoTmp.getSufijo())
				.build();
	}
}
