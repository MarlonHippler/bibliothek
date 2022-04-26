import { Component, OnInit } from '@angular/core';import {Observable} from "rxjs";
import {PubService} from "../services/pub.service";
import {LeihvorgangModel} from "../models/leihvorgang-model";


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
    'rueckgabedatum'];

  public dataSource!: Observable<LeihvorgangModel[]>;

  constructor(private pubService: PubService) {
  } // service reingeben

  ngOnInit(): void {
    this.dataSource = this.pubService.zeigeAlleAusgeliehenenPubs()
  }

  toLocalDateString(veroeffentlichung: string): string {
    return new Date(veroeffentlichung).toUTCString()
  }
}
