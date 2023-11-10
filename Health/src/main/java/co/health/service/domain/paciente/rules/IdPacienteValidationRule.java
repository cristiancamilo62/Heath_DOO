package co.health.service.domain.paciente.rules;

import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.ValidationRule;

public final class IdPacienteValidationRule implements ValidationRule<UUID>{
	
private static final ValidationRule<UUID> instancia = new IdPacienteValidationRule();
	
	private IdPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(UUID dato) {
		validarIdPorDefecto(dato);
		
	}
	private final void validarIdPorDefecto(final UUID id) {
		if(UtilUuid.valorDefecto(id)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000070));
		}
	}	
	

}
