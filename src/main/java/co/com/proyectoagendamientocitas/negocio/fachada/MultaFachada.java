package co.com.proyectoagendamientocitas.negocio.fachada;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.dto.BarberoDTO;
import co.com.proyectoagendamientocitas.dto.MultaDTO;

public interface MultaFachada {

	MultaDTO imponerMultaCliente(MultaDTO datos);

	List<MultaDTO> consultarMultasDeCliente(MultaDTO filtro);

	List<MultaDTO> consultarMultasSinPagarClienteEnBarberia(MultaDTO filtro, BarberiaDTO barberia);

	List<MultaDTO> consultarMultasClienteDeBarbero(MultaDTO filtro, BarberoDTO barbero);

	MultaDTO registrarPagoMulta(UUID id, LocalDateTime fechaHoraPago);

	void eliminarMulta(UUID id);
}
