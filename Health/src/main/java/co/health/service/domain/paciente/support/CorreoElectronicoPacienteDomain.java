package co.health.service.domain.paciente.support;

import co.health.crosscutting.util.UtilTexto;

public final class CorreoElectronicoPacienteDomain {

	private String correoElectronico;
	private boolean correoELectronicoConfirmado;
	
	
	public CorreoElectronicoPacienteDomain() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoELectronicoConfirmado(false);
	}
	
	private CorreoElectronicoPacienteDomain(final String correoElectronico, final boolean correoELectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoELectronicoConfirmado(correoELectronicoConfirmado);
	}
	
	public static final CorreoElectronicoPacienteDomain crear(final String correoElectronico, final boolean correoELectronicoConfirmado) {
		return new CorreoElectronicoPacienteDomain(correoElectronico, correoELectronicoConfirmado);
	}
	
	public static final CorreoElectronicoPacienteDomain crear() {
		return new CorreoElectronicoPacienteDomain();
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}


	public final boolean isCorreoELectronicoConfirmado() {
		return correoELectronicoConfirmado;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoELectronicoConfirmado(final boolean correoELectronicoConfirmado) {
		this.correoELectronicoConfirmado = correoELectronicoConfirmado;
	}
	
	
}
