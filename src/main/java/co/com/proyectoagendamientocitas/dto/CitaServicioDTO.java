package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class CitaServicioDTO {

	private UUID id;
	private CitaDTO cita;
	private BarberoServicioDTO barberoServicio;
	private int precioServicio;
	private int duracionEnHorasElServicio;
	private int duracionEnMinutosElServicio;
	private int tiempoExtra;

	public CitaServicioDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaDTO());
		setBarberoServicio(new BarberoServicioDTO());
		setPrecioServicio(UtilNumero.CERO);
		setDuracionEnHorasElServicio(UtilNumero.CERO);
		setDuracionEnMinutosElServicio(UtilNumero.CERO);
		setTiempoExtra(UtilNumero.CERO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CitaDTO getCita() {
		return cita;
	}

	public void setCita(CitaDTO cita) {
		this.cita = UtilObjeto.esNulo(cita) ? new CitaDTO() : cita;
	}

	public BarberoServicioDTO getBarberoServicio() {
		return barberoServicio;
	}

	public void setBarberoServicio(BarberoServicioDTO barberoServicio) {
		this.barberoServicio = UtilObjeto.esNulo(barberoServicio) ? new BarberoServicioDTO() : barberoServicio;
	}

	public int getPrecioServicio() {
		return precioServicio;
	}

	public void setPrecioServicio(Integer precioServicio) {
		this.precioServicio = UtilNumero.obtenerValorDefecto(precioServicio, UtilNumero.CERO);
	}

	public int getDuracionEnHorasElServicio() {
		return duracionEnHorasElServicio;
	}

	public void setDuracionEnHorasElServicio(Integer duracionEnHorasElServicio) {
		this.duracionEnHorasElServicio = UtilNumero.obtenerValorDefecto(duracionEnHorasElServicio, UtilNumero.CERO);
	}

	public int getDuracionEnMinutosElServicio() {
		return duracionEnMinutosElServicio;
	}

	public void setDuracionEnMinutosElServicio(Integer duracionEnMinutosElServicio) {
		this.duracionEnMinutosElServicio = UtilNumero.obtenerValorDefecto(duracionEnMinutosElServicio, UtilNumero.CERO);
	}

	public int getTiempoExtra() {
		return tiempoExtra;
	}

	public void setTiempoExtra(Integer tiempoExtra) {
		this.tiempoExtra = UtilNumero.obtenerValorDefecto(tiempoExtra, UtilNumero.CERO);
	}
}
