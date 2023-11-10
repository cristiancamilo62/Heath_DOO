package co.health.service.domain.cita.rules;

import co.health.service.domain.ValidationRule;
import co.health.service.domain.cita.support.DatosServicioCitaDomain;

public class DatosServicioCitaValidationRule implements ValidationRule<DatosServicioCitaDomain>{
	private static final ValidationRule<DatosServicioCitaDomain> instancia = new DatosServicioCitaValidationRule();
	
	private   DatosServicioCitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final DatosServicioCitaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(DatosServicioCitaDomain dato) {
		CodigoCitaValidationRule.ejecutarValidacion(dato.getCodigo());
		ConsultorioCitaValidationRule.ejecutarValidacion(dato.getConsultorio());
		NombreServicioCitaValidationRule.ejecutarValidacion(dato.getNombreServicio());
		PrecioCitaValidationRule.ejecutarValidacion(dato.getPrecio());
	}
}
