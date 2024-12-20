import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private authUrl: string = 'http://localhost:8080/auth/bejelentkezes';
  private registationUrl: string = 'http://localhost:8080/auth/regisztracio';

  constructor(private http: HttpClient) {}

  login(email: string, jelszo: string): Observable<any>{
    return this.http.post(this.authUrl, {email, jelszo}, {responseType:'text'})
  }

  registation(nev: string, email: string, jelszo: string): Observable<any>{
    return this.http.post(this.registationUrl, {nev, email, jelszo}, {responseType:'text'})
  }
}
