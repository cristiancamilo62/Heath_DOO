package co.health.service.dto.support;

import co.health.crosscutting.util.UtilTexto;

public class NombreCompletoDTO {
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	public NombreCompletoDTO() {
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}
	
	public NombreCompletoDTO(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	
	public static final NombreCompletoDTO crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoDTO(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}

	
	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final NombreCompletoDTO setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final NombreCompletoDTO setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final NombreCompletoDTO setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public final NombreCompletoDTO setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}
	
	
	

}
