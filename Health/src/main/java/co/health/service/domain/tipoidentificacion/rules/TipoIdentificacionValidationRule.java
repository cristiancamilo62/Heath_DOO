package co.health.service.domain.tipoidentificacion.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class TipoIdentificacionValidationRule implements ValidationRule<TipoIdentificacionDomain>{
	
private static final ValidationRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();
	
	private TipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final TipoIdentificacionDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000082));
		}
	}

}
