package co.health.service.domain.profesionalsalud.rules;

import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.ValidationRule;

public final class IdTipoServicioValidationRule implements ValidationRule<UUID>{

	
	private static final ValidationRule<UUID> instancia = new IdTipoServicioValidationRule();
	
	private IdTipoServicioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(final UUID dato) {
		if(UtilUuid.valorDefecto(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000204);
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

}
