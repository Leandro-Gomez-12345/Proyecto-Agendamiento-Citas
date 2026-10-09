package co.com.proyectoagendamientocitas.dao.datos;

public interface ActualizarDAO<E, I> {

	void actualizar(I id, E entidad);
}
