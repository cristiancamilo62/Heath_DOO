package co.health.service.businesslogic.concrete.paciente;

import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.UseCase;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.mapper.entity.concrete.PacienteEntityMapper;

public final class EliminarPacienteUseCase implements UseCase<PacienteDomain>{

	private DAOFactory factoria;

	public EliminarPacienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(PacienteDomain domain) {
		
		validarExistenciaPacienteAEliminar(domain.getId());
		
		eliminarCliente(domain);
		
	}
	
	private void eliminarCliente(final PacienteDomain domain) {
		var entity = PacienteEntityMapper.convertToEntity(domain);
		getPacienteDAO().eliminar(entity.getId());
	}

	private final void validarExistenciaPacienteAEliminar(final UUID id) {
	    var entity = crearPacienteEntityIdAEliminar(id);
	    var resultados = getPacienteDAO().consultarPorId(entity.getId());
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el Paciente que se desea eliminar";
	        throw ServiceHealthException.crear(mensajeUsuario);
	    }
	}

	private PacienteEntity crearPacienteEntityIdAEliminar(final UUID id) {
	    var domain = PacienteDomain.crear(id, null, null, null, null, null, null);
	    return PacienteEntityMapper.convertToEntity(domain);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final PacienteDAO getPacienteDAO() {
		return getFactoria().obtenerPacienteDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000186);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000187);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
