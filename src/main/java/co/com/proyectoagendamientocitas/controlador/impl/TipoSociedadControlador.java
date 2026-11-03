package co.com.proyectoagendamientocitas.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.proyectoagendamientocitas.controlador.AbstractRestController;
import co.com.proyectoagendamientocitas.controlador.respuesta.RespuestaOk;
import co.com.proyectoagendamientocitas.dto.TipoSociedadDTO;
import co.com.proyectoagendamientocitas.negocio.fachada.impl.TipoSociedadFachadaImpl;

@RestController
@RequestMapping("/api/v1/tipos-sociedad")
public class TipoSociedadControlador extends AbstractRestController {

	@GetMapping
	public ResponseEntity<RespuestaOk<TipoSociedadDTO>> consultarTodosLosTiposSociedad() {
		var tiposSociedad = new TipoSociedadFachadaImpl().consultarTodosLosTiposSociedad();
		return ResponseEntity.ok(RespuestaOk.crear(tiposSociedad));
	}
}
