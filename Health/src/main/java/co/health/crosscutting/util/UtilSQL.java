package co.health.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.health.crosscutting.exception.concrete.CrosscuttingHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;

public final class UtilSQL {
	
	private UtilSQL(){
		super();
	}
	public static final boolean conexionAbierta(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000007);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			return  !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000005);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000006);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}
	
	public static final void cerrarConexion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000008);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000009);
				throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.close();
		} catch (final CrosscuttingHealthException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000010);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000011);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000012);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000013);
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			if(!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000014);
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.setAutoCommit(false);
		} catch (final CrosscuttingHealthException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000015);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000016);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	public static final void confirmarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000017);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000018);
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000019);
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.commit();
		} catch (final CrosscuttingHealthException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000020);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000021);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	public static final void cancelarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000022);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000023);
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000024);
				throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.rollback();
		} catch (final CrosscuttingHealthException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000025);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000026);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}

}
