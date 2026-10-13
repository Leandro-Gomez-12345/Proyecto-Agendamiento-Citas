package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.BarberoServicioDominio;
import co.com.proyectoagendamientocitas.entidad.BarberoServicioEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class BarberoServicioEntidadAssembler implements EntidadAssembler<BarberoServicioDominio, BarberoServicioEntidad> {

	private static final EntidadAssembler<BarberoServicioDominio, BarberoServicioEntidad> INSTANCIA = new BarberoServicioEntidadAssembler();

	private BarberoServicioEntidadAssembler() {

	}

	public static EntidadAssembler<BarberoServicioDominio, BarberoServicioEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public BarberoServicioEntidad convertirAEntidad(final BarberoServicioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new BarberoServicioDominio.Builder().build());
		var entidad = new BarberoServicioEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setBarbero(BarberoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getBarbero()));
		entidad.setServicio(ServicioEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getServicio()));
		entidad.setDuracionEnHoras(dominioTmp.getDuracionEnHoras());
		entidad.setDuracionEnMinutos(dominioTmp.getDuracionEnMinutos());
		entidad.setTiempoExtra(dominioTmp.getTiempoExtra());
		entidad.setVigente(dominioTmp.isVigente());
		return entidad;
	}

	@Override
	public BarberoServicioDominio convertirADominio(final BarberoServicioEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new BarberoServicioEntidad());
		return new BarberoServicioDominio.Builder()
				.id(entidadTmp.getId())
				.barbero(BarberoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getBarbero()))
				.servicio(ServicioEntidadAssembler.getInstance().convertirADominio(entidadTmp.getServicio()))
				.duracionEnHoras(entidadTmp.getDuracionEnHoras())
				.duracionEnMinutos(entidadTmp.getDuracionEnMinutos())
				.tiempoExtra(entidadTmp.getTiempoExtra())
				.vigente(entidadTmp.isVigente())
				.build();
	}
}
