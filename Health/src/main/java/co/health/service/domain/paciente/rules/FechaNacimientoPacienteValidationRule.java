package co.health.service.domain.paciente.rules;

import java.sql.Date;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilDate;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;

public final class FechaNacimientoPacienteValidationRule implements ValidationRule<Date>{
	
private static final ValidationRule<Date> instancia = new FechaNacimientoPacienteValidationRule();
	
	private FechaNacimientoPacienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Date dato) {
		instancia.validar(dato);
	}


	@Override
	public final void validar(final Date dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}

	private final void validarObligatoriedad(final Date dato) {
		if(UtilDate.esFechaNula(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000069));
		}
	}

	private final void validarFormato(final Date dato) {
		if(!UtilDate.cumpleFormatoFecha(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000070));
		}
	}
	

}
