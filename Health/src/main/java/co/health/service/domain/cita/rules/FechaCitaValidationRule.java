package co.health.service.domain.cita.rules;

import co.health.service.domain.ValidationRule;
import co.health.service.domain.cita.support.FechaCitaDomain;

public class FechaCitaValidationRule implements ValidationRule<FechaCitaDomain>{
	private static final ValidationRule<FechaCitaDomain> instancia = new FechaCitaValidationRule();
	
	private   FechaCitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final FechaCitaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(FechaCitaDomain dato) {
		FechaInicioCitaValidationRule.ejecutarValidacion(dato.getFechaInicio());
		FechaFinCitaValidationRule.ejecutarValidacion(dato.getFechaFin());
	}

}
