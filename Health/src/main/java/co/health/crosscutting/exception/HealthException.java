package co.health.crosscutting.exception;

import co.health.crosscutting.exception.enumerator.LugarException;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;

public class HealthException extends RuntimeException{

	private static final long serialVersionUID = -8277282569789560598L;
	private LugarException lugar;
	private Throwable raizExcepcion;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz ;
	
	protected HealthException(final LugarException lugar, final Throwable raizExcepcion,final String mensajeUsuario,
			final String mensajeTecnico) {
		setLugar(lugar);
		setRaizExcepcion(raizExcepcion);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
	}
	private final void setLugar(final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarException.GENERAL);
	}
	private final void setRaizExcepcion(final Throwable raizExcepcion) {
		setTieneExcepcionRaiz(!UtilObjeto.esNulo(raizExcepcion ));
		this.raizExcepcion = UtilObjeto.obtenerValorDefecto(raizExcepcion, new Exception());
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.aplicarTrim(mensajeTecnico);
	}
	private final void setTieneExcepcionRaiz(final boolean tieneExcepcionRaiz) {
		this.tieneExcepcionRaiz = tieneExcepcionRaiz;
	}
	public final LugarException getLugar() {
		return lugar;
	}
	public final Throwable getRaizExcepcion() {
		return raizExcepcion;
	}
	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public final boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	}
	
	

}
