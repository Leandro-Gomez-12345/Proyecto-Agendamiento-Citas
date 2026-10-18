package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface MapeadorFila<E> {

	E mapear(ResultSet resultados) throws SQLException;
}
