package co.com.proyectoagendamientocitas.entidad;

import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class CitaEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private AgendaEntidad agenda;
	private EstadoEntidad estado;
	private LocalTime horaInicio;
	private LocalTime horaFinEstimada;
	private int porcentajeDescuento;
	private int multa;
	private int tiempoEspera;
	private int precioTotal;

	public CitaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setAgenda(new AgendaEntidad());
		setEstado(new EstadoEntidad());
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

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntidad cliente) {
		this.cliente = UtilObjeto.esNulo(cliente) ? new ClienteEntidad() : cliente;
	}

	public AgendaEntidad getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaEntidad agenda) {
		this.agenda = UtilObjeto.esNulo(agenda) ? new AgendaEntidad() : agenda;
	}

	public EstadoEntidad getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntidad estado) {
		this.estado = UtilObjeto.esNulo(estado) ? new EstadoEntidad() : estado;
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
