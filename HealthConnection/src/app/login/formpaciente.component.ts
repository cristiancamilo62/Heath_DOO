import { Component, OnInit } from '@angular/core';
import { Paciente } from './paciente';
import { PacienteService } from './paciente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-formpaciente',
  templateUrl: './formpaciente.component.html',
  styleUrls: ['./formpaciente.component.css']
})
export class FormpacienteComponent implements OnInit{
  
  paciente: Paciente = new Paciente();

  titulo:string="Registro del paciente";
  mensajeDeError:string="";

  constructor(private pacienteservice: PacienteService, private router:Router){}
  
  ngOnInit(): void {
  }

  create(): void{
    this.pacienteservice.create(this.paciente).subscribe(
      (response)=>{
        alert("su registro a sido exitoso")
        this.router.navigate(['/login'])
      },
   (error) => {
    // Manejar el error aquí
    console.error(error);

    // Acceder al mensaje de error
    if (error.error && error.error.mensajes && error.error.mensajes.length > 0) {
      const mensajeDeError = error.error.mensajes[0];
      alert(mensajeDeError);
    }
  }
    );
    
  }

}
