package co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl;

import co.com.proyectoagendamientocitas.dominio.HorarioSedeDominio;
import co.com.proyectoagendamientocitas.entidad.HorarioSedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.EntidadAssembler;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;

public final class HorarioSedeEntidadAssembler implements EntidadAssembler<HorarioSedeDominio, HorarioSedeEntidad> {

	private static final EntidadAssembler<HorarioSedeDominio, HorarioSedeEntidad> INSTANCIA = new HorarioSedeEntidadAssembler();

	private HorarioSedeEntidadAssembler() {

	}

	public static EntidadAssembler<HorarioSedeDominio, HorarioSedeEntidad> getInstance() {
		return INSTANCIA;
	}

	@Override
	public HorarioSedeEntidad convertirAEntidad(final HorarioSedeDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new HorarioSedeDominio.Builder().build());
		var entidad = new HorarioSedeEntidad();
		entidad.setId(dominioTmp.getId());
		entidad.setSede(SedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getSede()));
		entidad.setDiaDeLaSemana(DiaSemanaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getDiaDeLaSemana()));
		entidad.setHoraApertura(dominioTmp.getHoraApertura());
		entidad.setHoraCierre(dominioTmp.getHoraCierre());
		entidad.setFechaCreacion(dominioTmp.getFechaCreacion());
		entidad.setFechaDesactivacion(dominioTmp.getFechaDesactivacion());
		entidad.setVigente(dominioTmp.isVigente());
		return entidad;
	}

	@Override
	public HorarioSedeDominio convertirADominio(final HorarioSedeEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new HorarioSedeEntidad());
		return new HorarioSedeDominio.Builder()
				.id(entidadTmp.getId())
				.sede(SedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getSede()))
				.diaDeLaSemana(DiaSemanaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getDiaDeLaSemana()))
				.horaApertura(entidadTmp.getHoraApertura())
				.horaCierre(entidadTmp.getHoraCierre())
				.fechaCreacion(entidadTmp.getFechaCreacion())
				.fechaDesactivacion(entidadTmp.getFechaDesactivacion())
				.vigente(entidadTmp.isVigente())
				.build();
	}
}
