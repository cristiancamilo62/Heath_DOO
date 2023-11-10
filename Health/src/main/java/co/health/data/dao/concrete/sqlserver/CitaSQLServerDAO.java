package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.crosscutting.exception.concrete.DataHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.CitaDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.CitaEntity;

public final class CitaSQLServerDAO extends SQLDAO implements CitaDAO{

	public CitaSQLServerDAO(final Connection conexion) {
		super(conexion);
	}
	
	@Override
	public void registrar(CitaEntity cita) {
		
		final StringBuilder sentencia = new StringBuilder();
		sentencia.append("INSERT INTO Cita (id_cita,codigo,consultorio,nombreServicio,precio,fechaInicio,fechaFin,"
				+ "primerNombre,segundoNombre,primerApellido,segundoApellido) ");
		sentencia.append("VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, cita.getId());
			sentenciaPreparada.setString(2, cita.getDatosServicioCita().getCodigo());
			sentenciaPreparada.setString(3, cita.getDatosServicioCita().getConsultorio());
			sentenciaPreparada.setString(4, cita.getDatosServicioCita().getNombreServicio());
			sentenciaPreparada.setLong(5, cita.getDatosServicioCita().getPrecio());
			sentenciaPreparada.setDate(6, cita.getFecha().getFechaInicio());
			sentenciaPreparada.setDate(7, cita.getFecha().getFechaFin());
			sentenciaPreparada.setString(8, cita.getNombreProfesional().getPrimerNombre());
			sentenciaPreparada.setString(9, cita.getNombreProfesional().getSegundoNombre());
			sentenciaPreparada.setString(10,cita.getNombreProfesional().getPrimerApellido() );
			sentenciaPreparada.setString(11, cita.getNombreProfesional().getSegundoApellido());
			
			
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
	
			throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000135)
					,CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000136),excepcion);
			
		} catch (final Exception excepcion) {
			throw DataHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000137),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000138),excepcion);
			
		} 
	}
	
	
	@Override
	public final void agendar(final CitaEntity cita) {
		
	}

	@Override
	public final void enviarConfirmacion(final CitaEntity cita) {
	}

	@Override
	public final void cancelar(final CitaEntity cita) {	
	}

	@Override
	public final void reprogramar(final CitaEntity cita) {		
	}

	@Override
	public final void cambiarEstado(final CitaEntity cita) {
	}

	@Override
	public final Optional<CitaEntity> consultarPorId(final UUID id) {
		return null;
	}
	@Override
	public final List<CitaEntity> consultar(final CitaEntity cita) {
		// TODO Auto-generated method stub
		return null;
	}

}
