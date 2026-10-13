package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BarberiaDTOAssembler implements DTOAssembler<BarberiaDominio, BarberiaDTO> {

	private static final DTOAssembler<BarberiaDominio, BarberiaDTO> INSTANCIA = new BarberiaDTOAssembler();

	private BarberiaDTOAssembler() {

	}

	public static DTOAssembler<BarberiaDominio, BarberiaDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BarberiaDTO convertirADTO(final BarberiaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BarberiaDominio.Builder().build());
		var dto = new BarberiaDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombreBarberia(dominioTmp.getNombreBarberia());
		dto.setRazonSocial(dominioTmp.getRazonSocial());
		dto.setNit(dominioTmp.getNit());
		return dto;
	}

	@Override
	public BarberiaDominio convertirADominio(final BarberiaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new BarberiaDTO());
		return new BarberiaDominio.Builder()
				.id(dtoTmp.getId())
				.nombreBarberia(dtoTmp.getNombreBarberia())
				.razonSocial(dtoTmp.getRazonSocial())
				.nit(dtoTmp.getNit())
				.build();
	}
}
