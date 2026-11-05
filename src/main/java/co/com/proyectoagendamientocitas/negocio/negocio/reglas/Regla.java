package co.com.proyectoagendamientocitas.negocio.negocio.reglas;

public interface Regla<O> {
	
	@SuppressWarnings("unchecked")
	void ejecutar(O... datos);
}
