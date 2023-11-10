import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Paciente } from './paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private url:string= "http://localhost:8080/health/api/v1/paciente";

  id:string='';

  constructor(private http:HttpClient) { }

  
  getCredenciales(paciente:Paciente):Observable<{datos:[Paciente],mensajes:[]}>{
     return this.http.post<{datos:[Paciente],mensajes:[]}>(this.url+'/consultar',paciente) 
     
  }

  create(paciente:Paciente):Observable<Paciente>{
    return this.http.post<Paciente>(this.url,paciente);
  }

  update(Paciente:Paciente,id:string):Observable<Paciente>{
    return this.http.put<Paciente>(this.url+'/'+id,Paciente);
  }

  deleteP(id:string):Observable<Paciente>{
  return  this.http.delete<Paciente>(this.url+'/'+id)
  }

  getUuid(idL:string): void{
    this.id = idL;
  }

  getPaciente(paciente:Paciente):Observable<{datos:[Paciente],mensajes:[]}>{
    return this.http.post<{datos:[Paciente],mensajes:[]}>(this.url+'/consultar',paciente) 
    
 }

  
 
}
