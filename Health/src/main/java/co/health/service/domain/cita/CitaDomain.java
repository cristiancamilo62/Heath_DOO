package co.health.service.domain.cita;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.cita.support.DatosServicioCitaDomain;
import co.health.service.domain.cita.support.FechaCitaDomain;
import co.health.service.domain.estadocita.EstadoCitaDomain;
import co.health.service.domain.paciente.support.NombreCompletoDomain;

public class CitaDomain {
	private UUID id;
	private DatosServicioCitaDomain datosServicioCita;
	private FechaCitaDomain fecha;
	private EstadoCitaDomain estadoCita;
	private NombreCompletoDomain nombreProfesional; 
	
	
	private CitaDomain(final UUID id, final DatosServicioCitaDomain datosServicioCita, final FechaCitaDomain fecha,
			 final EstadoCitaDomain estadoCita, final NombreCompletoDomain nombreProfesional) {
		setId(id);
		setDatosServicioCita(datosServicioCita);
		setFecha(fecha);
		setEstadoCita(estadoCita);
		setNombreProfesional(nombreProfesional);
		
		}

	public static final CitaDomain crear(final UUID id, final DatosServicioCitaDomain datosServicioCita, final FechaCitaDomain fecha, 
			 final EstadoCitaDomain estadoCita, final NombreCompletoDomain nombreProfesional) {
		return new CitaDomain(id, datosServicioCita, fecha ,estadoCita, nombreProfesional);
	}

	public final UUID getId() {
		return id;
	}

	public final DatosServicioCitaDomain getDatosServicioCita() {
		return datosServicioCita;
	}

	public final FechaCitaDomain getFecha() {
		return fecha;
	}


	public final EstadoCitaDomain getEstadoCita() {
		return estadoCita;
	}

	
	public final NombreCompletoDomain getNombreProfesional() {
		return nombreProfesional;
	}
	
	

	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}

	private final void setDatosServicioCita(final DatosServicioCitaDomain datosServicioCita) {
		this.datosServicioCita = UtilObjeto.obtenerValorDefecto(datosServicioCita, new DatosServicioCitaDomain());
	}

	private final void setFecha(final FechaCitaDomain fecha) {
		this.fecha = UtilObjeto.obtenerValorDefecto(fecha, new FechaCitaDomain());
	}

	private final void setEstadoCita(final EstadoCitaDomain estadoCita) {
		this.estadoCita = UtilObjeto.obtenerValorDefecto(estadoCita, new EstadoCitaDomain());
	}

	private final void setNombreProfesional(NombreCompletoDomain nombreProfesional) {
		this.nombreProfesional = UtilObjeto.obtenerValorDefecto(nombreProfesional, new NombreCompletoDomain());
	}
	
}
	