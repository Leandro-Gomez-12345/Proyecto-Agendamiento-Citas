package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class ServicioEntidad {

	private UUID id;
	private SedeEntidad sede;
	private String nombre;
	private String descripcion;
	private int precio;
	private boolean disponible;

	public ServicioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeEntidad());
		setNombre(UtilTexto.VACIA);
		setDescripcion(UtilTexto.VACIA);
		setPrecio(UtilNumero.CERO);
		setDisponible(UtilBooleano.SI);
	}

	public ServicioEntidad(UUID id, SedeEntidad sede, String nombre, String descripcion, Integer precio,
			Boolean disponible) {
		setId(id);
		setSede(sede);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setDisponible(disponible);
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = UtilNumero.obtenerValorDefecto(precio, UtilNumero.CERO);
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = UtilBooleano.obtenerValorDefecto(disponible, UtilBooleano.SI);
	}
}
