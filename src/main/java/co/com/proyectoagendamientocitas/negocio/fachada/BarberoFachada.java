package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberoDTO;
import co.com.proyectoagendamientocitas.dto.ServicioDTO;

public interface BarberoFachada {

	BarberoDTO registrarBarbero(BarberoDTO datos);

	BarberoDTO editarContactoBarbero(UUID id, BarberoDTO datos);

	BarberoDTO consultarDatosBarbero(UUID id);

	void desactivarBarbero(UUID id);

	void reactivarBarbero(UUID id);

	BarberoDTO cambiarSedeDeTrabajoBarbero(UUID id, BarberoDTO datos);

	List<ServicioDTO> consultarServiciosSedeBarbero(UUID id);

	void eliminarBarbero(UUID id);
}
