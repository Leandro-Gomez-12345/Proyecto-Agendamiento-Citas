package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BarberiaDTO {

	private UUID id;
	private TipoSociedadDTO tipoSociedad;
	private String nombreBarberia;
	private String denominacion;
	private String razonSocial;
	private String nit;

	public BarberiaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoSociedad(new TipoSociedadDTO());
		setNombreBarberia(UtilTexto.VACIA);
		setDenominacion(UtilTexto.VACIA);
		setRazonSocial(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoSociedadDTO getTipoSociedad() {
		return tipoSociedad;
	}

	public void setTipoSociedad(TipoSociedadDTO tipoSociedad) {
		this.tipoSociedad = UtilObjeto.esNulo(tipoSociedad) ? new TipoSociedadDTO() : tipoSociedad;
	}

	public String getNombreBarberia() {
		return nombreBarberia;
	}

	public void setNombreBarberia(String nombreBarberia) {
		this.nombreBarberia = UtilTexto.quitarEspaciosEnBlanco(nombreBarberia);
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = UtilTexto.quitarEspaciosEnBlanco(denominacion);
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = UtilTexto.quitarEspaciosEnBlanco(razonSocial);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
	}
}
