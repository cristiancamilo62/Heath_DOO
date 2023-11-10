package co.health.data.entity;

import java.util.UUID;

public class EpsEntity {
	
	private UUID id;
	private String nombre;
	
	private EpsEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EpsEntity crear(final UUID id, final String nombre) {
		return new EpsEntity(id, nombre);
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
