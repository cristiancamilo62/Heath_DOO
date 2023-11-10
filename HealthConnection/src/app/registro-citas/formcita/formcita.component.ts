import { Component, OnInit } from '@angular/core';
import { Cita } from '../cita';
import { CitasService } from '../citas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-formcita',
  templateUrl: './formcita.component.html',
  styleUrls: ['./formcita.component.css']
})
export class FormcitaComponent implements OnInit{

  cita: Cita = new Cita();

  titulo:string="Registro de citas";
  mensajeDeError:string="";

  constructor(private citaservice: CitasService, private router:Router){}

  ngOnInit(): void {
   
  }
  registrar(): void{
    console.log(this.cita)
    this.citaservice.create(this.cita).subscribe(
      (response)=>{
        console.log(response)
      },
   (error) => {
    // Manejar el error aquí
    console.error(error);

    // Acceder al mensaje de error
    if (error.error && error.error.mensajes && error.error.mensajes.length > 0) {
      const mensajeDeError = error.error.mensajes[0];
      alert(mensajeDeError);
    }
   //return  res=>this.router.navigate(['/login'])
  }
    );
    
  }

}
