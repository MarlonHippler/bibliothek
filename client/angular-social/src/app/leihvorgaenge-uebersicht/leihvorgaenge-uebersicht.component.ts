import {Component, OnInit, ViewChild} from '@angular/core';import {Observable, Subject, takeUntil} from "rxjs";
import {PubService} from "../services/pub.service";
import {LeihvorgangModel} from "../models/leihvorgang-model";
import {LeihvorgangService} from "../services/leihvorgang.service";
import {MatSort} from "@angular/material/sort";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ActivatedRoute} from "@angular/router";
//autor Marc, übersicht der leihvorgänge

@Component({
  selector: 'app-leihvorgaenge-uebersicht',
  templateUrl: './leihvorgaenge-uebersicht.component.html',
  styleUrls: ['./leihvorgaenge-uebersicht.component.css']
})





export class LeihvorgaengeUebersichtComponent implements OnInit {
  displayedColumns: string[] = ['vorgangID','pubID','pubTitel' ,'vorname', 'name', 'matrikelnummer', 'ausgabedatum',
    'rueckgabedatum', 'leihfristVerlaengern', "rueckgabe"];

  public dataSource!: Observable<LeihvorgangModel[]>;
  private destroy$: Subject<boolean> = new Subject<boolean>();
  @ViewChild(MatSort, {static: true}) sort!: MatSort; //fürs sortieren
  private pubID!: number;


  constructor(private leihvorgangService: LeihvorgangService, private pubService: PubService, private snackBar: MatSnackBar,private route: ActivatedRoute) {
  } // services und snackbar reingeben

  ngOnInit(): void {
    //hier if else nach url dann data source picken

    this.pubID = parseInt(this.route.snapshot.paramMap.get('id') as string); //id aus der url lesen
     if (this.pubID) { this.dataSource = this.pubService.zeigeAlleAusgeliehenenPubsnachPubID(this.pubID)
     } else {
    this.dataSource = this.pubService.zeigeAlleAusgeliehenenPubs() //laden der leihgvorgänge in die tabelle
  } }

  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toISOString().slice(0, 10); //datumsformat anpassen
  }
  leihvorgangVerlaengern(leihvorgangModel: LeihvorgangModel) {

    this.leihvorgangService.verlaengereLeihvorgang(leihvorgangModel).pipe(takeUntil(this.destroy$)).subscribe(
      publikation => {
      },
      error => {
        if (error.error) {
          this.openSnackBar(error.error.nachricht)
        } }
    )



  }
  rueckgabe(leihvorgangModel: LeihvorgangModel) {
    console.log(leihvorgangModel.vorgangID)
    this.leihvorgangService.zurueckgeben(leihvorgangModel).pipe(takeUntil(this.destroy$)).subscribe(publikation => {
      },
      error => {
        if (error.error) {
          this.openSnackBar(error.error.nachricht)
        }})



  }
  openSnackBar(nachricht: string): void {
    this.snackBar.open(nachricht, 'X', { // nachricht vom backend übernehmen
      duration: 5000
    })
  }
}
