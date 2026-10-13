package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.HorarioBarberoDominio;
import co.com.proyectoagendamientocitas.entidad.HorarioBarberoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class HorarioBarberoEntidadAssembler implements EntidadAssembler<HorarioBarberoDominio, HorarioBarberoEntidad> {

	private static final EntidadAssembler<HorarioBarberoDominio, HorarioBarberoEntidad> INSTANCIA = new HorarioBarberoEntidadAssembler();

	private HorarioBarberoEntidadAssembler() {

	}

	public static EntidadAssembler<HorarioBarberoDominio, HorarioBarberoEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public HorarioBarberoEntidad convertirAEntidad(final HorarioBarberoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new HorarioBarberoDominio.Builder().build());
		var entidad = new HorarioBarberoEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setBarbero(BarberoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getBarbero()));
		entidad.setHorarioDeLaSede(HorarioSedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getHorarioDeLaSede()));
		entidad.setHoraInicio(dominioTmp.getHoraInicio());
		entidad.setHoraFinal(dominioTmp.getHoraFinal());
		entidad.setFechaCreacion(dominioTmp.getFechaCreacion());
		entidad.setFechaDesactivacion(dominioTmp.getFechaDesactivacion());
		entidad.setVigente(dominioTmp.isVigente());
		return entidad;
	}

	@Override
	public HorarioBarberoDominio convertirADominio(final HorarioBarberoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new HorarioBarberoEntidad());
		return new HorarioBarberoDominio.Builder()
				.id(entidadTmp.getId())
				.barbero(BarberoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getBarbero()))
				.horarioDeLaSede(HorarioSedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getHorarioDeLaSede()))
				.horaInicio(entidadTmp.getHoraInicio())
				.horaFinal(entidadTmp.getHoraFinal())
				.fechaCreacion(entidadTmp.getFechaCreacion())
				.fechaDesactivacion(entidadTmp.getFechaDesactivacion())
				.vigente(entidadTmp.isVigente())
				.build();
	}
}
