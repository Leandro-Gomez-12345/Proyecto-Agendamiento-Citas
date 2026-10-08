package co.com.proyectoagendamientocitas.dao.datos.entidad;

public interface ActualizarDAO<E, ID> {
	
	void actualizar(ID id, E entidad);
}
