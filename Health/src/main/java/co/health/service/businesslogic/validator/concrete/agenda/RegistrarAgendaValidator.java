package co.health.service.businesslogic.validator.concrete.agenda;

import co.health.service.businesslogic.validator.Validator;
import co.health.service.domain.agenda.AgendaDomain;
import co.health.service.domain.agenda.rules.AgendaValidationRule;
import co.health.service.domain.agenda.rules.FechaFinAgendaValidationRule;
import co.health.service.domain.agenda.rules.FechaInicioAgendaValidationRule;

public final class RegistrarAgendaValidator implements Validator<AgendaDomain>{

	private static final Validator<AgendaDomain> instancia = new RegistrarAgendaValidator();
	
	private  RegistrarAgendaValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final AgendaDomain data) {
		instancia.execute(data);
	}

	
	@Override
	public void execute(final AgendaDomain dato) {
		AgendaValidationRule.ejecutarValidacion(dato);
		//IdAgendaValidationRule.ejecutarValidacion(dato.getId());
		//NombreTipoServicioValidationRule.ejecutarValidacion(dato.getProfesionalSalud().getServicio().getNombre());
		//NombreCompletoValidationRule.ejecutarValidacion(dato.getProfesionalSalud().getNombreCompletoProfesionalSalud());
		FechaInicioAgendaValidationRule.ejecutarValidacion(dato.getFechaInicio());
		FechaFinAgendaValidationRule.ejecutarValidacion(dato.getFechaFin());
	}

}
