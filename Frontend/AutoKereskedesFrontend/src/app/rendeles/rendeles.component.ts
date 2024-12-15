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
import {MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {Rendeles, RendelesService} from '../rendeles.service';

@Component({
  selector: 'app-rendeles',
  imports: [
    MatTable,
    MatCell,
    MatHeaderCell,
    MatColumnDef,
    MatHeaderRow,
    MatRow
  ],
  templateUrl: './rendeles.component.html',
  standalone: true,
  styleUrl: './rendeles.component.css'
})
export class RendelesComponent {
  rendelesek: any[] = [];
  displayedColumns: string[] = ['id', 'felhasznaloNev', 'felhasznaloEmail'];
  dataSource = new MatTableDataSource<Rendeles>(this.rendelesek)

  constructor(private rendelesService: RendelesService) { }

  ngOnInit(): void {
    this.loadEtelek();
  }

  loadEtelek(){
    this.rendelesService.getAllRendeles().subscribe(data => {
      this.rendelesek = data;
      this.dataSource.data = data;
    });
  }

  /*deleteEtel(id: number){
    this.rendelesService.(id).subscribe(() => this.loadEtelek());
  }*/
}
