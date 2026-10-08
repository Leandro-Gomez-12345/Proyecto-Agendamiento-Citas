package co.com.proyectoagendamientocitas.dto;

import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class CitaDTO {

	private UUID id;
	private ClienteDTO cliente;
	private AgendaDTO agenda;
	private EstadoDTO estado;
	private LocalTime horaInicio;
	private LocalTime horaFinEstimada;
	private int porcentajeDescuento;
	private int multa;
	private int tiempoEspera;
	private int precioTotal;

	public CitaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
		setAgenda(new AgendaDTO());
		setEstado(new EstadoDTO());
		setHoraInicio(UtilHora.HORA_DEFECTO);
		setHoraFinEstimada(UtilHora.HORA_DEFECTO);
		setPorcentajeDescuento(UtilNumero.CERO);
		setMulta(UtilNumero.CERO);
		setTiempoEspera(UtilNumero.CERO);
		setPrecioTotal(UtilNumero.CERO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = UtilObjeto.esNulo(cliente) ? new ClienteDTO() : cliente;
	}

	public AgendaDTO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDTO agenda) {
		this.agenda = UtilObjeto.esNulo(agenda) ? new AgendaDTO() : agenda;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = UtilObjeto.esNulo(estado) ? new EstadoDTO() : estado;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilHora.obtenerValorDefecto(horaInicio);
	}

	public LocalTime getHoraFinEstimada() {
		return horaFinEstimada;
	}

	public void setHoraFinEstimada(LocalTime horaFinEstimada) {
		this.horaFinEstimada = UtilHora.obtenerValorDefecto(horaFinEstimada);
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Integer porcentajeDescuento) {
		this.porcentajeDescuento = UtilNumero.obtenerValorDefecto(porcentajeDescuento, UtilNumero.CERO);
	}

	public int getMulta() {
		return multa;
	}

	public void setMulta(Integer multa) {
		this.multa = UtilNumero.obtenerValorDefecto(multa, UtilNumero.CERO);
	}

	public int getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(Integer tiempoEspera) {
		this.tiempoEspera = UtilNumero.obtenerValorDefecto(tiempoEspera, UtilNumero.CERO);
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = UtilNumero.obtenerValorDefecto(precioTotal, UtilNumero.CERO);
	}
}
