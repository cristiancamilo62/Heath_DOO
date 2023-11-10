package co.health.service.mapper.dto.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.estadocita.EstadoCitaDomain;
import co.health.service.dto.EstadoCitaDTO;
import co.health.service.mapper.dto.DTOMapper;

public class EstadoCitaDTOMapper implements DTOMapper<EstadoCitaDTO, EstadoCitaDomain>{
	
	private static final DTOMapper<EstadoCitaDTO, EstadoCitaDomain> instancia = new EstadoCitaDTOMapper();
	
	private EstadoCitaDTOMapper() {
		super();
	}

	@Override
	public final EstadoCitaDomain toDomain(final EstadoCitaDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return EstadoCitaDomain.crear(dto.getId(),dto.getNombre());
	}
	
	@Override
	public final EstadoCitaDTO toDTO(final EstadoCitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return EstadoCitaDTO.crear(domain.getId(),domain.getNombre());
	}
	
	public static final EstadoCitaDomain convertToDomain(final EstadoCitaDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final EstadoCitaDTO convertToEntity(final EstadoCitaDomain domain) {
		return instancia.toDTO(domain);
	}

}
