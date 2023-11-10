package co.health.service.domain.profesionalsalud.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public final  class NombreTipoServicioValidationRule implements ValidationRule<String>{
	
	private static final ValidationRule<String> instancia = new NombreTipoServicioValidationRule();
	
	private NombreTipoServicioValidationRule() {
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000205);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000206);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetras(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000207);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}


}
