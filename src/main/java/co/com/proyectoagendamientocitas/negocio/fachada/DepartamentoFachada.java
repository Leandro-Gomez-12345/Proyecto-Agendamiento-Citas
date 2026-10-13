package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;

import co.com.proyectoagendamientocitas.dto.DepartamentoDTO;

public interface DepartamentoFachada {

	List<DepartamentoDTO> consultarDepartamentos();
}
