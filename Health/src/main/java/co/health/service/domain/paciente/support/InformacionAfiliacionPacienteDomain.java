package co.health.service.domain.paciente.support;

import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.eps.EpsDomain;
import co.health.service.domain.regimenafiliacion.RegimenAfiliacionDomain;

public final class InformacionAfiliacionPacienteDomain {
	
	private boolean estadoCuenta;
	private RegimenAfiliacionDomain regimenAfiliacion;
	private EpsDomain eps;
	
	public InformacionAfiliacionPacienteDomain() {
			setEstadoCuenta(false);
			setRegimenAfiliacion(new RegimenAfiliacionDomain());
			setEps(new EpsDomain());
	}
	
	private InformacionAfiliacionPacienteDomain(final boolean estadoCuenta, final RegimenAfiliacionDomain regimenAfiliacion,
			final EpsDomain eps) {
		setEstadoCuenta(estadoCuenta);
		setRegimenAfiliacion(regimenAfiliacion);
		setEps(eps);
		
	}
	
	public static final InformacionAfiliacionPacienteDomain crear(final boolean estadoCuenta, final RegimenAfiliacionDomain regimenAfiliacion,
			final EpsDomain eps) {
		return new InformacionAfiliacionPacienteDomain(estadoCuenta, regimenAfiliacion, eps);
	}
	
	public static final InformacionAfiliacionPacienteDomain crear() {
		return new InformacionAfiliacionPacienteDomain();
	}

	public final boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public final RegimenAfiliacionDomain getRegimenAfiliacion() {
		return regimenAfiliacion;
	}

	public final EpsDomain getEps() {
		return eps;
	}

	private final void setEstadoCuenta(final boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	private final void setRegimenAfiliacion(final RegimenAfiliacionDomain regimenAfiliacion) {
		this.regimenAfiliacion = UtilObjeto.obtenerValorDefecto(regimenAfiliacion, new RegimenAfiliacionDomain());
	}

	private final void setEps(final EpsDomain eps) {
		this.eps = UtilObjeto.obtenerValorDefecto(eps, new EpsDomain());
	}
	
	

}
