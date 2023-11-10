import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormpacienteComponent } from './login/formpaciente.component';
import { RegistroCitasComponent } from './registro-citas/registro-citas.component';
import { FormcitaComponent } from './registro-citas/formcita/formcita.component';
import { PrincipalComponent } from './principal/principal.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormpacientemodificarComponent } from './login/formpacientemodificar.component';
import { AuthService } from './auth.service';
import { AgendaComponent } from './agenda/agenda.component';

const routes: Routes = [
  { path: '', redirectTo:'/login' ,pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'login/form', component: FormpacienteComponent },
  { path: 'login/principal/:id', component: PrincipalComponent },
  { path: 'login/principal/editarPerfil/:id', component: FormpacientemodificarComponent },
  { path: 'principal/crearAgenda', component: AgendaComponent }


];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FormpacienteComponent,
    RegistroCitasComponent,
    FormcitaComponent,
    PrincipalComponent,
    FormpacientemodificarComponent,
    AgendaComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    ModalModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
