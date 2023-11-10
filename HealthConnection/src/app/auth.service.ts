import { Injectable } from '@angular/core';
import { PacienteService } from './login/paciente.service';
import { Paciente } from './login/paciente';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn = false;
  paciente: Paciente | null = null;

  constructor(private pacienteservice: PacienteService) { }

  login(paciente:Paciente):boolean{
    this.pacienteservice.getCredenciales(paciente).subscribe(
      (response)=>{
        if(response){
          this.loggedIn = true;
          this.paciente= response.datos[0];
        
        }
        else{
          this.loggedIn = false;
        }
       
        }
    );
    return this.loggedIn;
      }

    logout(): void {
      this.loggedIn = false
      this.paciente = null;
    }

}
