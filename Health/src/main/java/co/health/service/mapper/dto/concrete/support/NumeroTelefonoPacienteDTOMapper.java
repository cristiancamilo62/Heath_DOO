package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.NumeroTelefonoPacienteDomain;
import co.health.service.dto.support.NumeroTelefonoPacienteDTO;
import co.health.service.mapper.dto.DTOMapper;

public final class NumeroTelefonoPacienteDTOMapper implements DTOMapper<NumeroTelefonoPacienteDTO, NumeroTelefonoPacienteDomain>{

	private static final DTOMapper<NumeroTelefonoPacienteDTO, NumeroTelefonoPacienteDomain> instancia = new NumeroTelefonoPacienteDTOMapper();
	
	private NumeroTelefonoPacienteDTOMapper() {
		super();
	}
	
	@Override
	public NumeroTelefonoPacienteDomain toDomain(NumeroTelefonoPacienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000117));
		
		}
		return NumeroTelefonoPacienteDomain.crear(dto.getNumeroTelefono(), false);
	}

	@Override
	public NumeroTelefonoPacienteDTO toDTO(NumeroTelefonoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000118));
		
		}
		return NumeroTelefonoPacienteDTO.crear(domain.getNumeroTelefono(), false);
	}
	
	public static final NumeroTelefonoPacienteDomain convertToDomain(final NumeroTelefonoPacienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NumeroTelefonoPacienteDTO convertToDTO(final NumeroTelefonoPacienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
