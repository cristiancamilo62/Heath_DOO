package co.health.service.domain.factura.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.factura.FacturaDomain;

public class FacturaValidationRule implements ValidationRule<FacturaDomain>{
	private static final ValidationRule<FacturaDomain> instancia = new FacturaValidationRule();
	
	private  FacturaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final FacturaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final FacturaDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			//TODO MENsajes
			var mensajeUsuario = "No es posible realizar la operacion con una factura Nula";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
	}

}
