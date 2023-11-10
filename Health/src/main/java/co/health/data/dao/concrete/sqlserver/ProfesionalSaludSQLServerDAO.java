package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.health.crosscutting.exception.concrete.DataHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;
import co.health.data.dao.ProfesionalSaludDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.ProfesionalSaludEntity;
import co.health.data.entity.support.NombreCompletoEntity;
import co.health.data.entity.support.TipoServicioEntity;

public final class ProfesionalSaludSQLServerDAO extends SQLDAO implements ProfesionalSaludDAO{

	public ProfesionalSaludSQLServerDAO(Connection conexion) {
		super(conexion);
	}
	
	

	@Override
	public List<ProfesionalSaludEntity> consultar(final ProfesionalSaludEntity profesional) {
		final var parametros = new ArrayList<Object>();

	    final String sentencia = formarSentenciaConsulta(profesional, parametros);

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
	        colocarParametrosConsulta(sentenciaPreparada, parametros);
	       
	        return ejecutarConsulta(sentenciaPreparada);

	    } catch (final DataHealthException excepcion) {
	        throw excepcion;
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000171);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000172);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000171);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000173);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }

	}
	
	private final String formarSentenciaConsulta(final ProfesionalSaludEntity profesional, final List<Object> parametros) {
		
		final var sentencia = new StringBuilder();
	    String operadorCondicional = " WHERE";
	    
	    sentencia.append("SELECT P.identificacion, P.primerNombre, T.nombre  FROM Profesional P JOIN TipoServicio T ");
	    sentencia.append("ON P.id_servicio = T.id_servicio ");
	    
	    if(!UtilObjeto.esNulo(profesional)) {
	    	if ((profesional.getId()) != UtilUuid.DEFAULT_UUID) {
	            sentencia.append(operadorCondicional).append(" id_profesional = ? ");
	            operadorCondicional = "AND";
	            parametros.add(profesional.getId());
	    	}
	    	if(!UtilTexto.estaVacio(profesional.getNumeroIdentificacion())) {
	    		 sentencia.append(operadorCondicional).append(" identificacion = ? ");
	            operadorCondicional = "AND";
	            parametros.add(profesional.getId());
	    	}
	    	if(!UtilTexto.estaVacio(profesional.getNombreCompletoProfesionalSalud().getPrimerNombre())) {
	    		 sentencia.append(operadorCondicional).append(" primerNombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(profesional.getNombreCompletoProfesionalSalud().getPrimerNombre());
	    	}
	    	if(!UtilTexto.estaVacio(profesional.getServicio().getNombre())) {
	    		 sentencia.append(operadorCondicional).append(" nombre = ? ");
	            parametros.add(profesional.getServicio().getNombre());
	    	}
	    }
	    System.out.println(sentencia.toString());
	    return sentencia.toString();
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
	    try {
	        for (int indice = 0; indice < parametros.size(); indice++) {
	            sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
	            System.out.println(parametros.get(indice));
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000171);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000174);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000171);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000175);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	}
	
	private final List<ProfesionalSaludEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada) {
	    final var listaResultados = new ArrayList<ProfesionalSaludEntity>();

	    try (final var resultados = sentenciaPreparada.executeQuery()) {
	        while (resultados.next()) {
	        	
	        	var nombreCompletoProfesionalEntity = NombreCompletoEntity.crear(resultados.getString("primerNombre"),
						null,null, null);
	        	
	        	var servicio = TipoServicioEntity.crear(null, resultados.getString("nombre"));
	        	
	        	var profesionalSalud = ProfesionalSaludEntity.crear(null,
	        			resultados.getString("identificacion"), nombreCompletoProfesionalEntity, servicio, null);
	       

	            listaResultados.add(profesionalSalud);
	            
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000171);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000176);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000171);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000177);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	    return listaResultados;
	}

}
