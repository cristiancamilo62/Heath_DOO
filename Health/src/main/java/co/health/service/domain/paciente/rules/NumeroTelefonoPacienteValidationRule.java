package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.NumeroTelefonoPacienteDomain;

public final class NumeroTelefonoPacienteValidationRule implements ValidationRule<NumeroTelefonoPacienteDomain>{
	
private static final ValidationRule<NumeroTelefonoPacienteDomain> instancia = new NumeroTelefonoPacienteValidationRule();
	
	private NumeroTelefonoPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NumeroTelefonoPacienteDomain dato) {
		instancia.validar(dato);
	}


	@Override
	public final void validar(final NumeroTelefonoPacienteDomain dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}

	private final void validarFormato(final NumeroTelefonoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloDigitos(dato.getNumeroTelefono())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000086));
		}
	}

	private final void validarObligatoriedad(final NumeroTelefonoPacienteDomain dato) {
		if(UtilObjeto.esNulo(dato.getNumeroTelefono())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000087));
		}
	}

	private final void validarLongitud(final NumeroTelefonoPacienteDomain dato) {
		if(!UtilTexto.longitudIgual(dato.getNumeroTelefono(), 10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000088));
		}
	}

}
