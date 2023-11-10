package co.health.controller.paciente;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.health.controller.concrete.response.Respuesta;
import co.health.crosscutting.exception.HealthException;
import co.health.data.entity.PacienteEntity;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.concrete.paciente.ConsultarPacienteFacade;
import co.health.service.facade.concrete.paciente.EliminarPacienteFacade;
import co.health.service.facade.concrete.paciente.ModificarPacienteFacade;
import co.health.service.facade.concrete.paciente.RegistrarPacienteFacade;
import co.health.service.mapper.dto.concrete.PacienteDTOMapper;

@RestController
@RequestMapping("/api/v1/paciente")
public final class PacienteController{
	
	@GetMapping("/dummy")
	public final PacienteDTO obtenerDummy() {
		return PacienteDTO.crear();
	}
	

	@PostMapping()
	public final ResponseEntity<Respuesta<PacienteDTO>> registrar(@RequestBody PacienteDTO dto) {
		
		final Respuesta<PacienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarPacienteFacade facade = new RegistrarPacienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha registrado exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de resgistrar el cliente");
			excepcion.printStackTrace();
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@GetMapping()
	public final ResponseEntity<Respuesta<PacienteEntity>> consultar(@RequestBody PacienteDTO dto) {
		
		final Respuesta<PacienteEntity> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		
		try {
			ConsultarPacienteFacade facade = new ConsultarPacienteFacade();
			
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
	
	
	@DeleteMapping("/{id}")
	public final ResponseEntity<Respuesta<PacienteDTO>> eliminar(@PathVariable("id") UUID id) {
		final Respuesta<PacienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			var domain =  PacienteDomain.crear(id, null, null, null, null, null, null);
			PacienteDTO dto = PacienteDTOMapper.convertToDTO(domain);
			
			EliminarPacienteFacade facade = new EliminarPacienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha eliminado exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de eliminar el cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
		
	}
	
	@PostMapping("/consultar")
	public final ResponseEntity<Respuesta<PacienteEntity>> consultarLo(@RequestBody PacienteDTO dto) {
		
		final Respuesta<PacienteEntity> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		
		try {
			ConsultarPacienteFacade facade = new ConsultarPacienteFacade();
			
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
	
	@PutMapping("{id}")
	public final ResponseEntity<Respuesta<PacienteDTO>> modificar(@PathVariable("id") UUID id,@RequestBody PacienteDTO dto) {
		final Respuesta<PacienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			PacienteDTO newDTO = PacienteDTO.crear(id, dto.getNumeroIdentificacion(),
					dto.getNombreCompletoPaciente(), dto.getContactoPaciente(), dto.getFechaNacimiento(),
					dto.getTipoIdentificacion(), dto.getInformacionAfiliacionPaciente());
			
			ModificarPacienteFacade facade = new ModificarPacienteFacade();
			facade.execute(newDTO);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El paciente se ha modificado exitosamente");
			
		} catch (final HealthException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getRaizExcepcion().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de modificar el pa");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	
		
}
