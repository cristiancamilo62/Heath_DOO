package co.health.service.domain.factura.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.profesionalsalud.rules.NumeroIdentificacionProfesionalSaludValidationRule;

public class DescripcionFacturaValidationRule implements ValidationRule<String>{
private static final ValidationRule<String> instancia = new DescripcionFacturaValidationRule();
	
	private DescripcionFacturaValidationRule() {
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
		if(!UtilTexto.longitudValida(dato, 0, 100)) {
			var mensajeUsuario = "La longitud del numero de identificacion debe ser igual a 10";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "La descripcion de la factura es un dato obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			var mensajeUsuario = "La descripcion debe tener digitos y letras";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
}
