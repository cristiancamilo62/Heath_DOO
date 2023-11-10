import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cita } from './cita';

@Injectable({
  providedIn: 'root'
})
export class CitasService {
  
  private url:string= "http://localhost:8080/health/api/v1/cita";

  constructor(private http:HttpClient){}
  
  create(cita:Cita):Observable<Cita>{
      return this.http.post<Cita>(this.url,cita)
  }
}
