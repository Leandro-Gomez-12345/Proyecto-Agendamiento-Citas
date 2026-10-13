package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.SedeDominio;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class SedeEntidadAssembler implements EntidadAssembler<SedeDominio, SedeEntidad> {

	private static final EntidadAssembler<SedeDominio, SedeEntidad> INSTANCIA = new SedeEntidadAssembler();

	private SedeEntidadAssembler() {

	}

	public static EntidadAssembler<SedeDominio, SedeEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public SedeEntidad convertirAEntidad(final SedeDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new SedeDominio.Builder().build());
		var entidad = new SedeEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setCiudad(CiudadEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCiudad()));
		entidad.setBarberia(BarberiaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getBarberia()));
		entidad.setNombre(dominioTmp.getNombre());
		entidad.setDireccion(dominioTmp.getDireccion());
		return entidad;
	}

	@Override
	public SedeDominio convertirADominio(final SedeEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new SedeEntidad());
		return new SedeDominio.Builder()
				.id(entidadTmp.getId())
				.ciudad(CiudadEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCiudad()))
				.barberia(BarberiaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getBarberia()))
				.nombre(entidadTmp.getNombre())
				.direccion(entidadTmp.getDireccion())
				.build();
	}
}
