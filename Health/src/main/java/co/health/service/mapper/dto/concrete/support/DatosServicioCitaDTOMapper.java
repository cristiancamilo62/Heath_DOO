package co.health.service.mapper.dto.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.cita.support.DatosServicioCitaDomain;
import co.health.service.dto.support.DatosServicioCitaDTO;
import co.health.service.mapper.dto.DTOMapper;

public class DatosServicioCitaDTOMapper implements DTOMapper<DatosServicioCitaDTO, DatosServicioCitaDomain>{
	
	private static final DTOMapper<DatosServicioCitaDTO, DatosServicioCitaDomain> instancia = new DatosServicioCitaDTOMapper();
	
	private DatosServicioCitaDTOMapper() {
		super();
	}
	@Override
	public DatosServicioCitaDomain toDomain(DatosServicioCitaDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000120));
		
		}
		return DatosServicioCitaDomain.crear(dto.getCodigo(),dto.getConsultorio(),dto.getNombreServicio(),
				dto.getPrecio());
	}
	
	@Override
	public final DatosServicioCitaDTO toDTO(final DatosServicioCitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000121));
		
		}
		return DatosServicioCitaDTO.crear(domain.getCodigo(),domain.getConsultorio(),domain.getNombreServicio(),
				domain.getPrecio());
	}
	
	public static final DatosServicioCitaDomain convertToDomain(final DatosServicioCitaDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final DatosServicioCitaDTO convertToEntity(final DatosServicioCitaDomain domain) {
		return instancia.toDTO(domain);
	}



}
