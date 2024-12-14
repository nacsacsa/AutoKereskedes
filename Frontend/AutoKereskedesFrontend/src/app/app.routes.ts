import { Routes } from '@angular/router';
import {JarmuComponent} from './jarmu/jarmu.component';
import {LoginComponent} from './login/login.component';


export const routes: Routes = [{path: '', component: LoginComponent},
  {path: 'jarmu', component: JarmuComponent}];

