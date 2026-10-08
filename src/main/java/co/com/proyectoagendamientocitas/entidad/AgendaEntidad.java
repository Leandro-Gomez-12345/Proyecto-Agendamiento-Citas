package co.com.proyectoagendamientocitas.entidad;

import java.time.LocalDate;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class AgendaEntidad {

	private UUID id;
	private HorarioBarberoEntidad horarioDelBarbero;
	private LocalDate fecha;

	public AgendaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setHorarioDelBarbero(new HorarioBarberoEntidad());
		setFecha(UtilFecha.FECHA_DEFECTO);
	}

	public AgendaEntidad(UUID id, HorarioBarberoEntidad horarioDelBarbero, LocalDate fecha) {
		setId(id);
		setHorarioDelBarbero(horarioDelBarbero);
		setFecha(fecha);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public HorarioBarberoEntidad getHorarioDelBarbero() {
		return horarioDelBarbero;
	}

	public void setHorarioDelBarbero(HorarioBarberoEntidad horarioDelBarbero) {
		this.horarioDelBarbero = UtilObjeto.esNulo(horarioDelBarbero) ? new HorarioBarberoEntidad() : horarioDelBarbero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = UtilFecha.obtenerValorDefecto(fecha);
	}
}
