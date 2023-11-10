package co.health.service.domain.estadocita.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.estadocita.EstadoCitaDomain;

public class EstadoCitaValidationRule implements ValidationRule<EstadoCitaDomain>{
	private static final ValidationRule<EstadoCitaDomain> instancia = new EstadoCitaValidationRule();
	
	private  EstadoCitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final EstadoCitaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final EstadoCitaDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000128));
		}
		
	}
}
