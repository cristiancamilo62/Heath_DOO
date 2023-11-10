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
import co.health.crosscutting.util.UtilDate;
import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.PacienteEntity;
import co.health.data.entity.TipoIdentificacionEntity;
import co.health.data.entity.support.ContactoPacienteEntity;
import co.health.data.entity.support.CorreoElectronicoPacienteEntity;
import co.health.data.entity.support.NombreCompletoEntity;

import org.mindrot.jbcrypt.BCrypt;
import co.health.data.entity.support.NombreCompletoPacienteEntity;

import co.health.data.entity.support.NumeroTelefonoPacienteEntity;


public final class PacienteSQLServerDAO extends SQLDAO implements PacienteDAO{

	public PacienteSQLServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public final void registar(final PacienteEntity paciente) {
		final StringBuilder sentencia = new StringBuilder();

	    sentencia.append("INSERT INTO Paciente (id_paciente, id_tipoIdentificacion,numeroIdentificacion, primerNombre, segundoNombre, primerApellido, "
	            + "segundoApellido, correoElectronico, correoElectronicoConfirmado, numeroTelefono, numeroTelefonoConfirmado, fechaNacimiento,estadoCuenta,contrasenia) ");
	    sentencia.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
	        sentenciaPreparada.setObject(1, paciente.getId());
	        sentenciaPreparada.setObject(2, conexionTipoIdentificacion(paciente.getTipoIdentificacion(), getConexion()));
	        sentenciaPreparada.setString(3, paciente.getNumeroIdentificacion());
	        sentenciaPreparada.setString(4, paciente.getNombreCompletoPaciente().getPrimerNombre());
	        sentenciaPreparada.setString(5, paciente.getNombreCompletoPaciente().getSegundoNombre());
	        sentenciaPreparada.setString(6, paciente.getNombreCompletoPaciente().getPrimerApellido());
	        sentenciaPreparada.setString(7, paciente.getNombreCompletoPaciente().getSegundoApellido());
	        sentenciaPreparada.setString(8, paciente.getContactoPaciente().getCorreoElectronicoPaciente().getCorreoElectronico());
	        sentenciaPreparada.setBoolean(9, paciente.getContactoPaciente().getCorreoElectronicoPaciente().isCorreoELectronicoConfirmado());
	        sentenciaPreparada.setString(10, paciente.getContactoPaciente().getNumeroTelefonoPaciente().getNumeroTelefono());
	        sentenciaPreparada.setBoolean(11, paciente.getContactoPaciente().getNumeroTelefonoPaciente().isNumeroTelefonoConfirmado());
	        sentenciaPreparada.setDate(12, paciente.getFechaNacimiento());
	        sentenciaPreparada.setBoolean(13, false);
	        sentenciaPreparada.setString(14,paciente.getContactoPaciente().getContrasenia());
//BCrypt.hashpw(paciente.getContactoPaciente().getContrasenia(), BCrypt.gensalt(12))
	        sentenciaPreparada.executeUpdate();

	    } catch (final SQLException excepcion) {
	        throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027),
	        		CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028), excepcion);

	    } catch (final Exception excepcion) {
	        throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027), 
	        		CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029), excepcion);
	    }
		
	}
	
	private final UUID conexionTipoIdentificacion(final TipoIdentificacionEntity entity, final Connection conexion) {
		
		
	    StringBuilder sentencia = new StringBuilder();
	    sentencia.append("SELECT id_tipoIdentificacion FROM TipoIdentificacion WHERE codigo = ? ");
	    
	    try (final var sentenciaPreparada = conexion.prepareStatement(sentencia.toString())) {
	    	sentenciaPreparada.setString(1, entity.getNombre());
	    	return ejecutarConsultaTipoIdentificacion(sentenciaPreparada);
	    } catch (final SQLException excepcion) {
			throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000132),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000133),excepcion);
		}
	}
	    
	private final UUID ejecutarConsultaTipoIdentificacion(final PreparedStatement sentenciaPreparada) {
	    UUID tipoIdentificacionId = null;

	    try (final var resultado = sentenciaPreparada.executeQuery()) {
	        if (resultado.next()) {
	            tipoIdentificacionId = UUID.fromString(resultado.getString("id_tipoIdentificacion"));
	        }
	    } catch (final SQLException excepcion) {
	        throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000130),
	        		CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000131), excepcion);
	    }
	    return tipoIdentificacionId;
	}
	
	@Override
	public final void modificar(final PacienteEntity paciente) {
		final var parametros = new ArrayList<>();

	    final String sentencia = formarSentenciaModificar(paciente, parametros);
	    try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia)) {

	       colocarParametrosConsulta(sentenciaPreparada, parametros);

	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        String mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000154);
	        String mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000155);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        String mensajeUsuario =CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000154);
	        String mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000156);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
		
	}
	
	private final String formarSentenciaModificar(final PacienteEntity paciente, final List<Object> parametros) {
	    final StringBuilder sentencia = new StringBuilder("UPDATE Paciente SET");

	    
	    sentencia.append(" numeroIdentificacion = ?,");
	    sentencia.append(" id_tipoIdentificacion = ?,");
	    sentencia.append(" primerNombre = ?,");
	    sentencia.append(" segundoNombre = ?,");
	    sentencia.append(" primerApellido = ?,");
	    sentencia.append(" segundoApellido = ?,");
	    sentencia.append(" correoElectronico = ?,");
	    sentencia.append(" numeroTelefono = ?,");
	    sentencia.append(" fechaNacimiento = ?");

	    sentencia.append(" WHERE id_paciente = ?");
	    
	    parametros.add(paciente.getNumeroIdentificacion());
	    parametros.add(conexionTipoIdentificacion(paciente.getTipoIdentificacion(), getConexion()));
	    parametros.add(paciente.getNombreCompletoPaciente().getPrimerNombre());
	    parametros.add(paciente.getNombreCompletoPaciente().getSegundoNombre());
	    parametros.add(paciente.getNombreCompletoPaciente().getPrimerApellido());
	    parametros.add(paciente.getNombreCompletoPaciente().getSegundoApellido());
	    parametros.add(paciente.getContactoPaciente().getCorreoElectronicoPaciente().getCorreoElectronico());
	    parametros.add(paciente.getContactoPaciente().getNumeroTelefonoPaciente().getNumeroTelefono());
	    parametros.add(paciente.getFechaNacimiento());
	    parametros.add(paciente.getId()); 

	    return sentencia.toString();
	}

	@Override
	public final Optional<PacienteEntity> consultarPorId(final UUID id) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("SELECT id_paciente, numeroIdentificacion,primerNombre,segundoNombre,primerApellido,"
				+ "segundoApellido, correoElectronico,correoElectronicoConfirmado, numeroTelefono,numeroTelefonoConfirmado,fechaNacimiento, contrasenia ");
		sentencia.append("FROM Paciente ");
		sentencia.append("WHERE id_paciente = ? ");
		
		Optional<PacienteEntity> resultado = Optional.empty();
		
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
	
