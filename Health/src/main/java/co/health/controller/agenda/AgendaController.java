package co.health.controller.agenda;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.health.controller.concrete.response.Respuesta;
import co.health.crosscutting.exception.HealthException;
import co.health.service.dto.AgendaDTO;
import co.health.service.facade.concrete.agenda.RegistrarAgendaFacade;

@RestController
@RequestMapping("/api/v1/agenda")
public final class AgendaController {
	
	@GetMapping("/dummy")
	public final AgendaDTO obtenerDummy() {
		return AgendaDTO.crear();
	}
	
	@PostMapping()
	public final ResponseEntity<Respuesta<AgendaDTO>> registrar(@RequestBody AgendaDTO dto) {
		
		final Respuesta<AgendaDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarAgendaFacade facade = new RegistrarAgendaFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("se ha registrado la cita en la agenda exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de resgistrar la cita en la agenda");
			excepcion.printStackTrace();
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	

}
