import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Rendeles{
  id: number;
  felhasznalo: {
    nev: string;
    email: string;
  };
}

@Injectable({
  providedIn: 'root'
})
export class RendelesService {
  private baseUrl = 'http://localhost:8080/api'
  constructor(private http: HttpClient) {}

  private getHeaders(){
    return new HttpHeaders({'Authorization': `Bearer ${localStorage.getItem('token')}`,
      'Access-Control-Allow-Origin':'*'});
  }

  getAllRendeles(): Observable<any>{
    return this.http.get(`${this.baseUrl}/rendeles`, {headers: this.getHeaders()});
  }

  saveRendeles(): Observable<any>{
    return this.http.post(`${this.baseUrl}/save/rendeles`, {}, {headers: this.getHeaders()});
  }

  updateRendeles(jarmuId: number): Observable<any>{
    return this.http.put(`${this.baseUrl}/rendeles/jarmu/save?jarmuId=${jarmuId}`, {}, {headers: this.getHeaders()});
  }

}
