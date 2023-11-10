package co.health.service.facade.concrete.paciente;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.concrete.paciente.ModificarPacienteUseCase;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.PacienteValidationRule;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.Facade;
import co.health.service.mapper.dto.concrete.PacienteDTOMapper;

public final class ModificarPacienteFacade implements Facade<PacienteDTO>{
	
	@Override
	public final void execute(final PacienteDTO dto) {
		final PacienteDomain domain = PacienteDTOMapper.convertToDomain(dto);
		PacienteValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new ModificarPacienteUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final HealthException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000211);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000212);
			throw ServiceHealthException.crear(mensajeUsuario,mensajeTecnico,exception);
		}
		finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
