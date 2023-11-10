package co.health.service.dto.support;


import co.health.crosscutting.util.UtilObjeto;
import co.health.service.dto.EpsDTO;
import co.health.service.dto.EstadoCitaDTO;
import co.health.service.dto.RegimenAfiliacionDTO;

public class InformacionAfiliacionPacienteDTO {

	private boolean estadoCuenta;
	private RegimenAfiliacionDTO regimenAfiliacion;
	private EpsDTO eps;
	
	public InformacionAfiliacionPacienteDTO() {
		setEstadoCuenta(true);
		setRegimenAfiliacion(new RegimenAfiliacionDTO());
		setEps(new EpsDTO());
		
	}
	public InformacionAfiliacionPacienteDTO(boolean estadoCuenta, RegimenAfiliacionDTO regimenAfiliacion,
			EpsDTO eps) {
		setEstadoCuenta(estadoCuenta);
		setRegimenAfiliacion(regimenAfiliacion);
		setEps(eps);
	}
	
	public static final InformacionAfiliacionPacienteDTO crear(boolean estadoCuenta, RegimenAfiliacionDTO regimenAfiliacion,
			EpsDTO eps) {
		return new InformacionAfiliacionPacienteDTO(estadoCuenta, regimenAfiliacion, eps);
	}
	public final boolean isEstadoCuenta() {
		return estadoCuenta;
	}
	public final InformacionAfiliacionPacienteDTO setEstadoCuenta(final boolean estadoCuenta) {
		this.estadoCuenta = UtilObjeto.obtenerValorDefecto(estadoCuenta,true);
		return this;
	}
	public final RegimenAfiliacionDTO getRegimenAfiliacion() {
		return regimenAfiliacion;
	}
	public final InformacionAfiliacionPacienteDTO setRegimenAfiliacion(final RegimenAfiliacionDTO regimenAfiliacion) {
		this.regimenAfiliacion = UtilObjeto.obtenerValorDefecto(regimenAfiliacion, new RegimenAfiliacionDTO());
		return this;
	}
	public final EpsDTO getEps() {
		return eps;
	}
	public final InformacionAfiliacionPacienteDTO setEps(final EpsDTO eps) {
		this.eps = UtilObjeto.obtenerValorDefecto(eps, new EpsDTO());
		return this;
	}
	
	
	
	
}
