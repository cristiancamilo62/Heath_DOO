package co.health.service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.health.crosscutting.util.UtilDate;
import co.health.crosscutting.util.UtilLong;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilUuid;


public final class AgendaDTO {
	
	private UUID id; 
	private ProfesionalSaludDTO profesionalSalud;
	private long precioServicio;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	public AgendaDTO() {
		setId(id);
		setProfesionalSalud(profesionalSalud);
		setPrecioServicio(precioServicio);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
	}
	
	public AgendaDTO(final UUID id, final ProfesionalSaludDTO profesionalSalud,final long precioServicio, final  LocalDateTime fechaInicio,
			final LocalDateTime fechaFin) {
		setId(id);
		setProfesionalSalud(profesionalSalud);
		setPrecioServicio(precioServicio);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
	}
	
	public static final AgendaDTO crear(final UUID id, final ProfesionalSaludDTO profesionalSalud,final long precioServicio, final  LocalDateTime fechaInicio,
			final LocalDateTime fechaFin) {
		return new AgendaDTO(id, profesionalSalud, precioServicio, fechaInicio, fechaFin);
	}

	public static final AgendaDTO crear() {
		return new AgendaDTO();
	}
	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}

	public final ProfesionalSaludDTO getProfesionalSalud() {
		return profesionalSalud;
	}

	public final void setProfesionalSalud(final ProfesionalSaludDTO profesionalSalud) {
		this.profesionalSalud = UtilObjeto.obtenerValorDefecto(profesionalSalud, new ProfesionalSaludDTO());
	}

	public final long getPrecioServicio() {
		return precioServicio;
	}

	public final void setPrecioServicio(final long precioServicio) {
		this.precioServicio = UtilObjeto.obtenerValorDefecto(precioServicio, UtilLong.DEFAULT_LONG);
	}

	public final LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public final void setFechaInicio(final LocalDateTime fechaInicio) {
		this.fechaInicio = UtilObjeto.obtenerValorDefecto(fechaInicio, UtilDate.obtenerFechaDefectoEnTipoLocalDateTime());
	}

	public final LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public final void setFechaFin(final LocalDateTime fechaFin) {
		this.fechaFin = UtilObjeto.obtenerValorDefecto(fechaFin, UtilDate.obtenerFechaDefectoEnTipoLocalDateTime());
	}
}
