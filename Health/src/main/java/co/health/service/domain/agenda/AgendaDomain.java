package co.health.service.domain.agenda;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import co.health.crosscutting.util.UtilDate;
import co.health.crosscutting.util.UtilLong;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.profesionalsalud.ProfesionalSaludDomain;

public class AgendaDomain {

	private UUID id; 
	private ProfesionalSaludDomain profesionalSalud;
	private long precioServicio;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	public AgendaDomain() {
		setId(UtilUuid.obtenerDefectoUUID(id));
		setProfesionalSalud(new ProfesionalSaludDomain());
		setPrecioServicio(UtilLong.DEFAULT_LONG);
		setFechaInicio(UtilDate.obtenerFechaDefectoEnTipoLocalDateTime());
		setFechaFin(UtilDate.obtenerFechaDefectoEnTipoLocalDateTime());
	}
	
	private AgendaDomain(final UUID id, final ProfesionalSaludDomain profesionalSalud, final long precioServicio,
			final LocalDateTime fechaInicio, final LocalDateTime fechaFin) {
		setId(id);
		setProfesionalSalud(profesionalSalud);
		setPrecioServicio(precioServicio);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
	}
	
	
	public static final AgendaDomain crear(final UUID id, final ProfesionalSaludDomain profesionalSalud, final long precioServicio,
			final LocalDateTime fechaInicio, final LocalDateTime fechaFin) {
		return new AgendaDomain(id, profesionalSalud, precioServicio, fechaInicio, fechaFin);
	}
	
	public static final AgendaDomain crear() {
		return new AgendaDomain();
	}

	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}

	private final void setProfesionalSalud(final ProfesionalSaludDomain profesionalSalud) {
		this.profesionalSalud = UtilObjeto.obtenerValorDefecto(profesionalSalud, new ProfesionalSaludDomain());
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

	public final ProfesionalSaludDomain getProfesionalSalud() {
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
