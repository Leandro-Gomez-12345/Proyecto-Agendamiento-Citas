package co.com.proyectoagendamientocitas.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class AgendaDTO {

	private UUID id;
	private HorarioBarberoDTO horarioDelBarbero;
	private LocalDate fecha;

	public AgendaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setHorarioDelBarbero(new HorarioBarberoDTO());
		setFecha(UtilFecha.FECHA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public HorarioBarberoDTO getHorarioDelBarbero() {
		return horarioDelBarbero;
	}

	public void setHorarioDelBarbero(HorarioBarberoDTO horarioDelBarbero) {
		this.horarioDelBarbero = UtilObjeto.esNulo(horarioDelBarbero) ? new HorarioBarberoDTO() : horarioDelBarbero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = UtilFecha.obtenerValorDefecto(fecha);
	}
}
