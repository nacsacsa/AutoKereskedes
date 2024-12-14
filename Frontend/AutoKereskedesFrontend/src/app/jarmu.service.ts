import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Jarmu{
  id?: number;
  marka: string;
  tipus: string;
  ar: number;
  ev: number
}

@Injectable({
  providedIn: 'root'
})
export class JarmuService {
  private baseUrl = 'http://localhost:8080/api'
  constructor(private http: HttpClient) {}

  private getHeaders(){
    return new HttpHeaders({'Authorization': `Bearer ${localStorage.getItem('token')}`,
    'Access-Control-Allow-Origin':'*'});
  }

  getAllJarmu(): Observable<any>{
    return this.http.get(`${this.baseUrl}/jarmu`, {headers: this.getHeaders()});
  }

  /*getJarmuByFilter(email: string, jelszo: string): Observable<any>{
    return this.http.post(this.authUrl, {email, jelszo}, {responseType:'text'})
  }*/
}
