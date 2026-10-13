package co.com.proyectoagendamientocitas.negocio.negocio.assembler;

import java.util.List;

public interface EntidadAssembler<D, E> {

	E convertirAEntidad(D dominio);

	D convertirADominio(E entidad);

	default List<E> convertirAEntidad(List<D> dominios) {
		return dominios.stream().map(this::convertirAEntidad).toList();
	}

	default List<D> convertirADominio(List<E> entidades) {
		return entidades.stream().map(this::convertirADominio).toList();
	}
}
