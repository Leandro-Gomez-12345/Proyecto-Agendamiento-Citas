package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class MultaDominio {

	private UUID id;
	private CitaDominio cita;
	private TipoMultaDominio tipo;
	private int monto;
	private LocalTime horaGeneracion;
	private LocalDateTime fechaHoraPago;
	private boolean pagada;

	private MultaDominio(Builder builder) {
		this.id = builder.id;
		this.cita = builder.cita;
		this.tipo = builder.tipo;
		this.monto = builder.monto;
		this.horaGeneracion = builder.horaGeneracion;
		this.fechaHoraPago = builder.fechaHoraPago;
		this.pagada = builder.pagada;
	}

	public UUID getId() {
		return id;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public TipoMultaDominio getTipo() {
		return tipo;
	}

	public int getMonto() {
		return monto;
	}

	public LocalTime getHoraGeneracion() {
		return horaGeneracion;
	}

	public LocalDateTime getFechaHoraPago() {
		return fechaHoraPago;
	}

	public boolean isPagada() {
		return pagada;
	}

	public static class Builder {

		private UUID id;
		private CitaDominio cita;
		private TipoMultaDominio tipo;
		private int monto;
		private LocalTime horaGeneracion;
		private LocalDateTime fechaHoraPago;
		private boolean pagada;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cita = CitaDominio.obtenerValorDefecto(null);
			tipo = TipoMultaDominio.obtenerValorDefecto(null);
			monto = UtilNumero.CERO;
			horaGeneracion = UtilHora.HORA_DEFECTO;
			fechaHoraPago = UtilFechaHora.FECHA_HORA_DEFECTO;
			pagada = UtilBooleano.NO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cita(CitaDominio cita) {
			this.cita = CitaDominio.obtenerValorDefecto(cita);
			return this;
		}

		public Builder tipo(TipoMultaDominio tipo) {
			this.tipo = TipoMultaDominio.obtenerValorDefecto(tipo);
			return this;
		}

		public Builder monto(Integer monto) {
			this.monto = UtilNumero.obtenerValorDefecto(monto, UtilNumero.CERO);
			return this;
		}

		public Builder horaGeneracion(LocalTime horaGeneracion) {
			this.horaGeneracion = UtilHora.obtenerValorDefecto(horaGeneracion);
			return this;
		}

		public Builder fechaHoraPago(LocalDateTime fechaHoraPago) {
			this.fechaHoraPago = UtilFechaHora.obtenerValorDefecto(fechaHoraPago);
			return this;
		}

		public Builder pagada(Boolean pagada) {
			this.pagada = UtilBooleano.obtenerValorDefecto(pagada, UtilBooleano.NO);
			return this;
		}

		public MultaDominio build() {
			return new MultaDominio(this);
		}
	}
}
