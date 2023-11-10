import { Component, OnInit } from '@angular/core';
import { Paciente } from './paciente';
import { PacienteService } from './paciente.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  paciente:Paciente=new Paciente();

  constructor(private autService: AuthService, private router: Router) { }

  ngOnInit(): void { 
  }

  getCredenciales(): void {
    if(this.autService.login(this.paciente)){
      this.router.navigate(['login/principal',this.autService.paciente?.id])
    }else{
      alert("no existe usuario")
    }

  }
}

