package co.health.service.facade;

public interface FacadeRetorno<T,R> {

	R executeRetorno(T dto);
}
