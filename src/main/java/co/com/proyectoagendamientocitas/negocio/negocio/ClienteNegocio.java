package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.ClienteDominio;

public interface ClienteNegocio {

	ClienteDominio registrarCliente(ClienteDominio datos);

	ClienteDominio editarContactoCliente(UUID id, ClienteDominio datos);

	ClienteDominio consultarDatosCliente(UUID id);
}
