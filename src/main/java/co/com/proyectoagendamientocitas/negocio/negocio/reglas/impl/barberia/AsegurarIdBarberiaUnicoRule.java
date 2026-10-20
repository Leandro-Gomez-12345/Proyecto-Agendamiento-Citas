package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class AsegurarIdBarberiaUnicoRule extends ReglaConDAO<BarberiaEntidad> {

	private static final Rule<Object> INSTANCIA = new AsegurarIdBarberiaUnicoRule();

	private AsegurarIdBarberiaUnicoRule() {
		super(BarberiaEntidad.class);
	}

	public static Rule<Object> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	protected void aplicar(final BarberiaEntidad barberia, final DAOFactory daoFactory) {
		do {
			barberia.setId(UtilUUID.generar());
		} while (existeBarberiaConId(barberia.getId(), daoFactory));
	}

	private static boolean existeBarberiaConId(final UUID id, final DAOFactory daoFactory) {
		var existente = daoFactory.obtenerBarberiaDAO().consultarPorId(id);
		return !UtilUUID.obtenerUUIDDefecto().equals(existente.getId());
	}
}
