package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class AsegurarBarberiaSedeExisteRule implements ReglaConDAO<SedeEntidad> {

	private static final ReglaConDAO<SedeEntidad> INSTANCIA = new AsegurarBarberiaSedeExisteRule();

	private AsegurarBarberiaSedeExisteRule() {

	}

	public static ReglaConDAO<SedeEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(SedeEntidad sede, DAOFactory daoFactory) {
		var barberia = daoFactory.obtenerBarberiaDAO().consultarPorId(sede.getBarberia().getId());

		if (UtilUUID.obtenerUUIDDefecto().equals(barberia.getId())) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_EXISTE_BARBERIA_CON_ID;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
