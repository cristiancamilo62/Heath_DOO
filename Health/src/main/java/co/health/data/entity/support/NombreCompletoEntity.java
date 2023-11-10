package co.health.data.entity.support;

import co.health.crosscutting.util.UtilTexto;

public class NombreCompletoEntity {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	private NombreCompletoEntity(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		
	}
		
	public static final NombreCompletoEntity crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}


	public final String getSegundoNombre() {
		return segundoNombre;
	}


	public final String getPrimerApellido() {
		return primerApellido;
	}


	public final String getSegundoApellido() {
		return segundoApellido;
	}


	private final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilTexto.aplicarTrim(primerNombre);
	}


	private final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilTexto.aplicarTrim(segundoNombre);
	}


	private final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilTexto.aplicarTrim(primerApellido);
	}


	private final void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = UtilTexto.aplicarTrim(segundoApellido);
	}
	
	

	
	
	
}