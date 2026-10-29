package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class SedeFestivoEntidad {

	private UUID id;
	private SedeEntidad sede;
	private FestivoEntidad festivo;

	public SedeFestivoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeEntidad());
		setFestivo(new FestivoEntidad());
	}

	public SedeFestivoEntidad(UUID id, SedeEntidad sede, FestivoEntidad festivo) {
		setId(id);
		setSede(sede);
		setFestivo(festivo);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(SedeEntidad sede) {
		this.sede = UtilObjeto.esNulo(sede) ? new SedeEntidad() : sede;
	}

	public FestivoEntidad getFestivo() {
		return festivo;
	}

	public void setFestivo(FestivoEntidad festivo) {
		this.festivo = UtilObjeto.esNulo(festivo) ? new FestivoEntidad() : festivo;
	}
}
