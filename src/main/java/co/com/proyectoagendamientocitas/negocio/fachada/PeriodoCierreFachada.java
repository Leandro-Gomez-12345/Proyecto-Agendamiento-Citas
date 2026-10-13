package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.dto.PeriodoCierreDTO;
import co.com.proyectoagendamientocitas.dto.SedeDTO;

public interface PeriodoCierreFachada {

	List<PeriodoCierreDTO> definirPeriodoCierreTodasLasSedes(PeriodoCierreDTO datos);

	PeriodoCierreDTO definirPeriodoCierreSede(PeriodoCierreDTO datos);

	List<PeriodoCierreDTO> cambiarPeriodoCierreTodasLasSedes(PeriodoCierreDTO filtro, PeriodoCierreDTO datos);

	PeriodoCierreDTO cambiarPeriodoCierreSede(UUID id, PeriodoCierreDTO datos);

	List<PeriodoCierreDTO> consultarPeriodosCierreSede(SedeDTO filtro);

	List<PeriodoCierreDTO> consultarPeriodosCierreTodasLasSedes(BarberiaDTO filtro);

	List<PeriodoCierreDTO> consultarPeriodosCierrePorSedeYRango(PeriodoCierreDTO filtro);

	void eliminarPeriodoCierreTodasLasSedes(PeriodoCierreDTO filtro);

	void eliminarPeriodoCierreSede(UUID id);
}
