package co.health.service.domain.paciente.support;

import co.health.crosscutting.util.UtilTexto;

public final class NombreCompletoDomain {

	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	public  NombreCompletoDomain() {
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}
	
	private NombreCompletoDomain(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		
	}
		
	public static final NombreCompletoDomain crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoDomain(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}
	
	public static final NombreCompletoDomain crear() {
		return new NombreCompletoDomain();
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
