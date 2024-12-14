import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Jarmu{
  id: number;
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

  getFilteredJarmu(marka: string, tipus: string, kezdo_ar: number, veg_ar: number, kezdo_ev: number, veg_ev: number): Observable<any>{
    return this.http.post(`${this.baseUrl}/jarmu/filter`, { marka,tipus, kezdo_ar, veg_ar, kezdo_ev, veg_ev }, {headers: this.getHeaders()});
  }

  updateJarmu(id: number, marka: string, tipus: string, ar: number, ev: number): Observable<any>{
    return this.http.put(`${this.baseUrl}/update/jarmu`, { id, marka, tipus, ar, ev }, {headers: this.getHeaders()});
  }

  deleteJarmu(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/delete/jarmu?id=${id}`, {headers: this.getHeaders()});
  }


  /*login(email: string, jelszo: string): Observable<any>{
    return this.http.post(this.authUrl, {email, jelszo}, {responseType:'text'})
  }*/
}
