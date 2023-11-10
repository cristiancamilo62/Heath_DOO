package co.health.service.domain.estadocita.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public class NombreEstadoCitaValidationRule implements ValidationRule<String> {
	private static final ValidationRule<String> instancia = new NombreEstadoCitaValidationRule();
	
	private NombreEstadoCitaValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,10)) {
			var mensajeUsuario = "la longitud del nombre del estado de la cita debe ser menor a 20";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "El nombre del estado de cita es un dato obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloDigitos(dato)) {
			var mensajeUsuario = "El nombre del estado de la cita debe tener solo letras";
			throw ServiceHealthException.crear(mensajeUsuario);
		}	
	}
}
