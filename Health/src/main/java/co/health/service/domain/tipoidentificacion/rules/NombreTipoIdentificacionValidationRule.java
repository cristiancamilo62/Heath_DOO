package co.health.service.domain.tipoidentificacion.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public final class NombreTipoIdentificacionValidationRule  implements ValidationRule<String>{
	
private static final ValidationRule<String> instancia = new NombreTipoIdentificacionValidationRule();
	
	private NombreTipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}
	
	@Override
	public final void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000063));
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000064));
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000065));
		}
		
	}

}
