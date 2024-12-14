import { Component } from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import { RouterModule } from '@angular/router';
import {MatFormField} from '@angular/material/form-field';
import {MatCard} from '@angular/material/card';
import {FormsModule} from '@angular/forms';
import {MatInput} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-register',
  imports: [RouterModule, MatFormField, MatCard, FormsModule, MatInput, MatInputModule, MatButton],
  templateUrl: './register.component.html',
  standalone: true,
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  nev :string = '';
  email = '';
  jelszo = '';

  constructor(private authService: AuthService, private router: Router) {}

  onRegister(){
    this.authService.registation(this.nev, this.email, this.jelszo).subscribe(
      (response: any) => {
        localStorage.setItem('token', response)
        console.log('Sikeres regisztráció');
        this.router.navigate(['']);
      },
      error => {
        console.error('Hiba történt a regisztáció során', error)
      }
    );
  }
}
