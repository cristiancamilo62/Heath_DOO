import { Component, OnInit } from '@angular/core';
import { Paciente } from './paciente';
import { PacienteService } from './paciente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-formpacientemodificar',
  templateUrl: './formpacientemodificar.component.html',
  styleUrls: ['./formpacientemodificar.component.css']
})
export class FormpacientemodificarComponent  implements OnInit{

  paciente:Paciente=new Paciente();

  id:string='';

  constructor(private pacienteService:PacienteService, private router:Router,private activedRouted:ActivatedRoute){}
  

  ngOnInit(): void {
    this.cargar();
    console.log(this.paciente.contactoPaciente.correoElectronicoPaciente.correoElectronico);
  }

  cargar():void {
    this.activedRouted.params.subscribe(
      pa=>{
        this.id = pa['id'];
        if(this.id){
          this.paciente.id = this.id;
          this.pacienteService.getPaciente(this.paciente).subscribe(
            response=>this.paciente=response.datos[0]
          );
          }
        }
    );
  }

  actualizar(): void{
    this.pacienteService.update(this.paciente,this.paciente.id).subscribe(
      response=>{
              if(response){
                alert("se ha actualizado el paciente")}
                this.router.navigate(['login/principal',this.paciente.id]);
        },
        (error)=>{
          alert("A sucedido un error tratando de actualizar su cuenta")
        }
           
      );


  }



}
