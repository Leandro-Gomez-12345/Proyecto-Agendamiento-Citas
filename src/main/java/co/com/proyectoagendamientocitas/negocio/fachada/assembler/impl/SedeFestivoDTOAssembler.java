package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.SedeFestivoDominio;
import co.com.proyectoagendamientocitas.dto.SedeFestivoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class SedeFestivoDTOAssembler implements DTOAssembler<SedeFestivoDominio, SedeFestivoDTO> {

	private static final DTOAssembler<SedeFestivoDominio, SedeFestivoDTO> INSTANCIA = new SedeFestivoDTOAssembler();

	private SedeFestivoDTOAssembler() {

	}

	public static DTOAssembler<SedeFestivoDominio, SedeFestivoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public SedeFestivoDTO convertirADTO(final SedeFestivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new SedeFestivoDominio.Builder().build());
		var dto = new SedeFestivoDTO();
		dto.setId(dominioTmp.getId());
		dto.setSede(SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede()));
		dto.setFestivo(FestivoDTOAssembler.getInstance().convertirADTO(dominioTmp.getFestivo()));
		return dto;
	}

	@Override
	public SedeFestivoDominio convertirADominio(final SedeFestivoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new SedeFestivoDTO());
		return new SedeFestivoDominio.Builder()
				.id(dtoTmp.getId())
				.sede(SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede()))
				.festivo(FestivoDTOAssembler.getInstance().convertirADominio(dtoTmp.getFestivo()))
				.build();
	}
}
