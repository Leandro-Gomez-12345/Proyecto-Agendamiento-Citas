package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BarberiaDTO {

	private UUID id;
	private String nombreBarberia;
	private String razonSocial;
	private String nit;

	public BarberiaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombreBarberia(UtilTexto.VACIA);
		setRazonSocial(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombreBarberia() {
		return nombreBarberia;
	}

	public void setNombreBarberia(String nombreBarberia) {
		this.nombreBarberia = UtilTexto.quitarEspaciosEnBlanco(nombreBarberia);
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = UtilTexto.obtenerValorDefecto(razonSocial);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
	}
}
