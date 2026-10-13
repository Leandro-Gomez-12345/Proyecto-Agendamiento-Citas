package co.com.proyectoagendamientocitas.negocio.negocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.MultaDominio;

public interface MultaNegocio {

	MultaDominio imponerMultaCliente(MultaDominio datos);

	List<MultaDominio> consultarMultasDeCliente(MultaDominio filtro);

	MultaDominio registrarPagoMulta(UUID id, LocalDateTime fechaHoraPago);
}
