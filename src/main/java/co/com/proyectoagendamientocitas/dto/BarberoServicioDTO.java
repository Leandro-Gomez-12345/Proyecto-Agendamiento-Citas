package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BarberoServicioDTO {

	private UUID id;
	private BarberoDTO barbero;
	private ServicioDTO servicio;
	private int duracionEnHoras;
	private int duracionEnMinutos;
	private int tiempoExtra;
	private boolean vigente;

	public BarberoServicioDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoDTO());
		setServicio(new ServicioDTO());
		setDuracionEnHoras(UtilNumero.CERO);
		setDuracionEnMinutos(UtilNumero.CERO);
		setTiempoExtra(UtilNumero.CERO);
		setVigente(UtilBooleano.SI);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public BarberoDTO getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoDTO barbero) {
		this.barbero = UtilObjeto.esNulo(barbero) ? new BarberoDTO() : barbero;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = UtilObjeto.esNulo(servicio) ? new ServicioDTO() : servicio;
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
