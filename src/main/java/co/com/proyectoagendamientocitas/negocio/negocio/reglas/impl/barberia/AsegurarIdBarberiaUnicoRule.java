package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class AsegurarIdBarberiaUnicoRule implements ReglaConDAO<BarberiaEntidad> {

	private static final ReglaConDAO<BarberiaEntidad> INSTANCIA = new AsegurarIdBarberiaUnicoRule();

	private AsegurarIdBarberiaUnicoRule() {

	}

	public static ReglaConDAO<BarberiaEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final BarberiaEntidad barberia, final DAOFactory daoFactory) {
		do {
			barberia.setId(UtilUUID.generar());
		} while (existeBarberiaConId(barberia.getId(), daoFactory));
	}

	private static boolean existeBarberiaConId(final UUID id, final DAOFactory daoFactory) {
		var existente = daoFactory.obtenerBarberiaDAO().consultarPorId(id);
		return !UtilUUID.obtenerUUIDDefecto().equals(existente.getId());
	}
}
