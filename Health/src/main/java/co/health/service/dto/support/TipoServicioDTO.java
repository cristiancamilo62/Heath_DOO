package co.health.service.dto.support;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;
import co.health.service.domain.profesionalsalud.support.TipoServicioDomain;

public class TipoServicioDTO {
	
	private UUID id;
	private String nombre;
	
	public TipoServicioDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setNombre(UtilTexto.VACIO);
	}
	
	
	private TipoServicioDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static final TipoServicioDTO crear(final UUID id, final String nombre) {
		return new TipoServicioDTO(id, nombre);
	}
	
	public static final TipoServicioDomain crear() {
		return new TipoServicioDomain();
	}

	public final UUID getId() {
		return id;
	}


	public final String getNombre() {
		return nombre;
	}


	public final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}


	public final void setNombre(final String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
	}

}
