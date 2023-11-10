package co.health.service.domain.cita.rules;

import java.sql.Date;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilDate;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;

public class FechaFinCitaValidationRule implements ValidationRule<Date> {
	private static final ValidationRule<Date> instancia = new FechaFinCitaValidationRule();
	
	private FechaFinCitaValidationRule() {
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
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "La fecha de la cita es un dato Obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

	private final void validarFormato(final Date dato) {
		if(!UtilDate.cumpleFormatoFecha(dato)) {
			var mensajeUsuario = "La fecha no cumple el formato.La fecha de la cita debe tener el formato yyyy-MM-dd-";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
}
