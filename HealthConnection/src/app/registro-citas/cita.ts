export class Cita{
    id: string = '00000000-0000-0000-0000-000000000000';
    datosServicioCita : DatosServicioCita = new DatosServicioCita;
	fechaCita : FechaCita = new FechaCita;
	EstadoCita : EstadoCita = new EstadoCita;
	NombreCompletoProfesional: NombreCompletoProfesional = new NombreCompletoProfesional;
}

export class NombreCompletoProfesional {
    primerNombre: string = '';
    segundoNombre: string = '';
    primerApellido: string = '';
    segundoApellido: string = '';
  }

export class EstadoCita{
    id: string = '00000000-0000-0000-0000-000000000000';
	 nombre:string='disponible';
}

export class FechaCita{
    fechaInicio:string='';
	fechaFin : string='';
}

export class DatosServicioCita{
    codigo:string='';
	consultorio:string='';
	nombreServicio:string='';
	precio:number = 0;
}