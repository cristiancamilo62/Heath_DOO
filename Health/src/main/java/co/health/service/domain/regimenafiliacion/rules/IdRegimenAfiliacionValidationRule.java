package co.health.service.domain.regimenafiliacion.rules;

import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.ValidationRule;

public final class IdRegimenAfiliacionValidationRule implements ValidationRule<UUID>{

private static final ValidationRule<UUID> instancia = new IdRegimenAfiliacionValidationRule();
	
	private IdRegimenAfiliacionValidationRule() {
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
			var mensajeUsuario = "El id del regimen de afiliacion es el valor por defecto";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}	
	
}
