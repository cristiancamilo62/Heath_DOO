package co.health.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.health.data.entity.support.ContactoPacienteEntity;
import co.health.data.entity.support.InformacionAfiliacionPacienteEntity;
import co.health.data.entity.support.NombreCompletoEntity;


public class PacienteEntity {
	
	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoEntity nombreCompletoPaciente;
	private ContactoPacienteEntity contactoPaciente;
	private Date fechaNacimiento;
	private TipoIdentificacionEntity tipoIdentificacion;
	private InformacionAfiliacionPacienteEntity informacionAfiliacionPaciente;

	
	private PacienteEntity(final UUID id, final String numeroIdentificacion, final NombreCompletoEntity nombreCompletoPaciente,
			final ContactoPacienteEntity contactoPaciente, final Date fechaNacimiento,
			final TipoIdentificacionEntity tipoIdentificacion, final InformacionAfiliacionPacienteEntity informacionAfiliacionPaciente) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoPaciente(nombreCompletoPaciente);
		setContactoPaciente(contactoPaciente);
		setInformacionAfiliacionPaciente(informacionAfiliacionPaciente);
		setFechaNacimiento(fechaNacimiento);
		setTipoIdentificacion(tipoIdentificacion);
	}

	public static final PacienteEntity crear(final UUID id, final String numeroIdentificacion, final NombreCompletoEntity nombreCompletoPaciente,
			final ContactoPacienteEntity contactoPaciente, final Date fechaNacimiento,
			final TipoIdentificacionEntity tipoIdentificacion, final InformacionAfiliacionPacienteEntity informacionAfiliacionPaciente) {
		return new PacienteEntity(id, numeroIdentificacion, 
				nombreCompletoPaciente, contactoPaciente, fechaNacimiento, tipoIdentificacion, informacionAfiliacionPaciente);
	}

	public final UUID getId() {
		return id;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final NombreCompletoEntity getNombreCompletoPaciente() {
		return nombreCompletoPaciente;
	}

	public final ContactoPacienteEntity getContactoPaciente() {
		return contactoPaciente;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final InformacionAfiliacionPacienteEntity getInformacionAfiliacionPaciente() {
		return informacionAfiliacionPaciente;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	private final void setNombreCompletoPaciente(final NombreCompletoEntity nombreCompletoPaciente) {
		this.nombreCompletoPaciente = nombreCompletoPaciente;
	}

	private final void setContactoPaciente(final ContactoPacienteEntity contactoPaciente) {
		this.contactoPaciente = contactoPaciente;
	}

	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setInformacionAfiliacionPaciente(final InformacionAfiliacionPacienteEntity informacionAfiliacionPaciente) {
		this.informacionAfiliacionPaciente = informacionAfiliacionPaciente;
	}

	

	
	
	

}
