package co.health.data.entity;

import java.util.UUID;

import co.health.data.entity.support.NombreCompletoEntity;
import co.health.data.entity.support.TipoServicioEntity;

public class ProfesionalSaludEntity {

	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoEntity nombreCompletoProfesionalSalud;
	private TipoServicioEntity servicio;
	private TipoIdentificacionEntity tipoIdentificacion;

	
	private ProfesionalSaludEntity(final UUID id, final String numeroIdentificacion,
			final NombreCompletoEntity nombreCompletoProfesionalSalud, final TipoServicioEntity servicio,
			final TipoIdentificacionEntity tipoIdentificacion) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoProfesionalSalud(nombreCompletoProfesionalSalud);
		setServicio(servicio);
		setTipoIdentificacion(tipoIdentificacion);
	}

	public static final ProfesionalSaludEntity crear(final UUID id, final String numeroIdentificacion,
			final NombreCompletoEntity nombreCompletoProfesionalSalud, final TipoServicioEntity servicio,
			final TipoIdentificacionEntity tipoIdentificacion) {
		return new ProfesionalSaludEntity(id, numeroIdentificacion, nombreCompletoProfesionalSalud, servicio, tipoIdentificacion);
	}

	public final UUID getId() {
		return id;
	}


	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	public final NombreCompletoEntity getNombreCompletoProfesionalSalud() {
		return nombreCompletoProfesionalSalud;
	}

	public final TipoServicioEntity getServicio() {
		return servicio;
	}


	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}


	private final void setNombreCompletoProfesionalSalud(
			final NombreCompletoEntity nombreCompletoProfesionalSalud) {
		this.nombreCompletoProfesionalSalud = nombreCompletoProfesionalSalud;
	}

	private final void setServicio(final TipoServicioEntity servicio) {
		this.servicio = servicio;
	}


	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	
}
