package co.health.service.businesslogic.validator.concrete.tipoidentificacion;

import co.health.service.businesslogic.validator.Validator;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.health.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.health.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.health.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;
import co.health.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public final class ModificarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{
	
	private static final Validator<TipoIdentificacionDomain> instancia = new ModificarTipoIdentificacionValidator();
	
	private ModificarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}

	@Override
	public final void execute(final TipoIdentificacionDomain data) {
		TipoIdentificacionValidationRule.ejecutarValidacion(data);
		IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(data.getNombre());		
	}
}
