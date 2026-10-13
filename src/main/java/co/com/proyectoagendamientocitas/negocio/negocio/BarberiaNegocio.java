package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;

public interface BarberiaNegocio {

	BarberiaDominio registrarBarberia(BarberiaDominio datos);

	String consultarNombreBarberia(UUID id);

	BarberiaDominio consultarRazonSocialYNitBarberia(UUID id);

	BarberiaDominio cambiarNombreBarberia(UUID id, BarberiaDominio datos);

	BarberiaDominio cambiarRazonSocialBarberia(UUID id, BarberiaDominio datos);

	BarberiaDominio cambiarNitBarberia(UUID id, BarberiaDominio datos);

	void darDeBajaBarberia(UUID id);
}
