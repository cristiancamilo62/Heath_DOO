package co.health.service.businesslogic.validator.profesionalsalud;

import co.health.service.businesslogic.validator.Validator;
import co.health.service.domain.profesionalsalud.ProfesionalSaludDomain;
import co.health.service.domain.profesionalsalud.rules.ProfesionalSaludValidationRule;

public final class ConsultarProfesionalSaludValidator implements Validator<ProfesionalSaludDomain>{

	private static final Validator<ProfesionalSaludDomain> instancia = new ConsultarProfesionalSaludValidator();
	
	private  ConsultarProfesionalSaludValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final ProfesionalSaludDomain data) {
		instancia.execute(data);
	}
	
	
	@Override
	public final void execute(final ProfesionalSaludDomain dato) {
		ProfesionalSaludValidationRule.ejecutarValidacion(dato);
	}

}
