package co.health.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.health.crosscutting.exception.concrete.CrosscuttingHealthException;
import co.health.crosscutting.messages.enumerator.CategoriaMensaje;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.messages.enumerator.TipoMensaje;
import co.health.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {

	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<CodigoMensaje, Mensaje>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	

	
	public static void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000001, TipoMensaje.TECNICO,CategoriaMensaje.FATAL, "No se recibio el codigo de "
				+ "mensaje que se quería crear. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No existe un mensaje con el "
				+ "código indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000003, TipoMensaje.TECNICO,CategoriaMensaje.FATAL, "No es posible obtener un mensaje "
				+ "con un código vacio o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000004, TipoMensaje.USUARIO,CategoriaMensaje.FATAL, "Se a presentado un problema inesperado"
				+ " tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte"
				+ "al administrador de la aplicación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema "
				+ "trantando de validar si la conexión SQL estaba abierta. Se presento una excepción de tipo SQLException. Por favor verifique"
				+ "la traza completa del error presentado, para así poder diagnosticar con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema "
				+ "inesperado trantando de validar si la conexión SQL estaba abierta. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible validar si una conexión "
				+ "esta abierta cuando es nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000008,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible cerrar una conexión "
				+ "que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible cerrar una conexión "
				+ "que ya esta cerrada. Esto se debe a que una conexión que ha sido terminada o cerrada ya "
				+ "no se encuentra en un estado activo y operativo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando "
				+ " de cerrar la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para poder diagnosticar "
				+ "con mayor certeza lo que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado"
				+ "trantando de cerrar la conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000012,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible iniciar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible iniciar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible iniciar una transacción que ya ha sido"
				+ "iniciada. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema trantando"
				+ "de iniciar la transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema"
				+ "trantando de iniciar la transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000017,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible confirmar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible confirmar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible confirmar una transacción que no ha sido"
				+ "iniciada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando"
				+ "de confirmar la transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado "
				+ "trantando de confirmar la transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000022,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible cancelar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible cancelar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible cancelar una transacción que no ha sido"
				+ "iniciada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando"
				+ "de cancelar una transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado "
				+ "trantando de cancelar una transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000027, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de registrar "
				+ "la información del nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000028, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion en el metodo crear "
				+ "de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del "
				+ "nuevo tipo de Identificación. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo crear "
				+ "de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del "
				+ "nuevo tipo de Identificación. Por favor revise la traza completa del problema presentado"
				+ "para asi identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000030, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de consultar "
				+ "la información de un tipo de identificación por el id"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion "
				+ "de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del "
				+ "tipo de Identificación deseada. Por favor revise la traza completa del problema presentado"
				+ "para asi identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion"
				+ "de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del "
				+ "tipo de Identificación deseada. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion"
				+ "tratando de llevar a cabo la recuperación de los datos de la consulta del Tipo de Identificación deseado. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion"
				+ "tratando de llevar a cabo la recuperación de los datos de la consulta del Tipo de Identificación deseado. Por favor revise la traza completa del problema presentado"
				+ "para asi poder identificar que sucedio y solucionar el problema."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha producido una excepción de tipo SQLException al intentar eliminar un "
				+ "registro en la base de datos con el ID proporcionado. Para resolver este problema, revise los detalles técnicos proporcionados y asegúrese de que el ID proporcionado "
				+ "sea válido y cumpla con las restricciones de la base de datos. Además, verifique la validez de la sentencia SQL de eliminación en su código."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000036, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de eliminar "
				+ "la información de un tipo de identificación por el id"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Exception al intentar eliminar un "
				+ "registro en la base de datos con el ID proporcionado. Para resolver este problema, revise los detales técnicos proporcionados y asegúrese de que el ID proporcionado "
				+ "sea válido y cumpla con las restricciones de la base de datos. Además, verifique la validez de la sentencia SQL de eliminación en su código."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para PostgreSQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000039, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para MySQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para Oracle no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos deseada no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener la conexión con SQL Server. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000043, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de obtener la conexión con SQL Server. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000061, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "la longitud minima de la contraseña debe ser 8"));	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000062, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La contraseña del usuario es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000063, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud del Nombre del tipo de identificacion no es valida.La longitud maxima es 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000064, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El Nombre del tipo de identificacion es obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000065, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El Nombre del tipo de identificación solo debe contener letras, digitos y espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000066, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud maxima del correo electronico es de 40"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000067, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El correo electronico es una dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000068, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El correo electronico ingresado no es un dato valido. verifique su formato a 'ejemplo12@gmail.com'"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000069, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La fecha de nacimiento es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000070, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La fecha no cumple el formato.La fecha de nacimiento debe tener el formato yyyy-MM-dd"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000071, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El id del cliente es el valor por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000072, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud maxima del primer nombre es de 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000073, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud maxima del segundo nombre es de 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000074, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud maxima del primer apellido es de 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000075, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud maxima del segundo apellido es de 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000076, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El primer nombre debe tener solo letras o digitos"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000077, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El segundo nombre debe tener solo letras o digitos" ));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000078, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El primer apellido debe tener solo letras o digitos"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000079, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El segundo apellido debe tener solo letras o digitos"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000080, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El primer nombre es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000081, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El primer apellido es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000082, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "No es posible realizar la operacion con un tipo de identificación nulo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000083, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "la longitud del numero de identificacion debe ser igual a 10"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000084, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "EL número de identificacion es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000085, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El número de identificacion debe tener solo números"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000086, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El numero de telefono debe contener solo numeros"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000087, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El número de telefono es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000088, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud del numero de telefono debe ser 10 digitos"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000089, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "No es posible realizar la operacion con un paciente Nulo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000090, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud del codigo del tipo de identificacion no es valida.La longitud maxima es 4 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000091, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El código del tipo de identificacion es obligatorio. El campo no puede estar vacio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000092, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El código del tipo de identificación solo debe contener letras"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000093, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El id del tipo de identificación es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000094, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El id del tipo de identificacion es el valor por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000095, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de registrar una nueva cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000096, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema tratando de tipo excepcion tratando de registrar una nueva cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000097, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de conultar un cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000098, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema tratando de tipo excepcion tratando de consultar un cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000099, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de eliminar un cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000100, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema o excepcion tratando de eliminar un paciente desde EliminarPacienteFacade"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000101, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de registrar un nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000102, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo excepcion dentro de RegistrarPacienteFacade tratando de registrar un nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000103, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de registrar un nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000104, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema  de tipo excepcion tratando de registrar un nuevo numero de identificacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000105, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el PacienteEntity es nulo en toDomain de la clase PacienteDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000106, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el PacienteEntity es nulo en toEntity de la clase PacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000107, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el CitaEntity es nulo en todomain de la clase CitaDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000108, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el CitaEntity es nulo en toEntity de la clase CitaEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000109, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el contactoPaciente es nulo en toDomain de la clase ContactoPacienteDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000110, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el contactoPaciente es nulo en toEntity de la clase ContactoPacienteDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000111, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el correo electronico es nulo en toDomain de la clase CorreoElectronicoPacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000112, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el correo electronico es nulo en toEntity de la clase CorreoELectronicoDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000113, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el InformacionAfliacionPaciente es nulo en toDomain de la clase InformacionAfiliacionPacienteDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000114, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "el InformacionAfliacionPaciente es nulo en toEntity de la clase InformacionAfiliacionPacienteDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000115, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo toDomain de la clase NombreCompletoPacienteDTOMapper por que el nombreCompletoPaciente es nulo "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000116, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo toEntity de la clase NombreCompletoPacienteDTOMapper por que el nombreCompletoPaciente es nulo "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000117, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "El numerotelefonoPaciente es nulo en to domain de la clase NumeroTelefonoPacienteDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000118, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "El fechaCita es nulo en toDomain de la clase FechaCitaDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000119, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "El fechaCita es nulo en toentity de la clase FechaCitaDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000120, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "El DatosServicioCita es nulo en toDomain de la clase DatosServicioCitaDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000121, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "El DatosServicioCita es nulo en toEntity de la clase DatosServicioCitaDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000122, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de llevar a cabo el registro de la información de la nueva cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000123, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo setFactoria de la clase RegistrarCitaUseCase debido a que la factoria con la cual se desea crear esta nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000124, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Ya existe una cita con la misma fecha y consultorio "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000125, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "No existe el paciente con los datos ingresados"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000126, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000127, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo setFactoria de la clase RegistrarPacienteUseCase debido a que la factoria con la cual se desea crear esta nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000128, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "No es posible realizar la operacion con un estado de cita Nulo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000129, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "El id del estado de cita es el valor por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000130, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Ocurrió un error al ejecutar la consulta de tipo de identificación."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000131, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Error de tipo SQLExceptional recuperar el tipo de identificación desde la base de datos."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000132, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se presento un error al hacer la conexion con tipo identificacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000133, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se presentó un error de tipo SQLException al intentar hacer la conexion con la tabla tipoIdentificacion" ));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000134, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Ya existe cliente con el número de identificación:"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000135, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un error al registrar la cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000136, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un error de tipo SQLServer en CitaSQLServerDAO al momento de registrar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000137, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un error inesperado al registrar la cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000138, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un error desconocido en CitaSQLServerDAO al momento de registrar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000139, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha producido un error al validar la fecha. verifique que su formato se yyyy-MM-dd'T'HH:mm:ss"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000140, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha producido un error de formato al analizar la fecha. Asegúrate de que la fecha tenga el formato 'yyyy-MM-dd'T'HH:mm:ss'."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000141, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"se ha presentado un error tratando de registrar una cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000142, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se ha presentado un error de tipo SQLExcepcion  en la clase AgendaSQLServerDAO "
		+ "en el metodo registrarCita tratando de registrar una cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000143, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se ha presentado un error inesperado de tipo Excepcion  en la clase AgendaSQLServerDAO "
				+ "en el metodo registrarCita tratando de registrar una cita"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000144, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Ocurrió un error al ejecutar la consulta del profesionl de salud."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000145, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Error de tipo SQLExceptional recuperar el profesionl de salud desde la base de datos."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000146, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un proble tratando de consultar la información de la agenda"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000147, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se a presentado un problema de tipo SQLExcepcion tratando de ejecutar la consulta de la Agenda"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000148, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se a presentado un problema de tipo Excepcion tratando de ejecutar la consulta de la Agenda"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000149, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema, trantando de llevar a cabo la consulta de la cita.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000150, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase AgendaSQLServerDAO "
        		+ "tratando de colocar los parametros de la consulta de la cita deseada..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000151, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo colocarParametrosconsulta de la clase AgendaSQLServerDAO "
        		+ "tratando de colocar los parametros de la consulta de la cita deseada..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000152, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo ejecutarconsulta de la clase AgendaSQLServerDAO "
        		+ "tratando de ejecutar la consulta de la cita deseada..."
        		+ "por favor revise el error presentado para así poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000153, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo ejecutarconsulta de la clase AgendaSQLServerDAO "
        		+ "tratando de ejecutar la consulta de la cita deseada..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000154, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "se ha presentado un error tratando de modificar sus datos"
				+ "Por favor revise que los campos no esten vacios o que si cumplan con las reglas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000155, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion tradando de modificar los datos del"
				+ "Paciente en el metodo Modificar de la Clase PacienteSQLServerDAO. Por favor revise la traza del problema para verificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000156, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion tradando de modificar los datos del"
				+ "Paciente en el metodo Modificar de la Clase PacienteSQLServerDAO. Por favor revise la traza del problema para verificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000157, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "se ha presentado un problema tratando de consultar el Paciente por el Id"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000158, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion tratando ejecutar la consulta por Id"
				+ "Paciente en el metodo EjecutarConsultaPorId de la Clase PacienteSQLServerDAO. Por favor revise la traza del problema para verificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000159, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion tradando ejecutar la consulta por Id"
				+ "Paciente en el metodo EjecutarConsultaPorId de la Clase PacienteSQLServerDAO. Por favor revise la traza del problema para verificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000160, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "se ha presentado un problema tratando de consultar el Paciente por alguno de los parametros enviados"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000161, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion tradando de consultar"
				+ "Paciente en el metodo consultar de la Clase PacienteSQLServerDAO. Por favor revise la traza del problema para verificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000162, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion tratando de consultar el "
				+ "Paciente en el metodo consultar de la Clase PacienteSQLServerDAO. Por favor revise la traza del problema para verificar el error que se presento.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000163, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema, trantando de llevar a cabo la consulta de los clientes.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000164, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase PacienteSQLServerDAO"
        		+ "tratando de colocar los parametros de la consulta del cliente deseada..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000165, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase PacienteSQLServerDAO"
        		+ "tratando de colocar los parametros de la consulta del cliente deseada..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000166, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo ejecutarConsulta de la clase PacienteSQLServerDAO"
        		+ "tratando ejecutar la consulta del cliente deseado..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000167, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo ejecutarConsulta de la clase PacienteSQLServerDAO"
        		+ "tratando ejecutar la consulta del cliente deseado..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000168, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema, trantando de llevar a cabo la eliminacion del cliente."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000169, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo eliminar de la clase PacienteSQLServerDAO"
        		+ "tratando de eliminar el Paciente por el Id enviado. "
        		+ "Por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000170, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo Excepcion en el metodo eliminar de la clase PacienteSQLServerDAO"
        		+ "tratando de eliminar el Paciente por el Id enviado. "
        		+ "Por favor revise el problema presentado para así poder identificar que sucedio."));
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000171, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "se ha presentado un problema tratando de consultar el Profesional de salud por alguno de los parametros enviados"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000172, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion tradando de consultar"
				+ " Profesional de salud en el metodo consultar de la Clase ProfesionalSaludSQLServerDAO. Por favor revise la traza del problema para verificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000173, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion tratando de consultar el "
				+ " Profesional de salud en el metodo consultar de la Clase ProfesionalSaludSQLServerDAO. Por favor revise la traza del problema para verificar el error que se presento.."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000174, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase ProfesionalSaludSQLServerDAO "
        		+ "tratando de colocar los parametros de la consulta del Profesional de salud deseado..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000175, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase ProfesionalSaludSQLServerDAO "
        		+ "tratando de colocar los parametros de la consulta del Profesional de salud deseado..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000176, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo ejecutarConsulta de la clase ProfesionalSaludSQLServerDAO " 
        		+ "tratando ejecutar la consulta del Profesional de salud deseado..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000177, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo ejecutarConsulta de la clase ProfesionalSaludSQLServerDAO "
        		+ "tratando ejecutar la consulta del profesional de salud deseado..."
        		+ "por favor revise el problema presentado para así poder identificar que sucedio."));
	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000178, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un error al intentar modificar el tipo de identificacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000179, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un error de tipo SQLException dentro de TipoIdentificacionSQLServerDAO"
				+ " al intentar modificar un tipo de identificacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000180, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un error de tipo desconocido dentro de TipoIdentificacionSQLServerDAO"
				+ "al intentar modificar un tipo de identificacion"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000181, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo SQLException en el método colocarParametrosConsulta de la clase TipoIdentificacionSQLServer "
				+ "	tratando de colocar los parámetros de la consulta SQL, por favor, revise el problema presentado"
				+ "para verificar qué sucedió y solucionar el problema."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000182, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Exception en el método colocarParametrosConsulta de la clase TipoIdentificacionSQLServer"
				+ "tratando de colocar los parámetros de la consulta SQL. Por favor, revise la traza completa del problema presentado"
				+ "para poder identificar qué sucedió y solucionar el problema."));
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000183, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Ya existe una cita en la misma fecha, y con el mismo profesional de salud"));
	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000184, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de llevar a cabo el "
			+ "registro de la información de la nueva cita de la agenda"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000185, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo setFactoria de la clase"
				+ "RegistrarAgendaUSeCase debido a que la factoria con la cual se desea crear esta nula."));
	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000186, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de llevar a cabo la "
				+ "	eliminacion de la información del paciente.."));
			
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000187, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo setFactoria de la clase"
				+ "RegistrarPacienteUseCase debido a que la factoria con la cual se desea crear esta nula."));
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000188, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"No existe el paciente que se desea modificar"));
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000189, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de llevar a cabo la "
				+ "	Modificacion de la información del paciente.."));
			
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000190, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo setFactoria de la clase"
				+ "ModificarPacienteUseCase debido a que la factoria con la cual se desea crear esta nula."));
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000191, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Ya existe cliente con el número de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000192, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Ya existe cliente con el correo Electronico o Número de telefono. Por favor revise de"
				+ "nuevo los datos ingresados "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000193, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Ya existe cliente con el correo Electronico o Número de telefono. Por favor revise de "
				+ "nuevo los datos ingresados "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000194, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de llevar a cabo el "
				+ "registro de la información del nuevo cliente"));
			
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000195, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo setFactoria de la clase"
				+ "RegistrarPacienteUseCase debido a que la factoria con la cual se desea crear esta nula."));
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000196, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de llevar a cabo el "
				+ "la consulta de la información del profesional de salud"));
			
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000197, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo setFactoria de la clase"
			+ "ConsultarProfesionalUseCase debido a que la factoria con la cual se desea crear esta nula."));
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000198, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"No es posible realizar la operacion con una agenda nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000199, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La fecha de inicio de la agenda es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000200, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La fecha no cumple el formato.La fecha debe tener el formato yyyy-MM-dd"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000201, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La fecha de fin es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000202, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La fecha no cumple el formato. La fecha debe tener el formato yyyy-MM-dd"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000203, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El id de la Agenda es el valor por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000203, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El id del profesional de la salud es el valor por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000204, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El id del Tipo de servicio es el valor por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000205, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La longitud del nombre del servicio debe ser menor a 50"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000206, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El nombre del servicio es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000207, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El nombre del servicio debe contener solo letras"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000208, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"No es posible realizar la operacion con un cliente Nulo"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000209, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de registrar una nueva cita en la agenda"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000210, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo excepcion dentro de RegistrarAgendaFacade tratando de registrar una nueva Cita"));
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000211, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de modificar un paciente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000212, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo excepcion dentro de ModificarPacienteFacade tratando de modificar un Paciente"));
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000213, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de consultar un profesional de la salud"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000214, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema de tipo excepcion dentro de ConsultarPorfesionalSaludFacade tratando de consultar un profesional de salud"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000215, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El Tipo de servicio es nulo en toDomain de la clase TipoServicioDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000216, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El Tipo de servicio es nulo en toDTO de la clase TipoServicioDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000217, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La agenda es nulo en toDomain de la clase AgendaEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000218, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La agenda es nulo en toEntity de la clase AgendaEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000219, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El profesional de salud es nulo en toDomain de la clase ProfesionalSaludDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000220, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El profesional de salud es nulo en toDTO de la clase ProfesionalSaludDTOMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000221, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El contactoPaciente es nulo en toDomain de la clase ContactoPacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000222, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El contactoPaciente es nulo en toEntity de la clase ContactoPacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000223, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El correo electronico es nulo en toDomain de la clase CorreoElectronicoPacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000224, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El correo electronico es nulo en toEntity de la clase CorreoElectronicoPacienteEntityMapper"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000225, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El FechaCitaEntity es nulo en toDomain de la clase FechaCitaEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000226, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El FechaCitaEntity es nulo en toEntity de la clase FechaCitaEntityMapper"));
	
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000227, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo toDomain de la clase NombreCompletoPacienteEntityMapper "
				+ "por que el nombreCompletoPaciente es nulo "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000228, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema en el metodo toEntity de la clase NombreCompletoPacienteEntityMapper "
				+ "por que el nombreCompletoPaciente es nulo "));
	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000229, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El numerotelefonoPaciente es nulo en todamin de la clase NumeroTelefonoPacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000230, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El numerotelefonoPaciente es nulo en toEntity de la clase NumeroTelefonoPacienteEntityMapper"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000231, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El Tipo de servicio es nulo en toDomain de la clase TipoServicioEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000232, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El Tipo de servicio es nulo en toEntity de la clase TipoServicioEntityMapper"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000233, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La agenda es nulo en toDomain de la clase AgendaEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000234, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La agenda es nulo en toEntity de la clase AgendaEntityMapper"));
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000235, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El PacienteEntity es nulo en toDomain de la clase PacienteEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000236, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El PacienteEntity es nulo en toEntity de la clase PacienteEntityMapper"));
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000237, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "El profesional de salud es nulo en toDomain de la clase ProfesionalSaludEntityMapper"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000238, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"El profesional de salud es nulo en toEntity de la clase ProfesionalSaludEntityMapper"));
	
		
	}
	
	
	
	
	
	

	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	private static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000003);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		
		if(!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000002);
			throw CrosscuttingHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje( final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}
