package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.HorarioBarberoDominio;
import co.com.proyectoagendamientocitas.dto.HorarioBarberoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class HorarioBarberoDTOAssembler implements DTOAssembler<HorarioBarberoDominio, HorarioBarberoDTO> {

	private static final DTOAssembler<HorarioBarberoDominio, HorarioBarberoDTO> INSTANCIA = new HorarioBarberoDTOAssembler();

	private HorarioBarberoDTOAssembler() {

	}

	public static DTOAssembler<HorarioBarberoDominio, HorarioBarberoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public HorarioBarberoDTO convertirADTO(final HorarioBarberoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new HorarioBarberoDominio.Builder().build());
		var dto = new HorarioBarberoDTO();
		dto.setId(dominioTmp.getId());
		dto.setBarbero(BarberoDTOAssembler.getInstance().convertirADTO(dominioTmp.getBarbero()));
		dto.setHorarioDeLaSede(HorarioSedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getHorarioDeLaSede()));
		dto.setHoraInicio(dominioTmp.getHoraInicio());
		dto.setHoraFinal(dominioTmp.getHoraFinal());
		dto.setFechaCreacion(dominioTmp.getFechaCreacion());
		dto.setFechaDesactivacion(dominioTmp.getFechaDesactivacion());
		dto.setVigente(dominioTmp.isVigente());
		return dto;
	}

	@Override
	public HorarioBarberoDominio convertirADominio(final HorarioBarberoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new HorarioBarberoDTO());
		return new HorarioBarberoDominio.Builder()
				.id(dtoTmp.getId())
				.barbero(BarberoDTOAssembler.getInstance().convertirADominio(dtoTmp.getBarbero()))
				.horarioDeLaSede(HorarioSedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getHorarioDeLaSede()))
				.horaInicio(dtoTmp.getHoraInicio())
				.horaFinal(dtoTmp.getHoraFinal())
				.fechaCreacion(dtoTmp.getFechaCreacion())
				.fechaDesactivacion(dtoTmp.getFechaDesactivacion())
				.vigente(dtoTmp.isVigente())
				.build();
	}
}
