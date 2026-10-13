package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.AgendaDominio;
import co.com.proyectoagendamientocitas.entidad.AgendaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class AgendaEntidadAssembler implements EntidadAssembler<AgendaDominio, AgendaEntidad> {

	private static final EntidadAssembler<AgendaDominio, AgendaEntidad> INSTANCIA = new AgendaEntidadAssembler();

	private AgendaEntidadAssembler() {

	}

	public static EntidadAssembler<AgendaDominio, AgendaEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public AgendaEntidad convertirAEntidad(final AgendaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new AgendaDominio.Builder().build());
		var entidad = new AgendaEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setHorarioDelBarbero(HorarioBarberoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getHorarioDelBarbero()));
		entidad.setFecha(dominioTmp.getFecha());
		return entidad;
	}

	@Override
	public AgendaDominio convertirADominio(final AgendaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new AgendaEntidad());
		return new AgendaDominio.Builder()
				.id(entidadTmp.getId())
				.horarioDelBarbero(HorarioBarberoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getHorarioDelBarbero()))
				.fecha(entidadTmp.getFecha())
				.build();
	}
}
