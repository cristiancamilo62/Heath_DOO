package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.NombreCompletoDomain;
import co.health.service.dto.support.NombreCompletoDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class NombreCompletoDTOMapper implements DTOMapper<NombreCompletoDTO, NombreCompletoDomain>{

	
	private static final DTOMapper<NombreCompletoDTO, NombreCompletoDomain> instancia = new NombreCompletoDTOMapper();
	
	private NombreCompletoDTOMapper() {
		super();
	}
	
	
	@Override
	public NombreCompletoDomain toDomain(NombreCompletoDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000115));
		
		}
		return NombreCompletoDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public final NombreCompletoDTO toDTO(final NombreCompletoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000116));
		
		}
		return NombreCompletoDTO.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoDomain convertToDomain(final NombreCompletoDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoDTO convertToDTO(final NombreCompletoDomain domain) {
		return instancia.toDTO(domain);
	}


}
