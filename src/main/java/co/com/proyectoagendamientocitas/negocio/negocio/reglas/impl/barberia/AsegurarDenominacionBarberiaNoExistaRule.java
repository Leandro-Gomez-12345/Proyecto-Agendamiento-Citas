package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;

public class AsegurarDenominacionBarberiaNoExistaRule implements ReglaConDAO<BarberiaEntidad> {

	private static final ReglaConDAO<BarberiaEntidad> INSTANCIA = new AsegurarDenominacionBarberiaNoExistaRule();

	private AsegurarDenominacionBarberiaNoExistaRule() {

	}

	public static ReglaConDAO<BarberiaEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(BarberiaEntidad barberia, DAOFactory daoFactory) {
		var filtro = new BarberiaEntidad();
		filtro.setDenominacion(barberia.getDenominacion());

		var coincidencias = daoFactory.obtenerBarberiaDAO().consultarPorFiltro(filtro);

		if (coincidencias.stream().anyMatch(otra -> !otra.getId().equals(barberia.getId()))) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_DENOMINACION_BARBERIA_NO_EXISTA;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
