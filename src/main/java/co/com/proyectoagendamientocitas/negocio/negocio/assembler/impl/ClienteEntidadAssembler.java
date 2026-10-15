package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.ClienteDominio;
import co.com.proyectoagendamientocitas.entidad.ClienteEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class ClienteEntidadAssembler implements EntidadAssembler<ClienteDominio, ClienteEntidad> {

	private static final EntidadAssembler<ClienteDominio, ClienteEntidad> INSTANCIA = new ClienteEntidadAssembler();

	private ClienteEntidadAssembler() {

	}

	public static EntidadAssembler<ClienteDominio, ClienteEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public ClienteEntidad convertirAEntidad(final ClienteDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ClienteDominio.Builder().build());
		var entidad = new ClienteEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setPrimerNombre(dominioTmp.getPrimerNombre());
		entidad.setSegundoNombre(dominioTmp.getSegundoNombre());
		entidad.setPrimerApellido(dominioTmp.getPrimerApellido());
		entidad.setSegundoApellido(dominioTmp.getSegundoApellido());
		entidad.setPrefijoCelular(PrefijoCelularEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getPrefijoCelular()));
		entidad.setCelular(dominioTmp.getCelular());
		entidad.setElNumeroCelularEsCorrecto(dominioTmp.isElNumeroCelularEsCorrecto());
		return entidad;
	}

	@Override
	public ClienteDominio convertirADominio(final ClienteEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteEntidad());
		return new ClienteDominio.Builder()
				.id(entidadTmp.getId())
				.primerNombre(entidadTmp.getPrimerNombre())
				.segundoNombre(entidadTmp.getSegundoNombre())
				.primerApellido(entidadTmp.getPrimerApellido())
				.segundoApellido(entidadTmp.getSegundoApellido())
				.prefijoCelular(PrefijoCelularEntidadAssembler.getInstance().convertirADominio(entidadTmp.getPrefijoCelular()))
				.celular(entidadTmp.getCelular())
				.elNumeroCelularEsCorrecto(entidadTmp.isElNumeroCelularEsCorrecto())
				.build();
	}
}
