package co.health.service.businesslogic.validator.concrete.cita;

import co.health.service.businesslogic.validator.Validator;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.domain.cita.rules.DatosServicioCitaValidationRule;
import co.health.service.domain.cita.rules.FechaCitaValidationRule;
import co.health.service.domain.estadocita.rules.EstadoCitaValidationRule;
import co.health.service.domain.paciente.rules.NombreCompletoValidationRule;

public class RegistrarCitaValidator implements Validator<CitaDomain>{
	private static final Validator<CitaDomain> instancia = new RegistrarCitaValidator();
	
	private RegistrarCitaValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final CitaDomain data) {
		instancia.execute(data);
	}

	@Override
	public final void execute(final CitaDomain dato) {
		//IdCitaValidationRule.ejecutarValidacion(dato.getId());
		DatosServicioCitaValidationRule.ejecutarValidacion(dato.getDatosServicioCita());
		FechaCitaValidationRule.ejecutarValidacion(dato.getFecha());
		EstadoCitaValidationRule.ejecutarValidacion(dato.getEstadoCita());
		NombreCompletoValidationRule.ejecutarValidacion(dato.getNombreProfesional());
	}
}
