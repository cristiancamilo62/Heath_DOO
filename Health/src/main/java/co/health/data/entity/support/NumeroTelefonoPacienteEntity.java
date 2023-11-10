package co.health.data.entity.support;

public class NumeroTelefonoPacienteEntity {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	
	private NumeroTelefonoPacienteEntity(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoPacienteEntity crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoPacienteEntity(numeroTelefono, numeroTelefonoConfirmado);
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