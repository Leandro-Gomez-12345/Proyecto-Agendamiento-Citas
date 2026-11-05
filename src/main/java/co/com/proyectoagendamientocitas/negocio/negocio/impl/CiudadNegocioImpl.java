package co.com.proyectoagendamientocitas.negocio.negocio.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.dominio.CiudadDominio;
import co.com.proyectoagendamientocitas.entidad.DepartamentoEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.CiudadNegocio;
import co.com.proyectoagendamientocitas.negocio.negocio.assembler.impl.CiudadEntidadAssembler;

public class CiudadNegocioImpl implements CiudadNegocio {

	private final DAOFactory daoFactory;

	public CiudadNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<CiudadDominio> consultarCiudades() {
		var departamentos = daoFactory.obtenerDepartamentoDAO().consultarTodos().stream()
				.collect(Collectors.toMap(DepartamentoEntidad::getId, Function.identity()));
		var ciudades = daoFactory.obtenerCiudadDAO().consultarTodos();

		ciudades.forEach(ciudad -> ciudad.setDepartamento(
				departamentos.getOrDefault(ciudad.getDepartamento().getId(), ciudad.getDepartamento())));

		return CiudadEntidadAssembler.getInstance().convertirADominio(ciudades);
	}
}
