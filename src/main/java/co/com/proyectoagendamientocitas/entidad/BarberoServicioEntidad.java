package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BarberoServicioEntidad {

	private UUID id;
	private BarberoEntidad barbero;
	private ServicioEntidad servicio;
	private int duracionEnHoras;
	private int duracionEnMinutos;
	private int tiempoExtra;
	private boolean vigente;

	public BarberoServicioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoEntidad());
		setServicio(new ServicioEntidad());
		setDuracionEnHoras(UtilNumero.CERO);
		setDuracionEnMinutos(UtilNumero.CERO);
		setTiempoExtra(UtilNumero.CERO);
		setVigente(UtilBooleano.SI);
	}

	public BarberoServicioEntidad(UUID id, BarberoEntidad barbero, ServicioEntidad servicio,
			Integer duracionEnHoras, Integer duracionEnMinutos, Integer tiempoExtra, Boolean vigente) {
		setId(id);
		setBarbero(barbero);
		setServicio(servicio);
		setDuracionEnHoras(duracionEnHoras);
		setDuracionEnMinutos(duracionEnMinutos);
		setTiempoExtra(tiempoExtra);
		setVigente(vigente);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public BarberoEntidad getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoEntidad barbero) {
		this.barbero = UtilObjeto.esNulo(barbero) ? new BarberoEntidad() : barbero;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntidad servicio) {
		this.servicio = UtilObjeto.esNulo(servicio) ? new ServicioEntidad() : servicio;
	}

	public int getDuracionEnHoras() {
		return duracionEnHoras;
	}

	public void setDuracionEnHoras(Integer duracionEnHoras) {
		this.duracionEnHoras = UtilNumero.obtenerValorDefecto(duracionEnHoras, UtilNumero.CERO);
	}

	public int getDuracionEnMinutos() {
		return duracionEnMinutos;
	}

	public void setDuracionEnMinutos(Integer duracionEnMinutos) {
		this.duracionEnMinutos = UtilNumero.obtenerValorDefecto(duracionEnMinutos, UtilNumero.CERO);
	}

	public int getTiempoExtra() {
		return tiempoExtra;
	}

	public void setTiempoExtra(Integer tiempoExtra) {
		this.tiempoExtra = UtilNumero.obtenerValorDefecto(tiempoExtra, UtilNumero.CERO);
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = UtilBooleano.obtenerValorDefecto(vigente, UtilBooleano.SI);
	}
}
