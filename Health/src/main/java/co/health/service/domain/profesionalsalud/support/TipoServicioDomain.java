package co.health.service.domain.profesionalsalud.support;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;

public class TipoServicioDomain {
	
	private UUID id;
	private String nombre;
	
	public TipoServicioDomain() {
		setId(UtilUuid.DEFAULT_UUID);
		setNombre(UtilTexto.VACIO);
	}
	
	
	private TipoServicioDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static final TipoServicioDomain crear(final UUID id, final String nombre) {
		return new TipoServicioDomain(id, nombre);
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


	private final void setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}


	private final void setNombre(final String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
	}


}
