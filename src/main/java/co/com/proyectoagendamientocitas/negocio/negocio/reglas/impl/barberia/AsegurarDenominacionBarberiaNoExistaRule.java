package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;

public final class AsegurarDenominacionBarberiaNoExistaRule extends ReglaConDAO<BarberiaDominio> {

	private static final Rule<Object> INSTANCIA = new AsegurarDenominacionBarberiaNoExistaRule();

	private AsegurarDenominacionBarberiaNoExistaRule() {
		super(BarberiaDominio.class);
	}

	public static Rule<Object> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	protected void aplicar(final BarberiaDominio barberia, final DAOFactory daoFactory) {
		var filtro = new BarberiaEntidad();
		filtro.setDenominacion(barberia.getDenominacion());

		var coincidencias = daoFactory.obtenerBarberiaDAO().consultarPorFiltro(filtro);

		if (coincidencias.stream().anyMatch(otra -> !otra.getId().equals(barberia.getId()))) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_DENOMINACION_BARBERIA_NO_EXISTA;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
