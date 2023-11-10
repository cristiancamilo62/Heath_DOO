package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.profesionalsalud.support.TipoServicioDomain;
import co.health.service.dto.support.TipoServicioDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class TipoServicioDTOMapper implements DTOMapper<TipoServicioDTO, TipoServicioDomain>{

	private static final DTOMapper<TipoServicioDTO, TipoServicioDomain> instancia = new TipoServicioDTOMapper();
	
	private TipoServicioDTOMapper() {
		super();
	}
	
	@Override
	public final TipoServicioDomain toDomain(final TipoServicioDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000215);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoServicioDomain.crear(dto.getId(), dto.getNombre());
	}

	@Override
	public final TipoServicioDTO toDTO(final TipoServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000216);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoServicioDTO.crear(domain.getId(), domain.getNombre());
	}
	
	public static final TipoServicioDomain convertToDomain(final TipoServicioDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final TipoServicioDTO convertToDTO(final TipoServicioDomain domain) {
		return instancia.toDTO(domain);
	}

	
}
