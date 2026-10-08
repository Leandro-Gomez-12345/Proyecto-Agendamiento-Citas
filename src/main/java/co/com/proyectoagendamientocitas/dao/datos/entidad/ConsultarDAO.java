package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.List;

public interface ConsultarDAO<E, ID> {
	
	E consultarPorId(ID id);
	
	List<E> consultarPorFiltro(E filtro);
	
	List<E> consultarTodos();
}
