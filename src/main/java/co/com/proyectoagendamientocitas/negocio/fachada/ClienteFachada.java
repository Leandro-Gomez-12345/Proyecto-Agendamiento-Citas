package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.ClienteDTO;

public interface ClienteFachada {

	ClienteDTO registrarCliente(ClienteDTO datos);

	ClienteDTO editarContactoCliente(UUID id, ClienteDTO datos);

	ClienteDTO consultarDatosCliente(UUID id);
}
