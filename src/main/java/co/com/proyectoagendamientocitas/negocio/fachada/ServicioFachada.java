package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.dto.SedeDTO;
import co.com.proyectoagendamientocitas.dto.ServicioDTO;

public interface ServicioFachada {

	List<ServicioDTO> definirServicioTodasLasSedes(ServicioDTO datos);

	ServicioDTO definirServicioSede(ServicioDTO datos);

	List<ServicioDTO> editarServicioTodasLasSedes(ServicioDTO filtro, ServicioDTO datos);

	ServicioDTO editarServicioSede(UUID id, ServicioDTO datos);

	List<ServicioDTO> consultarServiciosSede(SedeDTO filtro);

	List<ServicioDTO> consultarServiciosTodasLasSedes(BarberiaDTO filtro);

	void retirarServicioTodasLasSedes(ServicioDTO filtro);

	void retirarServicioSede(UUID id);

	void reactivarServicioTodasLasSedes(ServicioDTO filtro);

	void reactivarServicioSede(UUID id);

	List<ServicioDTO> consultarServiciosNoDisponiblesSede(SedeDTO filtro);
}
