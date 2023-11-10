package co.health.data.entity.support;

import java.util.UUID;

public final class TipoServicioEntity {
	
	private UUID id;
	private String nombre;
	
	
	private TipoServicioEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static final TipoServicioEntity crear(final UUID id, final String nombre) {
		return new TipoServicioEntity(id, nombre);
	}

	public final UUID getId() {
		return id;
	}


	public final String getNombre() {
		return nombre;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
