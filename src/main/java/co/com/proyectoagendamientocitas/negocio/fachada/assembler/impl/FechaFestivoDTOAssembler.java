package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.FechaFestivoDominio;
import co.com.proyectoagendamientocitas.dto.FechaFestivoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class FechaFestivoDTOAssembler implements DTOAssembler<FechaFestivoDominio, FechaFestivoDTO> {

	private static final DTOAssembler<FechaFestivoDominio, FechaFestivoDTO> INSTANCIA = new FechaFestivoDTOAssembler();

	private FechaFestivoDTOAssembler() {

	}

	public static DTOAssembler<FechaFestivoDominio, FechaFestivoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public FechaFestivoDTO convertirADTO(final FechaFestivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new FechaFestivoDominio.Builder().build());
		var dto = new FechaFestivoDTO();
		dto.setId(dominioTmp.getId());
		dto.setSede(SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede()));
		dto.setFestivo(FestivoDTOAssembler.getInstance().convertirADTO(dominioTmp.getFestivo()));
		return dto;
	}

	@Override
	public FechaFestivoDominio convertirADominio(final FechaFestivoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new FechaFestivoDTO());
		return new FechaFestivoDominio.Builder()
				.id(dtoTmp.getId())
				.sede(SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede()))
				.festivo(FestivoDTOAssembler.getInstance().convertirADominio(dtoTmp.getFestivo()))
				.build();
	}
}
