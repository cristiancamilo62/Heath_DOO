package co.health.service.dto.support;

import co.health.crosscutting.util.UtilTexto;

public class ContactoPacienteDTO {
	private CorreoElectronicoPacienteDTO correoElectronicoPaciente;
	private NumeroTelefonoPacienteDTO numeroTelefonoPaciente;
	private String contrasenia;


	public ContactoPacienteDTO() {
		setCorreoElectronicoPaciente(new CorreoElectronicoPacienteDTO());
		setNumeroTelefonoPaciente(new NumeroTelefonoPacienteDTO());
		setContrasenia(UtilTexto.VACIO);
	}
	private ContactoPacienteDTO(final CorreoElectronicoPacienteDTO correoElectronicoPaciente,
			final NumeroTelefonoPacienteDTO numeroTelefonoPaciente,final String contrasenia) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
		setContrasenia(contrasenia);
	}
	
	public static final ContactoPacienteDTO crear (final CorreoElectronicoPacienteDTO correoElectronicoPaciente,
			final NumeroTelefonoPacienteDTO numeroTelefonoPaciente,final String contrasenia) {
		return new ContactoPacienteDTO(correoElectronicoPaciente, numeroTelefonoPaciente,contrasenia);
	}
	
	public final CorreoElectronicoPacienteDTO getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteDTO getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}
	
	public final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteDTO correoElectronicoPaciente) {
		this.correoElectronicoPaciente = correoElectronicoPaciente;
	}

	public final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteDTO numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = numeroTelefonoPaciente;
	}
	public final String getContrasenia() {
		return contrasenia;
	}
	public final void setContrasenia(final String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}