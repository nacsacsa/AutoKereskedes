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

@Component({
  selector: 'app-jarmu',
  imports: [MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSliderModule,
    MatSelectModule,
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

    newJarmu: { marka: string; tipus: string; ar: number, ev: number } = {marka: '', tipus: '', ar: 0, ev: 0};
    isEditing = false;

    constructor(private jarmuService: JarmuService) {
    }


    ngOnInit(): void {
        this.loadJarmu()
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

  addJarmu(marka: string, tipus: string, ev: number, ar: number) {
    this.jarmuService.saveJarmu(marka, tipus, ev, ar).subscribe({
      next: () => {
        console.log(`Jármű hozzáadva`);
        this.loadJarmu();
      },
      error: (err) => console.error('Hiba a létrehozás közben:', err),
    });
  }
}
