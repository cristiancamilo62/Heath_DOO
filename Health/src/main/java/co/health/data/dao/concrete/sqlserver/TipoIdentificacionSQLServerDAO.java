package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.crosscutting.exception.concrete.DataHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.TipoIdentificacionEntity;

public class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void registrar(final TipoIdentificacionEntity tipoIdentificacion) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO TipoIdentificacion (id_tipoIdentificacion, nombre, codigo ) ");
		sentencia.append("VALUES (?,?,?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, tipoIdentificacion.getId());
			sentenciaPreparada.setString(2, tipoIdentificacion.getCodigo());
			sentenciaPreparada.setString(3, tipoIdentificacion.getNombre());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		} 
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity tipoIdentificacion) {
		
		StringBuilder sentencia =  prepararSentenciaModificar(tipoIdentificacion);
		
		try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ){
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000178);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000179);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000178);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000180);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}
	@Override
	public final void eliminar(final UUID id) {
		
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM TipoIdentificacion WHERE id_tipoIdentificacion = ?");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
		
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000036);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000035);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000036);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000037);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("SELECT  id_tipoIdentificacion, codigo, nombre ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id_tipoIdentificacion = ? ");
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
	try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
		
		sentenciaPreparada.setObject(1, id);
		
		resultado = ejecutarConsultaPorId(sentenciaPreparada);
	}
		catch (final DataHealthException excepcion) {
		throw excepcion;
	}
	catch (final SQLException excepcion) {
		throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030),
				CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000031),excepcion);
	}
	catch (final Exception excepcion) {
		throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030),
				CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000032),excepcion);
	}
	return resultado;
	}
	
	private  final Optional<TipoIdentificacionEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		try (final var resultados = sentenciaPreparada.executeQuery() ){
			if(resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear
						(UUID.fromString(resultados.getObject("id_tipoIdentificacion").toString()), resultados.getString("codigo"),
								resultados.getString("nombre"));
			resultado = Optional.of(tipoIdentificacionEntity);
				
			}
		}catch (final SQLException excepcion) {
			throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000033),excepcion);
		} catch (final Exception excepcion) {
			throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000034),excepcion);
		}
		
		
		return resultado;
	}
	
	
	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity tipoIdentificacion) {

	    final var parametros = new ArrayList<Object>();
	    final String sentencia = formarSentenciaConsulta(tipoIdentificacion, parametros);
	    try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
	        colocarParametrosConsulta(sentenciaPreparada, parametros);
	        return ejecutarConsulta(sentenciaPreparada);

	    } catch (final DataHealthException excepcion) {
	        throw excepcion;
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000031);
	        throw DataHealthException.crear(mensajeUsuario,mensajeTecnico, excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000032);
	        throw DataHealthException.crear(mensajeUsuario,mensajeTecnico, excepcion);
	    }

	}
	private final String formarSentenciaConsulta(final TipoIdentificacionEntity tipoIdentificacion, final List<Object> parametros) {
	    final StringBuilder sentencia = new StringBuilder();
	    String operadorCondicional = " WHERE";

	    sentencia.append("SELECT id_tipoIdentificacion, codigo, nombre ");
	    sentencia.append("FROM TipoIdentificacion");

	    if (!UtilObjeto.esNulo(tipoIdentificacion)) {

	        if (!UtilObjeto.esNulo(tipoIdentificacion.getId())) {
	            sentencia.append(operadorCondicional).append(" id_tipoIdentificacion = ? ");
	            operadorCondicional = "AND";

	            parametros.add(tipoIdentificacion.getId());
	        }

	        if (!UtilTexto.estaVacio(tipoIdentificacion.getCodigo())) {
	            sentencia.append(operadorCondicional).append(" nombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(tipoIdentificacion.getCodigo());
	        }
	        if (!UtilTexto.estaVacio(tipoIdentificacion.getNombre())) {
	            sentencia.append(operadorCondicional).append(" codigo = ?");
	            parametros.add(tipoIdentificacion.getNombre());
	        }

	    }
	    return sentencia.toString();
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
	    try {
	        for (int indice = 0; indice < parametros.size(); indice++) {
	            sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000181);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico, excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000182);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico, excepcion);
	    }
	}
	private final List<TipoIdentificacionEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<TipoIdentificacionEntity>();
		try (final var resultados = sentenciaPreparada.executeQuery() ){
			while (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear
						(UUID.fromString(resultados.getObject("id_tipoIdentificacion").toString()),
								resultados.getString("codigo"),resultados.getString("nombre"));
				listaResultados.add(tipoIdentificacionEntity);
			}
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000033);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000034);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		return listaResultados;
	}
	private static final StringBuilder prepararSentenciaModificar(final TipoIdentificacionEntity tipoIdentificacion) {
		
		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional = " SET";
		
		sentencia.append("UPDATE TipoIdentificacion");
		
		if(!UtilObjeto.esNulo(tipoIdentificacion)) {
					
					if(!UtilTexto.estaVacio(tipoIdentificacion.getCodigo())) {
						sentencia.append(operadorCondicional).append(" codigo = ? ");
			operadorCondicional = ",";
		}
		if(!UtilTexto.estaVacio(tipoIdentificacion.getNombre())) {
			sentencia.append(operadorCondicional).append(" nombre = ? ");
				}
				
			}
		return sentencia;
		}

}
