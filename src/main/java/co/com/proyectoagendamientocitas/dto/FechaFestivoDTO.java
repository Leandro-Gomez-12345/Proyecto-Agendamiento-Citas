package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class FechaFestivoDTO {

	private UUID id;
	private SedeDTO sede;
	private FestivoDTO festivo;

	public FechaFestivoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeDTO());
		setFestivo(new FestivoDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(SedeDTO sede) {
		this.sede = UtilObjeto.esNulo(sede) ? new SedeDTO() : sede;
	}

	public FestivoDTO getFestivo() {
		return festivo;
	}

	public void setFestivo(FestivoDTO festivo) {
		this.festivo = UtilObjeto.esNulo(festivo) ? new FestivoDTO() : festivo;
	}
}
