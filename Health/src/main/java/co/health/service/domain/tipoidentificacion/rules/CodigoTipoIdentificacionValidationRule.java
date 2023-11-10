package co.health.service.domain.tipoidentificacion.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public final class CodigoTipoIdentificacionValidationRule implements ValidationRule<String>{
	
	private static final ValidationRule<String> instancia = new CodigoTipoIdentificacionValidationRule();
	
	private CodigoTipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(String dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,4)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000090));
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000091));
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetras(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000092));
		}
	}

}
