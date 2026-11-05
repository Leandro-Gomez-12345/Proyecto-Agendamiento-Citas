package co.com.proyectoagendamientocitas.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.proyectoagendamientocitas.controlador.AbstractRestController;
import co.com.proyectoagendamientocitas.controlador.respuesta.RespuestaOk;
import co.com.proyectoagendamientocitas.dto.CiudadDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.impl.CiudadFachadaImpl;

@RestController
@RequestMapping("/api/v1/ciudades")
public class CiudadControlador extends AbstractRestController {

	@GetMapping
	public ResponseEntity<RespuestaOk<CiudadDTO>> consultarCiudades() {
		var ciudades = new CiudadFachadaImpl().consultarCiudades();
		return ResponseEntity.ok(RespuestaOk.crear(ciudades));
	}
}
