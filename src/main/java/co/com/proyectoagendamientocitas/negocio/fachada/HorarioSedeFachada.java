package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.dto.HorarioSedeDTO;
import co.com.proyectoagendamientocitas.dto.SedeDTO;

public interface HorarioSedeFachada {

	List<HorarioSedeDTO> definirHorarioTodasLasSedes(HorarioSedeDTO datos);

	HorarioSedeDTO definirHorarioSede(HorarioSedeDTO datos);

	List<HorarioSedeDTO> cambiarHorasHorarioTodasLasSedes(HorarioSedeDTO filtro, HorarioSedeDTO datos);

	HorarioSedeDTO cambiarHorasHorarioSede(UUID id, HorarioSedeDTO datos);

	List<HorarioSedeDTO> consultarHorariosSede(SedeDTO filtro);

	List<HorarioSedeDTO> consultarHorariosTodasLasSedes(BarberiaDTO filtro);

	void desactivarHorarioTodasLasSedes(HorarioSedeDTO filtro);

	void desactivarHorarioSede(UUID id);
}
