package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class AsegurarTipoSociedadBarberiaExisteRule extends ReglaConDAO<BarberiaEntidad> {

	private static final Rule<Object> INSTANCIA = new AsegurarTipoSociedadBarberiaExisteRule();

	private AsegurarTipoSociedadBarberiaExisteRule() {
		super(BarberiaEntidad.class);
	}

	public static Rule<Object> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	protected void aplicar(final BarberiaEntidad barberia, final DAOFactory daoFactory) {
		var tipoSociedad = daoFactory.obtenerTipoSociedadDAO().consultarPorId(barberia.getTipoSociedad().getId());

		if (UtilUUID.obtenerUUIDDefecto().equals(tipoSociedad.getId())) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_EXISTE_TIPO_SOCIEDAD_CON_ID;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}

		barberia.setTipoSociedad(tipoSociedad);
	}
}
