package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberoServicioDominio;
import co.com.proyectoagendamientocitas.dominio.CitaDominio;

public interface CitaNegocio {

	CitaDominio pedirCita(CitaDominio datos, List<BarberoServicioDominio> servicios);

	CitaDominio reprogramarCita(UUID id, CitaDominio datos);

	CitaDominio cancelarCitaPorCliente(UUID id);

	CitaDominio cancelarCitaPorBarbero(UUID id);

	CitaDominio registrarInasistenciaCliente(UUID id);

	CitaDominio registrarDemoraCliente(UUID id);

	CitaDominio finalizarCita(UUID id);

	CitaDominio registrarNoPagoCita(UUID id);

	CitaDominio registrarTardanzaCliente(UUID id);
}
