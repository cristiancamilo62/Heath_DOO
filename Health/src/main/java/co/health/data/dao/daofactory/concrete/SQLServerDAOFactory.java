package co.health.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.health.crosscutting.exception.concrete.DataHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilSQL;
import co.health.data.dao.AgendaDAO;
import co.health.data.dao.CitaDAO;
import co.health.data.dao.EstadoCitaDAO;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.ProfesionalSaludDAO;
import co.health.data.dao.RegimenAfiliacionDAO;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.concrete.sqlserver.AgendaSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.CitaSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.EstadoCitaSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.PacienteSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.ProfesionalSaludSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.RegimenAfiliacionSQLServerDAO;
import co.health.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.health.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory{
	
	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirconexion();
	}

	@Override
	protected final void abrirconexion() {
		try {
			var cadenaConexion = "jdbc:sqlserver://LAPTOP-CDUN2RLC\\SQLEXPRESS:1433;encrypt=false;databaseName=HEALTH;user=sa;password=12345678";
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000042);
			throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000043);
			throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
		}
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransacion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	@Override
	public PacienteDAO obtenerPacienteDAO() {
		return new PacienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionSQLServerDAO(conexion);
	}

	@Override
	public CitaDAO obtenerCitaDAO() {
		return new CitaSQLServerDAO(conexion);
	}

	@Override
	public EstadoCitaDAO obtenerEstadoCitaDAO() {
		return new EstadoCitaSQLServerDAO(conexion);
	}

	@Override
	public RegimenAfiliacionDAO obtenerRegimenAfiliacionDAO() {
		return new RegimenAfiliacionSQLServerDAO(conexion);
	}

	@Override
	public AgendaDAO obtenerAgendaDAO() {
		return  new AgendaSQLServerDAO(conexion);
	}

	@Override
	public ProfesionalSaludDAO obtenerProfesionalSaludDAO() {
		return new ProfesionalSaludSQLServerDAO(conexion);
	}

}
