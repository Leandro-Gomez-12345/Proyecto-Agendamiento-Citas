package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dominio.PeriodoCierreDominio;
import co.com.proyectoagendamientocitas.dominio.SedeDominio;

public interface PeriodoCierreNegocio {

	List<PeriodoCierreDominio> definirPeriodoCierreTodasLasSedes(PeriodoCierreDominio datos);

	PeriodoCierreDominio definirPeriodoCierreSede(PeriodoCierreDominio datos);

	List<PeriodoCierreDominio> cambiarPeriodoCierreTodasLasSedes(PeriodoCierreDominio filtro, PeriodoCierreDominio datos);

	PeriodoCierreDominio cambiarPeriodoCierreSede(UUID id, PeriodoCierreDominio datos);

	List<PeriodoCierreDominio> consultarPeriodosCierreSede(SedeDominio filtro);

	List<PeriodoCierreDominio> consultarPeriodosCierreTodasLasSedes(BarberiaDominio filtro);

	List<PeriodoCierreDominio> consultarPeriodosCierrePorSedeYRango(PeriodoCierreDominio filtro);

	void eliminarPeriodoCierreTodasLasSedes(PeriodoCierreDominio filtro);

	void eliminarPeriodoCierreSede(UUID id);
}
