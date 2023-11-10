package co.health.service.domain.eps.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.eps.EpsDomain;

public final class EpsPacienteValidationRule implements ValidationRule<EpsDomain>{

	private static final ValidationRule<EpsDomain> instancia = new EpsPacienteValidationRule();
	
	private  EpsPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final EpsDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final EpsDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			//TODO MENsajes
			var mensajeUsuario = "No es posible realizar la operacion con una eps nula";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}
	
}
