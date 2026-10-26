package co.com.proyectoagendamientocitas.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.proyectoagendamientocitas.controlador.AbstractRestController;
import co.com.proyectoagendamientocitas.controlador.respuesta.RespuestaOk;
import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.impl.BarberiaFachadaImpl;

@RestController
@RequestMapping("/api/v1/barberias")
public class BarberiaControlador extends AbstractRestController {
	
	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarBarberia(@RequestBody BarberiaDTO datos) {
		new BarberiaFachadaImpl().registrarBarberia(datos);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha regitado la barberia correctamente.");
		return ResponseEntity.ok(respuesta);
	}
}
