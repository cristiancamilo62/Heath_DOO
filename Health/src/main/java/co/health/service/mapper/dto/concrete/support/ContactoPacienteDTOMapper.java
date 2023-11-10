package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.ContactoPacienteDomain;
import co.health.service.dto.support.ContactoPacienteDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class ContactoPacienteDTOMapper implements DTOMapper<ContactoPacienteDTO, ContactoPacienteDomain>{

	private static final DTOMapper<ContactoPacienteDTO, ContactoPacienteDomain> instancia = new ContactoPacienteDTOMapper();
	
	private ContactoPacienteDTOMapper() {
		super();
	}
	
	@Override
	public ContactoPacienteDomain toDomain(ContactoPacienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000109));
		
		}
		return ContactoPacienteDomain.crear(CorreoElectronicoPacienteDTOMapper.convertToDomain(dto.getCorreoElectronicoPaciente()),
				NumeroTelefonoPacienteDTOMapper.convertToDomain(dto.getNumeroTelefonoPaciente()),dto.getContrasenia());
	}

	@Override
	public final  ContactoPacienteDTO toDTO(final ContactoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000110));
		
		}
		return ContactoPacienteDTO.crear(CorreoElectronicoPacienteDTOMapper.convertToDTO(domain.getCorreoElectronicoPaciente()),
				NumeroTelefonoPacienteDTOMapper.convertToDTO(domain.getNumeroTelefonoPaciente()),domain.getContrasenia());
	}
	
	public static final ContactoPacienteDomain convertToDomain(final ContactoPacienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final ContactoPacienteDTO convertToDTO(final ContactoPacienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
