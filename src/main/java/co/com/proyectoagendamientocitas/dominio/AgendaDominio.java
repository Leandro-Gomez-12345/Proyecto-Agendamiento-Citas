package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDate;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class AgendaDominio {

	private final UUID id;
	private final HorarioBarberoDominio horarioDelBarbero;
	private final LocalDate fecha;

	private AgendaDominio(Builder builder) {
		this.id = builder.id;
		this.horarioDelBarbero = builder.horarioDelBarbero;
		this.fecha = builder.fecha;
	}

	public static AgendaDominio obtenerValorDefecto(AgendaDominio agenda) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(agenda, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public HorarioBarberoDominio getHorarioDelBarbero() {
		return horarioDelBarbero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public static class Builder {

		private UUID id;
		private HorarioBarberoDominio horarioDelBarbero;
		private LocalDate fecha;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			horarioDelBarbero = HorarioBarberoDominio.obtenerValorDefecto(null);
			fecha = UtilFecha.FECHA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder horarioDelBarbero(HorarioBarberoDominio horarioDelBarbero) {
			this.horarioDelBarbero = HorarioBarberoDominio.obtenerValorDefecto(horarioDelBarbero);
			return this;
		}

		public Builder fecha(LocalDate fecha) {
			this.fecha = UtilFecha.obtenerValorDefecto(fecha);
			return this;
		}

		public AgendaDominio build() {
			return new AgendaDominio(this);
		}
	}
}
