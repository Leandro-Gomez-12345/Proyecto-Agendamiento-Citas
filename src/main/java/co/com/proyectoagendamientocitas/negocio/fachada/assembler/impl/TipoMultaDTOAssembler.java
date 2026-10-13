package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.TipoMultaDominio;
import co.com.proyectoagendamientocitas.dto.TipoMultaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class TipoMultaDTOAssembler implements DTOAssembler<TipoMultaDominio, TipoMultaDTO> {

	private static final DTOAssembler<TipoMultaDominio, TipoMultaDTO> INSTANCIA = new TipoMultaDTOAssembler();

	private TipoMultaDTOAssembler() {

	}

	public static DTOAssembler<TipoMultaDominio, TipoMultaDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public TipoMultaDTO convertirADTO(final TipoMultaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new TipoMultaDominio.Builder().build());
		var dto = new TipoMultaDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setDescripcion(dominioTmp.getDescripcion());
		return dto;
	}

	@Override
	public TipoMultaDominio convertirADominio(final TipoMultaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new TipoMultaDTO());
		return new TipoMultaDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.descripcion(dtoTmp.getDescripcion())
				.build();
	}
}
