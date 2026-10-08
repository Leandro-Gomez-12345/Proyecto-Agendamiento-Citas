package co.com.proyectoagendamientocitas.entidad;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class MultaEntidad {

	private UUID id;
	private CitaEntidad cita;
	private TipoMultaEntidad tipo;
	private int monto;
	private LocalTime horaGeneracion;
	private LocalDateTime fechaHoraPago;
	private boolean pagada;

	public MultaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCita(new CitaEntidad());
		setTipo(new TipoMultaEntidad());
		setMonto(UtilNumero.CERO);
		setHoraGeneracion(UtilHora.HORA_DEFECTO);
		setFechaHoraPago(UtilFechaHora.FECHA_HORA_DEFECTO);
		setPagada(UtilBooleano.NO);
	}

	public MultaEntidad(UUID id, CitaEntidad cita, TipoMultaEntidad tipo, Integer monto,
			LocalTime horaGeneracion, LocalDateTime fechaHoraPago, Boolean pagada) {
		setId(id);
		setCita(cita);
		setTipo(tipo);
		setMonto(monto);
		setHoraGeneracion(horaGeneracion);
		setFechaHoraPago(fechaHoraPago);
		setPagada(pagada);
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

	public TipoMultaEntidad getTipo() {
		return tipo;
	}

	public void setTipo(TipoMultaEntidad tipo) {
		this.tipo = UtilObjeto.esNulo(tipo) ? new TipoMultaEntidad() : tipo;
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
