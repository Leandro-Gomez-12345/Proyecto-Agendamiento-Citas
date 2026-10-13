package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.ClienteDominio;
import co.com.proyectoagendamientocitas.dto.ClienteDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class ClienteDTOAssembler implements DTOAssembler<ClienteDominio, ClienteDTO> {

	private static final DTOAssembler<ClienteDominio, ClienteDTO> INSTANCIA = new ClienteDTOAssembler();

	private ClienteDTOAssembler() {

	}

	public static DTOAssembler<ClienteDominio, ClienteDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public ClienteDTO convertirADTO(final ClienteDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ClienteDominio.Builder().build());
		var dto = new ClienteDTO();
		dto.setId(dominioTmp.getId());
		dto.setPrimerNombre(dominioTmp.getPrimerNombre());
		dto.setSegundoNombre(dominioTmp.getSegundoNombre());
		dto.setPrimerApellido(dominioTmp.getPrimerApellido());
		dto.setSegundoApellido(dominioTmp.getSegundoApellido());
		dto.setPrefijoCelular(PrefijoCelularDTOAssembler.getInstance().convertirADTO(dominioTmp.getPrefijoCelular()));
		dto.setCelular(dominioTmp.getCelular());
		dto.setElNumeroCelularEsCorrecto(dominioTmp.isElNumeroCelularEsCorrecto());
		dto.setEstaVetado(dominioTmp.isEstaVetado());
		return dto;
	}

	@Override
	public ClienteDominio convertirADominio(final ClienteDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ClienteDTO());
		return new ClienteDominio.Builder()
				.id(dtoTmp.getId())
				.primerNombre(dtoTmp.getPrimerNombre())
				.segundoNombre(dtoTmp.getSegundoNombre())
				.primerApellido(dtoTmp.getPrimerApellido())
				.segundoApellido(dtoTmp.getSegundoApellido())
				.prefijoCelular(PrefijoCelularDTOAssembler.getInstance().convertirADominio(dtoTmp.getPrefijoCelular()))
				.celular(dtoTmp.getCelular())
				.elNumeroCelularEsCorrecto(dtoTmp.isElNumeroCelularEsCorrecto())
				.estaVetado(dtoTmp.isEstaVetado())
				.build();
	}
}
