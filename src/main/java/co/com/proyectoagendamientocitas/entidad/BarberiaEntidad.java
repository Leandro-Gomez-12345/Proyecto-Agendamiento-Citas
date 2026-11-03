package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BarberiaEntidad {

	private UUID id;
	private TipoSociedadEntidad tipoSociedad;
	private String nombreBarberia;
	private String denominacion;
	private String razonSocial;
	private String nit;

	public BarberiaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoSociedad(new TipoSociedadEntidad());
		setNombreBarberia(UtilTexto.VACIA);
		setDenominacion(UtilTexto.VACIA);
		setRazonSocial(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
	}

	public BarberiaEntidad(UUID id, TipoSociedadEntidad tipoSociedad, String nombreBarberia, String denominacion,
			String razonSocial, String nit) {
		setId(id);
		setTipoSociedad(tipoSociedad);
		setNombreBarberia(nombreBarberia);
		setDenominacion(denominacion);
		setRazonSocial(razonSocial);
		setNit(nit);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoSociedadEntidad getTipoSociedad() {
		return tipoSociedad;
	}

	public void setTipoSociedad(TipoSociedadEntidad tipoSociedad) {
		this.tipoSociedad = UtilObjeto.esNulo(tipoSociedad) ? new TipoSociedadEntidad() : tipoSociedad;
	}

	public String getNombreBarberia() {
		return nombreBarberia;
	}

	public void setNombreBarberia(String nombreBarberia) {
		this.nombreBarberia = UtilTexto.quitarEspaciosEnBlanco(nombreBarberia);
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = UtilTexto.quitarEspaciosEnBlanco(denominacion);
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = UtilTexto.quitarEspaciosEnBlanco(razonSocial);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
	}
}
