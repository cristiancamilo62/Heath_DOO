package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.dto.support.NombreCompletoDTO;
import co.health.service.dto.support.TipoServicioDTO;

public final class ProfesionalSaludDTO {
	
	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoDTO nombreCompletoProfesionalSalud;
	private TipoServicioDTO servicio;
	private TipoIdentificacionDTO tipoIdentificacion;

	
	public ProfesionalSaludDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setNumeroIdentificacion(UtilTexto.VACIO);
		setNombreCompletoProfesionalSalud(new NombreCompletoDTO());
		setServicio(new TipoServicioDTO());
		setTipoIdentificacion(new TipoIdentificacionDTO());
	}
	
	private ProfesionalSaludDTO(final UUID id, final String numeroIdentificacion,
			final NombreCompletoDTO nombreCompletoProfesionalSalud, final TipoServicioDTO servicio,
			final TipoIdentificacionDTO tipoIdentificacion) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoProfesionalSalud(nombreCompletoProfesionalSalud);
		setServicio(servicio);
		setTipoIdentificacion(tipoIdentificacion);
	}

	public static final ProfesionalSaludDTO crear(final UUID id, final String numeroIdentificacion,
			final NombreCompletoDTO nombreCompletoProfesionalSalud, final TipoServicioDTO servicio,
			final TipoIdentificacionDTO tipoIdentificacion) {
		return new ProfesionalSaludDTO(id, numeroIdentificacion, nombreCompletoProfesionalSalud, servicio, tipoIdentificacion);
	}

	public static final ProfesionalSaludDTO crear() {
		return new ProfesionalSaludDTO();
	}
	public final UUID getId() {
		return id;
	}


	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	public final NombreCompletoDTO getNombreCompletoProfesionalSalud() {
		return nombreCompletoProfesionalSalud;
	}

	public final TipoServicioDTO getServicio() {
		return servicio;
	}


	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}


	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.aplicarTrim(numeroIdentificacion);
	}


	private final void setNombreCompletoProfesionalSalud(
			final NombreCompletoDTO nombreCompletoProfesionalSalud) {
		this.nombreCompletoProfesionalSalud = UtilObjeto.obtenerValorDefecto(nombreCompletoProfesionalSalud,
				new NombreCompletoDTO());
	}

	private final void setServicio(final TipoServicioDTO servicio) {
		this.servicio = UtilObjeto.obtenerValorDefecto(servicio, new TipoServicioDTO());
	}


	private final void setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefecto(tipoIdentificacion, new TipoIdentificacionDTO());
	}

}
