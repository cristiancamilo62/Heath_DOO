package co.health.service.mapper.dto.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.health.service.dto.TipoIdentificacionDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain>{
	
private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}

	@Override
	public final TipoIdentificacionDomain toDomain(final TipoIdentificacionDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027));
		}
		return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre());
	}

	@Override
	public final TipoIdentificacionDTO toDTO(final TipoIdentificacionDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028));
		}
		return TipoIdentificacionDTO.crear(domain.getId(), domain.getCodigo(), domain.getNombre());
	}
	
	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}

}
