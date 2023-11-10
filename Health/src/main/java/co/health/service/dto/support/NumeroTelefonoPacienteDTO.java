package co.health.service.dto.support;

public class NumeroTelefonoPacienteDTO {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoPacienteDTO() {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	private NumeroTelefonoPacienteDTO(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoPacienteDTO crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoPacienteDTO(numeroTelefono, numeroTelefonoConfirmado);
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