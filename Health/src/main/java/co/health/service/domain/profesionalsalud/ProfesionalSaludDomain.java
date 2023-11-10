package co.health.service.domain.profesionalsalud;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.paciente.support.NombreCompletoDomain;
import co.health.service.domain.profesionalsalud.support.TipoServicioDomain;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class ProfesionalSaludDomain {
	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoDomain nombreCompletoProfesionalSalud;
	private TipoServicioDomain servicio;
	private TipoIdentificacionDomain tipoIdentificacion;

	
	public ProfesionalSaludDomain() {
		setId(UtilUuid.DEFAULT_UUID);
		setNumeroIdentificacion(UtilTexto.VACIO);
		setNombreCompletoProfesionalSalud(new NombreCompletoDomain());
		setServicio(new TipoServicioDomain());
		setTipoIdentificacion(new TipoIdentificacionDomain());
	}
	
	private ProfesionalSaludDomain(final UUID id, final String numeroIdentificacion,
			final NombreCompletoDomain nombreCompletoProfesionalSalud, final TipoServicioDomain servicio,
			final TipoIdentificacionDomain tipoIdentificacion) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoProfesionalSalud(nombreCompletoProfesionalSalud);
		setServicio(servicio);
		setTipoIdentificacion(tipoIdentificacion);
	}

	public static final ProfesionalSaludDomain crear(final UUID id, final String numeroIdentificacion,
			final NombreCompletoDomain nombreCompletoProfesionalSalud, final TipoServicioDomain servicio,
			final TipoIdentificacionDomain tipoIdentificacion) {
		return new ProfesionalSaludDomain(id, numeroIdentificacion, nombreCompletoProfesionalSalud, servicio, tipoIdentificacion);
	}
	
	public static final ProfesionalSaludDomain crear() {
		return new ProfesionalSaludDomain();
	}

	public final UUID getId() {
		return id;
	}


	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	public final NombreCompletoDomain getNombreCompletoProfesionalSalud() {
		return nombreCompletoProfesionalSalud;
	}

	public final TipoServicioDomain getServicio() {
		return servicio;
	}


	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}


	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.aplicarTrim(numeroIdentificacion);
	}


	private final void setNombreCompletoProfesionalSalud(
			final NombreCompletoDomain nombreCompletoProfesionalSalud) {
		this.nombreCompletoProfesionalSalud = UtilObjeto.obtenerValorDefecto(nombreCompletoProfesionalSalud,
				new NombreCompletoDomain());
	}

	private final void setServicio(final TipoServicioDomain servicio) {
		this.servicio = UtilObjeto.obtenerValorDefecto(servicio, new TipoServicioDomain());
	}


	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefecto(tipoIdentificacion, new TipoIdentificacionDomain());
	}


}
