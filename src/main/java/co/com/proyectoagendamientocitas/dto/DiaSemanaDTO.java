package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class DiaSemanaDTO {

	private UUID id;
	private String nombre;

	public DiaSemanaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}
}
