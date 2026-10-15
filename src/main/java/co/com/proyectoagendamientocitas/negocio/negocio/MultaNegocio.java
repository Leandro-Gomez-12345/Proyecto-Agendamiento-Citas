package co.com.proyectoagendamientocitas.negocio.negocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dominio.BarberoDominio;
import co.com.proyectoagendamientocitas.dominio.MultaDominio;

public interface MultaNegocio {

	MultaDominio imponerMultaCliente(MultaDominio datos);

	List<MultaDominio> consultarMultasDeCliente(MultaDominio filtro);

	List<MultaDominio> consultarMultasSinPagarClienteEnBarberia(MultaDominio filtro, BarberiaDominio barberia);

	List<MultaDominio> consultarMultasClienteDeBarbero(MultaDominio filtro, BarberoDominio barbero);

	MultaDominio registrarPagoMulta(UUID id, LocalDateTime fechaHoraPago);

	void eliminarMulta(UUID id);
}
