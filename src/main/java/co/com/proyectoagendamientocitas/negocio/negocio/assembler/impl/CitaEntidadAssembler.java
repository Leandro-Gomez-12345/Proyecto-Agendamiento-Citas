package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.CitaDominio;
import co.com.proyectoagendamientocitas.entidad.CitaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class CitaEntidadAssembler implements EntidadAssembler<CitaDominio, CitaEntidad> {

	private static final EntidadAssembler<CitaDominio, CitaEntidad> INSTANCIA = new CitaEntidadAssembler();

	private CitaEntidadAssembler() {

	}

	public static EntidadAssembler<CitaDominio, CitaEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public CitaEntidad convertirAEntidad(final CitaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CitaDominio.Builder().build());
		var entidad = new CitaEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setCliente(ClienteEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCliente()));
		entidad.setAgenda(AgendaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getAgenda()));
		entidad.setEstado(EstadoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getEstado()));
		entidad.setHoraInicio(dominioTmp.getHoraInicio());
		entidad.setHoraFinEstimada(dominioTmp.getHoraFinEstimada());
		entidad.setPorcentajeDescuento(dominioTmp.getPorcentajeDescuento());
		entidad.setMulta(dominioTmp.getMulta());
		entidad.setTiempoEspera(dominioTmp.getTiempoEspera());
		entidad.setPrecioTotal(dominioTmp.getPrecioTotal());
		return entidad;
	}

	@Override
	public CitaDominio convertirADominio(final CitaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CitaEntidad());
		return new CitaDominio.Builder()
				.id(entidadTmp.getId())
				.cliente(ClienteEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCliente()))
				.agenda(AgendaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getAgenda()))
				.estado(EstadoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getEstado()))
				.horaInicio(entidadTmp.getHoraInicio())
				.horaFinEstimada(entidadTmp.getHoraFinEstimada())
				.porcentajeDescuento(entidadTmp.getPorcentajeDescuento())
				.multa(entidadTmp.getMulta())
				.tiempoEspera(entidadTmp.getTiempoEspera())
				.precioTotal(entidadTmp.getPrecioTotal())
				.build();
	}
}
