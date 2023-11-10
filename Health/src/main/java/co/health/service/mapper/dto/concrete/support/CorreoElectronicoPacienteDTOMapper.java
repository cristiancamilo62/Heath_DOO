package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.CorreoElectronicoPacienteDomain;
import co.health.service.dto.support.CorreoElectronicoPacienteDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class CorreoElectronicoPacienteDTOMapper implements DTOMapper<CorreoElectronicoPacienteDTO, CorreoElectronicoPacienteDomain> {

	private static final DTOMapper<CorreoElectronicoPacienteDTO, CorreoElectronicoPacienteDomain> instancia = new CorreoElectronicoPacienteDTOMapper();
	
	private CorreoElectronicoPacienteDTOMapper() {
		super();
	}
	
	
	@Override
	public CorreoElectronicoPacienteDomain toDomain(CorreoElectronicoPacienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000111));
		
		}
		return CorreoElectronicoPacienteDomain.crear(dto.getCorreoElectronico(), false);
	}

	@Override
	public CorreoElectronicoPacienteDTO toDTO(CorreoElectronicoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000112));
		
		}
		return CorreoElectronicoPacienteDTO.crear(domain.getCorreoElectronico(), false);

	}
	
	public static final CorreoElectronicoPacienteDomain convertToDomain(final CorreoElectronicoPacienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final CorreoElectronicoPacienteDTO convertToDTO(final CorreoElectronicoPacienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
