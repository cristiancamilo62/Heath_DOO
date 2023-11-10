package co.health.data.dao.daofactory;

import co.health.crosscutting.exception.concrete.CrosscuttingHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.AgendaDAO;
import co.health.data.dao.CitaDAO;
import co.health.data.dao.EstadoCitaDAO;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.ProfesionalSaludDAO;
import co.health.data.dao.RegimenAfiliacionDAO;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.daofactory.concrete.SQLServerDAOFactory;

public abstract class DAOFactory {
	
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factoria) {
		switch (factoria) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		case POSTGRESQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000038);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		case MYSQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000039);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		case ORACLE: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000040);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		default:
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);

		}
	}
	
	protected abstract void abrirconexion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransacion();
	public abstract PacienteDAO obtenerPacienteDAO();
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();
	public abstract CitaDAO obtenerCitaDAO();
	public abstract EstadoCitaDAO obtenerEstadoCitaDAO();
	public abstract RegimenAfiliacionDAO obtenerRegimenAfiliacionDAO(); 
	public abstract AgendaDAO obtenerAgendaDAO();
	public abstract ProfesionalSaludDAO obtenerProfesionalSaludDAO();
	

}
