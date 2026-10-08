package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class SedeDTO {

	private UUID id;
	private CiudadDTO ciudad;
	private BarberiaDTO barberia;
	private String nombre;
	private String direccion;

	public SedeDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCiudad(new CiudadDTO());
		setBarberia(new BarberiaDTO());
		setNombre(UtilTexto.VACIA);
		setDireccion(UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = UtilObjeto.esNulo(ciudad) ? new CiudadDTO() : ciudad;
	}

	public BarberiaDTO getBarberia() {
		return barberia;
	}

	public void setBarberia(BarberiaDTO barberia) {
		this.barberia = UtilObjeto.esNulo(barberia) ? new BarberiaDTO() : barberia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
	}
}
