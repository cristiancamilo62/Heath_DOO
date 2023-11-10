package co.health.data.entity.support;

public class CorreoElectronicoPacienteEntity {
	private String correoElectronico;
	private boolean correoELectronicoConfirmado;
	
	
	private CorreoElectronicoPacienteEntity(final String correoElectronico, final boolean correoELectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoELectronicoConfirmado(correoELectronicoConfirmado);
	}
	
	public static final CorreoElectronicoPacienteEntity crear(final String correoElectronico, final boolean correoELectronicoConfirmado) {
		return new CorreoElectronicoPacienteEntity(correoElectronico, correoELectronicoConfirmado);
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