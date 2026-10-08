package co.com.proyectoagendamientocitas.dto;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class PrefijoCelularDTO {

	private static final String PREFIJO_DEFECTO = "+0";

	private UUID id;
	private String prefijo;

	public PrefijoCelularDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPrefijo(PREFIJO_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = UtilTexto.quitarEspaciosEnBlanco(UtilTexto.obtenerValorDefecto(prefijo, PREFIJO_DEFECTO));
	}
}
