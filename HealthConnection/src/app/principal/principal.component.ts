import { Component, OnInit } from '@angular/core';
import { Paciente } from '../login/paciente';
import { PacienteService } from '../login/paciente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {
  paciente: Paciente = new Paciente();

  id:string='';

  isMenuOpenPerfil = false;
  isMenuOpenAgenda = false;

  constructor(private pacienteService: PacienteService, private router: Router,private activeRoute: ActivatedRoute,
    private authservice:AuthService) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.activeRoute.params.subscribe(
      response=>{
        this.id = response['id'];
        if(this.id){
            console.log(this.id)
        }
      }
    );

  }

  eliminar():void{
    if(confirm("¿seguro que desea eliminar esta cuenta permanentemente?")){
      this.pacienteService.deleteP(this.id).subscribe(
        (response)=>{
          alert("se ha eliminado la cuenta permanentemente");
          window.history.replaceState({}, document.title, "/login");
          this.router.navigate(['/login'])
          
        },
        (error)=>{
            this.router.navigate(['/login/principal/'+this.id])
          
        }
      );
    }

   
  }
  toggleMenu() {
    this.isMenuOpenPerfil = !this.isMenuOpenPerfil;
  }

  toggleMenuS() {
    this.isMenuOpenAgenda = !this.isMenuOpenAgenda;
  }

  logout(): void {
    if (confirm("¿Estás seguro de cerrar la sesión?")) {
      this.authservice.logout();
      
      // Reemplaza la entrada actual en el historial del navegador con la página de inicio o cualquier otra página apropiada
      window.history.replaceState({}, document.title, "/login"); 
      
      this.router.navigate(['/login']);
    }
      else{
        this.router.navigate(['/login/principal/'+this.id])
    }
  }

}