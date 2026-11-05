package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class AsegurarCiudadSedeExisteRule implements ReglaConDAO<SedeEntidad> {

	private static final ReglaConDAO<SedeEntidad> INSTANCIA = new AsegurarCiudadSedeExisteRule();

	private AsegurarCiudadSedeExisteRule() {

	}

	public static ReglaConDAO<SedeEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(SedeEntidad sede, DAOFactory daoFactory) {
		var ciudad = daoFactory.obtenerCiudadDAO().consultarPorId(sede.getCiudad().getId());

		if (UtilUUID.obtenerUUIDDefecto().equals(ciudad.getId())) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_EXISTE_CIUDAD_CON_ID;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
