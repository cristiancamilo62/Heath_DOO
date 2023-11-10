package co.health.service.mapper.dto.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.agenda.AgendaDomain;
import co.health.service.dto.AgendaDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class AgendaDTOMapper implements DTOMapper<AgendaDTO, AgendaDomain> {
	
private static final DTOMapper<AgendaDTO, AgendaDomain> instancia = new AgendaDTOMapper();
	
	private AgendaDTOMapper() {
		super();
	}
	
	
	@Override
	public final AgendaDomain toDomain(final AgendaDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000217);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return AgendaDomain.crear(dto.getId(), ProfesionalSaludDTOMapper.convertToDomain(dto.getProfesionalSalud()),
				dto.getPrecioServicio(), dto.getFechaInicio(), dto.getFechaFin());
	}

	@Override
	public final AgendaDTO toDTO(final AgendaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000218);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return AgendaDTO.crear(domain.getId(), ProfesionalSaludDTOMapper.convertToDTO(domain.getProfesionalSalud()),
				domain.getPrecioServicio(), domain.getFechaInicio(), domain.getFechaFin());
	}
	
	public static final AgendaDomain convertToDomain(final AgendaDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final AgendaDTO convertToEntity(final AgendaDomain domain) {
		return instancia.toDTO(domain);
	}

}
