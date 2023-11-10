package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.LugarException;

public final class ServiceHealthException extends HealthException{
	
	private static final long serialVersionUID = -433250912528968263L;


	protected ServiceHealthException(final Throwable raizExcepcion, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.SERVICE, raizExcepcion, mensajeUsuario, mensajeTecnico);
		
	}
	
	public static final HealthException crear(final String mensajeUsuario) {
		return new ServiceHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceHealthException(null, mensajeUsuario,mensajeTecnico);
	}

	public static final HealthException crear(final String mensajeUsuario, final String mensajeTecnico,final Throwable raizExcepcion) {
		return new ServiceHealthException(raizExcepcion, mensajeUsuario,mensajeTecnico);
	}
	
}
