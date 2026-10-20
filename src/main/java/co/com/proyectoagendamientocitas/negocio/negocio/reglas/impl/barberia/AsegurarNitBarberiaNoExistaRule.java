package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;

public final class AsegurarNitBarberiaNoExistaRule extends ReglaConDAO<BarberiaDominio> {

	private static final Rule<Object> INSTANCIA = new AsegurarNitBarberiaNoExistaRule();

	private AsegurarNitBarberiaNoExistaRule() {
		super(BarberiaDominio.class);
	}

	public static Rule<Object> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	protected void aplicar(final BarberiaDominio barberia, final DAOFactory daoFactory) {
		var filtro = new BarberiaEntidad();
		filtro.setNit(barberia.getNit());

		var coincidencias = daoFactory.obtenerBarberiaDAO().consultarPorFiltro(filtro);

		if (coincidencias.stream().anyMatch(otra -> !otra.getId().equals(barberia.getId()))) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_NIT_BARBERIA_NO_EXISTA;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
