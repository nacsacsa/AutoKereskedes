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

  getFilteredJarmu(szuro: any): Observable<any>{
    return this.http.post(`${this.baseUrl}/jarmu/filter`, szuro, {headers: this.getHeaders()});
  }

  updateJarmu(id: number, marka: string, tipus: string, ar: number, ev: number): Observable<any>{
    return this.http.put(`${this.baseUrl}/update/jarmu`, { id, marka, tipus, ar, ev }, {headers: this.getHeaders()});
  }

  deleteJarmu(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/delete/jarmu?id=${id}`, {headers: this.getHeaders()});
  }

  saveJarmu(marka: string, tipus: string, ar: number, ev: number): Observable<any>{
    return this.http.post(`${this.baseUrl}/save/jarmu`, {marka, tipus, ar, ev}, {headers: this.getHeaders()});
  }
}
