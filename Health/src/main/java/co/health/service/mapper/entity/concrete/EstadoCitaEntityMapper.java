package co.health.service.mapper.entity.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.CitaEntity;
import co.health.data.entity.EstadoCitaEntity;
import co.health.data.entity.PacienteEntity;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.domain.estadocita.EstadoCitaDomain;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.mapper.entity.EntityMapper;

public class EstadoCitaEntityMapper implements EntityMapper<EstadoCitaEntity, EstadoCitaDomain>{

	private static final EntityMapper<EstadoCitaEntity, EstadoCitaDomain> instancia = new EstadoCitaEntityMapper();
	
	private EstadoCitaEntityMapper() {
		super();
	}
	
	@Override
	public final EstadoCitaDomain toDomain(final EstadoCitaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el EstadoCitaEntity es nulo en toDomain de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return EstadoCitaDomain.crear(entity.getId(),entity.getNombre());
	}
	
	@Override
	public final EstadoCitaEntity toEntity(final EstadoCitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el CitaEntity es nulo en toEntity de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return EstadoCitaEntity.crear(domain.getId(),domain.getNombre());
	} 
	
	public static final EstadoCitaDomain convertToDomain(final EstadoCitaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final EstadoCitaEntity convertToEntity(final EstadoCitaDomain domain) {
		return instancia.toEntity(domain);
	}
}
