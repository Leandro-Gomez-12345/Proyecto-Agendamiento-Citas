package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.CitaServicioDominio;
import co.com.proyectoagendamientocitas.dto.CitaServicioDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class CitaServicioDTOAssembler implements DTOAssembler<CitaServicioDominio, CitaServicioDTO> {

	private static final DTOAssembler<CitaServicioDominio, CitaServicioDTO> INSTANCIA = new CitaServicioDTOAssembler();

	private CitaServicioDTOAssembler() {

	}

	public static DTOAssembler<CitaServicioDominio, CitaServicioDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public CitaServicioDTO convertirADTO(final CitaServicioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CitaServicioDominio.Builder().build());
		var dto = new CitaServicioDTO();
		dto.setId(dominioTmp.getId());
		dto.setCita(CitaDTOAssembler.getInstance().convertirADTO(dominioTmp.getCita()));
		dto.setBarberoServicio(BarberoServicioDTOAssembler.getInstance().convertirADTO(dominioTmp.getBarberoServicio()));
		dto.setPrecioServicio(dominioTmp.getPrecioServicio());
		dto.setDuracionEnHorasElServicio(dominioTmp.getDuracionEnHorasElServicio());
		dto.setDuracionEnMinutosElServicio(dominioTmp.getDuracionEnMinutosElServicio());
		dto.setTiempoExtra(dominioTmp.getTiempoExtra());
		return dto;
	}

	@Override
	public CitaServicioDominio convertirADominio(final CitaServicioDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CitaServicioDTO());
		return new CitaServicioDominio.Builder()
				.id(dtoTmp.getId())
				.cita(CitaDTOAssembler.getInstance().convertirADominio(dtoTmp.getCita()))
				.barberoServicio(BarberoServicioDTOAssembler.getInstance().convertirADominio(dtoTmp.getBarberoServicio()))
				.precioServicio(dtoTmp.getPrecioServicio())
				.duracionEnHorasElServicio(dtoTmp.getDuracionEnHorasElServicio())
				.duracionEnMinutosElServicio(dtoTmp.getDuracionEnMinutosElServicio())
				.tiempoExtra(dtoTmp.getTiempoExtra())
				.build();
	}
}
