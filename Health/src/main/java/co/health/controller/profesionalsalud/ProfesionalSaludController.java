package co.health.controller.profesionalsalud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.health.controller.concrete.response.Respuesta;
import co.health.crosscutting.exception.HealthException;
import co.health.data.entity.ProfesionalSaludEntity;
import co.health.service.dto.ProfesionalSaludDTO;
import co.health.service.facade.concrete.profesionalsalud.ConsultarProfesionalSaludFacade;

@RestController
@RequestMapping("/api/v1/profesional")
public final class ProfesionalSaludController {

	
	@GetMapping("/dummy")
	public final ProfesionalSaludDTO obtenerDummy() {
		return ProfesionalSaludDTO.crear();
	}
	
	@PostMapping("/consultar")
	public final ResponseEntity<Respuesta<ProfesionalSaludEntity>> consultarLo(@RequestBody ProfesionalSaludDTO dto) {
		
		final Respuesta<ProfesionalSaludEntity> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		
		try {
			ConsultarProfesionalSaludFacade facade = new ConsultarProfesionalSaludFacade();
			
			respuesta.setDatos(facade.executeRetorno(dto));
			respuesta.getDatos();
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El Paciente esta registrado ");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de consultar el Paciente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	

}
