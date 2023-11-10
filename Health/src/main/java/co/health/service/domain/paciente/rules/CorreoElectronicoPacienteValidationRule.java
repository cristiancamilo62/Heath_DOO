package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.CorreoElectronicoPacienteDomain;

public final class CorreoElectronicoPacienteValidationRule implements ValidationRule<CorreoElectronicoPacienteDomain>{
	
private static final ValidationRule<CorreoElectronicoPacienteDomain> instancia = new CorreoElectronicoPacienteValidationRule();
	
	private   CorreoElectronicoPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CorreoElectronicoPacienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final CorreoElectronicoPacienteDomain dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarLongitud(final CorreoElectronicoPacienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getCorreoElectronico(), 40)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000066));
		}
	}
	
	private final void validarObligatoriedad(final CorreoElectronicoPacienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getCorreoElectronico())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000067));
		}
	}
	
	private final void validarFormato(final CorreoElectronicoPacienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosArrobaDominio(dato.getCorreoElectronico())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000068));
		}
		
	}


}
