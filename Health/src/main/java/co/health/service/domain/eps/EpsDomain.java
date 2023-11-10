package co.health.service.domain.eps;

import java.util.UUID;

import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;


public final class EpsDomain {
	
	private UUID id;
	private String nombre;
	
	public EpsDomain() {
		setId(UtilUuid.DEFAULT_UUID);
		setNombre(UtilTexto.VACIO);
	}
	
	private EpsDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EpsDomain crear(final UUID id, final String nombre) {
		return new EpsDomain(id, nombre);
	}
	
	public static final EpsDomain crear() {
		return new EpsDomain();
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

}
