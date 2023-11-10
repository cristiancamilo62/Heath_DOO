package co.health.data.dao.base;

import java.sql.Connection;

import co.health.crosscutting.exception.concrete.CrosscuttingHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilSQL;

public class SQLDAO {
	
	private Connection conexion;

	protected SQLDAO (final Connection conexion) {
		setConexion(conexion);
	}

	private final void setConexion(Connection conexion) {
		if(!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000044);
			throw CrosscuttingHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.conexion = conexion;
	}


	protected final Connection getConexion() {
		return conexion;
	}
	
	
}
