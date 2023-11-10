package co.health.service.domain.paciente.rules;

import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.ContactoPacienteDomain;
import co.health.service.domain.paciente.support.CorreoElectronicoPacienteDomain;
import co.health.service.domain.paciente.support.NumeroTelefonoPacienteDomain;

public final class ContactoPacienteValidationRule implements ValidationRule<ContactoPacienteDomain>{
	
	private static final ValidationRule<ContactoPacienteDomain> instancia = new ContactoPacienteValidationRule();

	private   ContactoPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ContactoPacienteDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public final void validar(final ContactoPacienteDomain dato) {
		CorreoElectronicoPacienteValidationRule.ejecutarValidacion(dato.getCorreoElectronicoPaciente());
		ContraseniaPacienteValidationRule.ejecutarValidacion(dato.getContrasenia());
		NumeroTelefonoPacienteValidationRule.ejecutarValidacion(dato.getNumeroTelefonoPaciente());
		
	
	}

}
