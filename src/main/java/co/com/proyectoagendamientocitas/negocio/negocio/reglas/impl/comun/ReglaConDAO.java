package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;

public abstract class ReglaConDAO<D> implements Rule<Object> {

	private final Class<D> tipoDato;

	protected ReglaConDAO(final Class<D> tipoDato) {
		this.tipoDato = tipoDato;
	}

	@Override
	public final void ejecutar(final Object... datos) {
		aplicar(tipoDato.cast(datos[0]), (DAOFactory) datos[1]);
	}

	protected abstract void aplicar(D dato, DAOFactory daoFactory);
}
