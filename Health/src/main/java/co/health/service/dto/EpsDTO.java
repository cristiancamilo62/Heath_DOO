package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;

public final class EpsDTO {

	private UUID id;
	private String nombre;
	
	public EpsDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setNombre(UtilTexto.VACIO);
	}
	
	public EpsDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EpsDTO crear(final UUID id, final String nombre) {
		return new EpsDTO(id, nombre);
	}
	
	public static final EpsDTO crear() {
		return new EpsDTO();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(final String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
	}
	
	

	
}
