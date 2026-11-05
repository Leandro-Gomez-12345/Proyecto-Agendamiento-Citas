package co.com.proyectoagendamientocitas.negocio.negocio.impl;

import java.util.List;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.TipoSociedadDominio;
import co.com.proyectoagendamientocitas.negocio.negocio.TipoSociedadNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl.TipoSociedadEntidadAssembler;

public class TipoSociedadNegocioImpl implements TipoSociedadNegocio {

	private final DAOFactory daoFactory;

	public TipoSociedadNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoSociedadDominio> consultarTodosLosTiposSociedad() {
		var tiposSociedad = daoFactory.obtenerTipoSociedadDAO().consultarTodos();
		return TipoSociedadEntidadAssembler.getInstance().convertirADominio(tiposSociedad);
	}
}
