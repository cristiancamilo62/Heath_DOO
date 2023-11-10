package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;

public class ContraseniaPacienteValidationRule implements ValidationRule<String> {
private static final ValidationRule<String> instancia = new ContraseniaPacienteValidationRule();
	
	private ContraseniaPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMinimaValida(dato, 8)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000061));
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000062));
		}
	}
	

}
