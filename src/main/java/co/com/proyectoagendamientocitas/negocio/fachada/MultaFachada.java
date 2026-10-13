package co.com.proyectoagendamientocitas.negocio.fachada;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.MultaDTO;

public interface MultaFachada {

	MultaDTO imponerMultaCliente(MultaDTO datos);

	List<MultaDTO> consultarMultasDeCliente(MultaDTO filtro);

	MultaDTO registrarPagoMulta(UUID id, LocalDateTime fechaHoraPago);
}
