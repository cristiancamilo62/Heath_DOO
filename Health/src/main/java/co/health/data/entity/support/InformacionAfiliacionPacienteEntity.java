package co.health.data.entity.support;

import co.health.data.entity.EpsEntity;
import co.health.data.entity.RegimenAfiliacionEntity;

public class InformacionAfiliacionPacienteEntity {
	private boolean estadoCuenta;
	private RegimenAfiliacionEntity regimenAfiliacion;
	private EpsEntity eps;
	
	
	private InformacionAfiliacionPacienteEntity(final boolean estadoCuenta, final RegimenAfiliacionEntity regimenAfiliacion,
			final EpsEntity eps) {
		setEstadoCuenta(estadoCuenta);
		setRegimenAfiliacion(regimenAfiliacion);
		setEps(eps);
		
	}
	
	public static final InformacionAfiliacionPacienteEntity crear(final boolean estadoCuenta, final RegimenAfiliacionEntity regimenAfiliacion,
			final EpsEntity eps) {
		return new InformacionAfiliacionPacienteEntity(estadoCuenta, regimenAfiliacion, eps);
	}

	public final boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public final RegimenAfiliacionEntity getRegimenAfiliacion() {
		return regimenAfiliacion;
	}

	public final EpsEntity getEps() {
		return eps;
	}

	private final void setEstadoCuenta(final boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	private final void setRegimenAfiliacion(final RegimenAfiliacionEntity regimenAfiliacion) {
		this.regimenAfiliacion = regimenAfiliacion;
	}

	private final void setEps(final EpsEntity eps) {
		this.eps = eps;
	}
	
	

	
}