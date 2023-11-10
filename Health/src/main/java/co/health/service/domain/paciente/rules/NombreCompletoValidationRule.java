package co.health.service.domain.paciente.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.paciente.support.NombreCompletoDomain;

public final class NombreCompletoValidationRule implements ValidationRule<NombreCompletoDomain>{
	
private static final ValidationRule<NombreCompletoDomain> instancia = new NombreCompletoValidationRule();
	
	public NombreCompletoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NombreCompletoDomain dato) {
		instancia.validar(dato);
	}
	

	@Override
	public final void validar(final NombreCompletoDomain dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
	}

	
	public final void validarLongitud(final NombreCompletoDomain dato) {
		validarLongitudPrimerNombre(dato);
		validarLongitudSegundoNombre(dato);
		validarLongitudPrimerApellido(dato);
		validadLongitudSegundoApellido(dato);
		
	}
	private final void validarLongitudPrimerNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerNombre(),10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000072));
		}
	}

	private final void validarLongitudSegundoNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.estaVacio(dato.getSegundoNombre()) && !UtilTexto.longitudMaximaValida(dato.getSegundoNombre(),10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000073));
		}
	}

	private final void validarLongitudPrimerApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerApellido(),10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000074));
		}
		
	}

	private final void validadLongitudSegundoApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.estaVacio(dato.getSegundoApellido()) && !UtilTexto.longitudMaximaValida(dato.getSegundoApellido(),10)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000075));
		}
	}
		
	
	private final void validarFormato(final NombreCompletoDomain dato) {
		validarFormatoPrimerNombre(dato);
		validarFormatoSegundoNombre(dato);
		validarFormatoPrimerApellido(dato);
		validarFormatoSegundoApellido(dato);
	}

	private final void validarFormatoPrimerNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerNombre())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000076));
		}
		
	}

	private final void validarFormatoSegundoNombre(final NombreCompletoDomain dato) {
		if(!UtilTexto.estaVacio(dato.getSegundoNombre()) && !UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoNombre())) {
				throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000077));
		}
	}

	private final void validarFormatoPrimerApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerApellido())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000078));
		}
	}

	private final void validarFormatoSegundoApellido(final NombreCompletoDomain dato) {
		if(!UtilTexto.estaVacio(dato.getSegundoNombre()) && !UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoApellido())) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000079));
		}
	}

	private final void validarObligatoriedad(final NombreCompletoDomain dato) {
		validarObligatoriedadPrimerNombre(dato);
		validarObligatoriedadPrimerApellido(dato);
		
	}

	private final void validarObligatoriedadPrimerNombre(final NombreCompletoDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerNombre())) {
			ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000080));
		}
		
	}

	private final void validarObligatoriedadPrimerApellido(final NombreCompletoDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerApellido())) {
			ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000081));
		}
	}

}
