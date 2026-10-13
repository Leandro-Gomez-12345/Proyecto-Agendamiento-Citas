package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.ServicioDominio;
import co.com.proyectoagendamientocitas.dto.ServicioDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class ServicioDTOAssembler implements DTOAssembler<ServicioDominio, ServicioDTO> {

	private static final DTOAssembler<ServicioDominio, ServicioDTO> INSTANCIA = new ServicioDTOAssembler();

	private ServicioDTOAssembler() {

	}

	public static DTOAssembler<ServicioDominio, ServicioDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public ServicioDTO convertirADTO(final ServicioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ServicioDominio.Builder().build());
		var dto = new ServicioDTO();
		dto.setId(dominioTmp.getId());
		dto.setSede(SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede()));
		dto.setNombre(dominioTmp.getNombre());
		dto.setDescripcion(dominioTmp.getDescripcion());
		dto.setPrecio(dominioTmp.getPrecio());
		dto.setDisponible(dominioTmp.isDisponible());
		return dto;
	}

	@Override
	public ServicioDominio convertirADominio(final ServicioDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ServicioDTO());
		return new ServicioDominio.Builder()
				.id(dtoTmp.getId())
				.sede(SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede()))
				.nombre(dtoTmp.getNombre())
				.descripcion(dtoTmp.getDescripcion())
				.precio(dtoTmp.getPrecio())
				.disponible(dtoTmp.isDisponible())
				.build();
	}
}
