package co.health.data.entity;

import java.util.UUID;

public class EstadoCitaEntity {
	
	private UUID id;
	private String nombre;
	
	private EstadoCitaEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCitaEntity crear(final UUID id, final String nombre) {
		return new EstadoCitaEntity(id, nombre);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}
	

}
