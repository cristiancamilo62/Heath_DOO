package co.health.service.domain.estadocita;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;

public class EstadoCitaDomain {
	private UUID id;
	private String nombre;
	
	public EstadoCitaDomain() {
		setId(UtilUuid.DEFAULT_UUID);
		setNombre(UtilTexto.VACIO);
	}
	
	private EstadoCitaDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCitaDomain crear(final UUID id, final String nombre) {
		return new EstadoCitaDomain(id, nombre);
	}

	public static final EstadoCitaDomain crear() {
		return new EstadoCitaDomain();
	}
	
	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}

	private final void setNombre(final String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}
}
