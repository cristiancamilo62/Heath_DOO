package co.health.service.mapper.entity.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.AgendaEntity;
import co.health.service.domain.agenda.AgendaDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class AgendaEntityMapper implements EntityMapper<AgendaEntity, AgendaDomain>{

	private static final EntityMapper<AgendaEntity, AgendaDomain> instancia = new AgendaEntityMapper();
	
	private AgendaEntityMapper() {
		super();
	}
	
	
	@Override
	public final AgendaDomain toDomain(final AgendaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000233);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return AgendaDomain.crear(entity.getId(), ProfesionalSaludEntityMapper.convertToDomain(entity.getProfesionalSalud()),
				entity.getPrecioServicio(), entity.getFechaInicio(), entity.getFechaFin());
	}

	@Override
	public final AgendaEntity toEntity(final AgendaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000234);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return AgendaEntity.crear(domain.getId(), ProfesionalSaludEntityMapper.convertToEntity(domain.getProfesionalSalud()),
				domain.getPrecioServicio(), domain.getFechaInicio(), domain.getFechaFin());
	}
	
	public static final AgendaDomain convertToDomain(final AgendaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final AgendaEntity convertToEntity(final AgendaDomain domain) {
		return instancia.toEntity(domain);
	}

}
