package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BarberoDominio;
import co.com.proyectoagendamientocitas.entidad.BarberoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BarberoEntidadAssembler implements EntidadAssembler<BarberoDominio, BarberoEntidad> {

	private static final EntidadAssembler<BarberoDominio, BarberoEntidad> INSTANCIA = new BarberoEntidadAssembler();

	private BarberoEntidadAssembler() {

	}

	public static EntidadAssembler<BarberoDominio, BarberoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BarberoEntidad convertirAEntidad(final BarberoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BarberoDominio.Builder().build());
		var entidad = new BarberoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setPrimerNombre(dominioTmp.getPrimerNombre());
		entidad.setSegundoNombre(dominioTmp.getSegundoNombre());
		entidad.setPrimerApellido(dominioTmp.getPrimerApellido());
		entidad.setSegundoApellido(dominioTmp.getSegundoApellido());
		entidad.setPrefijo(PrefijoCelularEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getPrefijo()));
		entidad.setCelular(dominioTmp.getCelular());
		entidad.setElNumeroCelularEsCorrecto(dominioTmp.isElNumeroCelularEsCorrecto());
		entidad.setVigente(dominioTmp.isVigente());
		entidad.setSedeDeTrabajo(SedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getSedeDeTrabajo()));
		return entidad;
	}

	@Override
	public BarberoDominio convertirADominio(final BarberoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new BarberoEntidad());
		return new BarberoDominio.Builder()
				.id(entidadTmp.getId())
				.primerNombre(entidadTmp.getPrimerNombre())
				.segundoNombre(entidadTmp.getSegundoNombre())
				.primerApellido(entidadTmp.getPrimerApellido())
				.segundoApellido(entidadTmp.getSegundoApellido())
				.prefijo(PrefijoCelularEntidadAssembler.getInstance().convertirADominio(entidadTmp.getPrefijo()))
				.celular(entidadTmp.getCelular())
				.elNumeroCelularEsCorrecto(entidadTmp.isElNumeroCelularEsCorrecto())
				.vigente(entidadTmp.isVigente())
				.sedeDeTrabajo(SedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getSedeDeTrabajo()))
				.build();
	}
}
