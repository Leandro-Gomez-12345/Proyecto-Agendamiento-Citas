package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.HorarioSedeDominio;
import co.com.proyectoagendamientocitas.dto.HorarioSedeDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class HorarioSedeDTOAssembler implements DTOAssembler<HorarioSedeDominio, HorarioSedeDTO> {

	private static final DTOAssembler<HorarioSedeDominio, HorarioSedeDTO> INSTANCIA = new HorarioSedeDTOAssembler();

	private HorarioSedeDTOAssembler() {

	}

	public static DTOAssembler<HorarioSedeDominio, HorarioSedeDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public HorarioSedeDTO convertirADTO(final HorarioSedeDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new HorarioSedeDominio.Builder().build());
		var dto = new HorarioSedeDTO();
		dto.setId(dominioTmp.getId());
		dto.setSede(SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede()));
		dto.setDiaDeLaSemana(DiaSemanaDTOAssembler.getInstance().convertirADTO(dominioTmp.getDiaDeLaSemana()));
		dto.setHoraApertura(dominioTmp.getHoraApertura());
		dto.setHoraCierre(dominioTmp.getHoraCierre());
		dto.setFechaCreacion(dominioTmp.getFechaCreacion());
		dto.setFechaDesactivacion(dominioTmp.getFechaDesactivacion());
		dto.setVigente(dominioTmp.isVigente());
		return dto;
	}

	@Override
	public HorarioSedeDominio convertirADominio(final HorarioSedeDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new HorarioSedeDTO());
		return new HorarioSedeDominio.Builder()
				.id(dtoTmp.getId())
				.sede(SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede()))
				.diaDeLaSemana(DiaSemanaDTOAssembler.getInstance().convertirADominio(dtoTmp.getDiaDeLaSemana()))
				.horaApertura(dtoTmp.getHoraApertura())
				.horaCierre(dtoTmp.getHoraCierre())
				.fechaCreacion(dtoTmp.getFechaCreacion())
				.fechaDesactivacion(dtoTmp.getFechaDesactivacion())
				.vigente(dtoTmp.isVigente())
				.build();
	}
}
