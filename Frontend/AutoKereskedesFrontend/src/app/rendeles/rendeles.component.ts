import { Component } from '@angular/core';
import {
  MatCell,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderRow,
  MatRow,
  MatTable,
  MatTableDataSource
} from '@angular/material/table';
import {MatButton, MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {Rendeles, RendelesService} from '../rendeles.service';
import {CurrencyPipe, NgForOf, NgIf, NgOptimizedImage} from '@angular/common';
import {Jarmu, JarmuService} from '../jarmu.service';
import {
  MatCard,
  MatCardActions,
  MatCardHeader,
  MatCardImage,
  MatCardSubtitle,
  MatCardTitle
} from '@angular/material/card';
import {MatDialogActions} from '@angular/material/dialog';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatSlider, MatSliderRangeThumb} from '@angular/material/slider';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-rendeles',
  imports: [
    MatCardImage,
    MatCardSubtitle,
    MatCardTitle,
    CurrencyPipe,
    MatButton,
    MatCard,
    MatCardHeader,
    NgForOf,
    NgOptimizedImage,
    ReactiveFormsModule
  ],
  templateUrl: './rendeles.component.html',
  standalone: true,
  styleUrl: './rendeles.component.css'
})
export class RendelesComponent {
  jarmuvek: any[] = [];
  displayedColumns: string[] = ['marka','tipus','ar', 'ev'];
  dataSource = new MatTableDataSource<Jarmu>(this.jarmuvek);

  constructor(private jarmuService: JarmuService, private rendelesService: RendelesService) {
  }

  ngOnInit(): void {
    this.loadRendeles();
  }

  loadRendeles(){
    this.rendelesService.getAllRendeles().subscribe(data => {
      this.jarmuvek = data;
      this.dataSource.data = data;
    });
  }
}
