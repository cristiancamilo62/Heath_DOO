package co.health.data.entity.support;

import java.sql.Date;

public class FechaCitaEntity {
	private Date fechaInicio;
	private Date fechaFin;
	
	
	private FechaCitaEntity(final Date fechaInicio, final Date fechaFin) {
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
	}
	
	public static final FechaCitaEntity crear(final Date fechaInicio, final Date fechaFin) {
		return new FechaCitaEntity(fechaInicio, fechaFin);
	}

	public final Date getFechaInicio() {
		return fechaInicio;
	}


	public final Date getFechaFin() {
		return fechaFin;
	}


	private final void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	private final void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
}