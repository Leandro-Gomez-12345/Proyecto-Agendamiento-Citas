package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberoServicioDTO;
import co.com.proyectoagendamientocitas.dto.CitaDTO;

public interface CitaFachada {

	CitaDTO pedirCita(CitaDTO datos, List<BarberoServicioDTO> servicios);

	CitaDTO reprogramarCita(UUID id, CitaDTO datos);

	CitaDTO cancelarCitaPorCliente(UUID id);

	CitaDTO cancelarCitaPorBarbero(UUID id);

	CitaDTO registrarInasistenciaCliente(UUID id);

	CitaDTO registrarDemoraCliente(UUID id);

	CitaDTO finalizarCita(UUID id);

	CitaDTO registrarNoPagoCita(UUID id);

	CitaDTO registrarTardanzaCliente(UUID id);
}
