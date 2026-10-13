package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dominio.HorarioSedeDominio;
import co.com.proyectoagendamientocitas.dominio.SedeDominio;

public interface HorarioSedeNegocio {

	List<HorarioSedeDominio> definirHorarioTodasLasSedes(HorarioSedeDominio datos);

	HorarioSedeDominio definirHorarioSede(HorarioSedeDominio datos);

	List<HorarioSedeDominio> cambiarHorasHorarioTodasLasSedes(HorarioSedeDominio filtro, HorarioSedeDominio datos);

	HorarioSedeDominio cambiarHorasHorarioSede(UUID id, HorarioSedeDominio datos);

	List<HorarioSedeDominio> consultarHorariosSede(SedeDominio filtro);

	List<HorarioSedeDominio> consultarHorariosTodasLasSedes(BarberiaDominio filtro);

	void desactivarHorarioTodasLasSedes(HorarioSedeDominio filtro);

	void desactivarHorarioSede(UUID id);
}
