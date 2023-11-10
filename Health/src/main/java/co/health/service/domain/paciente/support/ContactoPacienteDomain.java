package co.health.service.domain.paciente.support;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;


public final class ContactoPacienteDomain {
	
	private CorreoElectronicoPacienteDomain correoElectronicoPaciente;
	private NumeroTelefonoPacienteDomain numeroTelefonoPaciente;
	private String contrasenia;

	public ContactoPacienteDomain() {
		setCorreoElectronicoPaciente(new CorreoElectronicoPacienteDomain());
		setNumeroTelefonoPaciente(new NumeroTelefonoPacienteDomain());
		setContrasenia(UtilTexto.VACIO);
	}

	private ContactoPacienteDomain(final CorreoElectronicoPacienteDomain correoElectronicoPaciente,
			final NumeroTelefonoPacienteDomain numeroTelefonoPaciente,final String contrasenia) {
		setCorreoElectronicoPaciente(correoElectronicoPaciente);
		setNumeroTelefonoPaciente(numeroTelefonoPaciente);
		setContrasenia(contrasenia);
	}
	
	public static final ContactoPacienteDomain crear (final CorreoElectronicoPacienteDomain correoElectronicoPaciente,
			final NumeroTelefonoPacienteDomain numeroTelefonoPaciente,final String contrasenia) {
		return new ContactoPacienteDomain(correoElectronicoPaciente, numeroTelefonoPaciente,contrasenia);
	}
	
	public static final ContactoPacienteDomain crear() {
		return new ContactoPacienteDomain();
	}
	
	public final CorreoElectronicoPacienteDomain getCorreoElectronicoPaciente() {
		return correoElectronicoPaciente;
	}
	public final NumeroTelefonoPacienteDomain getNumeroTelefonoPaciente() {
		return numeroTelefonoPaciente;
	}


	private final void setCorreoElectronicoPaciente(final CorreoElectronicoPacienteDomain correoElectronicoPaciente) {
		this.correoElectronicoPaciente = UtilObjeto.obtenerValorDefecto(correoElectronicoPaciente, new CorreoElectronicoPacienteDomain());
	}

	private final void setNumeroTelefonoPaciente(final NumeroTelefonoPacienteDomain numeroTelefonoPaciente) {
		this.numeroTelefonoPaciente = UtilObjeto.obtenerValorDefecto(numeroTelefonoPaciente, new NumeroTelefonoPacienteDomain());
	}

	public final String getContrasenia() {
		return contrasenia;
	}

	private final void setContrasenia(final String contrasenia) {
		this.contrasenia = UtilTexto.aplicarTrim(contrasenia);
	}
	
	

}
