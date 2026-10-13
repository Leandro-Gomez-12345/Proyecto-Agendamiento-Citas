package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BarberoDominio;
import co.com.proyectoagendamientocitas.dto.BarberoDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BarberoDTOAssembler implements DTOAssembler<BarberoDominio, BarberoDTO> {

	private static final DTOAssembler<BarberoDominio, BarberoDTO> INSTANCIA = new BarberoDTOAssembler();

	private BarberoDTOAssembler() {

	}

	public static DTOAssembler<BarberoDominio, BarberoDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BarberoDTO convertirADTO(final BarberoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BarberoDominio.Builder().build());
		var dto = new BarberoDTO();
		dto.setId(dominioTmp.getId());
		dto.setPrimerNombre(dominioTmp.getPrimerNombre());
		dto.setSegundoNombre(dominioTmp.getSegundoNombre());
		dto.setPrimerApellido(dominioTmp.getPrimerApellido());
		dto.setSegundoApellido(dominioTmp.getSegundoApellido());
		dto.setPrefijo(PrefijoCelularDTOAssembler.getInstance().convertirADTO(dominioTmp.getPrefijo()));
		dto.setCelular(dominioTmp.getCelular());
		dto.setElNumeroCelularEsCorrecto(dominioTmp.isElNumeroCelularEsCorrecto());
		dto.setVigente(dominioTmp.isVigente());
		dto.setSedeDeTrabajo(SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSedeDeTrabajo()));
		return dto;
	}

	@Override
	public BarberoDominio convertirADominio(final BarberoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new BarberoDTO());
		return new BarberoDominio.Builder()
				.id(dtoTmp.getId())
				.primerNombre(dtoTmp.getPrimerNombre())
				.segundoNombre(dtoTmp.getSegundoNombre())
				.primerApellido(dtoTmp.getPrimerApellido())
				.segundoApellido(dtoTmp.getSegundoApellido())
				.prefijo(PrefijoCelularDTOAssembler.getInstance().convertirADominio(dtoTmp.getPrefijo()))
				.celular(dtoTmp.getCelular())
				.elNumeroCelularEsCorrecto(dtoTmp.isElNumeroCelularEsCorrecto())
				.vigente(dtoTmp.isVigente())
				.sedeDeTrabajo(SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSedeDeTrabajo()))
				.build();
	}
}
