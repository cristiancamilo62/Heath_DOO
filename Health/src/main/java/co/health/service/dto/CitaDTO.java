package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.dto.support.DatosServicioCitaDTO;
import co.health.service.dto.support.FechaCitaDTO;
import co.health.service.dto.support.NombreCompletoDTO;

public class CitaDTO {
	private UUID id;
	private DatosServicioCitaDTO datosServicioCita;
	private FechaCitaDTO fecha;
	private EstadoCitaDTO estadoCita;
	private NombreCompletoDTO nombreProfesional;
	
	
	public CitaDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setDatosServicioCita(new DatosServicioCitaDTO());
		setFecha(new FechaCitaDTO());
		setEstadoCita(new EstadoCitaDTO());
		setNombreProfesional(new NombreCompletoDTO());
		}
	public CitaDTO(final UUID id, final DatosServicioCitaDTO datosServicioCita, final FechaCitaDTO fecha,
			 final EstadoCitaDTO estadoCita, final NombreCompletoDTO nombreProfesional) {
		setId(id);
		setDatosServicioCita(datosServicioCita);
		setFecha(fecha);
		setEstadoCita(estadoCita);
		setNombreProfesional(nombreProfesional);		
	}

	public static final CitaDTO crear(final UUID id, final DatosServicioCitaDTO datosServicioCita, final FechaCitaDTO fecha, 
			 final EstadoCitaDTO estadoCita, final NombreCompletoDTO nombreProfesional) {
		return new CitaDTO(id, datosServicioCita, fecha ,estadoCita, nombreProfesional);
	}
	
	public static final CitaDTO crear() {
		return new CitaDTO();
	}
	public final UUID getId() {
		return id;
	}

	public final DatosServicioCitaDTO getDatosServicioCita() {
		return datosServicioCita;
	}

	public final FechaCitaDTO getFecha() {
		return fecha;
	}


	public final EstadoCitaDTO getEstadoCita() {
		return estadoCita;
	}

	
	public final NombreCompletoDTO getNombreProfesional() {
		return nombreProfesional;
	}

	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}

	private final void setDatosServicioCita(final DatosServicioCitaDTO datosServicioCita) {
		this.datosServicioCita = datosServicioCita;
	}

	private final void setFecha(final FechaCitaDTO fecha) {
		this.fecha = fecha;
	}

	
	private final void setEstadoCita(final EstadoCitaDTO estadoCita) {
		this.estadoCita = estadoCita;
	}

	private final void setNombreProfesional(NombreCompletoDTO nombreProfesional) {
		this.nombreProfesional = nombreProfesional;
	}
	
	
	
	
}

