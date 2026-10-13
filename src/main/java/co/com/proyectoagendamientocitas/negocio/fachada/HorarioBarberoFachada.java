package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.HorarioBarberoDTO;

public interface HorarioBarberoFachada {

	HorarioBarberoDTO definirHorarioDeTrabajo(HorarioBarberoDTO datos);

	List<HorarioBarberoDTO> consultarHorariosDefinidos(HorarioBarberoDTO filtro);

	void desactivarHorarioDeTrabajo(UUID id);

	List<HorarioBarberoDTO> consultarHorariosDeTrabajoDeBarbero(HorarioBarberoDTO filtro);
}
