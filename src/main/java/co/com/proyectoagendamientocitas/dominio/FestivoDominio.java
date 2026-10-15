package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDate;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class FestivoDominio {

	private UUID id;
	private LocalDate fecha;
	private String nombre;

	private FestivoDominio(Builder builder) {
		this.id = builder.id;
		this.fecha = builder.fecha;
		this.nombre = builder.nombre;
	}

	public static FestivoDominio obtenerValorDefecto(FestivoDominio festivo) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(festivo, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public static class Builder {

		private UUID id;
		private LocalDate fecha;
		private String nombre;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			fecha = UtilFecha.FECHA_DEFECTO;
			nombre = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder fecha(LocalDate fecha) {
			this.fecha = UtilFecha.obtenerValorDefecto(fecha);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public FestivoDominio build() {
			return new FestivoDominio(this);
		}
	}
}
