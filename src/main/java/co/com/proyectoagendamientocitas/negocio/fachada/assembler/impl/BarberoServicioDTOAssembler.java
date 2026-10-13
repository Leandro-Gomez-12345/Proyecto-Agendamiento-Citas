package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BarberoServicioDominio;
import co.com.proyectoagendamientocitas.dto.BarberoServicioDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BarberoServicioDTOAssembler implements DTOAssembler<BarberoServicioDominio, BarberoServicioDTO> {

	private static final DTOAssembler<BarberoServicioDominio, BarberoServicioDTO> INSTANCIA = new BarberoServicioDTOAssembler();

	private BarberoServicioDTOAssembler() {

	}

	public static DTOAssembler<BarberoServicioDominio, BarberoServicioDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BarberoServicioDTO convertirADTO(final BarberoServicioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BarberoServicioDominio.Builder().build());
		var dto = new BarberoServicioDTO();
		dto.setId(dominioTmp.getId());
		dto.setBarbero(BarberoDTOAssembler.getInstance().convertirADTO(dominioTmp.getBarbero()));
		dto.setServicio(ServicioDTOAssembler.getInstance().convertirADTO(dominioTmp.getServicio()));
		dto.setDuracionEnHoras(dominioTmp.getDuracionEnHoras());
		dto.setDuracionEnMinutos(dominioTmp.getDuracionEnMinutos());
		dto.setTiempoExtra(dominioTmp.getTiempoExtra());
		dto.setVigente(dominioTmp.isVigente());
		return dto;
	}

	@Override
	public BarberoServicioDominio convertirADominio(final BarberoServicioDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new BarberoServicioDTO());
		return new BarberoServicioDominio.Builder()
				.id(dtoTmp.getId())
				.barbero(BarberoDTOAssembler.getInstance().convertirADominio(dtoTmp.getBarbero()))
				.servicio(ServicioDTOAssembler.getInstance().convertirADominio(dtoTmp.getServicio()))
				.duracionEnHoras(dtoTmp.getDuracionEnHoras())
				.duracionEnMinutos(dtoTmp.getDuracionEnMinutos())
				.tiempoExtra(dtoTmp.getTiempoExtra())
				.vigente(dtoTmp.isVigente())
				.build();
	}
}
