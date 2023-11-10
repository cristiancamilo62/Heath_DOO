package co.health.service.mapper.dto.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.profesionalsalud.ProfesionalSaludDomain;
import co.health.service.dto.ProfesionalSaludDTO;
import co.health.service.mapper.dto.DTOMapper;
import co.health.service.mapper.dto.concrete.support.NombreCompletoDTOMapper;
import co.health.service.mapper.dto.concrete.support.TipoServicioDTOMapper;

public final class ProfesionalSaludDTOMapper implements DTOMapper<ProfesionalSaludDTO, ProfesionalSaludDomain>{

private static final DTOMapper<ProfesionalSaludDTO, ProfesionalSaludDomain> instancia = new ProfesionalSaludDTOMapper();
	
	private ProfesionalSaludDTOMapper() {
		super();
	}
	
	@Override
	public final ProfesionalSaludDomain toDomain(final ProfesionalSaludDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000219);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ProfesionalSaludDomain.crear(dto.getId(), dto.getNumeroIdentificacion(), NombreCompletoDTOMapper.convertToDomain(dto.getNombreCompletoProfesionalSalud()),
				TipoServicioDTOMapper.convertToDomain(dto.getServicio()),TipoIdentificacionDTOMapper.convertToDomain(dto.getTipoIdentificacion()));
	}

	@Override
	public final ProfesionalSaludDTO toDTO(final ProfesionalSaludDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000220);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ProfesionalSaludDTO.crear(domain.getId(), domain.getNumeroIdentificacion(), NombreCompletoDTOMapper.convertToDTO(domain.getNombreCompletoProfesionalSalud()),
				TipoServicioDTOMapper.convertToDTO(domain.getServicio()),TipoIdentificacionDTOMapper.convertToDTO(domain.getTipoIdentificacion()));
	}
	
	public static final ProfesionalSaludDomain convertToDomain(final ProfesionalSaludDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final ProfesionalSaludDTO convertToDTO(final ProfesionalSaludDomain domain) {
		return instancia.toDTO(domain);
	}
	
}
