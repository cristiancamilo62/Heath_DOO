package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public final class NumeroIdentificacionPacienteValidationRule implements ValidationRule<String> {
	
private static final ValidationRule<String> instancia = new NumeroIdentificacionPacienteValidationRule();
	
	private NumeroIdentificacionPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
		validarLongitud(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudIgual(dato,10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000083));
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000084));
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloDigitos(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000085));
		}
		
		
	}

}
