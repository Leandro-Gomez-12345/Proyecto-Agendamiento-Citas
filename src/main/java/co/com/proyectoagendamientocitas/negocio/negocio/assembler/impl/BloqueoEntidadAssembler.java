package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BloqueoDominio;
import co.com.proyectoagendamientocitas.entidad.BloqueoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BloqueoEntidadAssembler implements EntidadAssembler<BloqueoDominio, BloqueoEntidad> {

	private static final EntidadAssembler<BloqueoDominio, BloqueoEntidad> INSTANCIA = new BloqueoEntidadAssembler();

	private BloqueoEntidadAssembler() {

	}

	public static EntidadAssembler<BloqueoDominio, BloqueoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BloqueoEntidad convertirAEntidad(final BloqueoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BloqueoDominio.Builder().build());
		var entidad = new BloqueoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setBarbero(BarberoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getBarbero()));
		entidad.setFechaHoraInicio(dominioTmp.getFechaHoraInicio());
		entidad.setFechaHoraFinal(dominioTmp.getFechaHoraFinal());
		return entidad;
	}

	@Override
	public BloqueoDominio convertirADominio(final BloqueoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new BloqueoEntidad());
		return new BloqueoDominio.Builder()
				.id(entidadTmp.getId())
				.barbero(BarberoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getBarbero()))
				.fechaHoraInicio(entidadTmp.getFechaHoraInicio())
				.fechaHoraFinal(entidadTmp.getFechaHoraFinal())
				.build();
	}
}
