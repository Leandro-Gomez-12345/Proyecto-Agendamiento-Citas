package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class SedeEntidad {

	private UUID id;
	private CiudadEntidad ciudad;
	private BarberiaEntidad barberia;
	private String nombre;
	private String direccion;

	public SedeEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCiudad(new CiudadEntidad());
		setBarberia(new BarberiaEntidad());
		setNombre(UtilTexto.VACIA);
		setDireccion(UtilTexto.VACIA);
	}

	public SedeEntidad(UUID id, CiudadEntidad ciudad, BarberiaEntidad barberia, String nombre,
			String direccion) {
		setId(id);
		setCiudad(ciudad);
		setBarberia(barberia);
		setNombre(nombre);
		setDireccion(direccion);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CiudadEntidad getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntidad ciudad) {
		this.ciudad = UtilObjeto.esNulo(ciudad) ? new CiudadEntidad() : ciudad;
	}

	public BarberiaEntidad getBarberia() {
		return barberia;
	}

	public void setBarberia(BarberiaEntidad barberia) {
		this.barberia = UtilObjeto.esNulo(barberia) ? new BarberiaEntidad() : barberia;
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
