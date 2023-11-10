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
import co.health.crosscutting.util.UtilLong;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;
import co.health.data.dao.AgendaDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.AgendaEntity;
import co.health.data.entity.ProfesionalSaludEntity;
import co.health.data.entity.support.NombreCompletoEntity;
import co.health.data.entity.support.TipoServicioEntity;

public class AgendaSQLServerDAO extends SQLDAO implements AgendaDAO{
	
	public AgendaSQLServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public final void registrarCita(final AgendaEntity agenda) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Agenda (id_Agenda,fechaInicio,fechaFin,precio,id_profesional) ");
		sentencia.append("VALUES (?,?,?,?,?)");
		
		try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, agenda.getId());
			sentenciaPreparada.setObject(2, agenda.getFechaInicio());
			sentenciaPreparada.setObject(3, agenda.getFechaFin());
			sentenciaPreparada.setLong(4, agenda.getPrecioServicio());
			sentenciaPreparada.setObject(5, conexionProfesional(agenda.getProfesionalSalud(), getConexion()));
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000141);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000142);
			DataHealthException.crear(mensajeUsuario,mensajeTecnico);
			
			
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000141);
			var mensajeTecnico =  CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000143);
			DataHealthException.crear(mensajeUsuario,mensajeTecnico);
			
		}
		
		
	}
	
	private final UUID conexionProfesional(final ProfesionalSaludEntity entity, final Connection conexion) {
		
		
	    StringBuilder sentencia = new StringBuilder();
	    sentencia.append("SELECT id_profesional FROM Profesional WHERE primerNombre = ? ");
	    
	    try (final var sentenciaPreparada = conexion.prepareStatement(sentencia.toString())) {
	    	sentenciaPreparada.setString(1, entity.getNombreCompletoProfesionalSalud().getPrimerNombre());
	    	return ejecutarConsultaProfesionalSalud(sentenciaPreparada);
	    } catch (final SQLException excepcion) {
			throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000132),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000133),excepcion);
		}
	}
	    
	private final UUID ejecutarConsultaProfesionalSalud(final PreparedStatement sentenciaPreparada) {
	    UUID profesional = null;

	    try (final var resultado = sentenciaPreparada.executeQuery()) {
	        if (resultado.next()) {
	        	profesional = UUID.fromString(resultado.getString("id_profesional"));
	        }
	    } catch (final SQLException excepcion) {
	    	var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000144);
			var mensajeTecnico =  CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000145);
	    	
	        throw DataHealthException.crear(mensajeUsuario,mensajeTecnico);
	    }
	    return profesional;
	}

	@Override
	public final void eliminarCita(final AgendaEntity agenda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<AgendaEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<AgendaEntity> consultar(final AgendaEntity agenda) {
		
		final var parametros = new ArrayList<Object>();

	    final String sentencia = formarSentenciaConsulta(agenda, parametros);
	    
	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
	        colocarParametrosConsulta(sentenciaPreparada, parametros);
	       
	        return ejecutarConsulta(sentenciaPreparada);

	    } catch (final DataHealthException excepcion) {
	        throw excepcion;
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000146);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000147);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario =CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000146);
	        var mensajeTecnico =CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000148);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	}
	
	private final String formarSentenciaConsulta(final AgendaEntity agenda, final List<Object> parametros) {
		

		StringBuilder sentencia = new StringBuilder();
	    String operadorCondicional = " WHERE";

	    sentencia.append(" SELECT A.id_Agenda, A.fechaInicio, A.fechaFin, A.precio, P.primerNombre, T.nombre ");
	    sentencia.append(" FROM Agenda A JOIN Profesional P ON A.id_profesional = P.id_profesional ");
	    sentencia.append(" JOIN TipoServicio T ON P.id_servicio = T.id_servicio ");

		
		if(!UtilObjeto.esNulo(agenda)) {
			if ((agenda.getId()) != UtilUuid.DEFAULT_UUID) {
	            sentencia.append(operadorCondicional).append(" id_Agenda = ? ");
	            operadorCondicional = "AND";
	            parametros.add(agenda.getId());
	        }
			if(!UtilObjeto.esNulo(agenda.getFechaInicio())) {
				sentencia.append(operadorCondicional).append(" fechaInicio = ? ");
	            operadorCondicional = "AND";
	            parametros.add(agenda.getFechaInicio());
			}
			if(!UtilObjeto.esNulo(agenda.getFechaFin())) {
				sentencia.append(operadorCondicional).append(" fechaFin = ? ");
	            operadorCondicional = "AND";
	            parametros.add(agenda.getFechaFin());
			}
			if(!UtilLong.esValorPorDefecto(agenda.getPrecioServicio())) {
				sentencia.append(operadorCondicional).append(" precio = ? ");
	            operadorCondicional = "AND";
	            parametros.add(agenda.getPrecioServicio());
			}
			if(!UtilTexto.estaVacio(agenda.getProfesionalSalud().getNombreCompletoProfesionalSalud().getPrimerNombre())) {
				sentencia.append(operadorCondicional).append(" primerNombre = ? ");
	            parametros.add(agenda.getProfesionalSalud().getNombreCompletoProfesionalSalud().getPrimerNombre());
			}
			if(!UtilObjeto.esNulo(agenda.getProfesionalSalud().getNombreCompletoProfesionalSalud().getPrimerNombre())) {
				sentencia.append(operadorCondicional).append(" A.id_profesional = ? ");
	            parametros.add(conexionProfesional(agenda.getProfesionalSalud(), getConexion()));
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
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000149);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000150);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000149);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000151);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	}
	private final List<AgendaEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada) {
	    final var listaResultados = new ArrayList<AgendaEntity>();

	    try (final var resultados = sentenciaPreparada.executeQuery()) {
	        while (resultados.next()) {
	        	
	        	var nombreCompletoProfesionalEntity = NombreCompletoEntity.crear(resultados.getString("primerNombre"),
						null,null, null);
	        	var servicio = TipoServicioEntity.crear(null, resultados.getString("nombre"));
	        	
	        	var profesionalSalud = ProfesionalSaludEntity.crear(null,
	        			null, nombreCompletoProfesionalEntity, servicio, null);
	        	
	        	var fechaInicio = resultados.getTimestamp("fechaInicio").toLocalDateTime();
                var fechaFin = resultados.getTimestamp("fechaFin").toLocalDateTime();

	        	
				var agendaEntity = AgendaEntity.crear(UUID.fromString(resultados.getObject("id_Agenda").toString()),
						profesionalSalud, resultados.getLong("precio"), fechaInicio, fechaFin);

	            listaResultados.add(agendaEntity);
	            
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario =CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000149);
	        var mensajeTecnico =CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000152);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000149);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000153);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	    return listaResultados;
	}

}
