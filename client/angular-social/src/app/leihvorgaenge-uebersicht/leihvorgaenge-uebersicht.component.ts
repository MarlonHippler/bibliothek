import {Component, OnInit, ViewChild} from '@angular/core';import {Observable, Subject, takeUntil} from "rxjs";
import {PubService} from "../services/pub.service";
import {LeihvorgangModel} from "../models/leihvorgang-model";
import {LeihvorgangService} from "../services/leihvorgang.service";
import {MatSort} from "@angular/material/sort";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-leihvorgaenge-uebersicht',
  templateUrl: './leihvorgaenge-uebersicht.component.html',
  styleUrls: ['./leihvorgaenge-uebersicht.component.css']
})





// pubID: number
// vorname: String
// name: String
// matrikelnummer: number

export class LeihvorgaengeUebersichtComponent implements OnInit {
  displayedColumns: string[] = ['vorgangID','pubID', 'vorname', 'name', 'matrikelnummer', 'ausgabedatum',
    'rueckgabedatum', 'leihfristVerlaengern', "rueckgabe"];

  public dataSource!: Observable<LeihvorgangModel[]>;
  private destroy$: Subject<boolean> = new Subject<boolean>();
  @ViewChild(MatSort, {static: true}) sort!: MatSort;

  constructor(private leihvorgangService: LeihvorgangService, private pubService: PubService, private snackBar: MatSnackBar) {
  } // service reingeben

  ngOnInit(): void {
    this.dataSource = this.pubService.zeigeAlleAusgeliehenenPubs()
  }

  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toISOString().slice(0, 10);
  }
  leihvorgangVerlaengern(leihvorgangModel: LeihvorgangModel) {
    console.log(leihvorgangModel.vorgangID)
    this.leihvorgangService.verlaengereLeihvorgang(leihvorgangModel).pipe(takeUntil(this.destroy$)).subscribe()



  }
  rueckgabe(leihvorgangModel: LeihvorgangModel) {
    console.log(leihvorgangModel.vorgangID)
    this.leihvorgangService.zurueckgeben(leihvorgangModel).pipe(takeUntil(this.destroy$)).subscribe()



  }
  openSnackBar(message: string): void {
    this.snackBar.open(message, 'X', {
      duration: 5000
    })
  }
}
