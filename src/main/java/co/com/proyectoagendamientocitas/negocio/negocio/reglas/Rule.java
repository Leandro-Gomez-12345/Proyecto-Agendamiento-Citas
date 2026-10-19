package co.com.proyectoagendamientocitas.negocio.negocio.reglas;

public interface Rule<O> {

	void ejecutar(O... datos);
}
