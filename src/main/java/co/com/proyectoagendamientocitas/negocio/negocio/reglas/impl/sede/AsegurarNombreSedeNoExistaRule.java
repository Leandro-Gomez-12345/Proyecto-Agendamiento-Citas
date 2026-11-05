package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.ReglaConDAO;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;

public class AsegurarNombreSedeNoExistaRule implements ReglaConDAO<SedeEntidad> {

	private static final ReglaConDAO<SedeEntidad> INSTANCIA = new AsegurarNombreSedeNoExistaRule();

	private AsegurarNombreSedeNoExistaRule() {

	}

	public static ReglaConDAO<SedeEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(SedeEntidad sede, DAOFactory daoFactory) {
		var filtro = new SedeEntidad();
		filtro.setBarberia(sede.getBarberia());
		filtro.setNombre(sede.getNombre());

		var coincidencias = daoFactory.obtenerSedeDAO().consultarPorFiltro(filtro);

		if (coincidencias.stream().anyMatch(otra -> !otra.getId().equals(sede.getId()))) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_NOMBRE_SEDE_NO_EXISTA_EN_BARBERIA;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
