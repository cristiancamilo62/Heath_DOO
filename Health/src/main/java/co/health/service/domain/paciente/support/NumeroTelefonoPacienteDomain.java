package co.health.service.domain.paciente.support;

import co.health.crosscutting.util.UtilTexto;

public final class NumeroTelefonoPacienteDomain {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoPacienteDomain() {
		setNumeroTelefono(UtilTexto.VACIO);
		setNumeroTelefonoConfirmado(false);
	}
	
	private NumeroTelefonoPacienteDomain(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoPacienteDomain crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoPacienteDomain(numeroTelefono, numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoPacienteDomain crear() {
		return new NumeroTelefonoPacienteDomain();
	}
	
	public final String getNumeroTelefono() {
		return numeroTelefono;
	}


	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	private final void setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	private final void setNumeroTelefonoConfirmado(final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = numeroTelefonoConfirmado;
	}
	
}
