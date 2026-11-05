package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class AsegurarIdSedeUnicoRule implements ReglaConDAO<SedeEntidad> {

	private static final ReglaConDAO<SedeEntidad> INSTANCIA = new AsegurarIdSedeUnicoRule();

	private AsegurarIdSedeUnicoRule() {

	}

	public static ReglaConDAO<SedeEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(SedeEntidad sede, DAOFactory daoFactory) {
		do {
			sede.setId(UtilUUID.generar());
		} while (existeSedeConId(sede.getId(), daoFactory));
	}

	private static boolean existeSedeConId(UUID id, DAOFactory daoFactory) {
		var existente = daoFactory.obtenerSedeDAO().consultarPorId(id);
		return !UtilUUID.obtenerUUIDDefecto().equals(existente.getId());
	}
}
