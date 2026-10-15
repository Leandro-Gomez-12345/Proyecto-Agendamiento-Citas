package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.FestivoDominio;
import co.com.proyectoagendamientocitas.dto.FestivoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class FestivoDTOAssembler implements DTOAssembler<FestivoDominio, FestivoDTO> {

	private static final DTOAssembler<FestivoDominio, FestivoDTO> INSTANCIA = new FestivoDTOAssembler();

	private FestivoDTOAssembler() {

	}

	public static DTOAssembler<FestivoDominio, FestivoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public FestivoDTO convertirADTO(final FestivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new FestivoDominio.Builder().build());
		var dto = new FestivoDTO();
		dto.setId(dominioTmp.getId());
		dto.setFecha(dominioTmp.getFecha());
		dto.setNombre(dominioTmp.getNombre());
		return dto;
	}

	@Override
	public FestivoDominio convertirADominio(final FestivoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new FestivoDTO());
		return new FestivoDominio.Builder()
				.id(dtoTmp.getId())
				.fecha(dtoTmp.getFecha())
				.nombre(dtoTmp.getNombre())
				.build();
	}
}
