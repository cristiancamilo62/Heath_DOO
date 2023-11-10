package co.health.controller.tipoidentificacion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.health.controller.concrete.response.Respuesta;
import co.health.crosscutting.exception.HealthException;
import co.health.service.dto.TipoIdentificacionDTO;
import co.health.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionController {
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDummy() {
		return TipoIdentificacionDTO.crear();
	}
	
	@PostMapping()
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación se ha registrado exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de registrar el tipo de identificacion");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	

}
