package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class AsegurarTipoSociedadBarberiaExisteRule implements ReglaConDAO<BarberiaEntidad> {

	private static final ReglaConDAO<BarberiaEntidad> INSTANCIA = new AsegurarTipoSociedadBarberiaExisteRule();

	private AsegurarTipoSociedadBarberiaExisteRule() {

	}

	public static ReglaConDAO<BarberiaEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(BarberiaEntidad barberia, DAOFactory daoFactory) {
		var tipoSociedad = daoFactory.obtenerTipoSociedadDAO().consultarPorId(barberia.getTipoSociedad().getId());

		if (UtilUUID.obtenerUUIDDefecto().equals(tipoSociedad.getId())) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_EXISTE_TIPO_SOCIEDAD_CON_ID;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}

		barberia.setTipoSociedad(tipoSociedad);
	}
}
