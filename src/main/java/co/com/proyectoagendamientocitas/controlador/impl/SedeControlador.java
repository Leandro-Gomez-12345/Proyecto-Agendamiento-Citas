package co.com.proyectoagendamientocitas.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.proyectoagendamientocitas.controlador.AbstractRestController;
import co.com.proyectoagendamientocitas.controlador.respuesta.RespuestaOk;
import co.com.proyectoagendamientocitas.dto.SedeDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.impl.SedeFachadaImpl;

@RestController
@RequestMapping("/api/v1/sedes")
public class SedeControlador extends AbstractRestController {

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarSede(@RequestBody SedeDTO datos) {
		new SedeFachadaImpl().registrarSede(datos);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha registrado la sede correctamente.");
		return ResponseEntity.ok(respuesta);
	}
}
