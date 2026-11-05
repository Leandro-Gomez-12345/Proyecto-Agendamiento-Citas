package co.com.proyectoagendamientocitas.negocio.negocio.reglas;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;

public interface ReglaConDAO<D> {

	void ejecutar(D dato, DAOFactory daoFactory);
}
