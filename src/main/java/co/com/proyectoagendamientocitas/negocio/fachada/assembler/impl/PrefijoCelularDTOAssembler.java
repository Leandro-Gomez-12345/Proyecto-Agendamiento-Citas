package co.com.proyectoagendamientocitas.negocio.fachada.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.PrefijoCelularDominio;
import co.com.proyectoagendamientocitas.dto.PrefijoCelularDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.assembler.DTOAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class PrefijoCelularDTOAssembler implements DTOAssembler<PrefijoCelularDominio, PrefijoCelularDTO> {

	private static final DTOAssembler<PrefijoCelularDominio, PrefijoCelularDTO> INSTANCIA = new PrefijoCelularDTOAssembler();

	private PrefijoCelularDTOAssembler() {

	}

	public static DTOAssembler<PrefijoCelularDominio, PrefijoCelularDTO> getInstance() {
		return INSTANCIA;
	}

	@Override
	public PrefijoCelularDTO convertirADTO(final PrefijoCelularDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new PrefijoCelularDominio.Builder().build());
		var dto = new PrefijoCelularDTO();
		dto.setId(dominioTmp.getId());
		dto.setPrefijo(dominioTmp.getPrefijo());
		return dto;
	}

	@Override
	public PrefijoCelularDominio convertirADominio(final PrefijoCelularDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PrefijoCelularDTO());
		return new PrefijoCelularDominio.Builder()
				.id(dtoTmp.getId())
				.prefijo(dtoTmp.getPrefijo())
				.build();
	}
}
