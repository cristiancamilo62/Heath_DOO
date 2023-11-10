package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.support.TipoServicioEntity;
import co.health.service.domain.profesionalsalud.support.TipoServicioDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class TipoServicioEntityMapper implements EntityMapper<TipoServicioEntity, TipoServicioDomain>{

	
	private static final EntityMapper<TipoServicioEntity, TipoServicioDomain> instancia = new TipoServicioEntityMapper();
	
	private TipoServicioEntityMapper() {
		super();
	}
	
	@Override
	public final TipoServicioDomain toDomain(final TipoServicioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000231);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoServicioDomain.crear(entity.getId(), entity.getNombre());
	}

	@Override
	public final TipoServicioEntity toEntity(final TipoServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000232);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoServicioEntity.crear(domain.getId(), domain.getNombre());
	}
	
	public static final TipoServicioDomain convertToDomain(final TipoServicioEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final TipoServicioEntity convertToEntity(final TipoServicioDomain domain) {
		return instancia.toEntity(domain);
	}

}
