package co.health.service.businesslogic.validator.concrete.paciente;

import co.health.service.businesslogic.validator.Validator;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.IdPacienteValidationRule;
import co.health.service.domain.paciente.rules.PacienteValidationRule;

public final class EliminarPacienteValidator implements Validator<PacienteDomain>{
	
private static final Validator<PacienteDomain> instancia = new EliminarPacienteValidator();
	
	private  EliminarPacienteValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final PacienteDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(final PacienteDomain data) {
		PacienteValidationRule.ejecutarValidacion(data);
		IdPacienteValidationRule.ejecutarValidacion(data.getId());
	}


}
