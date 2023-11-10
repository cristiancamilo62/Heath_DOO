package co.health.controller.cita;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.health.controller.concrete.response.Respuesta;
import co.health.crosscutting.exception.HealthException;
import co.health.service.dto.CitaDTO;
import co.health.service.facade.concrete.cita.RegistrarCitaFacade;

@RestController
@RequestMapping("/api/v1/cita")
public final class CitaController {
	
	@GetMapping("/dummy")
	public final CitaDTO obtenerDummy() {
		return CitaDTO.crear();
	}
	

	@PostMapping()
	public final ResponseEntity<Respuesta<CitaDTO>> registrar(@RequestBody CitaDTO dto) {
		
		final Respuesta<CitaDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarCitaFacade facade = new RegistrarCitaFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("La cita se ha registrado exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de registrar la cita");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
}
