package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class CiudadEntidad {

	private UUID id;
	private String nombre;
	private DepartamentoEntidad departamento;

	public CiudadEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setDepartamento(new DepartamentoEntidad());
	}

	public CiudadEntidad(UUID id, String nombre, DepartamentoEntidad departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
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

	public DepartamentoEntidad getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoEntidad departamento) {
		this.departamento = UtilObjeto.esNulo(departamento) ? new DepartamentoEntidad() : departamento;
	}
}
