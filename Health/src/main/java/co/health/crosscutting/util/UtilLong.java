package co.health.crosscutting.util;

public final class UtilLong {
	
	private UtilLong() {
		super();
	}
	public static final Long DEFAULT_LONG = 0L;
	
	public static final boolean esNulo( final Long valor) {
		return UtilObjeto.esNulo(valor);
	}
	
	public static final boolean esValorPorDefecto(final Long valor) {
	    return !esNulo(valor) && valor.equals(DEFAULT_LONG);
	}
}
