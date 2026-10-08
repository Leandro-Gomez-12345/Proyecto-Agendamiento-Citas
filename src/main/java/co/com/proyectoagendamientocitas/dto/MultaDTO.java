package co.com.proyectoagendamientocitas.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class MultaDTO {

	private UUID id;
	private CitaDTO cita;
	private TipoMultaDTO tipo;
	private int monto;
	private LocalTime horaGeneracion;
	private LocalDateTime fechaHoraPago;
	private boolean pagada;

	public MultaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaDTO());
		setTipo(new TipoMultaDTO());
		setMonto(UtilNumero.CERO);
		setHoraGeneracion(UtilHora.HORA_DEFECTO);
		setFechaHoraPago(UtilFechaHora.FECHA_HORA_DEFECTO);
		setPagada(UtilBooleano.NO);
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

	public TipoMultaDTO getTipo() {
		return tipo;
	}

	public void setTipo(TipoMultaDTO tipo) {
		this.tipo = UtilObjeto.esNulo(tipo) ? new TipoMultaDTO() : tipo;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = UtilNumero.obtenerValorDefecto(monto, UtilNumero.CERO);
	}

	public LocalTime getHoraGeneracion() {
		return horaGeneracion;
	}

	public void setHoraGeneracion(LocalTime horaGeneracion) {
		this.horaGeneracion = UtilHora.obtenerValorDefecto(horaGeneracion);
	}

	public LocalDateTime getFechaHoraPago() {
		return fechaHoraPago;
	}

	public void setFechaHoraPago(LocalDateTime fechaHoraPago) {
		this.fechaHoraPago = UtilFechaHora.obtenerValorDefecto(fechaHoraPago);
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(Boolean pagada) {
		this.pagada = UtilBooleano.obtenerValorDefecto(pagada, UtilBooleano.NO);
	}
}
