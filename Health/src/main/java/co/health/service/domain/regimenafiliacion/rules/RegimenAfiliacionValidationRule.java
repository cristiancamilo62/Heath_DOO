package co.health.service.domain.regimenafiliacion.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.regimenafiliacion.RegimenAfiliacionDomain;

public final class RegimenAfiliacionValidationRule implements ValidationRule<RegimenAfiliacionDomain>{

	private static final ValidationRule<RegimenAfiliacionDomain> instancia = new RegimenAfiliacionValidationRule();
	
	private  RegimenAfiliacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final RegimenAfiliacionDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final RegimenAfiliacionDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			//TODO MENsajes
			var mensajeUsuario = "No es posible realizar la operacion con un regimen de afiliacion nulo";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}
}
