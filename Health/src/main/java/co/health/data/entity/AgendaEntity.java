package co.health.data.entity;

import java.time.LocalDateTime;
import java.util.UUID;


public class AgendaEntity {

	private UUID id; 
	private ProfesionalSaludEntity profesionalSalud;
	private long precioServicio;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	private AgendaEntity(final UUID id, final ProfesionalSaludEntity profesionalSalud, final long precioServicio,
			final LocalDateTime fechaInicio, final LocalDateTime fechaFin) {
		setId(id);
		setProfesionalSalud(profesionalSalud);
		setPrecioServicio(precioServicio);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
	}
	
	
	public static final AgendaEntity crear(final UUID id, final ProfesionalSaludEntity profesionalSalud, final long precioServicio,
			final LocalDateTime fechaInicio, final LocalDateTime fechaFin) {
		return new AgendaEntity(id, profesionalSalud, precioServicio, fechaInicio, fechaFin);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setProfesionalSalud(final ProfesionalSaludEntity profesionalSalud) {
		this.profesionalSalud = profesionalSalud;
	}

	private final void setPrecioServicio(final long precioServicio) {
		this.precioServicio = precioServicio;
	}

	private final void setFechaInicio(final LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	private final void setFechaFin(final LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public final UUID getId() {
		return id;
	}

	public final ProfesionalSaludEntity getProfesionalSalud() {
		return profesionalSalud;
	}

	public final long getPrecioServicio() {
		return precioServicio;
	}

	public final LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public final LocalDateTime getFechaFin() {
		return fechaFin;
	}	

}