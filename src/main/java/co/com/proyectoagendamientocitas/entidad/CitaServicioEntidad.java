package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class CitaServicioEntidad {

	private UUID id;
	private CitaEntidad cita;
	private BarberoServicioEntidad barberoServicio;
	private int precioServicio;
	private int duracionEnHorasElServicio;
	private int duracionEnMinutosElServicio;
	private int tiempoExtra;

	public CitaServicioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaEntidad());
		setBarberoServicio(new BarberoServicioEntidad());
		setPrecioServicio(UtilNumero.CERO);
		setDuracionEnHorasElServicio(UtilNumero.CERO);
		setDuracionEnMinutosElServicio(UtilNumero.CERO);
		setTiempoExtra(UtilNumero.CERO);
	}

	public CitaServicioEntidad(UUID id, CitaEntidad cita, BarberoServicioEntidad barberoServicio,
			Integer precioServicio, Integer duracionEnHorasElServicio, Integer duracionEnMinutosElServicio,
			Integer tiempoExtra) {
		setId(id);
		setCita(cita);
		setBarberoServicio(barberoServicio);
		setPrecioServicio(precioServicio);
		setDuracionEnHorasElServicio(duracionEnHorasElServicio);
		setDuracionEnMinutosElServicio(duracionEnMinutosElServicio);
		setTiempoExtra(tiempoExtra);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CitaEntidad getCita() {
		return cita;
	}

	public void setCita(CitaEntidad cita) {
		this.cita = UtilObjeto.esNulo(cita) ? new CitaEntidad() : cita;
	}

	public BarberoServicioEntidad getBarberoServicio() {
		return barberoServicio;
	}

	public void setBarberoServicio(BarberoServicioEntidad barberoServicio) {
		this.barberoServicio = UtilObjeto.esNulo(barberoServicio) ? new BarberoServicioEntidad() : barberoServicio;
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
