package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.EstadoCitaEntity;
import co.health.data.entity.support.FechaCitaEntity;
import co.health.service.domain.cita.support.FechaCitaDomain;
import co.health.service.domain.estadocita.EstadoCitaDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class FechaCitaEntityMapper implements EntityMapper<FechaCitaEntity, FechaCitaDomain>{

private static final EntityMapper<FechaCitaEntity, FechaCitaDomain> instancia = new FechaCitaEntityMapper();
	
	private FechaCitaEntityMapper() {
		super();
	}
	
	@Override
	public final FechaCitaDomain toDomain(final FechaCitaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000225);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return FechaCitaDomain.crear(entity.getFechaInicio(),entity.getFechaFin());
	}

	@Override
	public final FechaCitaEntity toEntity(final FechaCitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000226);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return FechaCitaEntity.crear(domain.getFechaInicio(),domain.getFechaFin());
	}
	
	public static final FechaCitaDomain convertToDomain(final FechaCitaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final FechaCitaEntity convertToEntity(final FechaCitaDomain domain) {
		return instancia.toEntity(domain);
	}
}
