import { Component, OnInit } from '@angular/core';
import { AgendaService } from './agenda.service';
import { Router } from '@angular/router';
import { Agenda, ProfesionalSalud } from './agenda';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit{

  profesionalesDeSalud: ProfesionalSalud[] = [];

  agenda:Agenda=new Agenda();



  constructor(private agendaservice:AgendaService,private router:Router){}
  
  ngOnInit(): void {
  }
  registrarCita():void{
    this.agendaservice.registrar(this.agenda).subscribe(
      response=>{
       if(response){
         alert(response.mensajes[0])
      }
    }
    );

  }
  consultar(): void {
    this.agendaservice.consultarProfesional(this.agenda.profesionalSalud).subscribe(
      response => {
        console.log(response)
        this.profesionalesDeSalud = response.datos;
      },
      error => {
        console.log(error.mensajes);
      }
    );
  }


}
