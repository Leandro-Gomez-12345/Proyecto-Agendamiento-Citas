package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.CitaServicioDominio;
import co.com.proyectoagendamientocitas.entidad.CitaServicioEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class CitaServicioEntidadAssembler implements EntidadAssembler<CitaServicioDominio, CitaServicioEntidad> {

	private static final EntidadAssembler<CitaServicioDominio, CitaServicioEntidad> INSTANCIA = new CitaServicioEntidadAssembler();

	private CitaServicioEntidadAssembler() {

	}

	public static EntidadAssembler<CitaServicioDominio, CitaServicioEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public CitaServicioEntidad convertirAEntidad(final CitaServicioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CitaServicioDominio.Builder().build());
		var entidad = new CitaServicioEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setCita(CitaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCita()));
		entidad.setBarberoServicio(BarberoServicioEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getBarberoServicio()));
		entidad.setPrecioServicio(dominioTmp.getPrecioServicio());
		entidad.setDuracionEnHorasElServicio(dominioTmp.getDuracionEnHorasElServicio());
		entidad.setDuracionEnMinutosElServicio(dominioTmp.getDuracionEnMinutosElServicio());
		entidad.setTiempoExtra(dominioTmp.getTiempoExtra());
		return entidad;
	}

	@Override
	public CitaServicioDominio convertirADominio(final CitaServicioEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CitaServicioEntidad());
		return new CitaServicioDominio.Builder()
				.id(entidadTmp.getId())
				.cita(CitaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCita()))
				.barberoServicio(BarberoServicioEntidadAssembler.getInstance().convertirADominio(entidadTmp.getBarberoServicio()))
				.precioServicio(entidadTmp.getPrecioServicio())
				.duracionEnHorasElServicio(entidadTmp.getDuracionEnHorasElServicio())
				.duracionEnMinutosElServicio(entidadTmp.getDuracionEnMinutosElServicio())
				.tiempoExtra(entidadTmp.getTiempoExtra())
				.build();
	}
}
