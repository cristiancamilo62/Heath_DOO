package co.health.service.businesslogic.validator.concrete.paciente;

import co.health.service.businesslogic.validator.Validator;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.PacienteValidationRule;

public final class ConsultarPacienteValidador implements Validator<PacienteDomain>{

	private static final Validator<PacienteDomain> instancia = new ConsultarPacienteValidador();
	
	private  ConsultarPacienteValidador() {
		super();
	}
	
	public static final void ejecutarValidacion(final PacienteDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(final PacienteDomain dato) {
		PacienteValidationRule.ejecutarValidacion(dato);
		
	}

}
