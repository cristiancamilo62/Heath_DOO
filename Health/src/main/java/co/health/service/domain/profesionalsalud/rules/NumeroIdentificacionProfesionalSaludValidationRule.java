package co.health.service.domain.profesionalsalud.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public class NumeroIdentificacionProfesionalSaludValidationRule implements ValidationRule<String> {
	
	private static final ValidationRule<String> instancia = new NumeroIdentificacionProfesionalSaludValidationRule();
	
	private NumeroIdentificacionProfesionalSaludValidationRule() {
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000083);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000084);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloDigitos(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000085);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

}
