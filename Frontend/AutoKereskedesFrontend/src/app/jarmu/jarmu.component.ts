import {Component, OnInit} from '@angular/core';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {FormsModule} from '@angular/forms';
import {Jarmu, JarmuService} from '../jarmu.service';
import {CurrencyPipe, NgOptimizedImage} from '@angular/common';
import { CommonModule } from '@angular/common';
import {MatSlider} from '@angular/material/slider';
import {MatOption, MatSelect} from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSelectModule } from '@angular/material/select';
import {MatDialogActions} from '@angular/material/dialog';
import {RendelesService} from '../rendeles.service';
import {Router} from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-jarmu',
  imports: [MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSliderModule,
    MatSelectModule,
    RouterModule,
    MatIconModule,
    CommonModule,
    MatCardModule,
    FormsModule, CurrencyPipe, NgOptimizedImage, MatDialogActions],
  templateUrl: './jarmu.component.html',
  styleUrl: './jarmu.component.css',
  standalone: true
})
export class JarmuComponent implements OnInit{
    jarmuvek: any[] = [];
    displayedColumns: string[] = ['marka','tipus','ar', 'ev'];
    dataSource = new MatTableDataSource<Jarmu>(this.jarmuvek);

    newJarmu: {id: number, marka: string; tipus: string; ar: number, ev: number } = {id: 0, marka: '', tipus: '', ar: 0, ev: 0};

    jarmuSzuro: {marka: string; tipus: string; kezdo_ar: number, veg_ar: number, kezdo_ev: number, veg_ev: number } = {marka: '', tipus: '', kezdo_ar: 0, veg_ar: 50000, kezdo_ev: 1900, veg_ev : 2024};

    isCreating = false;
    isEditing = false;

    constructor(private jarmuService: JarmuService, private rendelesService: RendelesService) {
    }


    ngOnInit(): void {
        this.loadJarmu()
    }

  newJarmuSzerkesztes(id: number, marka: string, tipus: string, ar: number, ev: number) {
    this.newJarmu = {id, marka, tipus, ev, ar}
  }
  resetNewJarmu() {
    this.newJarmu = {id: 0, marka: '', tipus: '', ar: 0, ev: 0};
  }

  loadJarmu(){
      this.jarmuService.getAllJarmu().subscribe(data => {
        this.jarmuvek = data;
        this.dataSource.data = data;
      });
    }

    deleteJarmu(id: number) {
      this.jarmuService.deleteJarmu(id).subscribe({
        next: () => {
          console.log(`Jármű törölve: ${id}`);
          this.loadJarmu();
        },
        error: (err) => console.error('Hiba a törlés során:', err),
      });
    }

  addJarmu(marka: string, tipus: string, ar: number, ev: number) {
    this.jarmuService.saveJarmu(marka, tipus, ar, ev).subscribe({
      next: () => {
        console.log(`Jármű hozzáadva`);
        this.loadJarmu();
      },
      error: (err) => console.error('Hiba a létrehozás közben:', err),
    });
  }

    updateJarmu(id: number, marka: string, tipus: string, ar: number, ev: number)
    {
      this.jarmuService.updateJarmu(id, marka, tipus, ar, ev).subscribe({
        next: () => {
          console.log(`Jármű módosítva`);
          this.loadJarmu();
        },
        error: (err) => console.error('Hiba a módosítás közben:', err),
      });
    }

  searchJarmu(marka: string, tipus: string, kezdoAr: number, vegAr: number, kezdoEv: number, vegEv: number)
  {
    const szuro: any = {};

    szuro.marka = marka;
    szuro.tipus = tipus;
    if (marka == "") szuro.marka = null;
    if (tipus == "") szuro.tipus = null;
    szuro.kezdoAr = kezdoAr;
    szuro.vegAr = vegAr;
    szuro.kezdoEv = kezdoEv;
    szuro.vegEv = vegEv
    console.log('Küldendő szűrő:', szuro);
    this.jarmuService.getFilteredJarmu(szuro).subscribe(
      data => {
      this.jarmuvek = data;
      this.dataSource.data = data;
    });
  }

  saveJarmuToRendeles(id: number)
  {
    this.rendelesService.updateRendeles(id).subscribe({
      next: () => {
        console.log(`Rendeléshez a jármű hozzáadva`);
      },
      error: (err) => console.error('Hiba a rendeléshez mentés közben:', err),
    });
  }
}