private  final Optional<PacienteEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<PacienteEntity> resultado = Optional.empty();
		try (final var resultados = sentenciaPreparada.executeQuery() ){
			if(resultados.next()) {
				
				var nombreCompletoPacienteEntity = NombreCompletoEntity.crear(resultados.getString("primerNombre"),
						resultados.getString("segundoNombre"), resultados.getString("primerApellido"), resultados.getString("segundoApellido"));
				
				var correoElectronicoPacienteEntity = CorreoElectronicoPacienteEntity.crear(
						resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"));
				
				var numeroTelefonoPacienteEntity = NumeroTelefonoPacienteEntity.crear(
						resultados.getString("numeroTelefono"), resultados.getBoolean("numeroTelefonoConfirmado"));
				
				var contactoPacienteEntity = ContactoPacienteEntity.crear(correoElectronicoPacienteEntity,
						numeroTelefonoPacienteEntity,resultados.getString("contrasenia"));
				
				var pacienteEntity = PacienteEntity.crear(UUID.fromString(resultados.getObject("id_paciente").toString()),
						resultados.getString("numeroIdentificacion"), nombreCompletoPacienteEntity,contactoPacienteEntity,
						resultados.getDate("fechaNacimiento"), null, null);
				
			resultado = Optional.of(pacienteEntity);
				
			}
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000157);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000158);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000157);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000159);
			throw DataHealthException.crear(mensajeUsuario,mensajeTecnico,excepcion);
		}
		return resultado;
	}

	@Override
	public final List<PacienteEntity> consultar(final PacienteEntity paciente) {
		 final var parametros = new ArrayList<Object>();

		    final String sentencia = formarSentenciaConsulta(paciente, parametros);

		    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
		        colocarParametrosConsulta(sentenciaPreparada, parametros);
		       
		        return ejecutarConsulta(sentenciaPreparada);

		    } catch (final DataHealthException excepcion) {
		        throw excepcion;
		    } catch (final SQLException excepcion) {
		        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000160);
		        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000161);
		        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
		    } catch (final Exception excepcion) {
		        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000160);
		        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000162);
		        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
		    }
		
	}
	
	private final String formarSentenciaConsulta(final PacienteEntity entity, final List<Object> parametros) {

	    final var sentencia = new StringBuilder();
	    String operadorCondicional = " WHERE";

	    sentencia.append("SELECT id_paciente, codigo, numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, correoElectronico, correoElectronicoConfirmado, numeroTelefono, numeroTelefonoConfirmado, fechaNacimiento, ");
	    sentencia.append("contrasenia FROM Paciente AS p JOIN "
	    		+ "TipoIdentificacion AS t ON p.id_tipoIdentificacion = t.id_tipoIdentificacion ");
	    if (!UtilObjeto.esNulo(entity)) {

	       if ((entity.getId()) != UtilUuid.DEFAULT_UUID) {
	            sentencia.append(operadorCondicional).append(" id_paciente = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getId());
	        }
	        if (!UtilTexto.estaVacio(entity.getNumeroIdentificacion())) {
	            sentencia.append(operadorCondicional).append(" numeroIdentificacion = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNumeroIdentificacion());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompletoPaciente().getPrimerNombre())) {
	            sentencia.append(operadorCondicional).append(" primerNombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompletoPaciente().getPrimerNombre());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompletoPaciente().getSegundoNombre())) {
	            sentencia.append(operadorCondicional).append(" segundoNombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompletoPaciente().getSegundoNombre());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompletoPaciente().getPrimerApellido())) {
	            sentencia.append(operadorCondicional).append(" primerApellido = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompletoPaciente().getPrimerApellido());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompletoPaciente().getSegundoApellido())) {
	            sentencia.append(operadorCondicional).append(" segundoApellido = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompletoPaciente().getSegundoApellido());
	        }
	        if (!UtilTexto.estaVacio(entity.getContactoPaciente().getCorreoElectronicoPaciente().getCorreoElectronico())) {
	            sentencia.append(operadorCondicional).append(" correoElectronico = ? ");
	            operadorCondicional = "OR";
	            parametros.add(entity.getContactoPaciente().getCorreoElectronicoPaciente().getCorreoElectronico());
	        }
	        if (!UtilTexto.estaVacio(entity.getContactoPaciente().getNumeroTelefonoPaciente().getNumeroTelefono())) {
	            sentencia.append(operadorCondicional).append(" numeroTelefono = ? ");
	            parametros.add(entity.getContactoPaciente().getNumeroTelefonoPaciente().getNumeroTelefono());
	        }
	        if (!UtilDate.tieneValorPorDefecto(entity.getFechaNacimiento())) {
	        	operadorCondicional = "AND";
	            sentencia.append(operadorCondicional).append(" fechaNacimiento = ? ");
	            parametros.add(entity.getFechaNacimiento());
	        }
	        if(!UtilTexto.estaVacio(entity.getContactoPaciente().getContrasenia())) {
	        	operadorCondicional = "AND";
	            sentencia.append(operadorCondicional).append(" contrasenia = ? ");
	            parametros.add(entity.getContactoPaciente().getContrasenia());
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
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000163);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000164);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000163);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000165);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	}
	
	private final List<PacienteEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada) {
	    final var listaResultados = new ArrayList<PacienteEntity>();

	    try (final var resultados = sentenciaPreparada.executeQuery()) {
	        while (resultados.next()) {
	        	
	        	var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(null,null,
	        			 resultados.getString("codigo"));
				
				var nombreCompletoPacienteEntity = NombreCompletoEntity.crear(resultados.getString("primerNombre"),
						resultados.getString("segundoNombre"), resultados.getString("primerApellido"), resultados.getString("segundoApellido"));
				var correoElectronicoPacienteEntity = CorreoElectronicoPacienteEntity.crear(
						resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"));
				
				var numeroTelefonoPacienteEntity = NumeroTelefonoPacienteEntity.crear(
						resultados.getString("numeroTelefono"), resultados.getBoolean("numeroTelefonoConfirmado"));
				
				var contactoPacienteEntity = ContactoPacienteEntity.crear(correoElectronicoPacienteEntity, numeroTelefonoPacienteEntity,resultados.getString("contrasenia"));
				
				var pacienteEntity = PacienteEntity.crear(UUID.fromString(resultados.getObject("id_paciente").toString()),
						resultados.getString("numeroIdentificacion"), nombreCompletoPacienteEntity, contactoPacienteEntity,
						resultados.getDate("fechaNacimiento"), tipoIdentificacionEntity, null);

	            listaResultados.add(pacienteEntity);
	            
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000163);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000166);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000163);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000167);
	        throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
	    }
	    return listaResultados;
	}

	@Override
	public final void eliminar(final UUID id) {
			final StringBuilder sentencia = new StringBuilder();
			
			sentencia.append("DELETE FROM Paciente WHERE id_paciente = ? " );
			
			try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
				
				sentenciaPreparada.setObject(1, id);
				sentenciaPreparada.executeUpdate();
				
			}catch (final SQLException excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000168);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000169);
				throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
				
			}catch (final Exception excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000168);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000170);
				throw DataHealthException.crear(mensajeUsuario, mensajeTecnico,excepcion);
			}
	}

}
