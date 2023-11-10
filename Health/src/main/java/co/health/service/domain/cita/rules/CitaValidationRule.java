package co.health.service.domain.cita.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.cita.CitaDomain;

public class CitaValidationRule implements ValidationRule<CitaDomain> {
	private static final ValidationRule<CitaDomain> instancia = new CitaValidationRule();
	
	private CitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CitaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final CitaDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "No es posible realizar la operacion con una cita nula";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
}
