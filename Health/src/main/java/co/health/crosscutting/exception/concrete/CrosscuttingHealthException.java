package co.health.crosscutting.exception.concrete;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.enumerator.LugarException;

public class CrosscuttingHealthException extends HealthException{
	
	private static final long serialVersionUID = 6669353138171663542L;

	protected CrosscuttingHealthException(Throwable raizExcepcion, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.CROSSCUTTING, raizExcepcion, mensajeUsuario, mensajeTecnico);

	}
	
	public static final HealthException crear(final String mensajeUsuario) {
		return new CrosscuttingHealthException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final HealthException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new CrosscuttingHealthException(null, mensajeUsuario,mensajeTecnico);
	}

	public static final HealthException crear(final String mensajeUsuario, final String mensajeTecnico,final Throwable raizExcepcion) {
		return new CrosscuttingHealthException(raizExcepcion, mensajeUsuario,mensajeTecnico);
	}

}
