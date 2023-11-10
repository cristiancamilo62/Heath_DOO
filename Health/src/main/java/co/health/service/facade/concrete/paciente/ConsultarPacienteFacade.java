package co.health.service.facade.concrete.paciente;


import java.util.ArrayList;
import java.util.List;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.concrete.paciente.ConsultarPacienteUseCase;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.PacienteValidationRule;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.FacadeRetorno;
import co.health.service.mapper.dto.concrete.PacienteDTOMapper;

public final class ConsultarPacienteFacade implements FacadeRetorno<PacienteDTO,List<PacienteEntity>> {

    @Override
    public List<PacienteEntity> executeRetorno(final PacienteDTO dto) {
        List<PacienteEntity> resultados = new ArrayList<>();

        final PacienteDomain domain = PacienteDTOMapper.convertToDomain(dto);
        PacienteValidationRule.ejecutarValidacion(domain);

        final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

        try {
            daoFactory.iniciarTransaccion();

            var useCase = new ConsultarPacienteUseCase(daoFactory);
            resultados = useCase.executeRetorno(domain);

            daoFactory.confirmarTransaccion();
        } catch (final HealthException exception) {
            daoFactory.cancelarTransacion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransacion();
            throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000097),
            		CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000098), exception);
        } finally {
            daoFactory.cerrarConexion();
        }
        return resultados;
    }

}
