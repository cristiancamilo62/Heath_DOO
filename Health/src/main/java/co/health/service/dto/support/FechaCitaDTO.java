package co.health.service.dto.support;

import java.sql.Date;

import co.health.crosscutting.util.UtilDate;
import co.health.service.domain.cita.support.FechaCitaDomain;

public class FechaCitaDTO {
		
	private Date fechaInicio;
	private Date fechaFin;
		
		
		public FechaCitaDTO() {
			setFechaInicio(UtilDate.crearFechaPorDefecto());
			setFechaFin(UtilDate.crearFechaPorDefecto());
		}
		
		public FechaCitaDTO(final Date fechaInicio, final Date fechaFin) {
			setFechaInicio(fechaInicio);
			setFechaFin(fechaFin);
		}
		
		public static final FechaCitaDTO crear (final Date fechaInicio,final Date fechaFin) {
			return new FechaCitaDTO();
		
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

