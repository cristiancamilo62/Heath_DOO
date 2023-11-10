package co.health.data.entity.support;

public class ContactoPacienteEntity {
	private CorreoElectronicoPacienteEntity correoElectronicoPaciente;
	private NumeroTelefonoPacienteEntity numeroTelefonoPaciente;
	private String contrasenia;


	private ContactoPacienteEntity(final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente,final String contrasenia) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
		setContrasenia(contrasenia);
	}
	
	public static final ContactoPacienteEntity crear (final CorreoElectronicoPacienteEntity correoElectronicoPaciente,
			final NumeroTelefonoPacienteEntity numeroTelefonoPaciente,final String contrasenia) {
		return new ContactoPacienteEntity(correoElectronicoPaciente, numeroTelefonoPaciente,contrasenia);
	}
	
	public final CorreoElectronicoPacienteEntity getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteEntity getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}


	private final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteEntity correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	private final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteEntity numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}

	public final String getContrasenia() {
		return contrasenia;
	}

	private final void setContrasenia(final String contrasenia) {
		this.contrasenia = contrasenia;
	}
	


	
}