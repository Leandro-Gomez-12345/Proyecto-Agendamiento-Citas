package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class EstadoEntidad {

	private UUID id;
	private String nombre;
	private String descripcion;

	public EstadoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setDescripcion(UtilTexto.VACIA);
	}

	public EstadoEntidad(UUID id, String nombre, String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.quitarEspaciosEnBlanco(descripcion);
	}
}
