package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class CitaDominio {

	private final UUID id;
	private final ClienteDominio cliente;
	private final AgendaDominio agenda;
	private final EstadoDominio estado;
	private final LocalTime horaInicio;
	private final LocalTime horaFinEstimada;
	private final int porcentajeDescuento;
	private final int multa;
	private final int tiempoEspera;
	private final int precioTotal;

	private CitaDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
		this.agenda = builder.agenda;
		this.estado = builder.estado;
		this.horaInicio = builder.horaInicio;
		this.horaFinEstimada = builder.horaFinEstimada;
		this.porcentajeDescuento = builder.porcentajeDescuento;
		this.multa = builder.multa;
		this.tiempoEspera = builder.tiempoEspera;
		this.precioTotal = builder.precioTotal;
	}

	public static CitaDominio obtenerValorDefecto(CitaDominio cita) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cita, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public AgendaDominio getAgenda() {
		return agenda;
	}

	public EstadoDominio getEstado() {
		return estado;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFinEstimada() {
		return horaFinEstimada;
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public int getMulta() {
		return multa;
	}

	public int getTiempoEspera() {
		return tiempoEspera;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public static class Builder {

		private UUID id;
		private ClienteDominio cliente;
		private AgendaDominio agenda;
		private EstadoDominio estado;
		private LocalTime horaInicio;
		private LocalTime horaFinEstimada;
		private int porcentajeDescuento;
		private int multa;
		private int tiempoEspera;
		private int precioTotal;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = ClienteDominio.obtenerValorDefecto(null);
			agenda = AgendaDominio.obtenerValorDefecto(null);
			estado = EstadoDominio.obtenerValorDefecto(null);
			horaInicio = UtilHora.HORA_DEFECTO;
			horaFinEstimada = UtilHora.HORA_DEFECTO;
			porcentajeDescuento = UtilNumero.CERO;
			multa = UtilNumero.CERO;
			tiempoEspera = UtilNumero.CERO;
			precioTotal = UtilNumero.CERO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cliente(ClienteDominio cliente) {
			this.cliente = ClienteDominio.obtenerValorDefecto(cliente);
			return this;
		}

		public Builder agenda(AgendaDominio agenda) {
			this.agenda = AgendaDominio.obtenerValorDefecto(agenda);
			return this;
		}

		public Builder estado(EstadoDominio estado) {
			this.estado = EstadoDominio.obtenerValorDefecto(estado);
			return this;
		}

		public Builder horaInicio(LocalTime horaInicio) {
			this.horaInicio = UtilHora.obtenerValorDefecto(horaInicio);
			return this;
		}

		public Builder horaFinEstimada(LocalTime horaFinEstimada) {
			this.horaFinEstimada = UtilHora.obtenerValorDefecto(horaFinEstimada);
			return this;
		}

		public Builder porcentajeDescuento(Integer porcentajeDescuento) {
			this.porcentajeDescuento = UtilNumero.obtenerValorDefecto(porcentajeDescuento, UtilNumero.CERO);
			return this;
		}

		public Builder multa(Integer multa) {
			this.multa = UtilNumero.obtenerValorDefecto(multa, UtilNumero.CERO);
			return this;
		}

		public Builder tiempoEspera(Integer tiempoEspera) {
			this.tiempoEspera = UtilNumero.obtenerValorDefecto(tiempoEspera, UtilNumero.CERO);
			return this;
		}

		public Builder precioTotal(Integer precioTotal) {
			this.precioTotal = UtilNumero.obtenerValorDefecto(precioTotal, UtilNumero.CERO);
			return this;
		}

		public CitaDominio build() {
			return new CitaDominio(this);
		}
	}
}
