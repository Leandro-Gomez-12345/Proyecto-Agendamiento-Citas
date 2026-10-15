package co.com.proyectoagendamientocitas.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class FestivoDTO {

	private UUID id;
	private LocalDate fecha;
	private String nombre;

	public FestivoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setFecha(UtilFecha.FECHA_DEFECTO);
		setNombre(UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = UtilFecha.obtenerValorDefecto(fecha);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}
}
