package co.health.service.mapper.dto.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.health.service.dto.CitaDTO;
import co.health.service.dto.TipoIdentificacionDTO;
import co.health.service.dto.support.DatosServicioCitaDTO;
import co.health.service.mapper.dto.DTOMapper;
import co.health.service.mapper.dto.concrete.support.DatosServicioCitaDTOMapper;
import co.health.service.mapper.dto.concrete.support.FechaCitaDTOMapper;
import co.health.service.mapper.dto.concrete.support.NombreCompletoDTOMapper;

public final class CitaDTOMapper implements DTOMapper<CitaDTO, CitaDomain>{
	
	private static final DTOMapper<CitaDTO, CitaDomain> instancia = new CitaDTOMapper();
	
	private CitaDTOMapper() {
		super();
	}

	@Override
	public final CitaDomain toDomain(final CitaDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000107));
		}
		return CitaDomain.crear(dto.getId(),DatosServicioCitaDTOMapper.convertToDomain(dto.getDatosServicioCita()),
				FechaCitaDTOMapper.convertToDomain(dto.getFecha()),EstadoCitaDTOMapper.convertToDomain(dto.getEstadoCita()),
				NombreCompletoDTOMapper.convertToDomain(dto.getNombreProfesional()));
	}
	
	@Override
	public final CitaDTO toDTO(final CitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004), 
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000108));
		}
		return CitaDTO.crear(domain.getId(),DatosServicioCitaDTOMapper.convertToEntity(domain.getDatosServicioCita()),
				FechaCitaDTOMapper.convertToEntity(domain.getFecha()),EstadoCitaDTOMapper.convertToEntity(domain.getEstadoCita()),
				NombreCompletoDTOMapper.convertToDTO(domain.getNombreProfesional()));
	}
	
	public static final CitaDomain convertToDomain(final CitaDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CitaDTO convertToEntity(final CitaDomain domain) {
		return instancia.toDTO(domain);
	}

}
