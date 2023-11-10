package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.LugarException;

public final class DataHealthException extends HealthException{
	
	private static final long serialVersionUID = -8707341661244453309L;


	protected DataHealthException(Throwable raizExcepcion, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.DATA, raizExcepcion, mensajeUsuario, mensajeTecnico);
	}
	
	public static final HealthException crear(final String mensajeUsuario) {
		return new DataHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new DataHealthException(null, mensajeUsuario,mensajeTecnico);
	}

	public static final HealthException crear(final String mensajeUsuario, final String mensajeTecnico,final Throwable raizExcepcion) {
		return new DataHealthException(raizExcepcion, mensajeUsuario,mensajeTecnico);
	}

	
}
