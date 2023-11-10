import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agenda, ProfesionalSalud } from './agenda';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgendaService {

  private url : string =  "http://localhost:8080/health/api/v1";

  constructor(private http:HttpClient) { }

  registrar(agenda:Agenda):Observable<{datos:[Agenda],mensajes:[string]}>{
    return this.http.post<{datos:[Agenda],mensajes:[string]}>(this.url+'/agenda',agenda) 
 }
 consultarProfesional(profesional:ProfesionalSalud):Observable<{datos:[ProfesionalSalud],mensajes:[]}>{
  return this.http.post<{datos:[ProfesionalSalud],mensajes:[]}>(this.url+'/profesional/consultar',profesional) 
}
}