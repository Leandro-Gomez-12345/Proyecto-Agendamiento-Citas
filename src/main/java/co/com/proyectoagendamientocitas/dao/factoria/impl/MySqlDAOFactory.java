package co.com.proyectoagendamientocitas.dao.factoria.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.proyectoagendamientocitas.dao.factoria.DAOFactory;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasDatosExcepcion;

public class MySqlDAOFactory extends DAOFactory {

	private static final String URL = System.getenv().getOrDefault("AGENDAMIENTOCITAS_MYSQL_URL",
			"jdbc:mysql://localhost:3306/agendamientocitas");
	private static final String USUARIO = System.getenv().getOrDefault("AGENDAMIENTOCITAS_MYSQL_USUARIO", "root");
	private static final String CONTRASENA = System.getenv().getOrDefault("AGENDAMIENTOCITAS_MYSQL_CONTRASENA", "");

	@Override
	protected void abrirConexion() {
		try {
			setConexion(DriverManager.getConnection(URL, USUARIO, CONTRASENA));
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_ABRIENDO_CONEXION;
			throw AgendamientoCitasDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
}
