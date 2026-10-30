package co.com.proyectoagendamientocitas.negocio.negocio.reglas;

public interface Rule<O> {
	
	@SuppressWarnings("unchecked")
	void ejecutar(O... datos);
}
