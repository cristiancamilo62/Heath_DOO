export class Paciente {
    id: string = '';
    numeroIdentificacion: string = '';
    nombreCompletoPaciente: NombreCompletoPaciente = new NombreCompletoPaciente();
    contactoPaciente: ContactoPaciente = new ContactoPaciente();
    fechaNacimiento: string = '';
    tipoIdentificacion: TipoIdentificacion = new TipoIdentificacion();
    informacionAfiliacionPaciente: InformacionAfiliacionPaciente = new InformacionAfiliacionPaciente();
  }
  
  export class NombreCompletoPaciente {
    primerNombre: string = '';
    segundoNombre: string = '';
    primerApellido: string = '';
    segundoApellido: string = '';
  }
  
  export class ContactoPaciente {
    correoElectronicoPaciente: CorreoElectronicoPaciente = new CorreoElectronicoPaciente();
    numeroTelefonoPaciente: NumeroTelefonoPaciente = new NumeroTelefonoPaciente();
    contrasenia : string = '';
  }
  
  export class CorreoElectronicoPaciente {
    correoElectronico: string = '';
    correoELectronicoConfirmado: boolean = false;
  }
  
  export class NumeroTelefonoPaciente {
    numeroTelefono: number | null = null;
    numeroTelefonoConfirmado: boolean = false;
  }
  
  export class TipoIdentificacion {
    id: string = '';
    codigo: string = '';
    nombre: string = '';
  }
  
  export class InformacionAfiliacionPaciente {
    estadoCuenta: boolean = true;
    regimenAfiliacion: RegimenAfiliacion = new RegimenAfiliacion();
    eps: Eps = new Eps();
  }
  
  export class RegimenAfiliacion {
    id: string = '00000000-0000-0000-0000-000000000000';
    tipo: string = '';
    coberturaServicios: string = '';
  }
  
  export class Eps {
    id: string = '00000000-0000-0000-0000-000000000000';
    nombre: string = '';
  }
  