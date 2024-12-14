import { Routes } from '@angular/router';
import {JarmuComponent} from './jarmu/jarmu.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {RendelesComponent} from './rendeles/rendeles.component';
import {FelhasznaloComponent} from './felhasznalo/felhasznalo.component';


export const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'jarmu', component: JarmuComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'rendeles', component: RendelesComponent},
  {path: 'felhasznalo', component: FelhasznaloComponent}
];

