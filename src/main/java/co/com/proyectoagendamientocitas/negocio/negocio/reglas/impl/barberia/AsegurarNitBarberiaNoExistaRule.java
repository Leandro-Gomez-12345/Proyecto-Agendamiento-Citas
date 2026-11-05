package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;

public class AsegurarNitBarberiaNoExistaRule implements ReglaConDAO<BarberiaEntidad> {

	private static final ReglaConDAO<BarberiaEntidad> INSTANCIA = new AsegurarNitBarberiaNoExistaRule();

	private AsegurarNitBarberiaNoExistaRule() {

	}

	public static ReglaConDAO<BarberiaEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(BarberiaEntidad barberia, DAOFactory daoFactory) {
		var filtro = new BarberiaEntidad();
		filtro.setNit(barberia.getNit());

		var coincidencias = daoFactory.obtenerBarberiaDAO().consultarPorFiltro(filtro);

		if (!coincidencias.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_NIT_BARBERIA_NO_EXISTA;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
