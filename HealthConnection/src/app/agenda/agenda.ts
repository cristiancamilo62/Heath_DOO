export class Servicio {
    id: string='';
    nombre: string='';
  }

export class TipoIdentificacion {
    id: string='';
    codigo: string='';
    nombre: string='';
  }
  
  // nombre-completo.model.ts
  export class NombreCompleto {
    primerNombre: string='';
    segundoNombre: string='';
    primerApellido: string='';
    segundoApellido: string='';
  }
  
  // profesional-salud.model.ts
  export class ProfesionalSalud {
    id: string='';
    numeroIdentificacion: string='';
    nombreCompletoProfesionalSalud: NombreCompleto=new NombreCompleto();
    servicio: Servicio=new Servicio();
    tipoIdentificacion: TipoIdentificacion=new TipoIdentificacion();
  }
  
  // agenda.model.ts
  export class Agenda {
    id: string='';
    profesionalSalud: ProfesionalSalud= new ProfesionalSalud();
    precioServicio: number=0;
    fechaInicio: string='';
    fechaFin: string='';
  }
